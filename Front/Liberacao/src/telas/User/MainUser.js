import React, { Component } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min';
import { MDBCardBody, MDBCardTitle, MDBContainer, MDBRow, MDBCol } from "mdbreact";
import ListaUser from './ListaUser';
import CadastroUser from './CadastroUser';
//Rodrigo

export default class CadastroUsuario extends Component {

  showSettings(event) {
    event.preventDefault();
  }

  render() {
    return (
      <MDBContainer>
        <MDBContainer style={{ marginTop: 60, marginBottom: 60 }}>
          <MDBRow>
            <MDBCol size="1"></MDBCol>
            <MDBCol size="15" md="15" lg="15" className="mx-auto float-none white z-depth-3 py-2 px-2">
              <MDBCardBody>
                <MDBCardTitle>Lista de Usuários</MDBCardTitle>
                <div className="alinhandoEsquerda">
                  <ListaUser></ListaUser>

                </div>

              </MDBCardBody>
            </MDBCol>
            <MDBCol size="1"></MDBCol>
          </MDBRow>
        </MDBContainer>

        <MDBContainer style={{ marginTop: 60, marginBottom: 60 }}>
          <MDBRow>
            <MDBCol size="2"></MDBCol>
            <MDBCol size="8" md="8" lg="8" className="mx-auto float-none white z-depth-3 py-2 px-2">
              <MDBCardBody>
                <MDBCardTitle>Cadastro de Usuário</MDBCardTitle>
                
                <CadastroUser></CadastroUser>

              </MDBCardBody>
            </MDBCol>
            <MDBCol size="2"></MDBCol>
          </MDBRow>
        </MDBContainer>


      </MDBContainer>
    );
  }
}