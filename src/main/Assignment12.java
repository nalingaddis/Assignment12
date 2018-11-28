package main;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import bus.uigen.widgets.TextFieldSelector;
import mp.custom.CustomSwingTextField;
import mp.factories.SingletonsCreator;
import mp.interfaces.BridgeSceneInterface;
import mp.scanner.CommandInterpreterInterface;
import util.misc.ThreadSupport;

public class Assignment12 {	
	static final int SLEEP = 1600;
	
	public static void assignment12Demo() {
		
		/**
		 * Setting up the scene and Frames
		 */
		BridgeSceneInterface scene = SingletonsCreator.produceBridgeScene();
		SingletonsCreator.produceDelegatingBridgeSceneView();
		SingletonsCreator.produceCommandInterpreterController();
		SingletonsCreator.produceBridgeSceneController();
		SingletonsCreator.produceConsoleSceneView();
		
		/**
		 * Broadcasting Clearance Manager
		 */
		ObjectEditor.edit(SingletonsCreator.produceClearanceManager());
		
		/**
		 * Command Interpreter
		 */
		ObjectEditor.initialize();
		TextFieldSelector.setTextFieldFactory(new CustomSwingTextField());
		
		CommandInterpreterInterface comInt = SingletonsCreator.produceCommandInterpreter();
		ObjectEditor.edit(comInt);
		
		/**
		 * LockStep Methods
		 */
		SingletonsCreator.produceClearanceManager().waitForProceed();
			//Setting up the followers
		comInt.lockstepArthur();
		comInt.lockstepGalahad();
		comInt.lockstepLancelot();
		comInt.lockstepRobin();
			//Activating the Coordinator
		comInt.lockstepGuard();
		
		ThreadSupport.sleep(SLEEP);
		/**
		 * Waiting Methods
		 */
		SingletonsCreator.produceClearanceManager().waitForProceed();
			//Setting up the waiters
		comInt.waitArthur();
		comInt.waitGalahad();
		comInt.waitLancelot();
		comInt.waitRobin();
		
		ThreadSupport.sleep(SLEEP);
		
		/**
		 * Error Throwing
		 */
		SingletonsCreator.produceClearanceManager().waitForProceed();
		comInt.setCommand("move arthur 100 100");
		SingletonsCreator.produceClearanceManager().waitForProceed();
		comInt.setCommand("undo");
		SingletonsCreator.produceClearanceManager().waitForProceed();
		comInt.setCommand("redo");
		
		/**
		 * More Recursive Parsing Extra Credit
		 * 	ALTERATive dance ;)
		 */
		SingletonsCreator.produceClearanceManager().waitForProceed();
			//LOCK STEP SETUP
		comInt.lockstepArthur();
		comInt.lockstepGalahad();
		comInt.lockstepLancelot();
		comInt.lockstepRobin();
		
			//THREAD BEATS DEMO
		comInt.setCommand("proceedAll");
		comInt.setCommand("define guardArmsIn { rotateLeftArm guard 60 rotateRightArm guard - 60 }");
		comInt.setCommand("define guardArmsOut { rotateLeftArm guard - 60 rotateRightArm guard 60 }");
		comInt.setCommand("define beat { call guardArmsIn proceedAll sleep 1000 call guardArmsOut proceedAll sleep 1000 }");
		comInt.setCommand("define beats repeat 7 call beat");
		comInt.setCommand("thread beats");
	}
	
	public static void main(String[] args) {
		assignment12Demo();
	}
}