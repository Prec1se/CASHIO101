package com.example.myproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class BuymemoController {


    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private Label cost;

    @FXML
    private Label totalproduct;

    @FXML
    void BackClicked(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("adminDashboard.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    void Load(ActionEvent event) {

        totalproduct.setText(String.valueOf(Sold.pur.get(Sold.pur.size()-1).totalproduct));
        cost.setText(String.valueOf(Sold.pur.get(Sold.pur.size()-1).totalocost));

    }

    @FXML
    void MouseEnterd(MouseEvent event) {

    }

}
