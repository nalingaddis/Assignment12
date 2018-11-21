package main;

import bus.uigen.ObjectEditor;
import mp.factories.SingletonsCreator;
import mp.interfaces.BridgeSceneInterface;
import mp.scanner.CommandInterpreterInterface;

public class Assignment12 {	
	
	public static void assignment11Demo() {
		BridgeSceneInterface scene = SingletonsCreator.produceBridgeScene();
		
		SingletonsCreator.produceDelegatingBridgeSceneView();
		SingletonsCreator.produceCommandInterpreterController();
		
		SingletonsCreator.produceBridgeSceneController();
		
		SingletonsCreator.produceConsoleSceneView();
				
		CommandInterpreterInterface comInt = SingletonsCreator.produceCommandInterpreter();
		
		comInt.asyncArthur();
		comInt.asyncArthur();
		comInt.asyncLancelot();
		comInt.asyncLancelot();
		comInt.asyncRobin();
		comInt.asyncRobin();
		comInt.asyncGalahad();
		
		ObjectEditor.edit(comInt);
		comInt.setCommand("{ move arthur 2 5 move arthur 3 10 move arthur 5 2 move arthur 7 6 }");
		comInt.setCommand("{ move arthur 10 8 move arthur 4 6 { move arthur 2 5 move arthur 3 10 move arthur 5 2 move arthur 7 6 } move arthur 3 1 }");
		comInt.setCommand("approach Arthur");
		comInt.setCommand("passed");
		comInt.setCommand("failed");
		comInt.setCommand("repeat 5  move Arthur  2 3");
		comInt.setCommand("repeat 5 { move Arthur  2 3 move Galahad 5 6 }");
		comInt.setCommand("repeat 4 repeat 5 { move Arthur + 2 - 3 move Galahad - 5 + 6 }");
		comInt.setCommand("Redo");
	}
	
	public static void main(String[] args) {
//		animateScanner();
//		animateLine();
//		drawBridgeScene();
//		modularBridgeScene();
//		demoTable();	
//		mvcDemo();
//		assignment9Demo();
//		assignment10Demo();
		
		assignment11Demo();
	}
	
	/**
	 * Uncalled methods stored below (for sentimental reasons)
	 */
	
	/*
	public static void assignment9Demo() {
		SingletonsCreator.produceDelegatingBridgeSceneView();
		SingletonsCreator.produceCommandInterpreterController();
		CommandInterpreterInterface comInt = SingletonsCreator.produceCommandInterpreter();
		
		long sleep = 50;
		
		BridgeSceneInterface bridgeScene = SingletonsCreator.produceBridgeScene();
		
		SingletonsCreator.produceBridgeSceneController();
		
		SingletonsCreator.produceConsoleSceneView();
		
		//OEFrame editor = ObjectEditor.edit(bridgeScene);
		
		//Animation
		ThreadSupport.sleep(sleep);
		bridgeScene.approach(bridgeScene.getArthur());
		
		ThreadSupport.sleep(sleep);
		bridgeScene.say("How was your day");
		
		ThreadSupport.sleep(sleep);
		bridgeScene.getArthur().move(300, 0);
		
		//Sick animation bro
		comInt.asyncArthur();
		comInt.asyncGalahad();
		comInt.asyncLancelot();
		comInt.asyncRobin();
	}
	
 	public static void animateScanner() {
		final int sleepTime = 3000;
		
		ScannerBeanInterface scannerBean = new ScannerBean();
		OEFrame editor = ObjectEditor.edit(scannerBean);
		
		scannerBean.setScannedString("MoVe 050 { saY \"hi!\" } ");
		editor.refresh();
		ThreadSupport.sleep(sleepTime);
		
		scannerBean.setScannedString("RotateLeftArm  5  rotateLeftArm");
		editor.refresh();
		ThreadSupport.sleep(sleepTime); 
		
		scannerBean.setScannedString("approach call define } fail - move 12 pass + proceedall \"quote\" redo repeat rotateleftarm rotaterightarm say sleep { thread undo wait word");
		editor.refresh();
		ThreadSupport.sleep(sleepTime); 
	}
	
	public static void animateLine() {
		final int sleepTime = 10;
		final int x = 200;
		final int y = 200;
		final double radius = 200;
		final double angle = 0;
		final int angleOfRotation = 361;
		
		RotatingLineInterface rotatingLine = new RotatingLine(x, y, radius, angle);
		OEFrame editor = ObjectEditor.edit(rotatingLine);

		for(int i = 0; i < angleOfRotation; i++) {
			// Uncomment code below for moving, rotating line
			rotatingLine.setX(x + (int)i/2);
			rotatingLine.setY(y + (int)i/2);
			
			rotatingLine.rotate(i);
			editor.refresh();
			ThreadSupport.sleep(sleepTime);
		}
	}
	
	public static void drawBridgeScene() {
		BridgeSceneInterface bridgeScene = new BridgeScene();
		OEFrame editor = ObjectEditor.edit(bridgeScene);
		
		final long sleepTime = 1000;
		final int 
			scrollX = 30,
			scrollY = 30;
		
		bridgeScene.say("Hey");
		editor.refresh();
		ThreadSupport.sleep(sleepTime);
		
		bridgeScene.approach(bridgeScene.getArthur());
		editor.refresh();
		ThreadSupport.sleep(sleepTime);
		
		bridgeScene.approach(bridgeScene.getLancelot());
		editor.refresh();
		ThreadSupport.sleep(sleepTime);
		
		bridgeScene.say("Hey");
		editor.refresh();
		ThreadSupport.sleep(sleepTime);
		
		bridgeScene.say("Hey");
		editor.refresh();
		ThreadSupport.sleep(sleepTime);
		
		bridgeScene.say("How was your day?");
		editor.refresh();
		ThreadSupport.sleep(sleepTime);
		
		bridgeScene.passed();
		editor.refresh();
		ThreadSupport.sleep(sleepTime);
		
		bridgeScene.say("Good");
		editor.refresh();
		ThreadSupport.sleep(sleepTime);
		
		bridgeScene.passed();
		editor.refresh();
		ThreadSupport.sleep(sleepTime);
		
		bridgeScene.approach(bridgeScene.getGalahad());
		editor.refresh();
		ThreadSupport.sleep(sleepTime);
		
		bridgeScene.say("Hey");
		editor.refresh();
		ThreadSupport.sleep(sleepTime);
		
		bridgeScene.say("You ugly");
		editor.refresh();
		ThreadSupport.sleep(sleepTime);
		
		bridgeScene.failed();
		editor.refresh();
		ThreadSupport.sleep(sleepTime);
		
		bridgeScene.approach(bridgeScene.getLancelot());
		editor.refresh();
		ThreadSupport.sleep(sleepTime);
		
		bridgeScene.say("Oof");
		editor.refresh();
		ThreadSupport.sleep(sleepTime);
		
		bridgeScene.failed();
		editor.refresh();
		ThreadSupport.sleep(sleepTime);

		bridgeScene.scroll(scrollX, scrollY);
		editor.refresh();
		ThreadSupport.sleep(sleepTime);
	}
	
	public static void modularBridgeScene() {
		final long sleep = 3000;
		
		ScannerBeanInterface scanner = SingletonsCreator.produceScannerBean();
		BridgeSceneInterface bridgeScene = SingletonsCreator.produceBridgeScene();
		CommandInterpreterInterface interpreter = SingletonsCreator.produceCommandInterpreter();
		
		OEFrame intrepreterEditor = ObjectEditor.edit(interpreter);
		OEFrame bridgeEditor = ObjectEditor.edit(bridgeScene);
		OEFrame scannerEditor = ObjectEditor.edit(scanner);

		bridgeScene.approach(bridgeScene.getArthur());
		
		interpreter.setCommand("say \"How is your day?\"");
		intrepreterEditor.refresh();
		ThreadSupport.sleep(sleep);
		
		interpreter.setCommand("say \"Good\"");
		intrepreterEditor.refresh();
		ThreadSupport.sleep(sleep);
		
		interpreter.setCommand("MoVe ArthUr - 100 - 0");
		intrepreterEditor.refresh();
		ThreadSupport.sleep(sleep);
		
		interpreter.setCommand("Say ");
		intrepreterEditor.refresh();
		ThreadSupport.sleep(sleep);
	}
	
	public static void demoTable() {
		TableInterface table = new Table();
		System.out.println(" Empty Table");
		table.print();
		
		System.out.println("\n Insertion");
		table.put("circle", "Circle");
		table.put("image", "Image");
		table.print();
		
		System.out.println("\n Replacement and Insertion");
		table.put("circle", new Circle());
		table.put("image", new Image());
		table.put("string", "Hello World");
		table.print();
	}
	
	public static void mvcDemo() {
		final long sleepTime = 1000;
		final int 
			scrollX = -30,
			scrollY = -30,
			horizon = 180,
			armWiggle = 30,
			legWiggle = 15;
		
		//Bridge Scene
		BridgeSceneInterface bridgeScene = SingletonsCreator.produceBridgeScene();
		OEFrame editor = ObjectEditor.edit(bridgeScene);
		
		//Console View
		SingletonsCreator.produceConsoleSceneView();
		
		//Demo
		bridgeScene.say("Hey");
		ThreadSupport.sleep(sleepTime);
		
		bridgeScene.approach(bridgeScene.getArthur());
		ThreadSupport.sleep(sleepTime);
		
		bridgeScene.approach(bridgeScene.getLancelot());
		ThreadSupport.sleep(sleepTime);
		
		bridgeScene.say("Hey");
		ThreadSupport.sleep(sleepTime);
		
		bridgeScene.say("Hey");
		ThreadSupport.sleep(sleepTime);
		
		bridgeScene.say("How was your day?");
		ThreadSupport.sleep(sleepTime);
		
		bridgeScene.passed();
		ThreadSupport.sleep(sleepTime);
		
		bridgeScene.say("Good");
		ThreadSupport.sleep(sleepTime);
		
		bridgeScene.passed();
		ThreadSupport.sleep(sleepTime);
		
		bridgeScene.approach(bridgeScene.getGalahad());
		ThreadSupport.sleep(sleepTime);
		
		bridgeScene.say("Hey");
		ThreadSupport.sleep(sleepTime);
		
		bridgeScene.say("You ugly");
		ThreadSupport.sleep(sleepTime);
		
		bridgeScene.failed();
		ThreadSupport.sleep(sleepTime);
		
		bridgeScene.approach(bridgeScene.getLancelot());
		ThreadSupport.sleep(sleepTime);
		
		bridgeScene.say("Oof");
		ThreadSupport.sleep(sleepTime);
		
		bridgeScene.failed();
		ThreadSupport.sleep(sleepTime);
		
		bridgeScene.getLancelot().getArms().getLeftLine().rotate(horizon + armWiggle);
		bridgeScene.getLancelot().getArms().getRightLine().rotate(-armWiggle);
		ThreadSupport.sleep(sleepTime);
		
		bridgeScene.getLancelot().getLegs().getLeftLine().rotate(horizon - legWiggle);
		bridgeScene.getLancelot().getLegs().getRightLine().rotate(legWiggle);
		ThreadSupport.sleep(sleepTime);
		
		bridgeScene.scroll(scrollX, scrollY);
		ThreadSupport.sleep(sleepTime);
		
		bridgeScene.getRobin().setText("Test test");
		
	}
	
	public static void assignment10Demo() {
		BridgeSceneInterface scene = SingletonsCreator.produceBridgeScene();
		
		SingletonsCreator.produceDelegatingBridgeSceneView();
		SingletonsCreator.produceCommandInterpreterController();
		
		SingletonsCreator.produceBridgeSceneController();
		
		SingletonsCreator.produceConsoleSceneView();
				
		CommandInterpreterInterface comInt = SingletonsCreator.produceCommandInterpreter();
		
		//Assertion Test
		scene.say("hello");
		scene.approach(scene.getArthur());
		scene.approach(scene.getGalahad());
		scene.passed();
		scene.passed();
		scene.failed();
		scene.failed();
		
		//Sick animation bro
		comInt.asyncArthur();
		comInt.asyncGalahad();
		comInt.asyncLancelot();
		comInt.asyncRobin();
	}
	*/
}
