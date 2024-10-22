import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaDeRemover extends JFrame { // documentacao da tela de remover 
    public static JLabel lblId;
    public static JComboBox<String> cbxId;
    public static String[] ids; // linha de string de id 

    public static JLabel lblNome; // linha de nome 
    public static JTextField txtNome;

    public static JLabel lblEmail; // linha de email 
    public static JTextField txtEmail;

    public static JLabel lblNotificacoes;

    public static JButton btnRemover; // linha de botao remover 
    public static JButton btnCancelar;

    public static int tamanhoInputs = 20;

    public TelaDeRemover() // linha da tela de remover 
    {
        super("Tela de Atualização"); // linha da tela de atualizacao 
        setLayout(new GridLayout(5,1,5,5));

        JPanel linha_id = new JPanel(new GridLayout(1, 2)); // linha de id 

        lblId = new JLabel("Id:", SwingConstants.RIGHT);
        linha_id.add(lblId);

        NavegadorDeRegistro.popularIds(); // linha de navegador de registro de id 
        cbxId = new JComboBox<String>(ids);
        linha_id.add(cbxId);

        add(linha_id);

        JPanel linha_nome = new JPanel(new GridLayout(1, 2));

        lblNome = new JLabel("Nome:", SwingConstants.RIGHT); // linha de navegador de nome 
        linha_nome.add(lblNome);

        txtNome = new JTextField(tamanhoInputs); // linha de nome de tamanho 
        txtNome.setEditable(false); // linha de nome falso 
        linha_nome.add(txtNome);

        add(linha_nome);

        JPanel linha_email = new JPanel(new GridLayout(1, 2));

        lblEmail = new JLabel("Email:", SwingConstants.RIGHT); // linha de email 
        linha_email.add(lblEmail);

        txtEmail = new JTextField(tamanhoInputs);
        txtEmail.setEditable(false);
        linha_email.add(txtEmail);

        add(linha_email);

        JPanel linha_botoes = new JPanel(new GridLayout(1, 2));

        btnRemover = new JButton("Remover"); //linha de botao de remover 
        linha_botoes.add(btnRemover);

        btnCancelar = new JButton("Cancelar"); //linha de botao cancelar 
        linha_botoes.add(btnCancelar);

        add(linha_botoes);

        JPanel linha_notificacoes = new JPanel(new GridLayout(1, 1));

        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER);// linha de notificao 
        linha_notificacoes.add(lblNotificacoes);

        add(linha_notificacoes);

        btnRemover.addActionListener( // linha de remover 
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    NavegadorDeRegistro.removerId();
                }
            }
        );

        btnCancelar.addActionListener( // linha de cancelar 
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    NavegadorDeRegistro.limparCampos(); // linha de navegador de registro limpar campos 
                }
            }
        );

        cbxId.addItemListener(
            new ItemListener() {
            @Override
                public void itemStateChanged(ItemEvent event) {
                    if (event.getStateChange() == ItemEvent.SELECTED) {
                        NavegadorDeRegistro.atualizarCampos(false); // linha de navegador de registro atualizar campos falso 
                    }
                } 
            }
        );

        setSize(250, 300);
        ImageIcon img = new ImageIcon("./senac-logo.png"); // linha de imagem de senac 
        setIconImage(img.getImage());
        setVisible(true);
        cbxId.requestFocus();
    }

    public static String setHtmlFormat(String strTexto) {
        return "<html><body>" + strTexto + "</body></html>";
    }

    public static void main(String[] args) {
        TelaDeRemover appTelaDeRemover = new TelaDeRemover(); // linha de tela de remover 
        appTelaDeRemover.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
