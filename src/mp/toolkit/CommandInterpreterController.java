package mp.toolkit;

import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import mp.factories.SingletonsCreator;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.Tags;

@Tags({"CommandInterpreterController"})
@PropertyNames({"TextField"})
@EditablePropertyNames({})
public class CommandInterpreterController implements CommandInterpreterControllerInterface{
	JTextField commandLine = new JTextField();
	
	public CommandInterpreterController() {
	
	}
	
	public CommandInterpreterController(JTextField textfield) {
		this.commandLine = textfield;
		commandLine.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = commandLine.getText();
		
		SingletonsCreator.produceCommandInterpreter().setCommand(command);
		
		System.out.println(SingletonsCreator.produceCommandInterpreter().getPropertyChangeListeners());
	}
	
	public JTextField getTextField() {
		return commandLine;
	}
}
