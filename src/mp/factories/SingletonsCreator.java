package mp.factories;

import java.beans.PropertyChangeListener;

import mp.animation.Animator;
import mp.animation.AnimatorInterface;
import mp.clearance.ABroadcastingClearanceManager;
import mp.clearance.BroadcastingClearanceManager;
import mp.controllers.BridgeSceneController;
import mp.controllers.BridgeSceneControllerInterface;
import mp.interfaces.AvatarInterface;
import mp.interfaces.BridgeSceneInterface;
import mp.parser.Parser;
import mp.parser.ParserInterface;
import mp.scanner.CommandInterpreter;
import mp.scanner.CommandInterpreterInterface;
import mp.scanner.ScannerBean;
import mp.scanner.ScannerBeanInterface;
import mp.shapes.BridgeScene;
import mp.table.Table;
import mp.table.TableInterface;
import mp.toolkit.CommandInterpreterController;
import mp.toolkit.CommandInterpreterControllerInterface;
import mp.toolkit.CommandInterpreterView;
import mp.toolkit.CommandInterpreterViewInterface;
import mp.view.ConsoleSceneView;
import mp.view.DelegatingBridgeSceneView;
import mp.view.DelegatingBridgeSceneViewInterface;
import mp.view.ObservableBridgeScenePainter;
import mp.view.ObservableBridgeScenePainterInterface;
import util.annotations.Tags;

@Tags({"SingletonsCreator"})
public class SingletonsCreator {	
	private static ScannerBeanInterface scanner;
	private static BridgeSceneInterface bridge;
	private static TableInterface<AvatarInterface> table;
	private static CommandInterpreterInterface interpreter;
	private static PropertyChangeListener consoleScene;
	private static ObservableBridgeScenePainterInterface obspScene;
	private static DelegatingBridgeSceneViewInterface dbsView;
	private static BridgeSceneControllerInterface controller;
	private static CommandInterpreterControllerInterface interpreterController;
	private static CommandInterpreterViewInterface commandInterpreterView;
	private static ParserInterface parser;
	private static AnimatorInterface arthurAnimator, galahadAnimator, guardAnimator, lancelotAnimator, robinAnimator;
	private static BroadcastingClearanceManager clearance;
	
	@Tags({"scannerFactoryMethod"})
	public static ScannerBeanInterface produceScannerBean() {
		if(scanner == null) {
			scanner = new ScannerBean();
		}
		return scanner;
	}
	
	@Tags({"bridgeSceneFactoryMethod"})
	public static BridgeSceneInterface produceBridgeScene() {
		if(bridge == null) {
			bridge = new BridgeScene();
		}
		return bridge;
	}
	
	@Tags({"avatarTableFactoryMethod"})
	public static TableInterface<AvatarInterface> produceAvatarTable() {
		if(table == null) {
			table = new Table<AvatarInterface>();
			
			table.put("arthur", produceBridgeScene().getArthur());
			table.put("galahad", produceBridgeScene().getGalahad());
			table.put("guard", produceBridgeScene().getGuard());
			table.put("lancelot", produceBridgeScene().getLancelot());
			table.put("robin", produceBridgeScene().getRobin());
		}
		
		return table;
	}
	
	@Tags({"commandInterpreterFactoryMethod"})
	public static CommandInterpreterInterface produceCommandInterpreter() {
		
		if(interpreter == null) {
			interpreter = new CommandInterpreter();
		}
		
		return interpreter;
	}
	
	@Tags({"consoleSceneViewFactoryMethod"})
	public static PropertyChangeListener produceConsoleSceneView() {
		if(consoleScene == null) {
			consoleScene = new ConsoleSceneView();
		}
		
		return consoleScene;
	}
	
	@Tags({"observableBridgeScenePainterFactoryMethod"})
	public static ObservableBridgeScenePainterInterface produceObservableBridgeScenePainter() {
		if(obspScene == null) {
			obspScene = new ObservableBridgeScenePainter();
		}
		
		return obspScene;
	}
	
	@Tags({"delegatingBridgeSceneViewFactoryMethod"})
	public static DelegatingBridgeSceneViewInterface produceDelegatingBridgeSceneView() {
		if(dbsView == null) {
			dbsView = new DelegatingBridgeSceneView();
		}
		
		return dbsView;
	}
	
	@Tags({"bridgeSceneControllerFactoryMethod"})
	public static BridgeSceneControllerInterface produceBridgeSceneController() {
		if(controller == null) {
			controller = new BridgeSceneController();
		}
		
		return controller;
	}
	
	@Tags({"commandInterpreterControllerFactoryMethod"})
	public static CommandInterpreterControllerInterface produceCommandInterpreterController() {
		if(interpreterController == null) {
			interpreterController = new CommandInterpreterController(produceCommandInterpreterView().getCommandLine());
		}
		
		return interpreterController;
	}
	
	@Tags({"commandInterpreterViewFactoryMethod"})
	public static CommandInterpreterViewInterface produceCommandInterpreterView() {
		if(commandInterpreterView == null) {
			commandInterpreterView = new CommandInterpreterView(produceCommandInterpreter());
		}
		
		return commandInterpreterView;
	}
	
	@Tags({"parserFactoryMethod"})
	public static ParserInterface produceParser() {
		if(parser == null) {
			parser = new Parser();
		}
		
		return parser;
	}
	
	public static AnimatorInterface produceGalahadAnimator() {
		if(galahadAnimator == null) {
			galahadAnimator = new Animator(produceBridgeScene().getGalahad());
		}
		
		return galahadAnimator;
	}
	
	public static AnimatorInterface produceGuardAnimator() {
		if(guardAnimator == null) {
			guardAnimator = new Animator(produceBridgeScene().getGuard());
		}
		
		return guardAnimator;
	}
	
	public static AnimatorInterface produceLancelotAnimator() {
		if(lancelotAnimator == null) {
			lancelotAnimator = new Animator(produceBridgeScene().getLancelot());
		}
		
		return lancelotAnimator;
	}
	
	public static AnimatorInterface produceRobinAnimator() {
		if(robinAnimator == null) {
			robinAnimator = new Animator(produceBridgeScene().getRobin());
		}
		
		return robinAnimator;
	}
	
	public static AnimatorInterface produceArthurAnimator() {
		if(arthurAnimator == null) {
			arthurAnimator = new Animator(produceBridgeScene().getArthur());
		}
		
		return arthurAnimator;
	}
	
	@Tags({"broadcastingClearanceManagerFactoryMethod"})
	public static BroadcastingClearanceManager produceClearanceManager() {
		if(clearance == null) {
			clearance = new ABroadcastingClearanceManager();
		}
		
		return clearance;
	}
}
