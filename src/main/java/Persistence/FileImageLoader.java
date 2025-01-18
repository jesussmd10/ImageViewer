package Persistence;

import Model.Image;
import Model.ImageV2;

import java.io.File;
import java.io.FileFilter;

public class FileImageLoader implements ImageLoader {

    private final File[] files;
    private int current;

    public FileImageLoader(File folder) {
        if (folder == null || !folder.isDirectory()) {
            throw new IllegalArgumentException("El argumento folder debe ser un directorio válido.");
        }

        this.files = folder.listFiles(imageTypes());

        if (this.files == null || this.files.length == 0) {
            throw new IllegalStateException("El directorio no contiene imágenes válidas.");
        }

        this.current = 0;
    }

    private FileFilter imageTypes() {
        return file -> file.getName().toLowerCase().endsWith(".jpg");
    }

    @Override
    public Image load() {
        if (files.length == 0) {
            throw new IllegalStateException("No hay imágenes disponibles para cargar.");
        }
        return new ImageV2(files[current]);
    }

    @Override
    public Image next() {
        current = (current + 1) % files.length;
        return load();
    }

    @Override
    public Image prev() {
        current = (current - 1 + files.length) % files.length;
        return load();
    }
}
