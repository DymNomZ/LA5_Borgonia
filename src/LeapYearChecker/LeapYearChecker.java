package LeapYearChecker;

import javax.swing.*;

public class LeapYearChecker extends JFrame {

    private JPanel lyc_panel;
    private JTextField yearTextField;
    private JButton checkYearButton;

    public LeapYearChecker(){
        this.setTitle("Leap Year Checker");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(300, 300);
        this.setVisible(true);

        checkYearButton.addActionListener(e -> {
            String raw_input = yearTextField.getText();
            try{
                int year = Integer.parseInt(raw_input);
                boolean leap = false;
                if (year % 4 == 0) {

                    if (year % 100 == 0) {

                        if (year % 400 == 0)
                            leap = true;
                        else
                            leap = false;
                    }

                    else
                        leap = true;
                }
                JOptionPane.showMessageDialog(null, leap ? "Leap year" : "Not a Leap Year");
            } catch (NumberFormatException e1) {
                JOptionPane.showMessageDialog(null, "Enter valid year");
            }
        });
    }
    public static void main(String[] args) {

        LeapYearChecker lyc = new LeapYearChecker();
        lyc.setContentPane(lyc.lyc_panel);
    }
}
