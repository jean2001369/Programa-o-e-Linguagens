import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Color;

public class FormularioTeste extends JFrame {
    private JPanel painel = new JPanel();
    private JButton jButtonLimpar = new JButton("Limpar");
    private JTextField jTextFieldTexto = new JTextField("Teste", 20);
    private JLabel jLabelMensagem = new JLabel("Exemplo Simples de Janela");

    public FormularioTeste() {
        this.setTitle("Texto da Barra de Título");
        this.setSize(300, 200);
        painel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 20));
        painel.setBackground(new Color(255, 255, 255));
        painel.add(jTextFieldTexto);
        painel.add(jButtonLimpar);
        painel.add(jLabelMensagem);
        this.getContentPane().add(painel);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new FormularioTeste();
    }
}

