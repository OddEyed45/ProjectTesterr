package com.example.projecttester;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

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
}
