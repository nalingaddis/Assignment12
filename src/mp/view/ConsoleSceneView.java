package mp.view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import mp.factories.SingletonsCreator;
import mp.interfaces.AvatarInterface;
import mp.interfaces.BridgeSceneInterface;
import util.annotations.Tags;

@Tags({"ConsoleSceneView"})
public class ConsoleSceneView implements PropertyChangeListener{
	
	//Constructor
	public ConsoleSceneView() {
		BridgeSceneInterface scene = SingletonsCreator.produceBridgeScene();
		
		addAvatarListener(scene.getArthur(),this);
		addAvatarListener(scene.getGalahad(),this);
		addAvatarListener(scene.getGuard(),this);
		addAvatarListener(scene.getLancelot(),this);
		addAvatarListener(scene.getRobin(),this);
		
		addBackgroundListener(scene, this);
		
		scene.addPropertyChangeListener(this);
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println(evt);
	}
	
	public static void addAvatarListener(AvatarInterface avatar, PropertyChangeListener listener) {
		avatar.getArms().getLeftLine().addPropertyChangeListener(listener);
		avatar.getArms().getRightLine().addPropertyChangeListener(listener);
		avatar.getLegs().getLeftLine().addPropertyChangeListener(listener);
		avatar.getLegs().getRightLine().addPropertyChangeListener(listener);
		avatar.getTorso().addPropertyChangeListener(listener);
		avatar.getStringShape().addPropertyChangeListener(listener);
		avatar.getHead().addPropertyChangeListener(listener);
	}
	
	public static void addBackgroundListener(BridgeSceneInterface scene, PropertyChangeListener listener) {
		//Gorge
		scene.getGorge().addPropertyChangeListener(listener);
				
		//Knight Area
		scene.getKnightArea().addPropertyChangeListener(listener);

		//Guard Area
		scene.getGuardArea().addPropertyChangeListener(listener);
	}
}
