package Ui;

import Model.Image;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SwingImageDisplay extends JPanel implements ImageDisplay {

    private Image currentImage;

    @Override
    public Image current() {
        return currentImage;
    }

    @Override
    public void show(Image image) {
        this.currentImage = image;
        this.repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); // Limpia el lienzo antes de dibujar
        if (currentImage != null) {
            BufferedImage bufferedImage = imageOf(currentImage);
            if (bufferedImage != null) {
                g.drawImage(bufferedImage, 0, 0, getWidth(), getHeight(), null);
            } else {
                System.err.println("No se pudo cargar la imagen actual.");
            }
        }
    }


    private BufferedImage imageOf(Image image) {
        try {
            return ImageIO.read(image.stream());
        } catch (IOException e) {
            System.err.println("Error al cargar la imagen: " + e.getMessage());
            return null;
        }
    }
}
