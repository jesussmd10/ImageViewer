package ImageViewer;

import Model.Image;
import Persistence.FileImageLoader;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Objects;

public class ImageViewer {

    public static void main(String[] args) {
        try {
            File folder = new File(Objects.requireNonNull(
                    ImageViewer.class.getResource("/imagenes")).toURI());

            if (!folder.exists() || !folder.isDirectory()) {
                throw new IllegalArgumentException("El directorio de imágenes no es válido.");
            }

            FileImageLoader imageLoader = new FileImageLoader(folder);
            Image image = imageLoader.load();

            MainFrame mainFrame = new MainFrame(imageLoader);
            mainFrame.getImageDisplay().show(image);

        } catch (URISyntaxException | NullPointerException e) {
            System.err.println("Error al cargar las imágenes: " + e.getMessage());
        }
    }
}
