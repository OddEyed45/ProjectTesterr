/**
 * The TrainingController class controls the behaviour of each
 * aspect on the HomeScreen page.
 * @author Sreeja Amaresam
 * Collaborators: Ashi Sharma, Emily Lou
 * Teacher Name: Ms. Bailey
 * Period: 5
 * Due Date: 05/10/2024
 */

package com.example.projecttester;

import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class TrainingController implements Initializable
{
    @FXML
    private AnchorPane pane;

    @FXML
    private Button homeButton;

    @FXML
    private Scene homeScene;

    public void setPrevScene (Scene scene)
    {
        homeScene = scene;
    }

    public void toHome(ActionEvent event)
    {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(homeScene);
        GameController.coinNum += 20;
        stage.show();
    }

    @FXML
    private ImageView trainAirplane;

    @FXML
    private ImageView trainAirplane3;
    @FXML
    private ImageView trainAirplane4;



    @FXML
    private ImageView trainFlyDuck;
    @FXML
    private ImageView trainFlyDuck2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        animateTrainingFly();
    }

    public void animateTrainingFly()
    {
        homeButton.setVisible(false);
        cycleAirplanes();
        makeDuckFly();
        makeDuckMoveable();
        gameOverOnTouch();
    }

    public void cycleAirplanes()
    {
        double ogX = 0;
        for (int i = 0; i < 200; i++)
        {


            if (trainAirplane != null && trainAirplane4 != null && trainAirplane3 != null)
            {
                trainAirplane.setVisible(false);
                trainAirplane3.setVisible(false);
                trainAirplane4.setVisible(false);
            }
            ogX = (int)(Math.random() * 300) + 800;
            moveAirplane(trainAirplane, ogX);
            ogX = (int)(Math.random() * 300) + 800;
            moveAirplane(trainAirplane3, ogX);
            ogX = (int)(Math.random() * 300) + 800;
            moveAirplane(trainAirplane4, ogX);
        }


    }


    @FXML
    private ImageView trainingOver;

    public void gameOverOnTouch()
    {
        if (trainingOver != null)
        {
            trainingOver.setVisible(false);
        }

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.1),
                new EventHandler<ActionEvent>()
                {
                    @Override
                    public void handle(ActionEvent actionEvent)
                    {
                        checkIntersect(trainFlyDuck, trainAirplane);
                        checkIntersect(trainFlyDuck, trainAirplane);
                        checkIntersect(trainFlyDuck2, trainAirplane);
                        checkIntersect(trainFlyDuck, trainAirplane3);
                        checkIntersect(trainFlyDuck2, trainAirplane3);
                        checkIntersect(trainFlyDuck, trainAirplane4);
                        checkIntersect(trainFlyDuck2, trainAirplane4);
                    }
                }));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public void checkIntersect(ImageView theDuck, ImageView plane)
    {
        if (theDuck.getBoundsInParent().intersects(plane.getBoundsInParent()))
        {
            trainingOver = new ImageView();
            trainingOver.setVisible(true);
            trainFlyDuck.setOpacity(0);
            trainFlyDuck2.setOpacity(0);
        }
    }

    public void moveAirplane(ImageView airplane, double ogX) {
        Timeline tl = new Timeline(
                new KeyFrame(Duration.seconds(6), new EventHandler<ActionEvent>()
                {
                    @Override
                    public void handle(ActionEvent actionEvent)
                    {
                        if (airplane != null) {
                            airplane.setVisible(true);
                            airplane.setX((int) (Math.random() * (300)) + 500);
                            TranslateTransition translate = new TranslateTransition();
                            translate.setNode(airplane);
                            translate.setDuration(Duration.seconds(8));
                            translate.setFromX(100);
                            translate.setToX(-2000);
                            translate.play();
                            translate.setOnFinished(new EventHandler<ActionEvent>()
                            {
                                @Override
                                public void handle(ActionEvent actionEvent) {
                                    airplane.setX((int) (Math.random() * (100)) + 900);
                                }
                            });
                        }
                    }
                }));
        tl.setCycleCount(Timeline.INDEFINITE);
        tl.play();
    }

    public void makeDuckFly()
    {
        if (trainFlyDuck2 != null)
        {
            trainFlyDuck2.setVisible(false);
        }


        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.3),
                new EventHandler<ActionEvent>()
                {
                    @Override
                    public void handle(ActionEvent actionEvent)
                    {
                        if (trainFlyDuck != null && trainFlyDuck2 != null) {
                            trainFlyDuck.setVisible(false);
                            trainFlyDuck2.setVisible(true);
                            trainFlyDuck2.setFocusTraversable(true);
                        }
                    }
                }));


        Timeline timeline2 = new Timeline(new KeyFrame(Duration.seconds(0.6),
                new EventHandler<ActionEvent>()
                {
                    @Override
                    public void handle(ActionEvent event)
                    {
                        if (trainFlyDuck != null && trainFlyDuck2 != null) {
                            trainFlyDuck.setVisible(true);
                            trainFlyDuck2.setVisible(false);
                            trainFlyDuck.setFocusTraversable(true);
                        }
                    }
                }));

        PauseTransition pause = new PauseTransition(Duration.seconds(0.3));

        pause.setOnFinished(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                timeline2.play();
            }
        });

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline2.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        pause.play();
    }

    public void makeDuckMoveable()
    {
        if (trainFlyDuck != null)
        {
            trainFlyDuck.setOnKeyPressed(new EventHandler<KeyEvent>()
            {
                @Override
                public void handle(KeyEvent event)
                {
                    KeyCode code = event.getCode();
                    switch (code)
                    {
                        case UP:
                            TranslateTransition translateUp = new TranslateTransition();
                            translateUp.setByY(-60);
                            translateUp.setNode(trainFlyDuck);

                            TranslateTransition translateUp2 = new TranslateTransition();
                            translateUp2.setByY(-60);
                            translateUp2.setNode(trainFlyDuck2);

                            translateUp.play();
                            translateUp2.play();
                            break;
                        case DOWN:
                            TranslateTransition translateDown = new TranslateTransition();
                            translateDown.setByY(60);
                            translateDown.setNode(trainFlyDuck);

                            TranslateTransition translateDown2 = new TranslateTransition();
                            translateDown2.setByY(60);
                            translateDown2.setNode(trainFlyDuck2);

                            translateDown.play();
                            translateDown2.play();
                            break;
                        case X:
                            homeButton.setVisible(true);
                            break;
                        default:
                            break;
                    }
                }
            });
        }

    }





}
