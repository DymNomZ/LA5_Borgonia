package ItemListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.LinkedList;
import java.util.List;

public class ItemListener extends JFrame {

    private JPanel panel1;
    private JCheckBox cCheckBox;
    private JCheckBox cppCheckBox;
    private JCheckBox cSharpCheckBox;
    private JCheckBox javaCheckBox;
    private JCheckBox pythonCheckBox;
    private JComboBox proficiencyComboBox;
    private JLabel languageLabel;
    private JLabel proficiencyLabel;
    private int language_counter;
    List<String> languages;

    private void setCheckBoxBehavior(JCheckBox cb,String name){
        cb.addItemListener(new java.awt.event.ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e){
                if(e.getStateChange() == ItemEvent.SELECTED){
                    languages.add(name);
                } else {
                    languages.remove(name);
                }
                outputLanguages();

            }
        });
    }
    private void outputLanguages(){
        String languages_string = "";
        int ctr = 0;
        for(String s : languages){

            if(ctr != 0)languages_string += ", ";
            languages_string += s;
            ctr++;
        }
        languageLabel.setText("My Favorite Languages: " + languages_string);
    }
    public ItemListener() throws HeadlessException{
        super("Item Listener");
        languages = new LinkedList<>();
        language_counter = 0;
        setCheckBoxBehavior(cCheckBox,"C");
        setCheckBoxBehavior(cppCheckBox,"C++");
        setCheckBoxBehavior(cSharpCheckBox,"C#");
        setCheckBoxBehavior(javaCheckBox,"Java");
        setCheckBoxBehavior(pythonCheckBox,"Python");
        proficiencyComboBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String selectedItem = (String) e.getItem();
                proficiencyLabel.setText("Proficiency: " + selectedItem);
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public static void main(String[] args) {
        ItemListener il = new ItemListener();
        il.setContentPane(il.getPanel1());
        il.setSize(500,300);
        il.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        il.setVisible(true);
    }
}