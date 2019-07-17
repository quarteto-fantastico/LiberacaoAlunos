import React, { Component } from 'react';
// This example's for browser use, so I'm using `BrowserRouter`.
// The are other routers for other environments, though.
import { BrowserRouter, Route, Redirect } from 'react-router-dom';
import Sidebar from './Sidebar';
import { isAuthenticated } from './services/auth';
// Your components.
import Login from './telas/Login';
import MenuPrincipal from './telas/MenuPrincipal';
import MainUsuario from './telas/User/MainUser';
import CadastroEntrada from './telas/Liberacao/CadastroEntrada';
import CadastroSaida from './telas/Liberacao/CadastroSaida';
import MainTurma from './telas/Turma/MainTurma';
import MainProfessor from './telas//Professor/MainProfessor';
import MainAluno from './telas/Aluno/MainAluno';
import AlunosLiberadosEntrada from './telas/Liberacao/AlunosLiberadosEntrada';
import AlunosLiberadosSaida from './telas/Liberacao/AlunosLiberadosSaida';
import Ajuda from './telas/Ajuda';
//TestValidation
// import Validation from './telas/Validation/Validation';
//Bruno


const PrivateRoute = ({ component: Component, ...rest }) => (
  <Route
    {...rest}
    render={props =>
      isAuthenticated() ? (
        <Component {...props} />
      ) : (
        <Redirect to={{ pathname: "/", state: { from: props.location } }} />
      )
    }
  />
);

class Routes extends Component {
  
  render() {
    return (
      <div id="App">

        <BrowserRouter>
          <Sidebar pageWrapId={"page-wrap"} outerContainerId={"App"}></Sidebar>
          <div id="page-wrap">
            {/* `component` will render when `path` matches the user's location */}
            {/* `exact` makes it so it only renders if `path` matches exactly. */}
            {/* Otherwise, `HomePage` would render on "mysite.com/About" as well as "mysite.com/". */}
            <Route exact path="/" component={Login} />
            <PrivateRoute path="/usuario" component={MainUsuario} />
            <PrivateRoute path="/cadastro_entrada" component={CadastroEntrada} />
            <PrivateRoute path="/cadastro_saida" component={CadastroSaida} />
            <PrivateRoute path="/turma" component={MainTurma} />
            <PrivateRoute path="/professor" component={MainProfessor} />
            <PrivateRoute path="/aluno" component={MainAluno} />
            <PrivateRoute path="/menu_principal" component={MenuPrincipal} />
            <PrivateRoute path="/alunos_liberados_entrada" component={AlunosLiberadosEntrada} />
            <PrivateRoute path="/alunos_liberados_saida" component={AlunosLiberadosSaida} />
            <PrivateRoute path="/ajuda" component={Ajuda} />
            {/* <PrivateRoute path="/validation_test" component={Validation} />*/}
          </div>
        </BrowserRouter>
      </div>
    );
  }
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
export default Routes;