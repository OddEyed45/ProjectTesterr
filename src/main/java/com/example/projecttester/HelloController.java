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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
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

    private double energyLevel;
    private double runLevel;
    private int coinNum;

    @FXML
    private Label coinShow;

    private Parent homeRoot;
    public void onButtonClick (ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("homeScreen.fxml"));
        homeRoot = root;
        stage = (Stage) (((Node)(event.getSource())).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        energyLevel = 0;
        runLevel = 0;
        coinNum = 0;
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
    public void startTrainingFly (ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("trainScreen1.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        PreviousController controller = fxmlLoader.getController();
        controller.setPrevScene(trainRun.getScene());

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
//        root = FXMLLoader.load(getClass().getResource("trainScreen1.fxml"));
//        stage = (Stage) (((Node)(event.getSource())).getScene().getWindow());
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
    }
    public void startTrainingRun (ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("trainScreen2.fxml"));
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


    @FXML
    private ImageView duckHolder2;

    @FXML
    private Button runButton;

    public void run(ActionEvent event)
    {
        if (duckHolder2.getImage().getUrl().contains("duck.png"))
            duckHolder2.setImage(new Image("duck2.png"));
        else
            duckHolder2.setImage(new Image("duck.png"));
        System.out.println(duckHolder2.getImage().equals(new Image("duck.png")));
    }


    @FXML
    private ImageView lemonadeClick;

    @FXML
    private Label displayMessage;

    @FXML
    private Button regLemonade;

    @FXML
    private Button panLemonade;


    public void mouseClick (MouseEvent event)
    {
        displayMessage.setText("Welcome. You can buy regular lemonade or our special Panera lemonade");
        regLemonade = new Button();
        regLemonade.setLayoutX(430);
        regLemonade.setLayoutY(331);
        regLemonade.setPrefHeight(40);
        regLemonade.setPrefWidth(60);
        regLemonade.setText("Regular Lemonade");
        regLemonade.setWrapText(true);
        regLemonade.setFont(new Font(8));
        regLemonade.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                dropLemonade(new Image("regLem.png"), actionEvent);
            }
        });
        panLemonade = new Button();
        panLemonade.setLayoutX(501);
        panLemonade.setLayoutY(331);
        panLemonade.setPrefHeight(40);
        panLemonade.setPrefWidth(60);
        panLemonade.setText("Panera Lemonade");
        panLemonade.setWrapText(true);
        panLemonade.setFont(new Font(8));
        panLemonade.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                dropLemonade(new Image("panLem.png"), actionEvent);
            }
        });
        pane.getChildren().add(regLemonade);
        pane.getChildren().add(panLemonade);
    }

    public void dropLemonade(Image lemonade, ActionEvent actionEvent)
    {
        ImageView lemonadeImage = new ImageView(lemonade);
        lemonadeImage.setFitHeight(lemonadeImage.prefHeight(0) / 10);
        lemonadeImage.setFitWidth(lemonadeImage.prefWidth(0) / 10);
        DraggableMaker lemonadeDrop = new DraggableMaker();
        lemonadeDrop.makeDraggable(lemonadeImage, pane);
        pane.getChildren().add(lemonadeImage);
    }


}