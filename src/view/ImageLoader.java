package view;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageLoader {
    static BufferedImage[] summerFlounder = createPicArray("summerFlounderLeft", "summerFlounderRight");
    static BufferedImage[] blueFish = createPicArray("blueFishLeft","blueFishRight");
    static BufferedImage[] bassFish = createPicArray("bassFishLeft","bassFishRight");
    static BufferedImage[] blueCrab = createPicArray("blueCrab","blueCrab");
    static BufferedImage askBackground = createImg("askHelpBackground");
    static BufferedImage infoBackground = createImg("infoPage");
    static BufferedImage endPage = createImg("endPage");
    static BufferedImage net = createImg("net");
    static BufferedImage boat = createImg("boatChild");
    static BufferedImage quizBackground = createImg("quizPage");
    static BufferedImage mainBackground = createImg("mainBackground");
    static BufferedImage explanBackground = createImg("explanBackground");
    static BufferedImage startBackground = createImg("startBackground");

   public static BufferedImage createImg(String name){
        BufferedImage img;
        try {
            img = ImageIO.read(new File("images/"+name+".png"));
            return img;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static BufferedImage[] createPicArray(String left, String right) {
        BufferedImage[] result = new BufferedImage[2];
        BufferedImage picLeft = createImg(left);
        BufferedImage picRight = createImg(right);

        result[0] = picLeft;
        result[1] = picRight;
        return result;
    }

}
