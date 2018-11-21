package mp.history;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class PCLSupport implements PCLSupportInterface{
	public static final int MAX_SIZE = 50;
	
	private List<PropertyChangeListener> contents = new ArrayList<PropertyChangeListener>();
	
	public List<PropertyChangeListener> get() {
		return contents;
	}
		
	public void notifyAllListeners(PropertyChangeEvent event) {
		for (int index = 0; index < contents.size(); index++) {			
			contents.get(index).propertyChange(event);
		}
	}
	
	public void clear() {
		contents.clear();
	}
	
	public void add(PropertyChangeListener listener) {
		contents.add(listener);
	}
}
