package main;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import media.Image;
import media.ImageLayer;
import media.SlideText;
import media.TextLayer;

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
		StackPane sp = new StackPane();
		ImageLayer il = new ImageLayer(defaultXSize, defaultYSize, images);
		TextLayer tl = new TextLayer(defaultXSize, defaultYSize, slideTexts);
		sp.getChildren().add(il.get());
		sp.getChildren().add(tl.get());
		//Testing here
		Scene scene = new Scene(sp, defaultXSize, defaultYSize);
		mainStage.setScene(scene);
		mainStage.show();	
	}
}
