package mp.history;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public interface PCLSupportInterface {
	public List<PropertyChangeListener> get();
	public void notifyAllListeners(PropertyChangeEvent event);
	public void clear();
	public void add(PropertyChangeListener listener);
}
