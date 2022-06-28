package com.example.myproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Vector;

public class SupplyReceiptController {

    /*@FXML
    void BackButtonPressed(ActionEvent event) {

    }
*/

    private Stage stage;
    private Scene scene;
    private Parent root;


        @FXML
        private TextField d1;

        @FXML
        private TextField d2;

        @FXML
        private TextField d3;

        @FXML
        private TextField d4;

        @FXML
        private TextField d5;

        @FXML
        private TextField d6;

        @FXML
        private TextArea from;

        @FXML
        private TextField q1;

        @FXML
        private TextField q2;

        @FXML
        private TextField q3;

        @FXML
        private TextField q4;

        @FXML
        private TextField q5;

        @FXML
        private TextField q6;

        @FXML
        private Label t1;

        @FXML
        private Label t2;

        @FXML
        private Label t3;

        @FXML
        private Label t4;

        @FXML
        private Label t5;

        @FXML
        private Label t6;

        @FXML
        private TextArea to;

        @FXML
        private Label u1;

        @FXML
        private Label u2;

        @FXML
        private Label u3;

        @FXML
        private Label u4;

        @FXML
        private Label u5;

        @FXML
        private Label u6;

        int count=0,total=0,temp=0,current_product_price=0;
        String Buyer_Name,Seller_Name;

         Vector<Sold> vec = new Vector<Sold>();




    @FXML
        void CreateClicked(ActionEvent event) throws IOException {
        int i = 0;
        while (i < vec.size()) {
            total=total+vec.get(i).price;
        i++;
        }


        Purches obj= new Purches(to.getText(),i,total);
        Sold.pur.add(obj);
        root = FXMLLoader.load(getClass().getResource("Sellmemo.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
        @FXML
        void MoreClicked(ActionEvent event) {
            count++;
            if(count==1)
            {
                temp= current_product_price*Integer.parseInt(q1.getText());
                t1.setText(Integer.toString(temp));
                t1.setVisible(true);
                u1.setText(Integer.toString(current_product_price));
                u1.setVisible(true);

                d2.setVisible(true);
                q2.setVisible(true);
               Seller_Name= from.getText();
               Buyer_Name= to.getText();
            }

           else if(count==2)
            {
                temp= current_product_price*Integer.parseInt(q2.getText());
                t2.setText(Integer.toString(temp));
                t2.setVisible(true);
                u2.setText(Integer.toString(current_product_price));
                u2.setVisible(true);

                d3.setVisible(true);
                q3.setVisible(true);
            }

           Sold myobj= new Sold(temp);
           vec.add(myobj);


        }


    @FXML
    void BackButtonPressed(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("CashierDashboard.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }




}