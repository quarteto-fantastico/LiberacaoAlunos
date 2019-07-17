import React from "react";
import { MDBInput } from "mdbreact";
//não funcionando
//Marcio


export default props => {

  return (
    <div>
      <MDBInput label="Nome" type="text" name="nome" background icon="user" onChange={(e => props.change(e))} />
      <MDBInput label="Email" type="text" name="email" background icon="envelope" onChange={(e => props.change(e))} />
      <MDBInput label="CPF" type="text" name="cpf" background icon="user" onChange={(e => props.change(e))} />
    </div>


  );
}


