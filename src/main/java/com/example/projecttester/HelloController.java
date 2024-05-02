package com.example.projecttester;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;
    @FXML
    private Button startGame;

    @FXML
    private AnchorPane pane;

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
    private ImageView background;

    @FXML
    private ImageView duckHolder;


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

    DraggableMaker draggableMaker = new DraggableMaker();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        draggableMaker.makeDraggable(duckHolder, pane);
    }
}