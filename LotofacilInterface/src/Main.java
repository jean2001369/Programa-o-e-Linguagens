import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MainGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Jogo de Loteria");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JButton buttonAposta1 = new JButton("Apostar de 0 a 100");
        JButton buttonAposta2 = new JButton("Apostar de A à Z");
        JButton buttonAposta3 = new JButton("Apostar em par ou ímpar");

        panel.add(buttonAposta1);
        panel.add(buttonAposta2);
        panel.add(buttonAposta3);

        frame.add(panel);

        buttonAposta1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog(null, "Digite um número de 0 a 100:");
                try {
                    int numSorteio = Integer.parseInt(input);
                    int numAleatorio = (int) (Math.random() * 101);

                    if (numSorteio == numAleatorio) {
                        JOptionPane.showMessageDialog(null, "Você ganhou R$ 1.000,00 reais!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Que pena! O número sorteado foi: " + numAleatorio);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Aposta Inválida. Insira um número válido.");
                }
            }
        });

        buttonAposta2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog(null, "Digite uma letra de A a Z:");
                if (input != null && input.length() == 1) {
                    char letraPremiada = 'T';
                    char letraDigitada = Character.toUpperCase(input.charAt(0));

                    if (Character.isLetter(letraDigitada)) {
                        if (letraPremiada == letraDigitada) {
                            JOptionPane.showMessageDialog(null, "Você ganhou R$ 500,00 reais!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Que pena! A letra sorteada foi: " + letraPremiada);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Aposta Inválida. Insira uma letra válida.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Aposta Inválida. Insira apenas uma letra.");
                }
            }
        });

        buttonAposta3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog(null, "Aposte em um número par ou ímpar:");
                try {
                    int numeroSorteio = Integer.parseInt(input);

                    if (numeroSorteio % 2 == 0) {
                        JOptionPane.showMessageDialog(null, "Você ganhou R$ 100,00 reais!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Que pena! O número digitado é ímpar e a premiação foi para números pares.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Aposta Inválida. Insira um número válido.");
                }
            }
        });

        frame.setVisible(true);
    }
}