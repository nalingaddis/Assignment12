package mp.custom;

import java.awt.Color;

import javax.swing.JTextField;

import bus.uigen.widgets.swing.SwingTextFieldFactory;
import util.annotations.Tags;

@Tags({"CustomSwingTextFieldFactory"})
public class CustomSwingTextField extends SwingTextFieldFactory{
	
	@Override
	protected JTextField createJTextField(String aText) {
		JTextField textField = new JTextField(aText);
		textField.setBackground(Color.BLACK);
		textField.setForeground(Color.GREEN);
		return textField;
	}
}
