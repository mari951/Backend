package controller;
import model.*;
import view.*;
import javax.swing.*;
import static java.nio.file.StandardCopyOption.*;
import java.nio.file.*;


public class TelaDeAtualizacaoController extends TelaDeAtualizacaoView {
    public static void popularIds() {
        TelaDeAtualizacaoModel.popularIdsModel();
    }

    public static void enviarIds(String[] idsView) {
        ids = idsView;
    }

    public static void enviarIds(String []) idsView) {
        ids = idsView;
    }
    public static void atualizarId(){
        try {
            String atualizarNome = "";
            String atualizarEmail = "";
            String atualizarSenha = "";
            String atualizarImagem = "";

            if (txtNome.getText().trim().equals(nomeAtual) == false) {
                atualizarNome = "`nome` = '" + txtNome.getText() + "'";
            }

            if (txtEmail.getText().trim().equals(emailAtual) == false) {
                if (atualizarNome.length() > 0) {
                    atualizarEmail = " , ";
                }
                atualizarEmail += "`email` = '" + txtEmail.getText() + "'";
            }

            if (String.valueOf(txtSenha.getPassword()).trim().equals(senhaAtual) == false) {
                if (atualizarNome.length() > 0 || atualizarEmail.length() > 0) {
                    atualizarSenha = " , ";
                }
                atualizarSenha += "`senha` = '" + String.valueOf(txtSenha.getPassword()) + "'";
            }

            if (atualizarNome.length() > 0 || atualizarEmail.length() > 0 || atualizarSenha.length() > 0) {
                TelaDeAtualizacaoModel.atualizarCadastroModel(cbxId.getSelectedItem().toString(), atualizarNome, atualizarEmail, atualizarSenha);
            } else {
                lblNotificacoes.setText("Não foram encontradas alterações para atualizar o id " + cbxId.getSelectedItem().toString());
            }
        } catch (Exception e) {
            lblNotificacoes.setText(setHtmlFormat("Não foi possível atualizar o id! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e);
        }
    }

    public static void limparCampos() {
        txtNome.setText("");
        txtEmail.setText("");
        txtSenha.setText("");
        cbxId.setSelectedIndex(0);
    }

    public static void atualizarCampos(String id) {
        if (cbxId.getSelectedIndex() > 0) {
            TelaDeAtualizacaoModel.atualizarCamposModel(String.valueOf(cbxId.getSelectedIndex()));
            // aqui será chamado o método que vai atualizar os campos via model
        } else {
            lblNotificacoes.setText("Selecione um id para continuar.");
            limparCampos();
        }
    }

    public static void enviarCampos(String nome, String email, String senha) {
        txtNome.setText(nome);
        nomeAtual = txtNome.getText();
        txtEmail.setText(email);
        emailAtual = txtEmail.getText();
        txtSenha.setText(senha);
        senhaAtual = String.valueOf(txtSenha.getPassword());
    }

    public static void notificarUsuario(String txt) {
        lblNotificacoes.setText(setHtmlFormat(txt));
    }

    public static void registrarAtualizacao() {
        nomeAtual = txtNome.getText();
        emailAtual = txtEmail.getText();
        senhaAtual = String.valueOf(txtSenha.getPassword());

    
    }
public static void carregarimagem imagem() {
//aqui vai carregar a imagem para a tela de atualizacao 
String fileName = ="";
try {

    JFileChosser chooser = new JFileChooser();
     chooser.setDialogTitle(dialogTitle:"Selecione o arquivo que deseja carregar");
     chooser.setApproveButtonText(approveButtonText:"Carregar arquivo");
     int returnVal1=chooser.showOpenDialog(parent:null);
     String fileFullPatch="";
     if (returnVal1 == JFileChooser.APPROVE_OPTION){
    fileFullPatch=chooser.getSelectdFile().getAbsolutePatch();
    fileName = chooser getSelectedFile().getName();
     }else {
    System.out.println("Que pena!");
    


