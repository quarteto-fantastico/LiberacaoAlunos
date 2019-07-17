import React, { Component } from "react";
import axios from 'axios';
import { MDBDataTable, MDBInput, MDBCollapse, MDBBtn } from "mdbreact";
import { urlServidor } from '../../Variaveis.json'
// Rodrigo


export default class ListaUser extends Component {
  constructor(props) {
    super(props);
    this.state = {
      collapseID: false,

      userIdAtual: '',
      userNomeAtual: '',
      userEmailAtual: '',
      userSenhaAtual: '',
      userTelefoneAtual: '',
      userTipoAtual: '',
      userNomeNovo: '',
      userEmailNovo: '',
      userSenhaNovo: '',
      userTelefoneNovo: '',
      userTipoNovo: '',
      listaUsers: {
        columns: [
          {
            label: 'ID',
            field: 'id',
            sort: 'asc',
            width: 45
          },
          {
            label: 'Nome',
            field: 'nome',
            sort: 'asc',
            width: 150
          },
          {
            label: 'E-mail',
            field: 'email',
            sort: 'asc',
            width: 200
          },
          // {
          //   label: 'Senha',
          //   field: 'senha',
          //   sort: 'asc',
          //   width: 200
          // },
          {
            label: 'Ativo',
            field: 'check',
            sort: 'asc',
            width: 70
          },
          {
            label: 'Telefones',
            field: 'telefones',
            sort: 'asc',
            width: 200
          },
          // {
          //   label: 'Data de Cadastro',
          //   field: 'create_time',
          //   sort: 'asc',
          //   width: 200
          // },
          {
            label: 'Editar',
            field: 'editar',
            sort: 'asc',
            width: 80
          },
          {
            label: 'Deletar',
            field: 'deletar',
            sort: 'asc',
            width: 100
          },
          // {
          //   label: 'Registros de Saídas',
          //   field: 'registros_saidas',
          //   sort: 'asc',
          //   width: 200
          // },
          // {
          //   label: 'Registros de Entradas',
          //   field: 'registros_entradas',
          //   sort: 'asc',
          //   width: 200
          // },
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

  componentDidMount() {
    axios.get(urlServidor + '/users')
      .then(resposta => {
        //se deu certo:
        //this.setState({ listaProfessores: resposta.data })
        let data = { ...this.state.listaUsers }
        data.rows = resposta.data
        data.rows.forEach(linha => {
          linha.ativo =
            <div className='alinhandoCentro'>
              <input type="checkbox" id={`${linha.id}`} defaultChecked={linha.ativo} disabled />
            </div>
          //<MDBInput type="checkbox" id={`${linha.id}`} checked={true}/>;
          //<MDBInput type="checkbox" id={`${linha.id}`} unchecked={true}/>;

          //console.log(linha.ativo)
        });
        data.rows.forEach(linha => {
          linha.perfis =
            <div>
              <button color="primary" onClick={() => this.toggleCollapse() + this.setState({ userIdAtual: linha.id, userNomeAtual: linha.nome, userEmailAtual: linha.email, userSenhaAtual: linha.senha, userTelefoneAtual: linha.telefone })}>
                Editar
              </button>
            </div>
        })

        data.rows.forEach(linha => {
          // data.rows = linha.slice(1,2)
          linha.delete =
            <div className='tyleBotao'>
              <button onClick={() => this.userDelete(linha.id)}>Deletar</button>
            </div>;
          //console.log(linha.perfis)
        });
        //console.log(data)
        this.setState({ listaUsers: data })

      })
      .catch(resposta => {
        //se deu errado:
        alert('Deu errado!')
        console.log(resposta)
      })
  }



  userEditar() {
    axios.put(urlServidor + '/users/' + this.state.userIdAtual, {
      id: this.state.userIdAtual,
      nome_user: this.state.userNomeNovo,
      email_user: this.state.userEmailNovo,
      telefone: this.state.userTelefoneNovo,
      tipo: this.state.userTipoNovo
    })
  }

  userDelete(idzin) {
    axios.delete(urlServidor + '/users/' + idzin)
      .then(res => {
        console.log(res);
        console.log(res.data);
        alert('User deletada')
        window.location.reload();
      }).catch(resposta => {
        //se der errado
        console.log(resposta);
        alert('Dados incorretos!');
      })
  }


  render() {
    return (
      <div>
        <MDBDataTable
          scrollY
          scrollX
          striped
          bordered
          hover
          data={this.state.listaUsers}
        />

        <MDBCollapse isOpen={this.state.collapseID}>

          {this.state.erro && <div className="alert alert-danger">{this.state.erro}</div>}
          <MDBInput label={this.state.userNomeAtual} name="userNome" background icon="user" onChange={(event => this.setState({ userNomeNovo: event.target.value }))} />
          <MDBInput label={this.state.userEmailAtual} background icon="envelope" onChange={(event => this.setState({ userEmailNovo: event.target.value }))} />
          <MDBInput label={this.state.userTelefoneAtual} background icon="phone" onChange={(event => this.setState({ userTelefoneNovo: event.target.value }))} />

          <select className="browser-default custom-select" defaultValue={this.state.userTipoAtual} onChange={(event => this.setState({ userTipoNovo: event.target.value }))} >
            <option disabled>Tipo de Usuário</option>
            <option value="ADMINISTRADOR">Administrador</option>
            <option value="GUARDA">Guarda</option>
          </select>
          <div className='tyleBotao'>
            <MDBBtn className="dusty-grass-gradient" onClick={() => this.userEditar()}>Salvar</MDBBtn>
          </div>

        </MDBCollapse>
      </div>
    );
  }

}