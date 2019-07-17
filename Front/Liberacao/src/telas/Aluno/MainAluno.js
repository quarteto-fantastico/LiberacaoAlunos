import React, { Component } from 'react';
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.bundle";
import { MDBBtn, MDBRow, MDBCol, MDBInput, MDBCard, MDBCardBody } from "mdbreact";
//import Imagem from '../../foto.jpg';
// import CadastroResposavel from "./CadastroResponsavel";
import CadastroAluno from "./CadastroAluno";
import ListaAlunos from "./ListaAlunos";
import api from '../../services/api';
import { urlServidor } from '../../Variaveis.json';
//Marcio




//Marcio
export default class MainAluno extends Component {

  constructor(props) {
    super(props);
    this.state = {
      listaAlunos: [],
      aluno: {
        id: null,
        nome: null,
        cpf: null,
      },
      id: null,
      listaTurmas: [],
      nome: 'nuuhj',
      email: 'gyugy',
      responsavel: {
        id: null,
        nome: null,
        email: null,
      },
      turmaIdSlc: null,
    }

    this.changeAluno = this.changeAluno.bind(this)
  }

  componentDidMount = async e => {
    api.get(urlServidor + '/turmas')
      .then(resposta => {
        let data = null
        data = resposta.data
        console.log(data)
        this.setState({ listaTurmas: data })
        console.log(this.state.listaTurmas)

      })
      .catch(resposta => {
        alert('Deu errado!')
        console.log(resposta)
      })

    api.get(urlServidor + '/alunos')
      .then(resposta => {
        console.log(resposta.data)
        this.setState({ listaAlunos: resposta.data })
      })
      .catch(resposta => {
        alert('Deu errado!')
        console.log(resposta)
      })
  }


  alunoPost() {
    let tamanhoLista = this.state.listaAlunos.length + 1
    if (!this.state.aluno.nome | !this.state.aluno.cpf | !this.state.nome | !this.state.cpf | !this.state.email | !this.state.turmaIdSlc) {
      alert("prencha todos os campos")
    } else {
      api.post(urlServidor + '/alunos', {
        id: null,
        nome: this.state.aluno.nome,
        cpf: this.state.aluno.cpf,
        turmas: [
          {
            "id": this.state.turmaIdSlc
          }
        ]
      }).then(resposta => {
        api.post(urlServidor + '/responsavel', {
          id: null,
          nome: this.state.nome,
          email: this.state.email,
          cpf: this.state.cpf,
          aluno:
          {
            "id": tamanhoLista
          }

        }).then(resposta => {
          alert('Cadastrado com sucesso!')
          console.log(tamanhoLista)
          window.location.reload();
        }).catch(resposta => {
          alert('Não Responsavel')
          console.log(tamanhoLista)
        })
      }).catch(resposta => {
        alert('Não cadastrado')
      })

    }

  }

  responsavelPost() {


  }



  changeAluno(e) {
    const aluno = { ...this.state.aluno }
    aluno[e.target.cpf] = e.target.value
    aluno[e.target.name] = e.target.value
    this.setState({ aluno })
    console.log(this.state)
  }

  render() {
    return (
      <div id="App">
        <div id="page-wrap">
          <h1>Aluno</h1>
          <div className="container" style={{ marginBottom: 30, marginTop: 30 }}>
            <div className="alinhandoEsquerda">
              <ListaAlunos></ListaAlunos>
            </div>
            <MDBCol>
              <form className="alinhandoEsquerda">
                <MDBCard>
                  <MDBCardBody>
                    <MDBRow>
                      <MDBCol size="1">
                      </MDBCol>
                      <MDBCol size="10">
                        <h3>Cadastro de Aluno</h3>
                        <CadastroAluno change={this.changeAluno}></CadastroAluno>
                        <h3>Cadastro de Responsável</h3>
                        <MDBInput label="Nome" type="text" name="nome" background icon="fas fa-user" onChange={(e => this.setState({ nome: e.target.value }))} />
                        <MDBInput label="Email" type="text" name="email" background icon="fas fa-envelope" onChange={(e => this.setState({ email: e.target.value }))} />
                        <MDBInput label="CPF" type="text" name="cpf" background icon="fas fa-id-card" onChange={(e => this.setState({ cpf: e.target.value }))} />
                        {/* Select da Turma */}
                        <select className="custom-select custom-select-lg mb-5" id="Turma" defaultValue="1" onChange={(e => this.setState({ turmaIdSlc: e.target.value }) + console.log(this.state.turmaIdSlc))}>
                          <option disabled value="1">Turma</option>
                          {this.state.listaTurmas.map(tur =>
                            <option key={tur.id} value={tur.id}>{tur.nome_curso}</option>
                          )}
                        </select>
                        {/* Botão Cadastrar */}
                        <div className='alinhandoCentro'>
                        <MDBBtn color="success" className="text-xs-left" onClick={() => this.alunoPost() + this.responsavelPost()}>Cadastrar</MDBBtn>
                        </div>
                      </MDBCol>
                      <MDBCol size="1">
                      </MDBCol>
                    </MDBRow>
                  </MDBCardBody>
                </MDBCard>
              </form>
            </MDBCol>
          </div>
        </div>
      </div>
    );
  }
}
//this.responsavelPost() +