import java.sql.*;

public class NavegadorDeRegistro extends TelaDePesquisa { // documentaçao da tela de navegador de registro 
    public static void pesquisar() {
        try {
            if (txtPesquisa.getText().trim().equals(txtUsuario) == false) { // tela de usuario falso 
                limparCampos(""); // limpar campos 
                Connection conexao = MySQLConnector.conectar();
                String strSqlPesquisa = "select * from `db_senac`.`tbl_senac` where `nome` like '%" + txtPesquisa.getText() + "%' or `email` like '%" + txtPesquisa.getText() + "%' order by `id` asc;";
                Statement stmSqlPesquisa = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rstSqlPesquisa = stmSqlPesquisa.executeQuery(strSqlPesquisa); // tela de pesquisa exucute 
                if (rstSqlPesquisa.next()) { 
                    rstSqlPesquisa.last(); // tela de pesquisa 
                    int rowNumbers = rstSqlPesquisa.getRow();
                    rstSqlPesquisa.first();

                    lblNotificacoes.setText(setHtmlFormat("Legal! Foi(Foram) encontrado(s) " + rowNumbers + " resultado(s)."));
                    txtId.setText(rstSqlPesquisa.getString("id")); // linha de  id 
                    txtNome.setText(rstSqlPesquisa.getString("nome")); // linha de nome 
                    txtEmail.setText(rstSqlPesquisa.getString("email"));//linha de email de pesquisa 
                    txtUsuario = txtPesquisa.getText(); // linha de usuario de pesquisa 
                    btnPesquisar.setEnabled(false); // linha de pesquisa falso 
                    if (rowNumbers > 1) {
                        btnProximo.setEnabled(true); // linha do proximo verdadeiro 
                        btnUltimo.setEnabled(true);
                    }
                } else {
                    txtUsuario = txtPesquisa.getText(); // linha de usuario de pesquisa 
                    btnPesquisar.setEnabled(false);
                    lblNotificacoes.setText(setHtmlFormat("Poxa vida! Não foram encontrados resultados para: \"" + txtPesquisa.getText() + "\"."));
                }
                stmSqlPesquisa.close();
            }
        } catch (Exception e) {
            lblNotificacoes.setText(setHtmlFormat("Não foi possível prosseguir com a pesquisa! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e); // linha de erro 
        }
    }

    public static void primeiroRegistro() { // linha de primeiro registro 
        try {
            limparCampos("Você está no primeiro registro."); // linha de limpar campos 
            Connection conexao = MySQLConnector.conectar(); // linha de conexao 
            String strSqlPesquisa = "select * from `db_senac`.`tbl_senac` where `nome` like '%" + txtPesquisa.getText() + "%' or `email` like '%" + txtPesquisa.getText() + "%' order by `id` asc;";
            Statement stmSqlPesquisa = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rstSqlPesquisa = stmSqlPesquisa.executeQuery(strSqlPesquisa);
            if (rstSqlPesquisa.next()) {
                txtId.setText(rstSqlPesquisa.getString("id")); //linha de pesquisa de id 
                txtNome.setText(rstSqlPesquisa.getString("nome")); // linha de pesquisa de nome 
                txtEmail.setText(rstSqlPesquisa.getString("email")); // linha de pesquisa de email 
                btnProximo.setEnabled(true);
                btnUltimo.setEnabled(true);
            } else {
                lblNotificacoes.setText(setHtmlFormat("Poxa vida! Não foram encontrados resultados para: \"" + txtPesquisa.getText() + "\"."));
            }
            txtUsuario = txtPesquisa.getText(); // linha de usuario 
            btnPesquisar.setEnabled(false);
            stmSqlPesquisa.close();
        } catch (Exception e) {
            lblNotificacoes.setText(setHtmlFormat("Não foi possível prosseguir com a pesquisa! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e);
        }
    }

    public static void registroAnterior() {
        try {
            String idAtual = txtId.getText(); //linha de id atual 
            String nomeAtual = txtNome.getText();
            String emailAtual = txtEmail.getText();
            limparCampos("Registro anterior posicionado com sucesso.");
            Connection conexao = MySQLConnector.conectar();
            String strSqlProximoRegistro = "select * from `db_senac`.`tbl_senac` where (`nome` like '%" + txtPesquisa.getText() + "%' or `email` like '%" + txtPesquisa.getText() + "%') and `id` < " + idAtual + " order by `id` desc;";
            Statement stmSqlProximoRegistro = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rstSqlProximoRegistro = stmSqlProximoRegistro.executeQuery(strSqlProximoRegistro);
            if (rstSqlProximoRegistro.next()) {
                txtId.setText(rstSqlProximoRegistro.getString("id")); // linha de id proximo registro 
                txtNome.setText(rstSqlProximoRegistro.getString("nome")); // linha de nome proxino registro 
                txtEmail.setText(rstSqlProximoRegistro.getString("email"));
                btnPrimeiro.setEnabled(true);
                btnAnterior.setEnabled(true); // linha do botao anterior verdadeiro 
                btnProximo.setEnabled(true); // linha do proximo verdadeiro botao 
                btnUltimo.setEnabled(true);
            } else {
                txtId.setText(idAtual);
                txtNome.setText(nomeAtual); //linha de nome atual 
                txtEmail.setText(emailAtual);
                btnProximo.setEnabled(true);
                btnUltimo.setEnabled(true);
                lblNotificacoes.setText("Você chegou ao primeiro registro.");
            }
            stmSqlProximoRegistro.close();
        } catch (Exception e) {
            lblNotificacoes.setText(setHtmlFormat("Não foi possível encontrar o próximo registro! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e);
        }    }

    public static void proximoRegistro() {
        try {
            String idAtual = txtId.getText();
            String nomeAtual = txtNome.getText();// linha de string nome atual 
            String emailAtual = txtEmail.getText();
            limparCampos("Próximo registro posicionado com sucesso.");
            Connection conexao = MySQLConnector.conectar();
            String strSqlProximoRegistro = "select * from `db_senac`.`tbl_senac` where (`nome` like '%" + txtPesquisa.getText() + "%' or `email` like '%" + txtPesquisa.getText() + "%') and `id` > " + idAtual + " order by `id` asc;";
            Statement stmSqlProximoRegistro = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rstSqlProximoRegistro = stmSqlProximoRegistro.executeQuery(strSqlProximoRegistro);
            if (rstSqlProximoRegistro.next()) {
                txtId.setText(rstSqlProximoRegistro.getString("id"));
                txtNome.setText(rstSqlProximoRegistro.getString("nome")); // linha de string do proximo registro 
                txtEmail.setText(rstSqlProximoRegistro.getString("email"));
                btnPrimeiro.setEnabled(true);
                btnAnterior.setEnabled(true); // linha do botao anterior
                btnProximo.setEnabled(true);
                btnUltimo.setEnabled(true);
            } else {
                txtId.setText(idAtual);
                txtNome.setText(nomeAtual);
                txtEmail.setText(emailAtual);//linha de botao de email 
                btnPrimeiro.setEnabled(true);
                btnAnterior.setEnabled(true);
                lblNotificacoes.setText("Você chegou ao último registro.");
            }
            stmSqlProximoRegistro.close();
        } catch (Exception e) {
            lblNotificacoes.setText(setHtmlFormat("Não foi possível encontrar o próximo registro! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e);
        }
    }

    public static void ultimoRegistro() {
        try {
            String idAtual = txtId.getText();
            String nomeAtual = txtNome.getText(); // linha de string nome atual 
            String emailAtual = txtEmail.getText();
            limparCampos("");
            Connection conexao = MySQLConnector.conectar();
            String strSqlProximoRegistro = "select * from `db_senac`.`tbl_senac` where `nome` like '%" + txtPesquisa.getText() + "%' or `email` like '%" + txtPesquisa.getText() + "%' order by `id` desc;";
            Statement stmSqlProximoRegistro = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rstSqlProximoRegistro = stmSqlProximoRegistro.executeQuery(strSqlProximoRegistro);
            if (rstSqlProximoRegistro.next()) {
                txtId.setText(rstSqlProximoRegistro.getString("id"));
                txtNome.setText(rstSqlProximoRegistro.getString("nome")); // linha do proximo registro id 
                txtEmail.setText(rstSqlProximoRegistro.getString("email"));
                btnPrimeiro.setEnabled(true);
                btnAnterior.setEnabled(true);
                lblNotificacoes.setText("Você chegou ao último registro.");
            } else {
                txtId.setText(idAtual);
                txtNome.setText(nomeAtual);
                txtEmail.setText(emailAtual);
                btnPrimeiro.setEnabled(true);
                btnAnterior.setEnabled(true);
                lblNotificacoes.setText("Você chegou ao último registro.");
            }
            stmSqlProximoRegistro.close();
        } catch (Exception e) {
            lblNotificacoes.setText(setHtmlFormat("Não foi possível encontrar o último registro! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e);
        }
    }
}
