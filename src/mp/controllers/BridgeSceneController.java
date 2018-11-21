package mp.controllers;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import mp.factories.SingletonsCreator;
import mp.interfaces.AvatarInterface;
import mp.interfaces.BridgeSceneInterface;
import mp.view.ObservableBridgeScenePainter;
import mp.view.ObservableBridgeScenePainterInterface;
import util.annotations.Tags;

@Tags({"BridgeSceneController"})
public class BridgeSceneController implements BridgeSceneControllerInterface{
	private static final int ARTHUR = 0, GALAHAD = 1, LANCELOT = 2, ROBIN = 3;
	private static final Dimension frameDim = new Dimension(1000, 500);
	
	private int x,y;
	private BridgeSceneInterface scene = SingletonsCreator.produceBridgeScene();
	
	private JFrame frame = new JFrame();
	
	ObservableBridgeScenePainterInterface scenePainter = SingletonsCreator.produceObservableBridgeScenePainter();
	
	public BridgeSceneController() {
		((ObservableBridgeScenePainter) scenePainter).addKeyListener(this);
		((ObservableBridgeScenePainter) scenePainter).addMouseListener(this);
		((ObservableBridgeScenePainter) scenePainter).requestFocus();
		
		
		frame.add((ObservableBridgeScenePainter) scenePainter);
		frame.setSize(frameDim);
		frame.setVisible(true);
	}

	public void keyTyped(KeyEvent e) {
		AvatarInterface tempAvatar = null; 
		if(e.getKeyChar() == 'a') {
			tempAvatar = scene.getArthur();
		} else if(e.getKeyChar() == 'g') {
			tempAvatar = scene.getGalahad();
		} else if(e.getKeyChar() == 'l') {
			tempAvatar = scene.getLancelot();
		} else if(e.getKeyChar() == 'r') {
			tempAvatar = scene.getRobin();
		} else if(e.getKeyChar() == 'o') {
			scene.getArthur().move(scene.initCoor(ARTHUR)[0] - scene.getArthur().getHead().getX(), scene.initCoor(ARTHUR)[1] - scene.getArthur().getHead().getY());
			scene.getGalahad().move(scene.initCoor(GALAHAD)[0] - scene.getGalahad().getHead().getX(), scene.initCoor(GALAHAD)[1] - scene.getGalahad().getHead().getY());
			scene.getLancelot().move(scene.initCoor(LANCELOT)[0] - scene.getLancelot().getHead().getX(), scene.initCoor(LANCELOT)[1] - scene.getLancelot().getHead().getY());
			scene.getRobin().move(scene.initCoor(ROBIN)[0] - scene.getRobin().getHead().getX(), scene.initCoor(ROBIN)[1] - scene.getRobin().getHead().getY());
		}
		
		if(tempAvatar != null) {
			tempAvatar.move(x - tempAvatar.getHead().getX(), y - tempAvatar.getHead().getY());
		}
	}
	
	public void mouseClicked(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	//Useless
	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
}
