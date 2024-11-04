package MostFrequentCharacter;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MostFrequentCharacter extends JFrame{
	private JPanel panel1;
	private JTextArea textArea;
	private JLabel frequentCharLabel;

	public MostFrequentCharacter() throws HeadlessException{
		super("Most Frequent Char");
		textArea.getDocument().addDocumentListener(new DocumentListener(){
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
				HashMap<Character,Integer> frequency_map = new HashMap<>();
				for(Character c : textArea.getText().toCharArray()){
					if(Character.isAlphabetic(c))
						frequency_map.put(Character.toUpperCase(c), frequency_map.getOrDefault(Character.toUpperCase(c),0) + 1);
				}
				char mostFrequentChar = ' ';
				int maxFrequency = 0;
				for(Map.Entry<Character, Integer> chars : frequency_map.entrySet()){
					if(maxFrequency < chars.getValue()){
						mostFrequentChar = chars.getKey();
						maxFrequency = chars.getValue();
					}
				}
				if(mostFrequentChar == ' '){
					frequentCharLabel.setText("No Text Inputted");
					return;
				}
				frequentCharLabel.setText("The most frequent character is: " + mostFrequentChar);
			}
		});
	}

	public JPanel getPanel1(){
		return panel1;
	}
}
