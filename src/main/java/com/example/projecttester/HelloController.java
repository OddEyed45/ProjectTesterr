package com.example.projecttester;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class HelloController implements Initializable
{
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

    private double energyLevel = 0;
    private double flyLevel = 0;
    protected static int coinNum = 0;

    @FXML
    private ProgressBar energyBar;
    @FXML
    private ProgressBar flyBar;

    @FXML
    protected Label coinShow;
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
    private Button trainFly;


    @FXML
    private ImageView background;

    @FXML
    private ImageView duckHolder;

    TrainingController controller;
    RaceController controller1;

    public void startRace1 (ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("runScreen1.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        controller1 = fxmlLoader.getController();
        controller1.setPrevScene(race1.getScene(), energyBar.getProgress(), flyBar.getProgress());

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void startTrainingFly (ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("trainScreen1.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        controller = fxmlLoader.getController();
        controller.setPrevScene(trainFly.getScene());

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        coinShow.setText("Coins: " + (coinNum + 20));
        flyLevel += 10;
        if (flyBar.getProgress() + (10.0 / 50) <= 1)
            flyBar.setProgress(flyBar.getProgress() + (10.0 / 50));
        stage.show();
    }

    DraggableMaker draggableMaker = new DraggableMaker();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        draggableMaker.makeDraggable(duckHolder, pane);
    }
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
                if (coinNum >= 1)
                {
                    dropLemonade(new Image("regLem.png"), actionEvent);
                    coinNum--;
                    coinShow.setText("Coins: " + coinNum);
                }
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
                if (coinNum >= 5)
                {
                    dropLemonade(new Image("panLem.png"), actionEvent);
                    coinNum -= 5;
                    coinShow.setText("Coins: " + coinNum);

                }
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
        lemonadeImage.setLayoutX(duckHolder.getLayoutX() + 60);
        lemonadeImage.setLayoutY(pane.getHeight() * .85);

        DraggableMaker lemonadeDrop = new DraggableMaker();
        lemonadeDrop.makeDraggable(lemonadeImage, pane);
        lemonadeDrop.collectCoins(duckHolder, lemonadeImage, pane);
        pane.getChildren().add(lemonadeImage);

        Set<Node> copy = new HashSet<>(pane.getChildren());
        duckHolder.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println(pane.getChildren().size() + " " + copy.size());
                if (pane.getChildren().size() < copy.size()) {

                    List<Node> copy2 = new ArrayList<>(pane.getChildren());
                    copy.removeAll(copy2);

                    if (((ImageView) (copy.toArray()[0])).getImage().getUrl().contains("panLem"))
                        energyLevel += 3;
                    else
                        energyLevel++;
                    copy.removeAll(copy);
                    copy.addAll(pane.getChildren());
                }
                energyBar.setProgress(energyLevel / 50.0);
                System.out.println(energyLevel);
            }
        });



    }


}