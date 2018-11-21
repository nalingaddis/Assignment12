package mp.scanner;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import mp.animation.AnimatingCommand;
import mp.animation.Animator;
import mp.factories.SingletonsCreator;
import mp.history.PCLSupport;
import mp.history.PCLSupportInterface;
import mp.interfaces.BridgeSceneInterface;
import mp.parser.ParserInterface;
import mp.table.TableInterface;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.Visible;

@Tags({"CommandInterpreter", "SignedMoveCommandInterpreter", "ErrorResilientCommandInterpreter", "ObservableCommandInterpreter"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Command", "Errors", "PropertyChangeListeners"})
@EditablePropertyNames({"Command"})

public class CommandInterpreter implements CommandInterpreterInterface{
	private BridgeSceneInterface bridgeScene = SingletonsCreator.produceBridgeScene();
	private String command = "";
	private TableInterface table = SingletonsCreator.produceAvatarTable();
	private String errors = "";
	
	private ParserInterface parser = SingletonsCreator.produceParser();

	
	PCLSupportInterface propertySupport = new PCLSupport();
	
	//Constructors
	public CommandInterpreter() {
		
	}
	
	//Getters
	public String getCommand() {
		return command;
	}
	
	public String getErrors() {
		return errors;
	}
	
	@Visible(false)
	public TableInterface getTable() {
		return table;
	}
	
	public List<PropertyChangeListener> getPropertyChangeListeners() {return propertySupport.get();}
	
	//Setters
	public void setCommand(String s) {
		String oldCommand = command;
		command = s;
		parser.setCommandText(s);
//		parser.getCommandObject();
		
		String oldErrors = errors;
		errors = parser.getErrors();
		
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Command", oldCommand, getCommand()));
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Errors", oldErrors, getErrors()));
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertySupport.add(listener);
	}
	
	//Sync Animation
	@Tags({"asynchronousArthur"})
	public void asyncArthur() {
		Thread thread = new Thread(new AnimatingCommand(SingletonsCreator.produceArthurAnimator()));
		
		thread.start();
	}
	
	@Tags({"asynchronousGalahad"})
	public void asyncGalahad() {
		Thread thread = new Thread(new AnimatingCommand(SingletonsCreator.produceGalahadAnimator()));
		
		thread.start();
	}
	
	@Tags({"asynchronousLancelot"})
	public void asyncLancelot() {
		Thread thread = new Thread(new AnimatingCommand(SingletonsCreator.produceLancelotAnimator()));
		
		thread.start();
	}
	
	@Tags({"asynchronousRobin"})
	public void asyncRobin() {
		Thread thread = new Thread(new AnimatingCommand(SingletonsCreator.produceRobinAnimator()));
		
		thread.start();
	}
	
	//Coordinated Animations
	@Tags({"waitArthur"})
	public void waitArthur() {
		Thread thread = new Thread(new AnimatingCommand(SingletonsCreator.produceArthurAnimator()));
		
		thread.start();
	}
	@Tags({"waitGalahad"})
	public void waitGalahad() {
		Thread thread = new Thread(new AnimatingCommand(SingletonsCreator.produceGalahadAnimator()));
		
		thread.start();
	}
	@Tags({"waitLancelot"})
	public void waitLancelot() {
		Thread thread = new Thread(new AnimatingCommand(SingletonsCreator.produceLancelotAnimator()));
		
		thread.start();
	}
	
	@Tags({"waitRobin"})
	public void waitRobin() {
		Thread thread = new Thread(new AnimatingCommand(SingletonsCreator.produceRobinAnimator()));
		
		thread.start();
	}
}
