package com.example.projecttester;

import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class RaceController implements Initializable
{
    @FXML
    Button flyRaceButton;

    @FXML
    Button exitRaceButton;

    @FXML
    ImageView thisDuckUp;
    @FXML
    ImageView thisDuckDown;
    @FXML
    ImageView anotherDuckUp;
    @FXML
    ImageView anotherDuckDown;

    private double energyLevel;
    private double flyLevel;

    public void setPrevScene (Scene scene, double energyLevel, double flyLevel)
    {
        homeScene = scene;
        this.energyLevel = energyLevel;
        this.flyLevel = flyLevel;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }

    public void raceDucks()
    {
        flyRaceButton.setVisible(false);
        makeDuckFly(thisDuckUp, thisDuckDown, .3 *
                        (Math.pow((5 / energyLevel) + (5 / flyLevel), -2) + 1 - energyLevel),
                .6 * (Math.pow((5 / energyLevel) + (5 / flyLevel), -2) + 1 - energyLevel));
        makeDuckMoveable(thisDuckUp, thisDuckDown);
        makeDuckFly(anotherDuckUp, anotherDuckDown, .15, .45 );
        makeDuckMoveable(anotherDuckUp, anotherDuckDown);
    }

    @FXML
    private AnchorPane pane;


    private Scene homeScene;

    public void makeDuckFly(ImageView flyDuck, ImageView flyDuck2,
                            double secBetweenFlaps, double otherSecBetweenFlaps)
    {


        if (flyDuck2 != null)
        {
            flyDuck2.setVisible(false);
        }

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(secBetweenFlaps), event -> {
            if (flyDuck != null && flyDuck2 != null){
                flyDuck.setVisible(false);
                flyDuck2.setVisible(true);
            }

        }));


        Timeline timeline2 = new Timeline(new KeyFrame(Duration.seconds(otherSecBetweenFlaps), event -> {

            if (flyDuck != null && flyDuck2 != null) {
                flyDuck.setVisible(true);
                flyDuck2.setVisible(false);
                flyDuck.setX((flyDuck.getX() + 3 * (Math.pow(5 / energyLevel, -2) + 1 - energyLevel)));
                flyDuck2.setX(flyDuck2.getX() + 3 * (Math.pow(5 / energyLevel, -2) + 1 - energyLevel));
            }
        }));

        PauseTransition pause = new PauseTransition(Duration.seconds(secBetweenFlaps));

        pause.setOnFinished(event -> {
            timeline2.play();
        });

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline2.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        pause.play();
    }

    public void makeDuckMoveable(ImageView flyDuck, ImageView flyDuck2)
    {
        if (flyDuck != null) {
            flyDuck.setFocusTraversable(true);
            flyDuck.setOnKeyPressed(event -> {
                KeyCode code = event.getCode();
                switch (code) {
                    case UP:
                        TranslateTransition translateUp = new TranslateTransition();
                        translateUp.setByY(-60);
                        translateUp.setNode(flyDuck);

                        TranslateTransition translateUp2 = new TranslateTransition();
                        translateUp2.setByY(-60);
                        translateUp2.setNode(flyDuck2);

                        translateUp.play();
                        translateUp2.play();
                        break;
                    case DOWN:
                        TranslateTransition translateDown = new TranslateTransition();
                        translateDown.setByY(60);
                        translateDown.setNode(flyDuck);

                        TranslateTransition translateDown2 = new TranslateTransition();
                        translateDown2.setByY(60);
                        translateDown2.setNode(flyDuck2);

                        translateDown.play();
                        translateDown2.play();
                        break;
                    default:
                        break;
                }
            });
        }
    }

    public void toHome(ActionEvent event)
    {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(homeScene);
        HelloController.coinNum += 20;
        stage.show();
    }


}
