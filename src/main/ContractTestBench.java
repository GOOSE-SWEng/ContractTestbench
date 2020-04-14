package main;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import media.Image;
import media.ImageLayer;
import media.SlideText;
import media.TextLayer;
// CUBIXEL TESTING
import media.XmlHandler;

public class ContractTestBench extends Application{
	public static int defaultXSize = 1280;
	public static int defaultYSize = 720;

	private static Stage mainStage;
	
	static ArrayList<Image> images = new ArrayList<Image>();
	static ArrayList<SlideText> slideTexts = new ArrayList<SlideText>();
		
	public static void main(String[] args) {
		System.out.println("Running...");
		launch(args);
		System.out.println("Finished...");
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
    mainStage = primaryStage;
    XmlHandler xml = new XmlHandler();
    Document doc = xml.makeXmlFromUrl("M:/ContractTestbench/ValidPresentation.xml");
    Node textNode = doc.getDocumentElement().getElementsByTagName("text").item(0);
		StackPane sp = new StackPane();
		ImageLayer il = new ImageLayer(defaultXSize, defaultYSize, images);
		TextLayer tl = new TextLayer(defaultXSize, defaultYSize, slideTexts);
		sp.getChildren().add(il.get());
		sp.getChildren().add(tl.get());
		//Testing here
    Scene scene = new Scene(sp, defaultXSize, defaultYSize);
		mainStage.setScene(scene);
    mainStage.show();
    tl.add(textNode, 0);
	}
}
