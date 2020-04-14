package media;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.SubScene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Module to display text onto a StackPlane by adding extra TextFlows.
 * Also handles removing text via an ID assigned when drawn.
 *
 * @author Daniel Bishop/Eric Walker
 *
 */
public class SlideText {

  private String dfFont = "Arial";
  private int dfFontSize = 12;
  private String dfFontColor = "#000000";
  private TextFlow toDisplay = null;
  private SubScene scene = null;
  private int slideNumber = 0;

  /**
   * Set up the handler with the target pane and default settings.
   */
  public SlideText(Node node, int slideNumber, int sceneWidth, int sceneHeight) {
    this.slideNumber = slideNumber;
    Pane blankPane = new Pane();
    TextFlow elementText = new TextFlow();
    this.scene = new SubScene(blankPane, sceneHeight, sceneWidth);

    //Set up defaults
    String fontName = this.dfFont;
    int fontSize = this.dfFontSize;
    String fontColor = this.dfFontColor;
    
    // Overwrite defaults
    // If size is specified, use it
    Node sizeNode = node.getAttributes().getNamedItem("fontsize");
    if (sizeNode != null) {
      fontSize = Integer.parseInt(sizeNode.getTextContent());
    }

    // If color is specified, use it
    Node colorNode = node.getAttributes().getNamedItem("fontcolor");
    if (colorNode != null) {
      fontColor = colorNode.getTextContent();
    }

    // If Font is specified, set it to that, else defaults
    Node fontNode = node.getAttributes().getNamedItem("font");
    if (fontNode != null) {
      fontName = fontNode.getTextContent();
    }

    Color fontFill = Color.web(fontColor);
    Font basic = Font.font(fontName, fontSize);
    Font italic = Font.font(fontName, FontPosture.ITALIC, fontSize);
    Font bold = Font.font(fontName, FontWeight.BOLD, fontSize);
    Text partialText;

    // Add each text element to the TextFlow
    NodeList children = node.getChildNodes();
    for (int i = 0; i < children.getLength(); i++) {
      // Add plain text
      if (children.item(i).getNodeName().equals("#text")) {
        partialText = new Text(children.item(i).getNodeValue());
        partialText.setFill(fontFill);
        partialText.setFont(basic);
        elementText.getChildren().add(partialText);
      // Add bold text
      } else if (children.item(i).getNodeName().equals("b")) {
        partialText = new Text(children.item(i).getChildNodes().item(0).getNodeValue());
        partialText.setFill(fontFill);
        partialText.setFont(bold);
        elementText.getChildren().add(partialText);
      // Add italic text
      } else if (children.item(i).getNodeName().equals("i")) {
        partialText = new Text(children.item(i).getChildNodes().item(0).getNodeValue());
        partialText.setFill(fontFill);
        partialText.setFont(italic);
        elementText.getChildren().add(partialText);
      }
    }

    float floatX = Float.parseFloat(node.getAttributes().getNamedItem("xpos").getTextContent());
    float floatY = Float.parseFloat(node.getAttributes().getNamedItem("ypos").getTextContent());

    // Calculate pixel values for x, y, w and h
    int x = Math.toIntExact(Math.round((floatX / 100) * sceneWidth));
    int y = Math.toIntExact(Math.round((floatY / 100) * sceneHeight));

    elementText.setTranslateX(x);
    elementText.setTranslateY(y);

    this.toDisplay = elementText;
  }

  /**
   * Draw the text with the provided ID.
   */
  public SubScene get() {
    return scene;
  }

  //TODO
  //start and end times
  public int getSlideNo() {
    return slideNumber;
  }

  public void start() {
  }
}