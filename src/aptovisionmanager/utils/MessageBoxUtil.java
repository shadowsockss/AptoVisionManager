package aptovisionmanager.utils;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class MessageBoxUtil
{
	public static void createNewMessageBox(String labelString)
	{
		VBox vBox = new VBox(5.0);
    	Label label = new Label(labelString);
    	Button button = new Button("确定");
    	
    	label.setWrapText(true);
    	label.setTextAlignment(TextAlignment.JUSTIFY);
    	button.setFont(new Font("Arial", 14));

    	//button.setPrefSize(button.getWidth()*1.5, button.getHeight()*1.5);
    	vBox.setAlignment(Pos.BASELINE_RIGHT);
    	vBox.getChildren().addAll(label,button);
    	vBox.setPadding(new Insets(15));
    	VBox.setMargin(label, new Insets(5.0));
    	VBox.setMargin(button, new Insets(5.0));
    	vBox.setFocusTraversable(false);
    	Stage popupStage = new Stage();
    	Scene popupscene = new Scene(vBox);
        //scene.getStylesheets().add(getClass().getResource("UIConfig.css").toExternalForm());
    	popupStage.setTitle("AptoVision_Manager");
    	popupStage.setScene(popupscene);       
//    	popupStage.setMinWidth(210);
//    	popupStage.setMinHeight(160);
//    	popupStage.setMaxWidth(210);
//    	popupStage.setMaxHeight(160);
    	popupStage.show();
    	
    	button.setOnAction((ActionEvent t) -> {
    		popupStage.close();
        });
	}

}
