package br.senai.sc.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import br.senai.sc.security.JWTAuthenticationFilter;
import br.senai.sc.security.JWTAuthorizationFilter;
import br.senai.sc.security.JWTUtil;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	private static final String[] PUBLIC_MATCHERS = {
			"/h2-console/**",
			"/users/**",
			"/turmas/**",
			"/alunos/**",
			"/**"
	};
	
	private static final String[] PUBLIC_MATCHERS_GET = {
	};

	private static final String[] PUBLIC_MATCHERS_POST = {
	};

	private static final String[] PUBLIC_MATCHERS_DELETE = {
	};

	private static final String[] PUBLIC_MATCHERS_PUT = {
	};
	
	@Autowired
    private Environment env;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JWTUtil jwtUtil;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//Se estiver em ambiente de Teste permite abrir o H2Console, habilitando html frame
		if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
            http.headers().frameOptions().disable();
        }
		
		//Desabilita a segurança CSRF
		http.cors().and().csrf().disable();
		
		//Autoriza as requisições para os caminhos que definimos nos arrays acima
		http.authorizeRequests()
			.antMatchers(PUBLIC_MATCHERS).permitAll()
			.antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET).permitAll()
			.antMatchers(HttpMethod.POST, PUBLIC_MATCHERS_POST).permitAll()
			.antMatchers(HttpMethod.DELETE, PUBLIC_MATCHERS_DELETE).permitAll()
			.antMatchers(HttpMethod.PUT, PUBLIC_MATCHERS_PUT).permitAll()
			.anyRequest().authenticated();
		http.addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtUtil));
		http.addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtUtil, userDetailsService));
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}
	
	//Resolve problema do crossorigin
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
		configuration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
