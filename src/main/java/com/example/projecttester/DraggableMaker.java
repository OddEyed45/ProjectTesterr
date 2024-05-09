package com.example.projecttester;

import javafx.scene.*;
import javafx.scene.layout.AnchorPane;

import javafx.scene.image.ImageView;

public class DraggableMaker
{
    private double mouseAnchorX;
    private double mouseAnchorY;

    public void makeDraggable (Node node, AnchorPane pane)
    {
        if (node == null)
            return;

        node.setOnMousePressed(mouseEvent -> {
            mouseAnchorX = mouseEvent.getX();
            mouseAnchorY = mouseEvent.getY();
        });

        node.setOnMouseDragged(mouseEvent ->
        {
            if (mouseEvent.getSceneX() - mouseAnchorX < .6 * pane.getPrefWidth() &&
                    mouseEvent.getSceneX() - mouseAnchorX > 0)
                node.setLayoutX(mouseEvent.getSceneX() - mouseAnchorX);
            if (mouseEvent.getSceneY() + node.prefHeight(0) - mouseAnchorY < pane.getPrefHeight() &&
                    mouseEvent.getSceneY() - mouseAnchorY > 0)
                node.setLayoutY(mouseEvent.getSceneY() - mouseAnchorY);
        });

        node.setOnMouseReleased(mouseEvent -> {
            while (node.getLayoutY() + node.maxHeight(0) < pane.getHeight() * .9)
            {
                node.setLayoutY(node.getLayoutY() + .5);
            }
        });



    }

}
