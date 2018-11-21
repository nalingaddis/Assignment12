package mp.shapes;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import mp.interfaces.AvatarInterface;
import mp.interfaces.BridgeSceneInterface;
import mp.interfaces.CircleInterface;
import mp.interfaces.ImageInterface;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.Visible;

@Tags({"BridgeScene"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Arthur", "Galahad", "Guard", "Lancelot", "Robin", "Gorge", "KnightArea", "GuardArea", "Occupied", "KnightTurn"})
@EditablePropertyNames({})


public class BridgeScene implements BridgeSceneInterface{
	private static final int X_INCREMENT = 200;
	private static final int Y_INCREMENT = 150;
	
	private static final int ONE = 1, TWO = 2, THREE = 3;
	
	private static int[][] initCoor = new int[4][2];
	
	private static final int KNIGHT_AREA_X = 425;
	private static final int GUARD_AREA_X = 550;
	private static final int AREA_Y = 225;
	private static final int AREA_SIZE = 50;
	
	private static final int INIT_GUARD_X = GUARD_AREA_X + 8;
	private static final int INIT_GUARD_Y = AREA_Y - 105;
	
	private static final int KNIGHT_X = KNIGHT_AREA_X + 5;
	private static final int KNIGHT_Y = AREA_Y - 100;
	
	private static final int BUFFER = 75;
	
	private AvatarInterface arthur = new Avatar(new Image("arthur.jpg"));
	private AvatarInterface galahad = new Avatar(new Image("galahad.jpg"));
	private AvatarInterface robin = new Avatar(new Image("robin.jpg"));
	private AvatarInterface lancelot = new Avatar(new Image("lancelot.jpg"));
	private AvatarInterface guard = new Avatar(new Image("guard.jpg"));
	
	private ImageInterface gorge = new Image(X_INCREMENT * 3, 0, "bridge.jpg");
	
	private CircleInterface knightArea = new Circle(KNIGHT_AREA_X, AREA_Y, AREA_SIZE, AREA_SIZE);
	private CircleInterface guardArea = new Circle(GUARD_AREA_X, AREA_Y, AREA_SIZE, AREA_SIZE);
	
	@Tags({"occupied"})
	private boolean occupied = false;
	
	private boolean knightTurn = false;
	
	private AvatarInterface interactingKnight;
	
	private List<PropertyChangeListener> listeners = new ArrayList<PropertyChangeListener>();
	
	//Constructors
	public BridgeScene() {
		initCoor[ONE][0] = X_INCREMENT;
		initCoor[THREE][0] = X_INCREMENT;
		initCoor[TWO][ONE] = Y_INCREMENT;
		initCoor[THREE][ONE] = Y_INCREMENT;
		
		arthur.move(0,0);
		galahad.move(X_INCREMENT,0);
		robin.move(0, Y_INCREMENT);
		lancelot.move(X_INCREMENT, Y_INCREMENT);
		guard.move(INIT_GUARD_X, INIT_GUARD_Y);
	}
	
	//Getters
	public AvatarInterface getArthur() {return arthur;}
	public AvatarInterface getGalahad() {return galahad;}
	public AvatarInterface getGuard() {return guard;}
	public AvatarInterface getLancelot() {return lancelot;}
	public AvatarInterface getRobin() {return robin;}
	
	public ImageInterface getGorge() {return gorge;}
	
	public CircleInterface getKnightArea() {return knightArea;}
	public CircleInterface getGuardArea() {return guardArea;}
	
	public boolean getOccupied() {return occupied;}
	public boolean getKnightTurn() {return knightTurn;}
	
	public List<PropertyChangeListener> getListeners(){
		return listeners;
	}
	
	@Visible(false)
	public AvatarInterface getInteractingKnight() {
		if(!occupied) {
			return null;
		} else {
			return interactingKnight;
		}
	}
	
	//Assertions
	public boolean preApproach() {
		notify(new PropertyChangeEvent(this, "this", "approach", !occupied));
		return !occupied;
	}

	@Override
	public boolean preSay() {
		notify(new PropertyChangeEvent(this, "this", "say", occupied));
		return occupied;
	}

	@Override
	public boolean prePassed() {
		notify(new PropertyChangeEvent(this, "this", "passed", occupied && !knightTurn));
		return occupied && !knightTurn;
	}

	@Override
	public boolean preFailed() {
		notify(new PropertyChangeEvent(this, "this", "failed", occupied));
		return occupied;
	}
	
	//Methods
	public void approach(AvatarInterface avatar) {
		assert preApproach();
		if(!occupied) {
			avatar.move(KNIGHT_X - avatar.getHead().getX(), KNIGHT_Y - avatar.getHead().getY());
			occupied = true;
			interactingKnight = avatar;
		}
	}
	
	public void say(String s) {
		assert preSay();
		if(occupied) {
			if(!knightTurn) {
				guard.setText(s);
				knightTurn = true;
			} else {
				interactingKnight.setText(s);
				knightTurn = false;
			}
		}
	}
	
	public void passed() {
		assert prePassed();
		
		if(occupied && !knightTurn) {
			interactingKnight.move(gorge.getWidth() + (gorge.getX() - interactingKnight.getHead().getX()) + BUFFER, 0);
			occupied = false;
		}
	}
	
	public void failed() {
		assert preFailed();
		
		if(occupied) {
			if(knightTurn) {
				guard.move(gorge.getWidth()/2 + (gorge.getX() - guard.getHead().getX())/2 + BUFFER, -BUFFER);
			}else if (!knightTurn) {
				interactingKnight.move(gorge.getWidth()/2 + (gorge.getX() - interactingKnight.getHead().getX())/2 + BUFFER, -BUFFER);
				occupied = false;
			}
		}
	}
	
	@Tags({"scroll"})
	public void scroll(int x, int y) {
		arthur.move(-x, -y);
		galahad.move(-x, -y);
		robin.move(-x, -y);
		lancelot.move(-x, -y);
		guard.move(-x, -y);
		
		gorge.setX(gorge.getX() - x);
		gorge.setY(gorge.getY() - y);
		
		knightArea.setX(knightArea.getX() - x);
		knightArea.setY(knightArea.getY() - y);
		
		guardArea.setX(guardArea.getX() - x);
		guardArea.setY(guardArea.getY() - y);
	}
	
	public int[] initCoor(int x) {
		if(x < THREE + ONE) {
			return initCoor[x];
		}
		
		return new int[2];
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		listeners.add(listener);
	}
	
	public void notify(PropertyChangeEvent event) {
		for(int i = 0; i < listeners.size(); i++) {
			listeners.get(i).propertyChange(event);
		}
	}
}
