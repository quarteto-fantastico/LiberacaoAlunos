import React, { Component } from "react";
import api from '../../services/api';
import { DataTable, MDBCollapse, MDBBtn, MDBInput } from "mdbreact";
import { urlServidor } from '../../Variaveis.json';
//Marcio

export default class ListaAlunos extends Component {
  constructor(props) {
    super(props);
    this.state = {
      collapseID: false,
      aLunoIdAtual: '',
      alunoNomeAtual: '',
      alunoCpfAtual: '',
      alunoomeNovo: '',
      alunoCpfNovo: '',
      listaAlunos: {
        columns: [
          {
            label: 'ID',
            field: 'id',
            sort: 'asc',
            width: 150
          },
          {
            label: 'Nome',
            field: 'nome',
            sort: 'asc',
            width: 150
          },
          {
            label: 'CPF',
            field: 'cpf',
            sort: 'asc',
            width: 270
          },
          {
            label: 'Editar',
            field: 'editar',
            sort: 'asc',
            width: 270
          },
      
        ],
        rows: [
          {

          }
        ]
      }
    }
  }
  
  toggleCollapse() {
    let colapsado = ''
    if (this.state.collapseID === false) {
      colapsado = true
    } else {
      colapsado = false
    }
    this.setState({ collapseID: colapsado })
  }

  componentDidMount = async e => {
    api.get(urlServidor + '/alunos')
      .then(resposta => {
        //se deu certo:
        //this.setState({ listaAlunos: resposta.data })
        let data = { ...this.state.listaAlunos }
        data.rows = resposta.data
        data.rows.forEach(linha => {
          linha.turmas = <div className='tyleBotao'>
          <button color="primary" onClick={() => this.toggleCollapse() + this.setState({ alunoIdAtual: linha.id, alunoNomeAtual: linha.nome, alunoCpfAtual: linha.cpf})}>
            Editar
          </button>
        </div>
          })
          data.rows.forEach(linha => {
            // data.rows = linha.slice(1,2)
            console.log(linha.perfis)
          });
        console.log(data)
        this.setState({ listaAlunos: data })
      })
      .catch(resposta => {
        //se deu errado:
        alert('Deu errado!')
        console.log(resposta)
      })
  }

  alunoEditar() {
    api.put(urlServidor + '/alunos/' + this.state.alunoIdAtual, {
      id: this.state.alunoIdAtual,
      nome: this.state.alunoNomeNovo,
      cpf: this.state.alunoCpfNovo,
      // aluno:[{id:1}]
    }).then(res => {
      window.location.reload();
    })
  }



  render() {
    return (
    
      <div>
        <DataTable
          scrollY
          scrollX
          striped
          bordered
          hover
          data={this.state.listaAlunos}
        />
        <MDBCollapse isOpen={this.state.collapseID}>

          {this.state.erro && <div className="alert alert-danger">{this.state.erro}</div>}
          <MDBInput label={this.state.alunoCpfAtual} name="AlunoCpf" background icon="user" onChange={(event => this.setState({ alunoCpfNovo: event.target.value }))} />
          <MDBInput label={this.state.alunoNomeAtual} background icon="user" onChange={(event => this.setState({ alunoNomeNovo: event.target.value }))} />
        
          <div className='tyleBotao'>
            <MDBBtn className="dusty-grass-gradient" onClick={() => this.alunoEditar()}>Salvar</MDBBtn>
          </div>

        </MDBCollapse>
      </div>
    );
  }
}