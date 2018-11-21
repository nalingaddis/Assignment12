package mp.interfaces;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Image", "BoundedShape"})
@StructurePattern(StructurePatternNames.IMAGE_PATTERN)
@PropertyNames({"X", "Y", "Height", "Width", "ImageFileName"})
@EditablePropertyNames({"X", "Y", "Height", "Width", "ImageFileName"})

public interface ImageInterface extends BoundedShapeInterface{
	//Getters
	public String getImageFileName();
	
	//Setters
	public void setImageFileName(String s);
}
