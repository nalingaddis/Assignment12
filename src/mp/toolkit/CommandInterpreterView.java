package mp.toolkit;

import java.awt.Component;
import java.awt.Graphics;
import java.beans.PropertyChangeEvent;

import javax.swing.JTextField;

import mp.factories.SingletonsCreator;
import mp.scanner.CommandInterpreterInterface;
import util.annotations.Tags;

@Tags({"CommandInterpreterView"})
public class CommandInterpreterView extends Component implements CommandInterpreterViewInterface{
	
	private JTextField errorsField = new JTextField("Errors");
	private JTextField commandLine = new JTextField("CommandLine");
		
	public CommandInterpreterView() {
		
	}
	
	public CommandInterpreterView(CommandInterpreterInterface commandInterpreter) {
		commandInterpreter.addPropertyChangeListener(this);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		errorsField.paint(g);
	}
	
	public void propertyChange(PropertyChangeEvent event) {
		if(event.getPropertyName() == "Errors") {
			errorsField.setText((String) event.getNewValue());
		}
	}
	
	public JTextField getErrorsField() {return errorsField;}
	public JTextField getCommandLine() {return commandLine;}
}
