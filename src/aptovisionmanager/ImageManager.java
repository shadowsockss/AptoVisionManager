

package aptovisionmanager;

import javafx.scene.image.Image;

/**
 * Helper class that manages image resources.
 * 
 * 
 */
public class ImageManager {

	public static Image[] getImages(String[] imagesPath) {
		if(imagesPath.length <= 0) return null;
		
		Image[] images = new Image[imagesPath.length];
		
		for (int i = 0; i < imagesPath.length; i++)
		{
			images[i] = getImage(imagesPath[i]);
		}
		
        return images;
    }
	
	public static Image getImage(String imagePath) {
        return new Image(getResource(imagePath));
    }
	
    public static String getResource(String resource) {
        return ImageManager.class.getResource(resource).toExternalForm();
    }
}