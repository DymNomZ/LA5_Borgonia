package FoodOrderingSystem;

import javax.swing.*;

public class FoodOrderingSystem extends JFrame{

    private JPanel FOS_panel;
    private JCheckBox cPizza;
    private JCheckBox cBurger;
    private JCheckBox cFries;
    private JCheckBox cSoftDrinks;
    private JCheckBox cTea;
    private JCheckBox cSundae;
    private JRadioButton rNone;
    private JRadioButton r5;
    private JRadioButton r10;
    private JRadioButton r15;
    private JButton btnOrder;

    public FoodOrderingSystem(){
        this.setTitle("Food Ordering System");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(500, 400);
        this.setVisible(true);

        JCheckBox[] foods = {cPizza, cBurger, cSoftDrinks, cTea, cSundae, cFries};
        JRadioButton[] discounts = {r5, r10, r15, rNone};

        btnOrder.addActionListener(e -> {
            double discount = 0;
            double total = 0;

            for(JCheckBox food : foods){
                if(food.isSelected()){
                    String name = food.getText();
                    switch(name){
                        case "Pizza":
                            total += 100;
                            break;
                        case "Burger":
                            total += 80;
                            break;
                        case "Fries":
                            total += 65;
                            break;
                        case "Soft Drinks":
                            total += 55;
                            break;
                        case "Tea":
                            total += 50;
                            break;
                        case "Sundae":
                            total += 40;
                            break;
                    }
                }
            }

            if(r5.isSelected()){
                discount = total * 0.05;
                total -= discount;
            }
            else if(r10.isSelected()){
                discount = total * 0.1;
                total -= discount;
            }
            else if(r15.isSelected()){
                discount = total * 0.15;
                total -= discount;
            }

            JOptionPane.showMessageDialog(null, "The total price is Php " + String.format("%.2f", total));
        });

    }

    public static void main(String[] args) {
        FoodOrderingSystem fos = new FoodOrderingSystem();
        fos.setContentPane(fos.FOS_panel);
    }
}
