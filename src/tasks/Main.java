package tasks;

import java.awt.image.BufferedImage;

/**
 * Created by sir.viters on 20.09.2016.
 */
public class Main {
    public static void main(String args[]) {
        BufferedImage newImage;
        for (int i = 0; i < 5; ++i) {
            newImage = RandomImageGenerator.generate(500, 500, 10, RandomImageGenerator.ImageType.MONOCHROMATIC);
            RandomImageGenerator.save(newImage, "images/image" + i + ".png");
        }
    }
}
