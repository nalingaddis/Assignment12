package mp.interfaces;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.Visible;
import util.models.PropertyListenerRegisterer;

@Tags({"BridgeScene"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Arthur", "Galahad", "Guard", "Lancelot", "Robin", "Gorge", "KnightArea", "GuardArea", "Occupied", "KnightTurn"})
@EditablePropertyNames({})

public interface BridgeSceneInterface extends PropertyListenerRegisterer{
	//Getters
	public AvatarInterface getArthur();
	public AvatarInterface getGalahad();
	public AvatarInterface getGuard();
	public AvatarInterface getLancelot();
	public AvatarInterface getRobin();
	
	public ImageInterface getGorge();
	
	public CircleInterface getKnightArea();
	public CircleInterface getGuardArea();
	
	public boolean getOccupied();
	public boolean getKnightTurn();
	
	@Visible(false)
	public AvatarInterface getInteractingKnight();
	
	//Assertion
	public boolean preApproach();
	public boolean preSay();
	public boolean prePassed();
	public boolean preFailed();
	
	//Methods
	public void approach(AvatarInterface avatar);
	public void say(String s);
	public void passed();
	public void failed();
	public void scroll(int x, int y);
	public int[] initCoor(int x);
}
