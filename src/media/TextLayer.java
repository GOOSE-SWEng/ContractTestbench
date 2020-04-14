package media;

import java.util.ArrayList;

import org.w3c.dom.Node;

import javafx.scene.SubScene;
import javafx.scene.layout.StackPane;

public class TextLayer {
	int height;
	int width;
	StackPane sp = new StackPane();
	ArrayList<SlideText> slideText = new ArrayList<SlideText>();
	SubScene window = new SubScene(sp,width,height);
	
	public TextLayer(int width,int height, ArrayList<SlideText> slideText){
		this.height = height;
		this.width = width;
		sp.setMinSize(width,height);
		this.slideText = slideText;
	}
	
	public void add(Node node, int slideNumber) {
		//constructor for the text object
		SlideText text = new SlideText(node, slideNumber, height, width);
		slideText.add(text);
		sp.getChildren().add(text.get());
	}
	
	public void remove(SlideText object) {
		sp.getChildren().remove(object.get());
	}
	
	public SubScene get() {
		return (window);
	}
}