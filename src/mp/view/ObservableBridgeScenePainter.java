package mp.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.beans.PropertyChangeEvent;
import java.awt.BasicStroke;
import java.util.ArrayList;
import java.util.List;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.Tags;

@Tags({"ObservableBridgeScenePainter", "PaintListener", "addPaintListener"})

public class ObservableBridgeScenePainter extends Component implements ObservableBridgeScenePainterInterface{
	
	private List<PaintListenerInterface> paintListeners = new ArrayList<PaintListenerInterface>();
	
	public ObservableBridgeScenePainter() {
		setFocusable(true);
	}
	
	public void paint(Graphics2D g) {
		
	}
	
	@Tags({"addPaintListener"})
	public List<PaintListenerInterface> getPaintListeners(){
		return paintListeners;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke());
		
		for(int i = 0; i < paintListeners.size(); i++) {
			paintListeners.get(i).paint(g2);
		}
	}

	public void propertyChange(PropertyChangeEvent evt) {
		repaint();
	}
	
	@Tags({"addPaintListener"})
	public void addPaintListener(PaintListenerInterface listener) {
		paintListeners.add(listener);
	}
}
