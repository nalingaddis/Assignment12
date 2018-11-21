package mp.toolkit;

import java.beans.PropertyChangeListener;

import javax.swing.JTextField;


public interface CommandInterpreterViewInterface extends PropertyChangeListener{
	public JTextField getErrorsField();
	public JTextField getCommandLine();
}
