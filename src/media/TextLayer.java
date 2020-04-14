package media;

import java.util.ArrayList;

import org.w3c.dom.Node;

import javafx.scene.Group;
import javafx.scene.SubScene;
import javafx.scene.layout.StackPane;

public class TextLayer {
	int height;
	int width;
	StackPane sp = new StackPane();
	ArrayList<SlideText> slideText = new ArrayList<SlideText>();
  SubScene window;
  StackPane test;
	
	public TextLayer(int width,int height, ArrayList<SlideText> slideText, StackPane test){
		this.height = height;
		this.width = width;
		sp.setMinSize(width,height);
    this.slideText = slideText;
    window = new SubScene(sp,width,height);
    this.test = test;
	}
	
	public void add(Node node, int slideNumber) {
		//constructor for the text object
		SlideText text = new SlideText(node, slideNumber, height, width);
    slideText.add(text);
    System.out.println(text.getStartTime());
    System.out.println(text.getEndTime());
    System.out.println(text.getSlideNo());
    Group textGroup = text.get();
    System.out.println("Children in group: " + textGroup.getChildren().size());
    text.start();
    System.out.println("Children in group: " + textGroup.getChildren().size());
    text.remove();
    System.out.println("Children in group: " + textGroup.getChildren().size());
    test.getChildren().add(text.getTextFlow());
    
	}
	
	public void remove(SlideText object) {
		sp.getChildren().remove(object.get());
	}
	
	public SubScene get() {
		return (window);
	}
}