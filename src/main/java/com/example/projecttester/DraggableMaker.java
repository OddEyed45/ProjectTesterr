package com.example.projecttester;

import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import javafx.scene.image.ImageView;

public class DraggableMaker
{
    private double mouseAnchorX;
    private double mouseAnchorY;

    private double mouseAnchorX2;
    private double mouseAnchorY2;

    public void makeDraggable (Node node, AnchorPane pane)
    {
        if (node == null)
            return;

        node.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                mouseAnchorX = mouseEvent.getX();
                mouseAnchorY = mouseEvent.getY();
            }
        });

        node.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getSceneX() - mouseAnchorX < .6 * pane.getPrefWidth() &&
                        mouseEvent.getSceneX() - mouseAnchorX > 0)
                    node.setLayoutX(mouseEvent.getSceneX() - mouseAnchorX);
                if (mouseEvent.getSceneY() + node.prefHeight(0) - mouseAnchorY < pane.getPrefHeight() &&
                        mouseEvent.getSceneY() - mouseAnchorY > 0)
                    node.setLayoutY(mouseEvent.getSceneY() - mouseAnchorY);
            }
        });

        node.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                while (node.getLayoutY() + node.maxHeight(0) < pane.getHeight() * .9)
                {
                    node.setLayoutY(node.getLayoutY() + .5);
                }
            }
        });

    }

    public void collectCoins (Node node1, ImageView node2, AnchorPane pane)
    {
        node1.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                mouseAnchorX = mouseEvent.getX();
                mouseAnchorY = mouseEvent.getY();
            }
        });

        node2.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                mouseAnchorX2 = mouseEvent.getX();
                mouseAnchorY2 = mouseEvent.getY();
            }
        });

        node1.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getSceneX() - mouseAnchorX < .6 * pane.getPrefWidth() &&
                        mouseEvent.getSceneX() - mouseAnchorX > 0)
                    node1.setLayoutX(mouseEvent.getSceneX() - mouseAnchorX);
                if (mouseEvent.getSceneY() + node1.prefHeight(0) - mouseAnchorY < pane.getPrefHeight() &&
                        mouseEvent.getSceneY() - mouseAnchorY > 0)
                    node1.setLayoutY(mouseEvent.getSceneY() - mouseAnchorY);



            }
        });

        node2.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                if (mouseEvent.getSceneX() - mouseAnchorX2 < .6 * pane.getPrefWidth() &&
                        mouseEvent.getSceneX() - mouseAnchorX2 > 0)
                    node2.setLayoutX(mouseEvent.getSceneX() - mouseAnchorX2);
                if (mouseEvent.getSceneY() + node2.prefHeight(0) - mouseAnchorY2 < pane.getPrefHeight() &&
                        mouseEvent.getSceneY() - mouseAnchorY2 > 0)
                    node2.setLayoutY(mouseEvent.getSceneY() - mouseAnchorY2);


                if (!(node2.getLayoutX() - (node2.prefWidth(0) * .5) < node1.getLayoutX()) &&
                        !(node2.getLayoutY() < node1.getLayoutY()) &&
                        !(node1.getLayoutX() + (node1.prefWidth(0) * .5) < node2.getLayoutX()) &&
                        !(node1.getLayoutY() + node1.prefHeight(0) < node2.getLayoutY()))
                    if (pane.getChildren().contains(node2))
                    {
                        pane.getChildren().remove(node2);
                    }

            }
        });

    }



}
