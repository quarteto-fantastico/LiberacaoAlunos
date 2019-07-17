package br.senai.sc;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.senai.sc.domain.Administrador;
import br.senai.sc.domain.Aluno;
import br.senai.sc.domain.Guarda;
import br.senai.sc.domain.Professor;
import br.senai.sc.domain.RegistroEntrada;
import br.senai.sc.domain.RegistroSaida;
import br.senai.sc.domain.Responsavel;
import br.senai.sc.domain.Turma;
import br.senai.sc.domain.User;
import br.senai.sc.domain.enums.Perfil;
import br.senai.sc.domain.enums.Periodo;
import br.senai.sc.repositories.AdministradorRepository;
import br.senai.sc.repositories.AlunoRepository;
import br.senai.sc.repositories.GuardaRepository;
import br.senai.sc.repositories.ProfessorRepository;
import br.senai.sc.repositories.RegistroEntradaRepository;
import br.senai.sc.repositories.RegistroSaidaRepository;
import br.senai.sc.repositories.ResponsavelRepository;
import br.senai.sc.repositories.TurmaRepository;
import br.senai.sc.repositories.UserRepository;

@SpringBootApplication
public class LiberacaoAlunosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiberacaoAlunosApplication.class, args);
	}

	@Autowired
	private UserRepository userR;
	
	@Autowired
	private ProfessorRepository profR;
	
	@Autowired
	private AdministradorRepository adminR;
	
	@Autowired
	private GuardaRepository guardaR;
	
	@Autowired
	private RegistroSaidaRepository regSaidaR;

	@Autowired
	private AlunoRepository alunoR;

	@Autowired
	private RegistroEntradaRepository regEntradaR;

	@Autowired
	private TurmaRepository turmaR;
	
	@Autowired
	private ResponsavelRepository responsavelR;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {

		ClassPathResource zed = new ClassPathResource("image/zed-classic.png");// transformando a imagem em uma variável
		byte[] arrayPic = new byte[(int) zed.contentLength()];// Não tenho certeza o porque disso tudo
		zed.getInputStream().read(arrayPic);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");// date format para data e hora.
		SimpleDateFormat stf = new SimpleDateFormat("hh:mm");// date format para data e hora.

		User user1 = new User(null, "teste", "testando@gmail.com", passwordEncoder.encode("123"), "995544", true);
		user1.addPerfil(Perfil.ADMINISTRADOR);
		
		Administrador admin1 = new Administrador(null, "Admin João da Silva", "joao1", passwordEncoder.encode("12345"), "999887766", true);
		Administrador admin2 = new Administrador(null, "Admin Manoel Heleno", "manuel1@gmail.com", passwordEncoder.encode("12345"), "999887766", true);
		Administrador admin3 = new Administrador(null, "Admin Helena Filha", "helena1@gmail.com", passwordEncoder.encode("12345"), "999887766", false);
		admin1.addPerfil(Perfil.ADMINISTRADOR);
		admin2.addPerfil(Perfil.ADMINISTRADOR);
		admin3.addPerfil(Perfil.ADMINISTRADOR);
		
		
//		admin1.getTelefones().add("(48)999887766");

		Guarda guarda1 = new Guarda(null, "Guarda João da Silva", "joao2@gmail.com", passwordEncoder.encode("12345"), "999887766", true);
		Guarda guarda2 = new Guarda(null, "Guarda Manoel Heleno", "manuel2@gmail.com", passwordEncoder.encode("12345"), "999887766", true);
		Guarda guarda3 = new Guarda(null, "Guarda Helena Filha", "helena2@gmail.com", passwordEncoder.encode("12345"), "999887766", false);

		Professor prof1 = new Professor(null, "Professor João da Silva", "joao3@gmail.com", passwordEncoder.encode("12345"), "999887766", true);
		Professor prof2 = new Professor(null, "Professor Manoel Heleno", "manuel3@gmail.com", passwordEncoder.encode("12345"), "999887766", true);
		Professor prof3 = new Professor(null, "Professor Helena Filha", "helena3@gmail.com", passwordEncoder.encode("12345"), "999887766", false);
		
		
		Turma turma1 = new Turma(null, "Desenvolvimento de Sistemas","3o","2019/01",Periodo.MATUTINO);
		Turma turma2 = new Turma(null, "Lógica","2o","2019/01",Periodo.VESPERTINO);
				
		
		Aluno aluno = new Aluno(null, "Marcio", "11112520909", null);
		Aluno aluno2 = new Aluno(null, "Bruno", "1115555-cpf", null);
		aluno.getTelefones().add("888776655");
		
		turma1.getAlunos().add(aluno);
		turma2.getAlunos().add(aluno2);
		aluno.getTurmas().add(turma1);
		aluno.getTurmas().add(turma2);
		aluno2.getTurmas().add(turma2);
		
		
		
		RegistroSaida regs1 = new RegistroSaida(null, "Obs", stf.parse("19:26"), sdf.parse("25/04/2019"), false, true,
				false, false, false, false, true, true, admin1, aluno);
		admin1.getRegistros_saidas().add(regs1);
		aluno.getRegistros_saidas().add(regs1);
		regs1.getProfessores().add(prof1);
		prof1.getRegistros_saidas().add(regs1);

		RegistroEntrada regE1 = new RegistroEntrada(null, "obs", "20:44", sdf.parse("25/04/2019"), false,
				true, false, false, false, false, true, true, admin1, aluno);
		admin1.getRegistros_entradas().add(regE1);
		aluno.getRegistros_entradas().add(regE1);
		prof1.getRegistros_entradas().add(regE1);
		regE1.getProfessores().add(prof1);
		
		Responsavel respon1 = new Responsavel(null, "pai", "pai@hotmail.com", "1234567894", aluno);
		respon1.getTelefones().add("999999999");
		aluno.getResponsaveis().add(respon1);

		userR.save(user1);
		
		adminR.save(admin1);
		adminR.save(admin2);
		adminR.save(admin3);

		guardaR.save(guarda1);
		guardaR.save(guarda2);
		guardaR.save(guarda3);

		profR.save(prof1);
		profR.save(prof2);
		profR.save(prof3);

		turmaR.save(turma1);
		turmaR.save(turma2);
		alunoR.save(aluno);
		alunoR.save(aluno2);
		
		regEntradaR.save(regE1);
		regSaidaR.save(regs1);
		
		responsavelR.save(respon1);
	}

}
