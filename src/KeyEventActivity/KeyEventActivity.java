package KeyEventActivity;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class KeyEventActivity extends JFrame{
	private JPanel panel1;
	private JTextArea editableTextArea;
	private JTextArea nonEditableTextArea;

	public KeyEventActivity() throws HeadlessException{
		super("Key Event Class");
		editableTextArea.getDocument().addDocumentListener(new DocumentListener(){
			@Override
			public void insertUpdate(DocumentEvent e){
				onChanged();
			}

			@Override
			public void removeUpdate(DocumentEvent e){
				onChanged();
			}

			@Override
			public void changedUpdate(DocumentEvent e){
				onChanged();
			}

			public void onChanged(){
				StringBuilder string = new StringBuilder();
				for(Character c : editableTextArea.getText().toCharArray()){
					c = Character.toLowerCase(c);
					if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
						c = Character.toUpperCase(c);
					}
					string.append(c);
				}
				nonEditableTextArea.setText(String.valueOf(string));
			}
		});
	}

	public JPanel getPanel1(){
		return panel1;
	}

	public static void main(String[] args) {
		KeyEventActivity kea = new KeyEventActivity();
		kea.setContentPane(kea.getPanel1());
		kea.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		kea.setSize(400,300);
		kea.setVisible(true);
	}
}
