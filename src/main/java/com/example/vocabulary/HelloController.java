package com.example.vocabulary;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HelloController {

    public ListView listView = new ListView<>();
    private List<String> linkedList = new LinkedList<>(Arrays.asList());


    public HelloController()
    {
        File file = new File("src\\main\\resources\\com\\example\\vocabulary/name.txt");
        try {
            Scanner read = new Scanner(file);
            while (read.hasNext())
            {
                String line = read.nextLine();
                linkedList.add("\n"+line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        //System.out.println(linkedList);
    }

    public void close(ActionEvent actionEvent)
    {
        ((Stage)(((Button)actionEvent.getSource()).getScene().getWindow())).close();
    }

    public void action(ActionEvent actionEvent) {
        if(!linkedList.isEmpty())
            listView.getItems().add(linkedList);
    }
}