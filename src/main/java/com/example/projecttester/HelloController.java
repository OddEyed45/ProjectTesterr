package com.example.projecttester;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Button startGame;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField nameTextField;

    public void onButtonClick (ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("homeScreen.fxml"));
        stage = (Stage) (((Node)(event.getSource())).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private Button race1;
    @FXML
    private Button race2;
    @FXML
    private Button race3;
    @FXML
    private Button trainRun;
    @FXML
    private Button trainFly;


    @FXML
    private ImageView imageView1;
    public void startRace1 (ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("runScreen1.fxml"));
        stage = (Stage) (((Node)(event.getSource())).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void startRace2 (ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("runScreen2.fxml"));
        stage = (Stage) (((Node)(event.getSource())).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void startRace3 (ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("runScreen3.fxml"));
        stage = (Stage) (((Node)(event.getSource())).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void startTrainingRun (ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("trainScreen1.fxml"));
        stage = (Stage) (((Node)(event.getSource())).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void startTrainingFly (ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("trainScreen21.fxml"));
        stage = (Stage) (((Node)(event.getSource())).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}