package mp.clearance;

import util.annotations.Tags;
import util.models.PropertyListenerRegisterer;

public interface ClearanceManager extends PropertyListenerRegisterer{
	public void proceed();
	@Tags({"waiting"})
	public void waitForProceed();	
	

}
