
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class TelaDeLoginView {
   public TelaDeLoginView() {
   }
}
public class TelaDeLoginView extends JFrame {
    public static JLabel lblId;
    public static JComboBox<String> cbxId;
    public static String[] ids;

    public static JLabel lblNome;
    public static JTextField txtNome;
    public static String nomeAtual;

    public static JLabel lblEmail;
    public static JTextField txtEmail;
    public static String emailAtual;

    public static JLabel lblSenha;
    public static JPasswordField txtSenha;
    public static String senhaAtual;

    public static JLabel lblNotificacoes;

    public static JButton btnAtualizar;
    public static JButton btnCancelar;

    public static int tamanhoInputs = 20;

    public TelaDeLoginView()
    {
        super("Tela de LoginView");
        setLayout(new GridLayout(6,1,5,5));

        JPanel linha_id = new JPanel(new GridLayout(1, 2));

        lblId = new JLabel("Id:", SwingConstants.RIGHT);
        linha_id.add(lblId);

        NavegadorDeRegistro.popularIds();
        cbxId = new JComboBox(ids);
        linha_id.add(cbxId);

        add(linha_id);

        JPanel linha_nome = new JPanel(new GridLayout(1, 2));

        lblNome = new JLabel("Nome:", SwingConstants.RIGHT);
        linha_nome.add(lblNome);

        txtNome = new JTextField(tamanhoInputs);
        linha_nome.add(txtNome);

        add(linha_nome);

        JPanel linha_email = new JPanel(new GridLayout(1, 2));

        lblEmail = new JLabel("Email:", SwingConstants.RIGHT);
        linha_email.add(lblEmail);

        txtEmail = new JTextField(tamanhoInputs);
        linha_email.add(txtEmail);

        add(linha_email);

        JPanel linha_senha = new JPanel(new GridLayout(1, 2));

        lblSenha = new JLabel("Senha:", SwingConstants.RIGHT);
        linha_senha.add(lblSenha);

        txtSenha = new JPasswordField(tamanhoInputs);
        linha_senha.add(txtSenha);

        add(linha_senha);
   
   btnAtualizar.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    TelaDeLoginView.atualizarId();
                }
            }
        );

        btnCancelar.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    TelaDeLoginView.limparCampos();
                }
            }
        );

        cbxId.addItemListener(
            new ItemListener() {
            @Override
                public void itemStateChanged(ItemEvent event) {
                    if (event.getStateChange() == ItemEvent.SELECTED) {
                        TelaDeLoginView.atualizarCampos(cbxId.getSelectedItem().toString());
                    }
                } 
            }
        );
        new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                try {
                    Connection conexao = MySQLConnector.conectar();
                    String strSqlLogin = "select * from `db_senac`.`tbl_senac` where `email` = '" + txtLogin.getText() + "' and `senha` = '" + String.valueOf(txtSenha.getPassword()) + "';";
                    Statement stmSqlLogin = conexao.createStatement();
                    ResultSet rstSqlLogin = stmSqlLogin.executeQuery(strSqlLogin);
                    if (rstSqlLogin.next()) {
                        lblNotificacoes.setText(setHtmlFormat("Conectado com sucesso!!!"));
                    } else {
                        lblNotificacoes.setText(setHtmlFormat("Login e/ou senha não encontrado! Por favor, verifique e tente novamente."));
                    }
                    stmSqlLogin.close();
                } catch (Exception e) {
                    lblNotificacoes.setText(setHtmlFormat("Não foi possível encontrar o login e/ou senha digitados/informados! Por favor, verifique e tente novamente. Veja o erro: " + e));
                }
            }
        
    };

    SetSize(150,200);
    setVisible(true);



private String setHtmlFormat(String strTexto) {
    return "<html><body>" + strTexto + "</body></html>";
}

public static void main(String[] args) {
    appTelaDeLoginView = new TelaDeLogin();
    appTelaDeLoginView.setDefaultCloseOperation(EXIT_ON_CLOSE);
}
}