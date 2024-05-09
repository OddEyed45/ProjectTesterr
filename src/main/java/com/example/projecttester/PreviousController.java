package com.example.projecttester;

import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class PreviousController
{
    @FXML
    private Button homeButton;

    private Scene homeScene;

    public void setPrevScene (Scene scene)
    {
        homeScene = scene;
    }

    public void toHome(ActionEvent event)
    {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(homeScene);
        stage.show();
    }
//
//
//    /*Emily's code*/
//
//
//    @FXML
//    private ImageView trainAirplane;
//
//    @FXML
//    private ImageView trainAirplane2;
//    @FXML
//    private ImageView trainAirplane3;
//    @FXML
//    private ImageView trainAirplane4;
//    @FXML
//    private ImageView trainAirplane5;
//
//
//
//    @FXML
//    private ImageView trainFlyDuck;
//    @FXML
//    private ImageView trainFlyDuck2;
//
//    public void animateTrainingFly()
//    {
//        moveAirplanes();
//        makeDuckFly();
//        makeDuckMoveable();
//        //gameOverOnTouch();
//    }
//
//    public void moveAirplanes()
//    {
//        TranslateTransition translate = new TranslateTransition();
//        translate.setNode(trainAirplane);
//        translate.setDuration(Duration.millis(2200));
//        translate.setByX(-600);
//        translate.play();
//    }
//
//    public void cycleAirplanes()
//    {
//        double ogX = 0;
//        for (int i = 0; i < 200; i++){
//
//
//            if (trainAirplane != null && trainAirplane2 != null && trainAirplane3 != null) {
//                trainAirplane.setVisible(false);
//                trainAirplane2.setVisible(false);
//                trainAirplane3.setVisible(false);
//                trainAirplane4.setVisible(false);
//                trainAirplane5.setVisible(false);
//            }
//
//
//            ogX = (int)(Math.random() * 300) + 800;
//            moveAirplane(trainAirplane, ogX);
//            ogX = (int)(Math.random() * 300) + 800;
//            moveAirplane(trainAirplane2, ogX);
//            ogX = (int)(Math.random() * 300) + 800;
//            moveAirplane(trainAirplane3, ogX);
//            ogX = (int)(Math.random() * 300) + 800;
//            moveAirplane(trainAirplane4, ogX);
//            ogX = (int)(Math.random() * 300) + 800;
//            moveAirplane(trainAirplane5, ogX);
//        }
//
//
//    }
//
//
//    public void moveAirplane(ImageView airplane, Double ogX)
//    {
//        Timeline tl = new Timeline(new KeyFrame(Duration.seconds(2), event -> {
//            if (airplane != null) {
//                airplane.setX(ogX);
//                airplane.setVisible(true);
//                TranslateTransition translate = new TranslateTransition();
//                translate.setNode(airplane);
//                translate.setDuration(Duration.seconds(6));
//                translate.setByX(-1500);
//                translate.play();
//            }
//        })
//        );
//        tl.play();
//    }
//
//    public void makeDuckFly()
//    {
//        if (trainFlyDuck2 != null)
//        {
//            trainFlyDuck2.setVisible(false);
//        }
//
//
//        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.3), event -> {
//            if (trainFlyDuck != null && trainFlyDuck2 != null){
//                trainFlyDuck.setVisible(false);
//                trainFlyDuck2.setVisible(true);
//            }
//
//        }));
//
//
//        Timeline timeline2 = new Timeline(new KeyFrame(Duration.seconds(0.6), event -> {
//
//            if (trainFlyDuck != null && trainFlyDuck2 != null) {
//                trainFlyDuck.setVisible(true);
//                trainFlyDuck2.setVisible(false);
//            }
//        }));
//
//        PauseTransition pause = new PauseTransition(Duration.seconds(0.3));
//
//        pause.setOnFinished(event -> {
//            timeline2.play();
//        });
//
//        timeline.setCycleCount(Timeline.INDEFINITE);
//        timeline2.setCycleCount(Timeline.INDEFINITE);
//        timeline.play();
//        pause.play();
//    }
//
//    public void makeDuckMoveable(){
//        double moveSpeed = 2;
//        final double[] imageY = {148};
//
//        if (trainFlyDuck != null){
//            trainFlyDuck.setFocusTraversable(true);
//            trainFlyDuck.setOnKeyPressed(event -> {
//                KeyCode code = event.getCode();
//                switch (code) {
//                    case UP:
//                        TranslateTransition translateUp = new TranslateTransition();
//                        translateUp.setByY(-60);
//                        translateUp.setNode(trainFlyDuck);
//
//                        TranslateTransition translateUp2 = new TranslateTransition();
//                        translateUp2.setByY(-60);
//                        translateUp2.setNode(trainFlyDuck2);
//
//                        translateUp.play();
//                        translateUp2.play();
//                        break;
//                    case DOWN:
//                        TranslateTransition translateDown = new TranslateTransition();
//                        translateDown.setByY(60);
//                        translateDown.setNode(trainFlyDuck);
//
//                        TranslateTransition translateDown2 = new TranslateTransition();
//                        translateDown2.setByY(60);
//                        translateDown2.setNode(trainFlyDuck2);
//
//                        translateDown.play();
//                        translateDown2.play();
//                        break;
//                    default:
//                        break;
//                }
//            });
//        }
//
//        //public void gameOverOnTouch(){
//
//        // }
//    }
//
//
//
//

}
