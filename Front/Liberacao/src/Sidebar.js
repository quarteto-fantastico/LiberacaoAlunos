import React from 'react';
import { slide as Menu } from 'react-burger-menu';
import { Link } from 'react-router-dom';
//Bruno

export default props => {
  return (
    <Menu {...props}>
      <Link to="/">{'Login'}</Link>
      <Link to="/menu_principal">{'Menu'}</Link>
      <Link to="/cadastro_entrada">{'Cadastro de entrada'}</Link>
      <Link to="/cadastro_saida">{'Cadastro de saida'}</Link>
      <Link to="/usuario">{'Usuário'}</Link>
      <Link to="/professor">{'Professor'}</Link>
      <Link to="/aluno">{'Aluno'}</Link>
      <Link to="/turma">{'Turmas'}</Link>
      <Link to="/alunos_liberados_entrada">{'Tela de liberação de entrada'}</Link>
      <Link to="/alunos_liberados_saida">{'Tela de liberação de saida'}</Link>
      <Link to="/Ajuda">{'Ajuda'}</Link>
      {/* <Link to="/">{'Logout'}</Link> */}
    </Menu>
  );
}
