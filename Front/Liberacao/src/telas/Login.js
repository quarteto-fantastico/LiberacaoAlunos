import React, { Component } from 'react';
import { MDBInput, MDBBtn } from "mdbreact";
import api from '../services/api';
import { login } from '../services/auth';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min';

//Bruno

export default class Login extends Component {

  constructor(props) {
    super(props);
    this.handleLogar = this.handleLogar.bind(this)
  }

  state = {
    email: "testando@gmail.com",
    senha: "123",
    erro: ""
  };

  handleLogar = async e => {
    e.preventDefault();
    const { email, senha } = this.state;
    if (!email || !senha) {
      this.setState({ erro: "Preencha e-mail e senha para continuar!" });
    } else {
      try {
        const response = await api.post("/login", { email, senha });
        login(response.headers.authorization);
        this.props.history.push("/menu_principal");
      } catch (err) {
        this.setState({
          erro:
            "Houve um problema com o login, verifique suas credenciais."
        });
      }
    }
  };

  render() {
    return (
      <div className='container'>
        <div className='row'>
          <div className='col-sm-2'></div>
          <div className='col-sm-8'>
          <div className="text-center">

          <img alt='Logo Senai' id="profile-img" className="rounded-circle profile-img-card" src="https://98fmapucarana.com.br/wp-content/uploads/2018/06/56822-Senai-Arauc%C3%A1ria-Cursos-Gratuitos-no-Paran%C3%A1-2.jpg" />
          </div>
            <h1>Login</h1>
            {this.state.erro && <div className="alert alert-danger">{this.state.erro}</div>}
            <form className='alinhandoEsquerda' onSubmit={this.handleLogar}>
              <MDBInput label="Email" type="email" background icon="envelope" onChange={(event => this.setState({ email: event.target.value }))}/>
              <MDBInput label="Senha" type="password" background icon="key" onChange={(event => this.setState({ senha: event.target.value }))}/>
              <div className='alinhandoDireita tyleBotao'>
                <MDBBtn color="success" type="submit">Login</MDBBtn>
              </div>
            </form>
          </div>
          <div className='col-sm-2'></div>
        </div>
      </div>
    );
  }
}
