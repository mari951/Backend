import java.sql.*;

public class NavegadorDeRegistro extends TelaDePesquisa { //documentaçao de linha de pesquisa 
    public static void pesquisar() {
        try {
            if (txtPesquisa.getText().trim().equals(txtUsuario) == false) { linha de pesquisa,usuario false 
                limparCampos("");
                Connection conexao = MySQLConnector.conectar(); linha de conexao 
                String strSqlPesquisa = "select * from `db_senac`.`tbl_senac` where `nome` like '%" + txtPesquisa.getText() + "%' or `email` like '%" + txtPesquisa.getText() + "%' order by `id` asc;";
                Statement stmSqlPesquisa = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rstSqlPesquisa = stmSqlPesquisa.executeQuery(strSqlPesquisa); //linha de pesquisa execute 
                if (rstSqlPesquisa.next()) {
                    rstSqlPesquisa.last();
                    int rowNumbers = rstSqlPesquisa.getRow();//linha de numero de pesquisa 
                    rstSqlPesquisa.first();

                    lblNotificacoes.setText(setHtmlFormat("Legal! Foi(Foram) encontrado(s) " + rowNumbers + " resultado(s)."));
                    txtId.setText(rstSqlPesquisa.getString("id")); // linha de pesquisa de id 
                    txtNome.setText(rstSqlPesquisa.getString("nome")); // linha de pesquisa de nome 
                    txtEmail.setText(rstSqlPesquisa.getString("email")); // linha de pesquisa de email 
                    txtUsuario = txtPesquisa.getText();
                    btnPesquisar.setEnabled(false); //linha de pesquisa falso 
                    if (rowNumbers > 1) {
                        btnProximo.setEnabled(true); // linha de pesquisa proximo verdadeiro 
                        btnUltimo.setEnabled(true);
                    }
                } else {
                    txtUsuario = txtPesquisa.getText(); // linha de usuario de pesquisa 
                    btnPesquisar.setEnabled(false); // linha de pesquisa falso 
                    lblNotificacoes.setText(setHtmlFormat("Poxa vida! Não foram encontrados resultados para: \"" + txtPesquisa.getText() + "\"."));
                }
                stmSqlPesquisa.close();
            }
        } catch (Exception e) {
            lblNotificacoes.setText(setHtmlFormat("Não foi possível prosseguir com a pesquisa! Por favor, verifique e tente novamente.")); 
            System.err.println("Erro: " + e);
        }
    }

    public static void primeiroRegistro() { // linha de primeiro registro 
        try {
            limparCampos("Você está no primeiro registro."); // linha de limpar campos de primeiro registro 
            Connection conexao = MySQLConnector.conectar();
            String strSqlPesquisa = "select * from `db_senac`.`tbl_senac` where `nome` like '%" + txtPesquisa.getText() + "%' or `email` like '%" + txtPesquisa.getText() + "%' order by `id` asc;";
            Statement stmSqlPesquisa = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rstSqlPesquisa = stmSqlPesquisa.executeQuery(strSqlPesquisa); // linha de documentaçao de pesquisa execute 
            if (rstSqlPesquisa.next()) {
                txtId.setText(rstSqlPesquisa.getString("id")); //linha de pesquisa de id 
                txtNome.setText(rstSqlPesquisa.getString("nome"));//linha de pesquisa de nome 
                txtEmail.setText(rstSqlPesquisa.getString("email"));//linha de pesquisa de email 
                btnProximo.setEnabled(true); //linha proximo de verdadeiro 
                btnUltimo.setEnabled(true);
            } else {
                lblNotificacoes.setText(setHtmlFormat("Poxa vida! Não foram encontrados resultados para: \"" + txtPesquisa.getText() + "\"."));
            }
            txtUsuario = txtPesquisa.getText();
            btnPesquisar.setEnabled(false);
            stmSqlPesquisa.close();
        } catch (Exception e) {
            lblNotificacoes.setText(setHtmlFormat("Não foi possível prosseguir com a pesquisa! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e);
        }
    }

    public static void registroAnterior() {
        try {
            String idAtual = txtId.getText(); // linha de string id atual 
            String nomeAtual = txtNome.getText(); // linha de string de nome 
            String emailAtual = txtEmail.getText(); // linha de email 
            limparCampos("Registro anterior posicionado com sucesso."); //linha de limpar campos 
            Connection conexao = MySQLConnector.conectar();
            String strSqlProximoRegistro = "select * from `db_senac`.`tbl_senac` where (`nome` like '%" + txtPesquisa.getText() + "%' or `email` like '%" + txtPesquisa.getText() + "%') and `id` < " + idAtual + " order by `id` desc;";
            Statement stmSqlProximoRegistro = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rstSqlProximoRegistro = stmSqlProximoRegistro.executeQuery(strSqlProximoRegistro);
            if (rstSqlProximoRegistro.next()) {
                txtId.setText(rstSqlProximoRegistro.getString("id")); //linha de id proximo registro 
                txtNome.setText(rstSqlProximoRegistro.getString("nome"));//linha de nome proximo registro 
                txtEmail.setText(rstSqlProximoRegistro.getString("email"));//linha de email proximo registro 
                btnPrimeiro.setEnabled(true);
                btnAnterior.setEnabled(true);
                btnProximo.setEnabled(true);
                btnUltimo.setEnabled(true);
            } else {
                txtId.setText(idAtual); // linha de id atual 
                txtNome.setText(nomeAtual);// linha de nome atual 
                txtEmail.setText(emailAtual);//linha de email 
                btnProximo.setEnabled(true);// linha proximo verdadeiro 
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
            String idAtual = txtId.getText();//linha de string id atual 
            String nomeAtual = txtNome.getText(); // linha de string nome atual 
            String emailAtual = txtEmail.getText(); // linha de string de email atual 
            limparCampos("Próximo registro posicionado com sucesso.");
            Connection conexao = MySQLConnector.conectar();
            String strSqlProximoRegistro = "select * from `db_senac`.`tbl_senac` where (`nome` like '%" + txtPesquisa.getText() + "%' or `email` like '%" + txtPesquisa.getText() + "%') and `id` > " + idAtual + " order by `id` asc;";
            Statement stmSqlProximoRegistro = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rstSqlProximoRegistro = stmSqlProximoRegistro.executeQuery(strSqlProximoRegistro);
            if (rstSqlProximoRegistro.next()) {
                txtId.setText(rstSqlProximoRegistro.getString("id")); //linha de id proximo registro 
                txtNome.setText(rstSqlProximoRegistro.getString("nome"));// linha de nome proximo registro 
                txtEmail.setText(rstSqlProximoRegistro.getString("email")); // linha de email proximo registro 
                btnPrimeiro.setEnabled(true);
                btnAnterior.setEnabled(true);
                btnProximo.setEnabled(true);
                btnUltimo.setEnabled(true);
            } else {
                txtId.setText(idAtual); // linha de id atual 
                txtNome.setText(nomeAtual); // linha de nome atual 
                txtEmail.setText(emailAtual); // linha de email atual 
                btnPrimeiro.setEnabled(true); // linha primeiro verdadeiro 
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
            String idAtual = txtId.getText(); // linha de string id atual 
            String nomeAtual = txtNome.getText(); // linha de string de nome atual 
            String emailAtual = txtEmail.getText(); // linha de email atual 
            limparCampos(""); // linha de limpar campos 
            Connection conexao = MySQLConnector.conectar();
            String strSqlProximoRegistro = "select * from `db_senac`.`tbl_senac` where `nome` like '%" + txtPesquisa.getText() + "%' or `email` like '%" + txtPesquisa.getText() + "%' order by `id` desc;";
            Statement stmSqlProximoRegistro = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rstSqlProximoRegistro = stmSqlProximoRegistro.executeQuery(strSqlProximoRegistro);
            if (rstSqlProximoRegistro.next()) {
                txtId.setText(rstSqlProximoRegistro.getString("id"));
                txtNome.setText(rstSqlProximoRegistro.getString("nome"));
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
