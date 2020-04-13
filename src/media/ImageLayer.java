package media;

import java.util.ArrayList;

import javafx.scene.SubScene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;

public class ImageLayer {
	int sceneHeight;
	int sceneWidth;
	StackPane sp = new StackPane();
	ArrayList<Image> images = new ArrayList<Image>();
	SubScene window = new SubScene(sp,sceneWidth,sceneHeight);
	
	public ImageLayer(int width,int height, ArrayList<Image> images){
		sceneHeight = height;
		sceneWidth = width;
		sp.setMinSize(sceneWidth,sceneHeight);
		this.images = images;
	}
	
	public void add(String urlName, int xStart, int yStart, int Width, int height, int startTime, int endTime, int slideNumber) {
		//constructor for the image object
		//Image image = new Image(urlName, xStart, yStart, width, height. startTime, endTime, slideNumber, sceneWidth, sceneHeight);
		// images. add(image);
		//sp.getChildren().add(image.get());
	}
	
	public void remove(Image object) {
		//sp.getChildren().remove(object.get());
	}
	
	public SubScene get() {
		return (window);
	}
}