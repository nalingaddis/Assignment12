package mp.scanner;

import java.beans.PropertyChangeListener;
import java.util.List;

import mp.animation.AnimatingCommand;
import mp.animation.Animator;
import mp.animation.CoordinatedAnimationCommand;
import mp.animation.CoordinatingAnimator;
import mp.factories.SingletonsCreator;
import mp.table.TableInterface;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.models.PropertyListenerRegisterer;

@Tags({"CommandInterpreter", "SignedMoveCommandInterpreter", "ErrorResilientCommandInterpreter"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Command", "Errors"})
@EditablePropertyNames({"Command"})

public interface CommandInterpreterInterface extends PropertyListenerRegisterer {
	//Getters
	public String getCommand();
	public String getErrors();
	public TableInterface getTable();
	public List<PropertyChangeListener> getPropertyChangeListeners();
	
	//Setters
	public void setCommand(String s);
	
	//Async Animation
	public void asyncArthur();
	public void asyncGalahad();
	public void asyncLancelot();
	public void asyncRobin();
	
	//LockStep
	public void lockstepGuard();
	public void lockstepArthur();
	public void lockstepGalahad();	
	public void lockstepLancelot();	
	public void lockstepRobin();	
}
