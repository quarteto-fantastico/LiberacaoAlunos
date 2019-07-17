import React, { Component } from "react";
import api from '../../services/api';
import { DataTable } from "mdbreact";
import { urlServidor } from '../../Variaveis.json'
// Bruno

export default class ListaProfessores extends Component {
  constructor(props) {
    super(props);
    this.state = {
      listaProfessores: {
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
            label: 'E-mail',
            field: 'email',
            sort: 'asc',
            width: 270
          },
          // {
          //   label: 'Senha',
          //   field: 'senha',
          //   sort: 'asc',
          //   width: 200
          // },
          {
            label: 'Ativo',
            field: 'ativo',
            sort: 'asc',  
          },
          {
            label: 'Telefone',
            field: 'telefone',
            sort: 'asc',  
          },
          {
            label: 'Perfil',
            field: 'perfil',
            sort: 'asc',  
          },
        ],
        rows: [
          {

          }
        ]
      }
    }
  }

  componentDidMount() {
    api.get(urlServidor + '/users/professores')
      .then(resposta => {
        //se deu certo:
        //this.setState({ listaProfessores: resposta.data })
        let data = { ...this.state.listaProfessores }
        data.rows = resposta.data
        data.rows.forEach(linha => {
          // data.rows = linha.slice(1,2)
          linha.perfis=<p>Professor</p>
          linha.ativo=<input type="checkbox" defaultChecked={linha.ativo} disabled/>;
          //console.log(linha.perfis)
        });
        // console.log(data)
        this.setState({ listaProfessores: data })

      })
      .catch(resposta => {
        //se deu errado:
        alert('Deu errado!')
        console.log(resposta)
      })
      // .catch(erro => {
      //     if (erro.response.status === 403) {
      //         this.props.history.push("/");    
      //     }
      // })
  }
  render() {
    return (
      <DataTable
        striped
        bordered
        hover
        data={this.state.listaProfessores}
      />
    );
  }

}