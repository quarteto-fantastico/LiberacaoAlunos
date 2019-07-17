import React, { Component } from "react";
import { MDBCardBody } from "mdbreact";
import CadastroTurma from "./CadastroTurma";
import ListaTurmas from "./ListaTurmas";
// Bruno

export default class MainTurma extends Component {

  render() {
    return (
      <div className='container containerBorda' style={{ marginTop: 60, marginBottom: 60 }}>
        <div className='row'>
          <div className='col-sm-2'></div>
          <div className='col-sm-8 alinhandoEsquerda z-depth-3'>
          <MDBCardBody>
            <ListaTurmas></ListaTurmas>
            <CadastroTurma></CadastroTurma>
          </MDBCardBody>
        </div>
        <div className='col-sm-2'></div>
      </div>
      </div >
    );
  }
}