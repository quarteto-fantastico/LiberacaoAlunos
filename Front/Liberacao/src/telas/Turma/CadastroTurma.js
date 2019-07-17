import React, { Component } from 'react';
import { MDBInput, MDBBtn, MDBCardTitle } from "mdbreact";
import axios from 'axios';
import { urlServidor } from '../../Variaveis.json';
//Bruno
export default class CadastroTurma extends Component {
  // showSettings(event) {
  //   event.preventDefault();
  // }
  constructor(props) {
    super(props);
    this.state = {
      turmaId: '1',
      turmaNome: null,
      turmaPeriodo: 'MATUTINO',
      turmaFase: null,
      turmaAnoSemestre: null,
      erro: ''
    }
  }

  turmaPost() {
    if (!this.state.turmaNome) {
      this.setState({ erro: "Preencha nome da turma para continuar!" });
    } else {
      axios.post(urlServidor + '/turmas', {
        id: null,
        nome_curso: this.state.turmaNome,
        periodo: this.state.turmaPeriodo,
        fase: this.state.turmaFase,
        ano_semestre: this.state.turmaAnoSemestre
      }).then(resposta => {
        //se deu certo:
        alert('Cadastrado com sucesso!');
        window.location.reload();
      }).catch(resposta => {
        //se der errado
        alert('Dados incorretos!');
      })
    }
  }

  render() {
    return (
      <form>
        <MDBCardTitle>Cadastro de Turma</MDBCardTitle>
        {this.state.erro && <div className="alert alert-danger">{this.state.erro}</div>}
        <MDBInput label="Nome da Turma" name="turmaNome" background icon="door-closed" onChange={(event => this.setState({ turmaNome: event.target.value }))} />
        <MDBInput label="Fase" background icon="hourglass" onChange={(event => this.setState({ turmaFase: event.target.value }))} />
        <MDBInput label="Ano / Semestre" background icon="hourglass" onChange={(event => this.setState({ turmaAnoSemestre: event.target.value }))} />
        <select className="browser-default custom-select" defaultValue="MATUTINO" onChange={(event => this.setState({ turmaPeriodo: event.target.value }))} >
          <option disabled>Período</option>
          <option value="MATUTINO">Matutino</option>
          <option value="VESPERTINO">Vespertino</option>
          <option value="DIURNO">Diurno</option>
          <option value="NOTURNO">Noturno</option>
        </select>
        <div className='tyleBotao'>
          <MDBBtn className="dusty-grass-gradient" onClick={() => this.turmaPost()}>Salvar</MDBBtn>
        </div>
      </form>
    );
  }
}
