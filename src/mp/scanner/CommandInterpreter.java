package mp.scanner;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import mp.animation.AnimatingCommand;
import mp.animation.Animator;
import mp.animation.CoordinatedAnimationCommand;
import mp.animation.CoordinatedAnimator;
import mp.animation.CoordinatingAnimatingCommand;
import mp.animation.CoordinatingAnimator;
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
	
//	//Sync Animation
//	@Tags({"asynchronousArthur"})
//	public void asyncArthur() {
//		Thread thread = new Thread(new AnimatingCommand(SingletonsCreator.produceArthurAnimator(), false));
//		
//		thread.start();
//	}
//	
//	@Tags({"asynchronousGalahad"})
//	public void asyncGalahad() {
//		Thread thread = new Thread(new AnimatingCommand(SingletonsCreator.produceGalahadAnimator(), false));
//		
//		thread.start();
//	}
//	
//	@Tags({"asynchronousLancelot"})
//	public void asyncLancelot() {
//		Thread thread = new Thread(new AnimatingCommand(SingletonsCreator.produceLancelotAnimator(), false));
//		
//		thread.start();
//	}
//	
//	@Tags({"asynchronousRobin"})
//	public void asyncRobin() {
//		Thread thread = new Thread(new AnimatingCommand(SingletonsCreator.produceRobinAnimator(), false));
//		
//		thread.start();
//	}
	
	//Coordinated Animations
	@Tags({"waitingArthur"})
	public void waitArthur() {
		Thread thread = new Thread(new AnimatingCommand(new Animator(), 
				SingletonsCreator.produceBridgeScene().getArthur(), true));
		
		thread.start();
	}
	@Tags({"waitingGalahad"})
	public void waitGalahad() {
		Thread thread = new Thread(new AnimatingCommand(new Animator(),
				SingletonsCreator.produceBridgeScene().getGalahad(), true));
		
		thread.start();
	}
	@Tags({"waitingLancelot"})
	public void waitLancelot() {
		Thread thread = new Thread(new AnimatingCommand(new Animator(),
				SingletonsCreator.produceBridgeScene().getLancelot(), true));
		
		thread.start();
	}
	
	@Tags({"waitingRobin"})
	public void waitRobin() {
		Thread thread = new Thread(new AnimatingCommand(new Animator(),
				SingletonsCreator.produceBridgeScene().getRobin(), true));
		
		thread.start();
	}
	
	@Tags({"startAnimation"})
	public void startAnimation() {
		SingletonsCreator.produceClearanceManager().proceedAll();
	}
	
	//Lockstep
	@Tags({"lockstepGuard"})
	public synchronized void lockstepGuard() {
		Thread thread = new Thread(new CoordinatingAnimatingCommand(
				new CoordinatingAnimator(), SingletonsCreator.produceBridgeScene().getGuard()));
		thread.start();
	}
	
	@Tags({"lockstepArthur"})
	public void lockstepArthur() {
		Thread thread = new Thread(new CoordinatedAnimationCommand(
				new CoordinatedAnimator(), SingletonsCreator.produceBridgeScene().getArthur()));
		thread.start();
	}
	
	@Tags({"lockstepGalahad"})
	public void lockstepGalahad() {
		Thread thread = new Thread(new CoordinatedAnimationCommand(
				new CoordinatedAnimator(), SingletonsCreator.produceBridgeScene().getGalahad()));
		thread.start();
	}
	
	@Tags({"lockstepLancelot"})
	public void lockstepLancelot() {
		Thread thread = new Thread(new CoordinatedAnimationCommand(
				new CoordinatedAnimator(), SingletonsCreator.produceBridgeScene().getLancelot()));
		thread.start();
	}
	
	@Tags({"lockstepRobin"})
	public void lockstepRobin() {
		Thread thread = new Thread(new CoordinatedAnimationCommand(
				new CoordinatedAnimator(), SingletonsCreator.produceBridgeScene().getRobin()));
		thread.start();
	}
}
