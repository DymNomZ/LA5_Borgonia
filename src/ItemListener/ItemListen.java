package ItemListener;

import javax.swing.*;

public class ItemListen extends JFrame {

    private JPanel panel;

    public ItemListen(){
        this.setTitle("Item Listener");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(600, 300);
        this.setVisible(true);


    }

    public static void main(String[] args) {
        ItemListen il = new ItemListen();
        il.setContentPane(il.panel);
    }
}
