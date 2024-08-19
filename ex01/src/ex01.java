import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ex01 {
    public JPanel mainpanel;
    public JTextArea textArea1;
    public JTextArea textArea2;
    public JRadioButton adicao;
    public JRadioButton subtracao;
    public JRadioButton divisao;
    public JRadioButton multiplicacao;

    public ButtonGroup Buttons;

    public ex01(){
        Buttons = new ButtonGroup();
        Buttons.add(adicao);
        Buttons.add(subtracao);
        Buttons.add(divisao);
        Buttons.add(multiplicacao);

        adicao.addActionListener(new OperacaoListener());
        subtracao.addActionListener(new OperacaoListener());
        divisao.addActionListener(new OperacaoListener());
        multiplicacao.addActionListener(new OperacaoListener());
    }

    public class OperacaoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {

                double num1 = Double.parseDouble(textArea1.getText());
                double num2 = Double.parseDouble(textArea2.getText());
                double resultado = 0;

                if (adicao.isSelected()) {
                    resultado = num1 + num2;
                } else if (subtracao.isSelected()) {
                    resultado = num1 - num2;
                } else if (divisao.isSelected()) {
                    if (num2 != 0) {
                        resultado = num1 / num2;
                    } else {
                        throw new ArithmeticException("Divisão por zero");
                    }
                } else if (multiplicacao.isSelected()) {
                    resultado = num1 * num2;
                }


                JOptionPane.showMessageDialog(mainpanel, "Resultado: " + resultado);
            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(mainpanel, "Por favor, insira valores válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (ArithmeticException ex) {

                JOptionPane.showMessageDialog(mainpanel, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
