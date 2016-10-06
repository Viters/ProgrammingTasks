package com.tasks;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by sir.viters on 06.10.2016.
 */
class RandomImageGenerator {
    static BufferedImage generate(int width, int height, int tileSize, ImageType type) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Color tempColor = type.colorPick();
        /*
            This loop
         */
        for (int YPos = 0; YPos < height; YPos += tileSize) {
            for (int i = 0; i < width; ++i) {
                if (i % tileSize == 0)
                    tempColor = type.colorPick();
                for (int j = YPos; j < tileSize + YPos; ++j) {
                    image.setRGB(i, j, tempColor.getRGB());
                }
            }
        }
        return image;
    }

    static void save(BufferedImage image, String path) {
        File file = new File(path);
        try {
            ImageIO.write(image, "png", file);
            System.out.println("Write successful!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    enum ImageType {
        NORMAL {
            Color colorPick() {
                int R = getRandomChannel();
                int G = getRandomChannel();
                int B = getRandomChannel();
                return new Color(R, G, B);
            }
        },
        MONOCHROMATIC {
            Color colorPick() {
                int R, G, B;
                R = G = B = 0;
                switch (ThreadLocalRandom.current().nextInt(0, 3)) {
                    case 0: {
                        R = getRandomChannel();
                        break;
                    }
                    case 1: {
                        G = getRandomChannel();
                        break;
                    }
                    case 2: {
                        B = getRandomChannel();
                        break;
                    }
                }
                return new Color(R, G, B);
            }
        },
        SEPIA {
            Color colorPick() {
                int R = getRandomChannel();
                int G = getRandomChannel();
                int B = getRandomChannel();
                return new Color(R, G, B);
            }
        },
        BW {
            Color colorPick() {
                int R = getRandomChannel();
                int G = getRandomChannel();
                int B = getRandomChannel();
                return new Color(R, G, B);
            }
        };

        abstract Color colorPick();

        private static int getRandomChannel() {
            return ThreadLocalRandom.current().nextInt(0, 256);
        }
    }
}