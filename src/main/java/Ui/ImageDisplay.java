package Ui;

import Model.Image;

public interface ImageDisplay {

    Image current();

    void show(Image image);
}