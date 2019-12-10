package model;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/*
        Author: Schlager Daniela
        Date: 28.11.2019
        Class: 4BHIT
        Zuletzt bearbeitet: 28.11.2019

 */
public class Main {


    public static void main(String[] args) {


        DoubleProperty number1 = new SimpleDoubleProperty(1);
        DoubleProperty number2 = new SimpleDoubleProperty(2);
        DoubleProperty number3 = new SimpleDoubleProperty(3);

        NumberBinding calculated1 = Bindings.add(number1, Bindings.multiply(number2,number3));

        NumberBinding calculated2 = number1.add(number2.multiply(number3));

        NumberBinding calculated3 = new DoubleBinding() {
            {
                super.bind(number1, number2, number3);
            }
            @Override
            protected double computeValue() {
                return number1.get() + (number2.get() * number3.get());
            }
        };

        System.out.println(calculated1.getValue());
        System.out.println("\n" + calculated2.getValue());
        System.out.println("\n" + calculated3.getValue());
    }
}
