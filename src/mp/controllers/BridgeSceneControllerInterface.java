package mp.controllers;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import util.annotations.Tags;

@Tags({"BridgeSceneController"})
public interface BridgeSceneControllerInterface extends KeyListener, MouseListener{
	public JFrame getFrame();
}
