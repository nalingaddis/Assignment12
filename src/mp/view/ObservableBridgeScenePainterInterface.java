package mp.view;

import java.beans.PropertyChangeListener;
import java.util.List;

import util.annotations.Tags;

public interface ObservableBridgeScenePainterInterface extends PropertyChangeListener{
	@Tags({"addPaintListener"})	
	public void addPaintListener(PaintListenerInterface listener);
	public List<PaintListenerInterface> getPaintListeners();
}
