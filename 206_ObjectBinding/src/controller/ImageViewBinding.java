package controller;

import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
/*
        Author: Schlager Daniela
        Date: 28.11.2019
        Class: 4BHIT
        Zuletzt bearbeitet: 28.11.2019

 */
public class ImageViewBinding extends ObjectBinding<Image> {
    StringProperty p;

    public ImageViewBinding(StringProperty property) {
        super.bind(property);
        p = property;
    }

    @Override
    protected Image computeValue() {
        try {
            Image image = new Image(p.get(), true);
            return image;
        } catch (Exception e) {

        }
        return null;
    }
}