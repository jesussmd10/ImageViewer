package Model;

import java.io.InputStream;

public class ImageV1 implements Image {
    final private String name;
    final private InputStream stream;

    public ImageV1(String name, InputStream stream) {
        this.name = name;
        this.stream = stream;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public InputStream stream() {
        return this.stream;
    }
}
