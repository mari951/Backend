import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
// import java.sql.*;

public class TelaDePesquisa extends JFrame { // documentaçao da tela de pesquisa 
    public static JLabel lblPesquisa; linha da tela de pesquisa 
    public static JTextField txtPesquisa;

    public static JLabel lblId;
    public static JTextField txtId; //linha da tela de id 

    public static JLabel lblNome; //linha da tela de nome 
    public static JTextField txtNome;

    public static JLabel lblEmail;
    public static JTextField txtEmail;

    public static JButton btnPesquisar; //linha de botao pesquisa 
    public static JButton btnPrimeiro; // linha de botao primeiro 
    public static JButton btnAnterior; // linha de botao anterior 
    public static JButton btnProximo; // linha de botao proximo 
    public static JButton btnUltimo; * // linha de botao ultimo 

    public static JLabel lblNotificacoes;

    public static int tamanhoInputs = 20; // linha de tamanho 
    public static String txtUsuario = "";

    public TelaDePesquisa()
    {
        super("Tela de Pesquisa");
        setLayout(new GridLayout(7,1,5,5)); // linha de numeraçao da tela de pesquisa 

        JPanel linha_lblPesquisa = new JPanel(new GridLayout(1, 2));

        lblPesquisa = new JLabel("Pesquisa:", SwingConstants.CENTER);
        linha_lblPesquisa.add(lblPesquisa);

        btnPesquisar = new JButton("🔍"); // linha da tela de pesquisa 
        btnPesquisar.setToolTipText("Pesquisar");
        btnPesquisar.setEnabled(false); // linha de pesquisa falso
        linha_lblPesquisa.add(btnPesquisar); 

        add(linha_lblPesquisa);

        JPanel linha_inputPesquisa = new JPanel(new GridLayout(1, 1));

        txtPesquisa = new JTextField(tamanhoInputs);
        linha_inputPesquisa.add(txtPesquisa);

        add(linha_inputPesquisa);

        JPanel linha_id = new JPanel(new GridLayout(1, 2));

        lblId = new JLabel("Id:", SwingConstants.RIGHT);
        linha_id.add(lblId);

        txtId = new JTextField(tamanhoInputs); //linha de id 
        txtId.setEnabled(false); // linha de id falso 
        linha_id.add(txtId);

        add(linha_id);

        JPanel linha_nome = new JPanel(new GridLayout(1, 2)); // linha de nome 

        lblNome = new JLabel("Nome:", SwingConstants.RIGHT);
        linha_nome.add(lblNome);

        txtNome = new JTextField(tamanhoInputs); // linha de tamanho de nome 
        txtNome.setEditable(false);
        linha_nome.add(txtNome);

        add(linha_nome);

        JPanel linha_email = new JPanel(new GridLayout(1, 2));

        lblEmail = new JLabel("Email:", SwingConstants.RIGHT); // linha de email 
        linha_email.add(lblEmail);

        txtEmail = new JTextField(10);
        txtEmail.setEditable(false); //linha de email 
        linha_email.add(txtEmail);

        add(linha_email);

        JPanel linha_botoes = new JPanel(new GridLayout(1, 4));

        btnPrimeiro = new JButton("<<"); // linha de botao primeiro 
        btnPrimeiro.setEnabled(false); // linha primeiro falso 
        linha_botoes.add(btnPrimeiro); // linha primeiro botao

        btnAnterior = new JButton("<");
        btnAnterior.setEnabled(false); // linha anterior falso 
        linha_botoes.add(btnAnterior);

        btnProximo = new JButton(">"); // linha do botao proximo 
        btnProximo.setEnabled(false); // linha proximo falso 
        linha_botoes.add(btnProximo);

        btnUltimo = new JButton(">>");
        btnUltimo.setEnabled(false); // linha botao ultimo falso 
        linha_botoes.add(btnUltimo);

        add(linha_botoes);

        JPanel linha_notificacoes = new JPanel(new GridLayout(1, 1)); // linha de numeracao de painel 

        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER);
        linha_notificacoes.add(lblNotificacoes);

        add(linha_notificacoes);

        btnPesquisar.addActionListener( // linha de botao de pesquisa 
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    if (txtPesquisa.getText().trim().length() <= 0) {
                        lblNotificacoes.setText(setHtmlFormat("Por favor, digite algo e tente novamente."));
                        txtPesquisa.requestFocus();
                        return;
                    } else {
                        NavegadorDeRegistro.pesquisar();
                    }
                }
            }
        );

        btnPrimeiro.addActionListener( // linha de botao primeiro 
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    if (ntfCampoVazio() == false) { // linha de campo vazio 
                        NavegadorDeRegistro.primeiroRegistro(); // linha de navegador de registro primeiro 
                    }
                }
            }
        );

        btnAnterior.addActionListener( // linha anterior 
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    if (ntfCampoVazio() == false) {
                        NavegadorDeRegistro.registroAnterior();
                    }
                }
            }
        );

        btnProximo.addActionListener( // linha do  botao do proximo 
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    if (ntfCampoVazio() == false) {
                        NavegadorDeRegistro.proximoRegistro();
                    }
                }
            }
        );

        btnUltimo.addActionListener( //linha do botao do ultimo 
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    if (ntfCampoVazio() == false) {
                        NavegadorDeRegistro.ultimoRegistro();
                    }
                }
            }
        );

        txtPesquisa.addKeyListener( // linha do botao de pesquisa 
            new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    if (txtPesquisa.getText().trim().equals(txtUsuario) == false && txtPesquisa.getText().trim().length() > 0) {
                        if (e.getKeyCode() == 10) {
                            NavegadorDeRegistro.pesquisar();
                        }
                    } else {
                        limparCampos("Digite algo para continuar.");
                    }
                    btnPesquisar.setEnabled(true);
                }
            }
        );

        setSize(250, 300); // linha de numeracao de pesquisa 
        setVisible(true);
        txtPesquisa.requestFocus();
    }

    public static boolean ntfCampoVazio() { // linha de campo vazio 
        if (txtPesquisa.getText().trim().length() <= 0) {
            lblNotificacoes.setText(setHtmlFormat("Ops! Campo vazio. Por favor, digite algo e tente novamente."));
            txtPesquisa.requestFocus();
            return true;
        } else {
            return false;
        }
    }

    public static void limparCampos(String notificacao) { // limparCampos("") // linha de limpar campos 
        btnPesquisar.setEnabled(false); // linha de pesquisa falso 
        txtId.setText("");
        txtNome.setText(""); // linha de nome 
        txtEmail.setText("");
        btnPrimeiro.setEnabled(false); // linha primeiro falso 
        btnAnterior.setEnabled(false);
        btnProximo.setEnabled(false); // linha do proximo falso 
        btnUltimo.setEnabled(false);
        if (notificacao.trim().length() > 0) {
            lblNotificacoes.setText(setHtmlFormat(notificacao));
        }
    }

    public static String setHtmlFormat(String strTexto) {
        return "<html><body>" + strTexto + "</body></html>";
    }

    public static void main(String[] args) {
        TelaDePesquisa appTelaDePesquisa = new TelaDePesquisa();
        appTelaDePesquisa.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
