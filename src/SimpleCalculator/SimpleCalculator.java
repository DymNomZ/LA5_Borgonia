package SimpleCalculator;

import javax.swing.*;

public class SimpleCalculator extends JFrame{

    private JPanel calc_panel;
    private JTextField tfNumber1;
    private JComboBox cbOperations;
    private JTextField tfNumber2;
    private JButton btnCompute;
    private JLabel lbResult;

    public SimpleCalculator(){
        this.setTitle("Simple Calculator");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(600, 300);
        this.setVisible(true);

        btnCompute.addActionListener(e -> {
            String raw_num1 = tfNumber1.getText();
            String raw_num2 = tfNumber2.getText();

            try{
                double num1 = Double.parseDouble(raw_num1);
                double num2 = Double.parseDouble(raw_num2);
                double answer = 0;
                //get ops
                String op = (String) cbOperations.getSelectedItem();

                switch(op) {
                    case "+":
                        answer = num1 + num2;
                        break;
                    case "*":
                        answer = num1 * num2;
                        break;
                    case "-":
                        if(num1 > num2){
                            answer = num1 - num2;
                        }else answer = num2 - num1;
                        break;
                    case "/":
                        if(num1 > num2){
                            answer = num1 / num2;
                        }else answer = num2 / num1;
                        break;
                }

                lbResult.setText(String.format("%.2f", answer));


            } catch (NumberFormatException e1){
                JOptionPane.showMessageDialog(null, "Enter valid input!");
            } catch (ArithmeticException e2) {
                JOptionPane.showMessageDialog(null, "Cannot Divide by zero!");
            }
        });

    }

    public static void main(String[] args) {
        SimpleCalculator calc = new SimpleCalculator();
        calc.setContentPane(calc.calc_panel);
    }
}
