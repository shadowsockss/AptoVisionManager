package aptovisionmanager.utils;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class TilePaneUtil
{	
	public static void creatAndSetTilePane(TilePane containPane,Integer itemCount, Image[] sourceImages)
	{
		//if( !(tilePane == null)) return;
		containPane.setAlignment(Pos.CENTER);
		//containPane.setId("containPane");
		for (int i = 0; i < itemCount; i++)
		{
			StackPane itemPane = new StackPane();	
			itemPane.resize(110.00, 110.00);
			itemPane.setPadding(new Insets(2));
			itemPane.setAlignment(Pos.CENTER);
			//itemPane.getStyleClass().add("eitemPane");
			//itemPane.setId("eitemPane");
			//BackgroundFill background = new BackgroundFill(Color.DARKGREY, new CornerRadii(2), new Insets(1));
			//itemPane.setBackground(new Background(background));
			Rectangle bgRectangle = new Rectangle(itemPane.getWidth(), itemPane.getHeight());
//			bgRectangle.setWidth(120);
//			bgRectangle.setHeight(120);
			bgRectangle.setFill(Color.DARKGREY);						
			itemPane.getChildren().add(bgRectangle);				
			
			if ( sourceImages != null && sourceImages.length > 0 && i < sourceImages.length)
			{
				ImageView imageView = new ImageView(sourceImages[i]);
				imageView.setFitHeight(itemPane.getHeight());
				imageView.setFitWidth(itemPane.getWidth());	
				itemPane.getChildren().add(imageView);		
				
				setImageDragSourceEvent(imageView); //set source event
			}
				
			setImageDragTargetEvent(bgRectangle,containPane);////set target event
			
			containPane.getChildren().add(itemPane);
		}
					
	}
	
	public static void setImageDragSourceEvent(ImageView sourceImageView)
	{
		sourceImageView.setId(sourceImageView.toString()+ System.currentTimeMillis());
        
		sourceImageView.setOnDragDetected((MouseEvent event) -> {
            
            Dragboard db = sourceImageView.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
            // Store the node ID in order to know what is dragged.
            content.putString(sourceImageView.getId());
            db.setContent(content);
            event.consume();
        });
	}
	
	public static void setImageDragTargetEvent(Rectangle bgRectangle,TilePane containPane)
	{
		StackPane targetItem = (StackPane) bgRectangle.getParent();
		if (targetItem.getChildren().size() > 2)
            return ;
        
		
		bgRectangle.setOnDragDropped((DragEvent event) -> {
            Dragboard db = event.getDragboard();
            boolean success = false;
            // If this is a meaningful drop...
            if (db.hasString()) {
                // Get an item ID here, which was stored when the drag started.
                String nodeId = db.getString();
                // ...search for the item in unequipped items. If it is there...
                ImageView sourceImage = (ImageView) containPane.lookup("#" + nodeId);
                if (sourceImage != null) {
                    // ... the item is removed from the unequipped list
                    // and attached to body.
                	StackPane sourceItem = (StackPane) sourceImage.getParent();                	
                	
                	sourceItem.getChildren().remove(sourceImage);
                	targetItem.getChildren().add(sourceImage);
                    
                    success = true;
                }
                // ...anyway, the item is now equipped.
               
            }
            event.setDropCompleted(success);
            event.consume();
        });
        
		bgRectangle.setOnDragOver((DragEvent event) -> {
            if (event.getGestureSource() != bgRectangle &&
                    event.getDragboard().hasString()) {
                event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
        });
		
		bgRectangle.setOnDragEntered(new EventHandler <DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                // the drag-and-drop gesture entered the target 
                //System.out.println("onDragEntered");
                // show to the user that it is an actual gesture target 
                if (event.getGestureSource() != bgRectangle &&
                        event.getDragboard().hasString()) {
                	
                	Dragboard db = event.getDragboard();
                    // If this is a meaningful drop...
                    if (db.hasString()) {
                        // Get an item ID here, which was stored when the drag started.
                        String nodeId = db.getString();
                        // ...search for the item in unequipped items. If it is there...
                        ImageView sourceImage = (ImageView) containPane.lookup("#" + nodeId);
                        if (sourceImage != null) {
                            // ... the item is removed from the unequipped list
                        	bgRectangle.setFill(Color.DIMGRAY);
                        }                      
                       
                    }
                }
                
                event.consume();
            }
        });

		bgRectangle.setOnDragExited(new EventHandler <DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                // mouse moved away, remove the graphical cues 
            	bgRectangle.setFill(Color.DARKGREY);
                
                event.consume();
            }
        });
		
	}

}
