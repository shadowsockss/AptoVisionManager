package aptovisionmanager;

import java.awt.PopupMenu;

import javax.swing.event.PopupMenuEvent;

import aptovisionmanager.utils.MessageBoxUtil;
import aptovisionmanager.utils.StringUtil;
import aptovisionmanager.utils.TilePaneUtil;
import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

public class AptoVisionManager extends Application {

    private TilePane targetPane = new TilePane();
    private String[] imagesPath;
    private int itemCount;
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("AptoVisionManager.fxml"));
        Scene scene = new Scene(root, 980, 750);
        //scene.getStylesheets().add(getClass().getResource("UIConfig.css").toExternalForm());
        stage.setTitle("AptoVision Manager 2.2.1");
        stage.setScene(scene);       
        stage.setMinWidth(980);
        stage.setMinHeight(750);
        stage.setMaxWidth(980);
        stage.setMaxHeight(750);
        stage.show();
        
        targetPane = (TilePane) root.lookup("#videoRoutingDecoders");
        imagesPath = new String[]{"images/VideoRouting_Decoders_1.png"};  
        itemCount = (int) (targetPane.getWidth()/120)*targetPane.getPrefRows();
        TilePaneUtil.creatAndSetTilePane(targetPane,itemCount, ImageManager.getImages(imagesPath));
        //
        targetPane = (TilePane) root.lookup("#videoRoutingEncoders");
        imagesPath = new String[]{};  
        itemCount = (int) (targetPane.getWidth()/120)*targetPane.getPrefRows();
        TilePaneUtil.creatAndSetTilePane(targetPane,itemCount, ImageManager.getImages(imagesPath));
        
        targetPane = (TilePane) root.lookup("#wallRoutingWall");
        imagesPath = new String[]{};  
        itemCount = (int) (targetPane.getWidth()/120)*targetPane.getPrefRows();
        TilePaneUtil.creatAndSetTilePane(targetPane,itemCount, ImageManager.getImages(imagesPath));
        
        targetPane = (TilePane) root.lookup("#wallRoutingDecoders");
        imagesPath = new String[]{"images/WallRouting_Decoders_1.png"};  
        itemCount = (int) (targetPane.getWidth()/120)*targetPane.getPrefRows();
        TilePaneUtil.creatAndSetTilePane(targetPane,itemCount, ImageManager.getImages(imagesPath));
        
        targetPane = (TilePane) root.lookup("#wallRoutingEncoders");
        imagesPath = new String[]{};  
        itemCount = (int) (targetPane.getWidth()/120)*targetPane.getPrefRows();
        TilePaneUtil.creatAndSetTilePane(targetPane,itemCount, ImageManager.getImages(imagesPath));
        
        targetPane = (TilePane) root.lookup("#multiviewRoutingWall");
        imagesPath = new String[]{};  
        itemCount = (int) (targetPane.getWidth()/120)*targetPane.getPrefRows();
        TilePaneUtil.creatAndSetTilePane(targetPane,itemCount, ImageManager.getImages(imagesPath));
        
        targetPane = (TilePane) root.lookup("#multiviewRoutingDecoders");
        imagesPath = new String[]{"images/MultiviewRouting_Decoders_1.png"};  
        itemCount = (int) (targetPane.getWidth()/120)*targetPane.getPrefRows();
        TilePaneUtil.creatAndSetTilePane(targetPane,itemCount, ImageManager.getImages(imagesPath));
        
        targetPane = (TilePane) root.lookup("#multiviewRoutingEncoders");
        imagesPath = new String[]{};  
        itemCount = (int) (targetPane.getWidth()/120)*targetPane.getPrefRows();
        TilePaneUtil.creatAndSetTilePane(targetPane,itemCount, ImageManager.getImages(imagesPath));
        
        targetPane = (TilePane) root.lookup("#HDMIAudioRoutingDecoders");
        imagesPath = new String[]{"images/AnalogAudioRouting_Decoders_1.png"};  
        itemCount = (int) (targetPane.getWidth()/120)*targetPane.getPrefRows();
        TilePaneUtil.creatAndSetTilePane(targetPane,itemCount, ImageManager.getImages(imagesPath));
        
        targetPane = (TilePane) root.lookup("#HDMIAudioRoutingEncoders");
        imagesPath = new String[]{};  
        itemCount = (int) (targetPane.getWidth()/120)*targetPane.getPrefRows();
        TilePaneUtil.creatAndSetTilePane(targetPane,itemCount, ImageManager.getImages(imagesPath));
        
        targetPane = (TilePane) root.lookup("#analogAudioRoutingDecoders");
        imagesPath = new String[]{"images/AnalogAudioRouting_Decoders_1.png"};  
        itemCount = (int) (targetPane.getWidth()/120)*targetPane.getPrefRows();
        TilePaneUtil.creatAndSetTilePane(targetPane,itemCount, ImageManager.getImages(imagesPath));
        
        targetPane = (TilePane) root.lookup("#analogAudioRoutingEncoders");
        imagesPath = new String[]{};  
        itemCount = (int) (targetPane.getWidth()/120)*targetPane.getPrefRows();
        TilePaneUtil.creatAndSetTilePane(targetPane,itemCount, ImageManager.getImages(imagesPath));
        
        targetPane = (TilePane) root.lookup("#RS232RoutingReceivers");
        imagesPath = StringUtil.getPaths("images/RS232Routing_Receivers_", "png", 3);
        itemCount = (int) (targetPane.getWidth()/120)*targetPane.getPrefRows();
        TilePaneUtil.creatAndSetTilePane(targetPane,itemCount, ImageManager.getImages(imagesPath));
        
        targetPane = (TilePane) root.lookup("#RS232RoutingSenders");
        imagesPath = new String[]{};  
        itemCount = (int) (targetPane.getWidth()/120)*targetPane.getPrefRows();
        TilePaneUtil.creatAndSetTilePane(targetPane,itemCount, ImageManager.getImages(imagesPath));
        
        targetPane = (TilePane) root.lookup("#infraredRoutingReceivers");
        imagesPath = StringUtil.getPaths("images/InfraredRouting_Receivers_", "png", 3);
        itemCount = (int) (targetPane.getWidth()/120)*targetPane.getPrefRows();
        TilePaneUtil.creatAndSetTilePane(targetPane,itemCount, ImageManager.getImages(imagesPath));
        
        targetPane = (TilePane) root.lookup("#infraredRoutingSenders");
        imagesPath = new String[]{};  
        itemCount = (int) (targetPane.getWidth()/120)*targetPane.getPrefRows();
        TilePaneUtil.creatAndSetTilePane(targetPane,itemCount, ImageManager.getImages(imagesPath));
        
        targetPane = (TilePane) root.lookup("#USBRoutingRemoteExtenders");
        imagesPath = new String[]{};  
        itemCount = (int) (targetPane.getWidth()/120)*targetPane.getPrefRows();
        TilePaneUtil.creatAndSetTilePane(targetPane,itemCount, ImageManager.getImages(imagesPath));
        
        targetPane = (TilePane) root.lookup("#USBRoutingLocalExtenders");
        imagesPath = new String[]{};  
        itemCount = (int) (targetPane.getWidth()/120)*targetPane.getPrefRows();
        TilePaneUtil.creatAndSetTilePane(targetPane,itemCount, ImageManager.getImages(imagesPath));
        
        targetPane = (TilePane) root.lookup("#deviceManagerAllDevices");
        imagesPath = new String[]{"images/DeviceManagement_AllDevices_1.png"};  
        itemCount = (int) (targetPane.getWidth()/120)*targetPane.getPrefRows();
        TilePaneUtil.creatAndSetTilePane(targetPane,itemCount, ImageManager.getImages(imagesPath));
        
        //check Tab
        TabPane tabPane = (TabPane) root.lookup("#tabPane");   
    	Tab HDMIAudioRoutingTab = tabPane.getTabs().get(3);
    	tabPane.getTabs().remove(HDMIAudioRoutingTab);
    	
        CheckBox separateHDMIAudioRoutingCheckBox = (CheckBox) root.lookup("#separateHDMIAudioRoutingCheckBox");
        
        separateHDMIAudioRoutingCheckBox.selectedProperty().addListener(
                (ObservableValue<? extends Boolean> ov,
                Boolean old_val, Boolean new_val) -> {
                if(new_val) tabPane.getTabs().add(3,HDMIAudioRoutingTab );
                else tabPane.getTabs().remove(HDMIAudioRoutingTab);
        });
        
        ImageView logoImage = (ImageView) root.lookup("#logoImage");
        logoImage.setImage(ImageManager.getImage("images/logoImage.png"));
        logoImage.setFitHeight(50);
        logoImage.setFitWidth(150);
        
        ImageView wallRoutingWallImage = (ImageView) root.lookup("#wallRoutingWallParametersImage");
        wallRoutingWallImage.setImage(ImageManager.getImage("images/WallRouting_Wall.png"));
        
        ImageView multiviewRoutingMultiviewDeviceImage = (ImageView) root.lookup("#multiviewRoutingMultiviewDeviceImage");
        multiviewRoutingMultiviewDeviceImage.setImage(ImageManager.getImage("images/MultiviewRouting_MultiviewDevice.png"));
        multiviewRoutingMultiviewDeviceImage.setFitHeight(120);
        multiviewRoutingMultiviewDeviceImage.setFitWidth(120);
        
        Button connectButton = (Button) root.lookup("#connectButton");
        connectButton.setOnAction((ActionEvent e) -> {
        	
        	MessageBoxUtil.createNewMessageBox("Unable to open connection property!");
        });
        
    }
    
    public static void main(String[] args) {
        Application.launch(AptoVisionManager.class, args);
    }
}