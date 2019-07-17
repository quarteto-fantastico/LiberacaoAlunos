import React from "react";
import { MDBInput, } from "mdbreact";
//Marcio
export default props => {

  return (
      <div>
        <MDBInput label="CPF" type="text" name="cpf" background icon="fas fa-id-card" onChange={(e => props.change(e))} />
        <MDBInput label="Nome" type="text" name="nome" background icon="fas fa-user" onChange={(e => props.change(e))} />
      </div>

    );
}