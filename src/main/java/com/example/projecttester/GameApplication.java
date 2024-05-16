/**
 * The GameApplication class launches the game
 * @author Sreeja Amaresam
 * Collaborators: Ashi Sharma, Emily Lou
 * Teacher Name: Ms. Bailey
 * Period: 5
 * Due Date: 05/10/2024
 */

package com.example.projecttester;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GameApplication extends Application
{
    @Override
    public void start(Stage stage) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("entryScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Got Any Grapes?");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args)
    {
        launch();
    }
}