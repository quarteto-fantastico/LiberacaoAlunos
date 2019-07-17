import React, { Component } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min';
import { MDBInput, MDBBtn} from "mdbreact";
import api from '../../services/api';
import { urlServidor } from '../../Variaveis.json'
//Rodrigo

export default class CadastroUsuario extends Component {

  constructor(props) {
    super(props);
    this.state = {
      userId: null,
      userNome: null,
      userSenha: null,
      userEmail: null,
      userTelefone: null,
      userTipo: null,
      urlTipoUser: null
    }
  }

  userPost() {
    if(this.state.userTipo === 'ADMINISTRADOR'){
      api.post(urlServidor + "/users/administradores", {
        id: null,
        nome: this.state.userNome,
        email: this.state.userEmail,
        senha: this.state.userSenha,
        telefone: this.state.userTelefone
      }).then(resposta => {
        //se deu certo:
        alert('Cadastrado com sucesso!');
        window.location.reload();
      })
        .catch(resposta => {
          //se der errado
          console.log(resposta);
          alert('Dados incorretos!');
        })
    } else if (this.state.userTipo === 'GUARDA'){
      api.post(urlServidor + "/users/guardas", {
        id: null,
        nome: this.state.userNome,
        email: this.state.userEmail,
        senha: this.state.userSenha,
        telefone: this.state.userTelefone
      }).then(resposta => {
        //se deu certo:
        alert('Cadastrado com sucesso!');
      })
        .catch(resposta => {
          //se der errado
          console.log(resposta);
          alert('Deu errado!');
        })
    } else {
      alert('Selecione o tipo de Usuário.');
    }
  }

  render() {
    return (
      <div>
        <form className='alinhandoEsquerda'>
          <MDBInput label="Nome Completo" background icon="user" group type="text" id='nome' onChange={(event => this.setState({ userNome: event.target.value }))} />
          <MDBInput label="E-mail" background icon="envelope" color="success" group type='email' id='email' onChange={(event => this.setState({ userEmail: event.target.value }))} />
          <MDBInput label="Senha" background icon="key" group type='password' id='senha' onChange={(event => this.setState({ userSenha: event.target.value }))} />
          <MDBInput label="Telefone / WhatsApp" background icon="phone" group type='tel' id='telefone' onChange={(event => this.setState({ userTelefone: event.target.value }))} />

          <div>
            <select className="custom-select custom-select-lg mb-5" id="categoria" defaultValue="1"  onChange={(event => this.setState({ userTipo: event.target.value }))} >
              <option disabled value="1">Tipo de Usuário</option>
              <option value="ADMINISTRADOR">Administrador</option>
              <option value="GUARDA">Guarda</option>
            </select>
          </div>

        </form>
        <MDBBtn color="success" className="text-xs-left"  onClick={() => this.userPost()}>Salvar</MDBBtn>
      </div>
    );
  }
}