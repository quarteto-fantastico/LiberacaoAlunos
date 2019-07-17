import React, { Component } from 'react';
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.bundle";
// Marcio

export default class Ajuda extends Component {

  render() {
    return (
      <div className="container">
        <h1>Menu de Ajuda</h1>
        <div className="card">
          <div className="cord-body">
            <div>
              <h2>Login</h2>
              <img alt='Imagem da Tela de Login' className="" src="imagens/Tela_login.png" width="750" height="400" ></img>
              <div className="row">
                <div className="col-4"></div>
                <div className="col-6 alinhandoEsquerda">
                  <p className="h6">
                    1. Digite seu email no campo Email;<br />
                    2. Digite sua senha no campo Senha;<br />
                    3. Você será redirecionado para tela Menu.
                  </p>
                </div>
              </div>
            </div>
            <br />

            <div>
              <h2>Menu</h2>
              <img alt='Imagem da Tela de Menu Principal' className="" src="imagens/tela menu.png" width="750" height="400" ></img>
              <div className="row">
                <div className="col-4"></div>
                <div className="col-6 alinhandoEsquerda">
                  <p className="h6">
                    1. Escolha a página de destino na lista do menu do lado esquerdo;<br />
                    2. Clique no nome da página para ir à página de destino;<br />
                    3. O menu esquerdo está acessível a partir de qualquer página.
                  </p>
                </div>
              </div>
            </div>
            <br />

            <div>
              <h2>Cadastro de Entrada</h2>
              <img alt='Imagem da Tela de Cadastro de Entrada Tardia de Alunos' className="" src="imagens/tela_cadastro_entrada.png" width="750" height="400" ></img>
              <div className="row">
                <div className="col-4"></div>
                <div className="col-6 alinhandoEsquerda">
                  <p className="h6">
                    1.Inserir o CPF do aluno já cadastrado;<br />
                    2.O sistema irá alto preencher os demais campos;<br />
                    3.Adicionar o professor atual para que ele receba uma notificação;<br />
                    4.Selecionar a Turma que o aluno está ativo no período;<br />
                    5.Selecionar o(s) dia(s), que o aluno deverá ser liberado;<br />
                    6.Salvar.
                  </p>
                </div>
              </div>
            </div>
            <br />

            <div>
              <h2>Cadastro Saida</h2>
              <img alt='Imagem da Tela de Cadastro de Saída Antecipada de Alunos' className="" src="imagens/tela_cadastro_saida.png" width="750" height="400" ></img>
              <div className="row">
                <div className="col-4"></div>
                <div className="col-6 alinhandoEsquerda">
                  <p className="h6">
                    1.Inserir o CPF do aluno já cadastrado;<br />
                    2.O sistema irá alto preencher os demais campos;<br />
                    3.Selecionar a Turma que o aluno está ativo no período;<br />
                    4.Selecionar o(s) dia(s), que o aluno deverá ser liberado;<br />
                    5.Salvar.
                  </p>
                </div>
              </div>
            </div>
            <br />

            <div>
              <h2>Cadastro de Usuario</h2>
              <img alt='Imagem da Tela de Cadastro de Usuários do Sistema' className="" src="imagens/tela_cadastro_user.png" width="750" height="600" ></img>
              <div className="row">
                <div className="col-2"></div>
                <div className="col-5 alinhandoEsquerda">
                  <h4>Cadastro de Guarda </h4>
                  <p className="h6">
                    1.Insira o nome do guarda;<br />
                    2.Insira o email do guarda;<br />
                    3.Insira uma senha para o guarda;<br />
                    4.Insira o telefone do guarda;<br />
                    5.Insira o tipo de usuário como guarda.
                  </p>
                </div>
                <div className="col-5 alinhandoEsquerda">
                  <h4>Cadastro de Administrador</h4>
                  <p className="h6">
                    1.Insira o nome do administrador;<br />
                    2.Insira o email do administrador;<br />
                    3.Insira uma senha para o administrador;<br />
                    4.Insira o telefone do administrador;<br />
                    5.Insira o tipo de usuário como administrador.
                  </p>
                </div>
              </div>
            </div>
            <br />
            <div>
              <h2>Cadastro de Professor</h2>
              <img alt='Imagem da Tela de Cadastro de Professores' className="" src="imagens/tela_cadastro_professor.png" width="750" height="600" ></img>
              <div className="row">
                <div className="col-4"></div>
                <div className="col-6  alinhandoEsquerda">
                  <p className="h6">
                    1.Insira o nome do professor;<br />
                    2.Insira o email do professor;<br />
                    3.Insira uma senha para o professor;<br />
                    4.Insira o telefone do professor.
                  </p>
                </div>
              </div>
            </div>
            <br />
            <div>
              <h2>Cadastro de Aluno</h2>
              <img alt='Imagem da Tela de Cadastro de Alunos' className="" src="imagens/tela_cadastro_aluno.png" width="750" height="600" ></img>
              <div className="row">
                <div className="col-2"></div>
                <div className="col-5 alinhandoEsquerda">
                  <h4>Cadastro de Aluno</h4>
                  <p className="h6">
                    1.Insira o CPF do aluno;<br />
                    2.Insira o nome do aluno;<br />
                    3.Insira a data de nascimento do aluno;<br />
                    4.Insira o nome do responsável;<br />
                    5.Insira o email do responsável;<br />
                    6.Clique no botão foto e faça o upload da foto do aluno;<br />
                    7.Selecione uma turma para o aluno;<br />
                    8.Caso a turma não exista vá à página de Turmas e faça o cadastro da mesma;<br />
                    9.Clique no botão Cadastrar e verifique se o aluno está incluso na lista de alunos cadastrados no topo.
                  </p>
                </div>
                <div className="col-3 alinhandoEsquerda">
                  <h4>Edição de dados</h4>
                  <p className="h6">
                    1.Pesquise pelo nome do aluno ou pelo CPF do aluno no campo Search;<br />
                    2.Clique no botão Editar na linha do aluno em questão;<br />
                    3.Altere os dados necessários;<br />
                    4.Clique no botão Salvar.
                  </p>
                </div>
              </div>
            </div>
            <br />

            <div>
              <h2>Cadastro de Turma</h2>
              <img alt='Imagem da Tela de Cadastro de Turmas' className="" src="imagens/tela_cadastro_turma.png" width="750" height="600" ></img>
              <div className="row">
                <div className="col-2"></div>
                <div className="col-4 alinhandoEsquerda">
                  <h4>Cadastro de Turma</h4>
                  <p className="h6">
                    1.Insira nome da turma;<br />
                    2.Insira a atual fase da turma;<br />
                    3.Insira o ano e semestre atual;<br />
                    4.Escolha o turno da turma.<br />
                  </p>
                </div>
                <div className="col-4 alinhandoEsquerda">
                  <h4>Edição de turma</h4>
                  <p className="h6">
                    1.Escolha turma a ser editada e clique no botão editar;<br />
                    2.Ao abrir o menu logo abaixo da lista, Insira os novos dados e clique em salvar.
                </p>
                </div>
              </div>
            </div>
            <br />
            <div>
              <h2>Liberação Entrada</h2>
              <img alt='Imagem da Tela de Liberação para Entrada Tardia' className="" src="imagens/tela_liberados_entrada.png" width="750" height="500" ></img>
              <div className="row">
                <div className="col-3"></div>
                <div className="col-6 alinhandoEsquerda">
                  <p className="h6">
                    1.Essa tela demonstra os alunos que têm permissão para a entrada tardia em sala de aula.<br/>
                    2.O botão deletar retiram os alunos da lista de liberados para entrada tardia.
                </p>
                </div>
                <div className="col-4"></div>
              </div>
            </div>
            <br />
            <div>
              <h2>Liberação Saida</h2>
              <img alt='Imagem da Tela de Liberação para Entrada Tardia' className="" src="imagens/tela_liberados_saida.png" width="750" height="500" ></img>
              <div className="row">
                <div className="col-3"></div>
                <div className="col-6 alinhandoEsquerda">
                  <p className="h6">
                    1.Essa tela demonstra os alunos que têm permissão para a Saida Antecipada da sala de aula.<br/>
                    2.O botão deletar retiram os alunos da lista de liberados para Saida Antecipada.
                  </p>
                </div>
                <div className="col-4"></div>
              </div>
            </div>
          </div>
        </div>
      </div>
    )
  }
}






