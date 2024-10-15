import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaDeAtualizacao extends JFrame { // documentaçao de tela de atualizaçao 
    public static JLabel lblId; // documentaçao de linha de id 
    public static JComboBox<String> cbxId; // linha de documentao de string de id 
    public static String[] ids;

    public static JLabel lblNome; // linha de nome 
    public static JTextField txtNome;
    public static String nomeAtual;

    public static JLabel lblEmail; // linha de email 
    public static JTextField txtEmail;
    public static String emailAtual;

    public static JLabel lblSenha; // linha de senha 
    public static JPasswordField txtSenha;
    public static String senhaAtual;

    public static JLabel lblNotificacoes;

    public static JButton btnAtualizar; // linha de atualizar 
    public static JButton btnCancelar;

    public static int tamanhoInputs = 20;

    public TelaDeAtualizacao()
    {
        super("Tela de Atualização"); // linha de tela de atualizaçao 
        setLayout(new GridLayout(6,1,5,5));

        JPanel linha_id = new JPanel(new GridLayout(1, 2));

        lblId = new JLabel("Id:", SwingConstants.RIGHT); // linha de id 
        linha_id.add(lblId);

        NavegadorDeRegistro.popularIds(); // linha de navegador de registro de id 
        cbxId = new JComboBox(ids);
        linha_id.add(cbxId);

        add(linha_id);

        JPanel linha_nome = new JPanel(new GridLayout(1, 2));

        lblNome = new JLabel("Nome:", SwingConstants.RIGHT); // linha de nome 
        linha_nome.add(lblNome);

        txtNome = new JTextField(tamanhoInputs);
        linha_nome.add(txtNome);

        add(linha_nome);

        JPanel linha_email = new JPanel(new GridLayout(1, 2));

        lblEmail = new JLabel("Email:", SwingConstants.RIGHT); // linha de email 
        linha_email.add(lblEmail);

        txtEmail = new JTextField(tamanhoInputs);
        linha_email.add(txtEmail);

        add(linha_email);

        JPanel linha_senha = new JPanel(new GridLayout(1, 2));

        lblSenha = new JLabel("Senha:", SwingConstants.RIGHT); // linha de senha 
        linha_senha.add(lblSenha);

        txtSenha = new JPasswordField(tamanhoInputs);
        linha_senha.add(txtSenha);

        add(linha_senha);

        JPanel linha_botoes = new JPanel(new GridLayout(1, 2));

        btnAtualizar = new JButton("Atualizar"); // linha de atualizaçao 
        linha_botoes.add(btnAtualizar);

        btnCancelar = new JButton("Cancelar"); // linha de botao cancelar 
        linha_botoes.add(btnCancelar);

        add(linha_botoes);

        JPanel linha_notificacoes = new JPanel(new GridLayout(1, 1));

        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER);
        linha_notificacoes.add(lblNotificacoes);

        add(linha_notificacoes);

        btnAtualizar.addActionListener( // linha de atualizar 
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    NavegadorDeRegistro.atualizarId();
                }
            }
        );

        btnCancelar.addActionListener( // linha de cancelar 
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    NavegadorDeRegistro.limparCampos();
                }
            }
        );

        cbxId.addItemListener(
            new ItemListener() {
            @Override
                public void itemStateChanged(ItemEvent event) {
                    if (event.getStateChange() == ItemEvent.SELECTED) {
                        NavegadorDeRegistro.atualizarCampos(cbxId.getSelectedItem().toString());
                    }
                } 
            }
        );

        setSize(250, 300);
        ImageIcon img = new ImageIcon("./senac-logo.png");
        setIconImage(img.getImage());
        setVisible(true);
        cbxId.requestFocus();
    }

    public static String setHtmlFormat(String strTexto) {
        return "<html><body>" + strTexto + "</body></html>";
    }

    public static void main(String[] args) {
        TelaDeAtualizacao appTelaDeAtualizacao = new TelaDeAtualizacao();
        appTelaDeAtualizacao.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
