/*
        Author: Schlager Daniela
        Date: 21.09.2019
        Class: 4BHIT
        Zuletzt bearbeitet: 23.09.2019
 */

import java.io.File;

public class main {
    public static void main(String[] args) {
        ListeKlasse list = new ListeKlasse();

        if(args.length>0){
            if(args.length<2){
                printWrongArgs();
            }else {
                int args_abw = 0;
                if (new File(args[0]).exists()) {
                    if (args[0].contains(".csv")) {
                        args_abw = 1;
                        if (args[1].compareTo("tab") == 0 || args[1].compareTo("semicolon") == 0 || args[1].compareTo("period") == 0) {
                            switch (args[1]) {
                                case "tab":
                                    list = new Reader().readCSV(args[0], '\t');
                                    break;
                                case "semicolon":
                                    list = new Reader().readCSV(args[0], ';');
                                    break;
                                case "period":
                                    list = new Reader().readCSV(args[0], ',');
                                    break;
                            }
                        } else {
                            printWrongArgs();
                        }
                    } else if (args[0].contains(".dst")) {
                        list = new Reader().readDST(args[0]);
                    } else if (args[0].contains(".ost")) {
                        list = new Reader().readObj(args[0]);
                    } else {
                        System.out.println("Datentyp nicht unterstützt!!!!");
                        return;
                    }
                    if (args[1 + args_abw].contains(".csv")) {
                        if (args.length >= 3 + args_abw) {
                            if (args[2 + args_abw].compareTo("tab") == 0 || args[2 + args_abw].compareTo("semicolon") == 0 || args[2 + args_abw].compareTo("period") == 0) {
                                switch (args[2 + args_abw]) {
                                    case "tab":
                                        new Writer().writeCSV(args[1 + args_abw], list, '\t');
                                        break;
                                    case "semicolon":
                                        new Writer().writeCSV(args[1 + args_abw], list, ';');
                                        break;
                                    case "period":
                                        new Writer().writeCSV(args[1 + args_abw], list, ',');
                                        break;
                                }
                            } else {
                                printWrongArgs();
                            }
                        } else {
                            printWrongArgs();
                        }
                    } else if (args[1 + args_abw].contains(".dst")) {
                        new Writer().writeDST(args[1 + args_abw], list);
                    } else if (args[1 + args_abw].contains(".ost")) {
                        new Writer().writeObj(args[1 + args_abw], list);
                    } else {
                        //Ausgabe wenn der Datentyp nicht unterstützt wird
                        System.out.println("Datentyp wird nicht unterstützt");
                        return;
                    }
                } else {
                    //Ausgabe wenn die Datei nicht gefunden wird
                    System.out.println("File " + args[0] + "nicht gefunden");
                    return;
                }
            }
        }else{
            //Ausgabe wenn keine Argumente gefunden werden
            System.out.println("Keine Argumente gefunden:\n" + "1. Argument Datei aus welcher die Daten gelesen werden soll." +
                    "\n2.Argument Falls die Dateien aus dem 1.Argument eine csv Datei ist, ist hier der Seperator (tab, semicolon, period anzugeben " +
                    "\n 3.Argument Falls im 2.Argument der Seperator angegeben wurde muss hier die Output Datei angegeben werden. Falls im 2.Argument eine CSV Datei angegeben wurde muss hier der gewünschte Seperator abgegeben werden"+
                    "\n 4.Argument Falls im 3.Argument eine CSV Datei angegeben wurde muss hier der gewünschte SEperator angegeben werden");
        }
    }

    //Ausgabe wenn falsche Argumente angegeben werden
    private static void printWrongArgs(){
        String wrong_args = "Falsches Argument gefunden:\n" +"1. Argument Datei aus welcher die Daten gelesen werden soll." +
                "\n2.Argument Falls die Dateien aus dem 1.Argument eine csv Datei ist, ist hier der Seperator (tab, semicolon, period anzugeben " +
                "\n 3.Argument Falls im 2.Argument der Seperator angegeben wurde muss hier die Output Datei angegeben werden. Falls im 2.Argument eine CSV Datei angegeben wurde muss hier der gewünschte Seperator abgegeben werden"+
                "\n 4.Argument Falls im 3.Argument eine CSV Datei angegeben wurde muss hier der gewünschte SEperator angegeben werden";
    }
}
