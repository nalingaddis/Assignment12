package mp.clearance;

import java.beans.PropertyChangeListener;
import mp.history.PCLSupport;
import mp.history.PCLSupportInterface;
import util.annotations.ComponentWidth;
import util.annotations.Row;
import util.annotations.Tags;
import util.models.AListenableVector;
import util.models.ListenableVector;

public class AClearanceManager implements ClearanceManager {
	ListenableVector waitingThreads = new AListenableVector<>();
	PCLSupportInterface propertyListenerSupport = new PCLSupport();
	
	@Row(0)
	@ComponentWidth(100)
	public synchronized void proceed() {
		System.out.println( Thread.currentThread() + ": before notify");
		notify(); 
		System.out.println( Thread.currentThread() + ": after notify");
	}
	
	@Tags({"waiting"})
	public synchronized void waitForProceed() {
			try {
				String aThreadID = Thread.currentThread().toString();
				System.out.println( aThreadID + ": before wait");
				waitingThreads.addElement(aThreadID);
				wait();
				System.out.println( aThreadID + ": after wait");
				waitingThreads.removeElement(aThreadID);
			} catch (Exception e) {
				e.printStackTrace();
			}
//		}
	}
	@Row(2)
	public ListenableVector getWaitingThreads() {
		return waitingThreads;

	}
	@Override
	public void addPropertyChangeListener(PropertyChangeListener arg0) {
		propertyListenerSupport.add(arg0);
	}

}
