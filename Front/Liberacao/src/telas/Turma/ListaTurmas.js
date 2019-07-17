import React, { Component } from "react";
import axios from '../../services/api';
import { DataTable, MDBCollapse, MDBBtn, MDBInput } from "mdbreact";
import { urlServidor } from '../../Variaveis.json';
//import EditarTurma from './EditarTurma';
// Bruno

export default class ListaTurmas extends Component {
  constructor(props) {
    super(props);
    this.state = {
      collapseID: false,
      turmaIdAtual: '',
      turmaNomeAtual: '',
      turmaFaseAtual: '',
      AnoSemestreAtual: '',
      turmaPeriodoAtual:'',
      turmaNomeNovo: '',
      turmaFaseNovo: '',
      AnoSemestreNovo: '',
      turmaPeriodoNovo:'',
      listaTurmas: {
        columns: [
          {
            label: 'ID',
            field: 'id',
            sort: 'asc',
            width: 45,
          },
          {
            label: 'Curso',
            field: 'nome_curso',
            sort: 'asc',
            width: 170,
          },
          {
            label: 'Período',
            field: 'periodo',
            sort: 'asc',
            width: 150,
          },
          {
            label: 'Fase',
            field: 'fase',
            sort: 'asc',
            width: 45,
          },
          {
            label: 'Ano/Semestre',
            field: 'ano_semestre',
            sort: 'asc',
            width: 45,
          },
          {
            label: 'Editar',
            field: 'editar',
            sort: 'asc',
            width: 45,
          },
          {
            label: 'Deletar',
            field: 'deletar',
            sort: 'asc',
            width: 45,
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

  componentDidMount() {
    axios.get(urlServidor + '/turmas')
      .then(resposta => {
        //se deu certo:
        //this.setState({ listaTurmas: resposta.data })
        let data = { ...this.state.listaTurmas }
        data.rows = resposta.data
        data.rows.forEach(linha => {
          linha.edit =
            <div>
              <button color="primary" onClick={() => this.toggleCollapse() + this.setState({ turmaIdAtual: linha.id, turmaNomeAtual: linha.nome_curso, turmaFaseAtual: linha.fase, AnoSemestreAtual: linha.ano_semestre, turmaPeriodoAtual:linha.periodo })}>
                Editar
              </button>
            </div>
        });
        // data.rows.forEach(linha => {
        //   // data.rows = linha.slice(1,2)
        //   linha.delete =
        //     <div className='tyleBotao'>
        //       <button onClick={() => this.turmaDelete(linha.id)}>Deletar</button>
        //     </div>;
        //   console.log(linha.perfis)
        // });
        console.log(data)
        this.setState({ listaTurmas: data })

      })
      .catch(resposta => {
        //se deu errado:
        alert('Deu errado!')
        console.log(resposta)
      })
  }

  turmaEditar() {
    axios.put(urlServidor + '/turmas/' + this.state.turmaIdAtual, {
      id: this.state.turmaIdAtual,
      nome_curso: this.state.turmaNomeNovo,
      periodo: this.state.turmaPeriodoNovo,
      fase: this.state.turmaFaseNovo,
      ano_semestre: this.state.AnoSemestreNovo,
      // aluno:[{id:1}]
    }).then(res => {
      window.location.reload();
    })
  }

  // turmaDelete(idzin) {
  //   axios.delete(urlServidor + '/turmas/' + idzin)
  //     .then(res => {
  //       console.log(res);
  //       console.log(res.data);
  //       alert('Turma deletada')
  //       window.location.reload();
  //     }).catch(resposta => {
  //       //se der errado
  //       console.log(resposta);
  //       alert('Dados incorretos!');
  //     })
  // }


  render() {
    return (
      <div>
        <h2>{this.state.turmaPeriodoAtual}</h2>
        <DataTable
          scrollY
          scrollX
          striped
          bordered
          hover
          data={this.state.listaTurmas}
        />
        <MDBCollapse isOpen={this.state.collapseID}>

          {this.state.erro && <div className="alert alert-danger">{this.state.erro}</div>}
          <MDBInput label={this.state.turmaNomeAtual} name="turmaNome" background icon="door-closed" onChange={(event => this.setState({ turmaNomeNovo: event.target.value }))} />
          <MDBInput label={this.state.turmaFaseAtual} background icon="hourglass" onChange={(event => this.setState({ turmaFaseNovo: event.target.value }))} />
          <MDBInput label={this.state.AnoSemestreAtual} background icon="hourglass" onChange={(event => this.setState({ AnoSemestreNovo: event.target.value }))} />

          <select className="browser-default custom-select" defaultValue="MATUTINO" onChange={(event => this.setState({ turmaPeriodoNovo: event.target.value }))} >
            <option disabled>{this.state.turmaPeriodoAtual}</option>
            <option value="MATUTINO">Matutino</option>
            <option value="VESPERTINO">Vespertino</option>
            <option value="DIURNO">Diurno</option>
            <option value="NOTURNO">Noturno</option>
          </select>
          <div className='tyleBotao'>
            <MDBBtn className="dusty-grass-gradient" onClick={() => this.turmaEditar()}>Salvar</MDBBtn>
          </div>

        </MDBCollapse>
      </div>
    );
  }

}