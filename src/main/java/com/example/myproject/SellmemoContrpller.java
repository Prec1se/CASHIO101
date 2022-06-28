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

public class SellmemoContrpller {



    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label cost;

    @FXML
    private Label totalproduct;

        @FXML
        private Label p1;

        @FXML
        private Label p2;

        @FXML
        private Label p3;

        @FXML
        private Label p4;

        @FXML
        private Label q1;

        @FXML
        private Label q2;

        @FXML
        private Label q3;

        @FXML
        private Label q4;

        @FXML
        private Label t1;

        @FXML
        private Label t2;

        @FXML
        private Label t3;

        @FXML
        private Label t4;

        @FXML
        private Label timeanddate;

        @FXML
        private Label u1;

        @FXML
        private Label u2;

        @FXML
        private Label u3;

        @FXML
        private Label u4;

        @FXML
        private Label total;



        @FXML
        void MouseEnterd(MouseEvent event) {

        }




    @FXML
    void BackClicked(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("CashierDashboard.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();



    }

    @FXML
    void Load(ActionEvent event) {
            if(Sold.totalnumberofsoldelemewnt==1)
            {
                p1.setText(ReceiptController.vec.get(0).name);
                p1.setVisible(true);

                q1.setText(String.valueOf(ReceiptController.vec.get(0).quantity));
                q1.setVisible(true);

                u1.setText(String.valueOf(ReceiptController.vec.get(0).price));
                u1.setVisible(true);

                t1.setText(String.valueOf(ReceiptController.vec.get(0).total_price));
                t1.setVisible(true);
            }
            else if(Sold.totalnumberofsoldelemewnt==2)
            {
                p1.setText(ReceiptController.vec.get(0).name);
                p1.setVisible(true);

                q1.setText(String.valueOf(ReceiptController.vec.get(0).quantity));
                q1.setVisible(true);

                u1.setText(String.valueOf(ReceiptController.vec.get(0).price));
                u1.setVisible(true);

                t1.setText(String.valueOf(ReceiptController.vec.get(0).total_price));
                t1.setVisible(true);



                p2.setText(ReceiptController.vec.get(1).name);
                p2.setVisible(true);

                q2.setText(String.valueOf(ReceiptController.vec.get(1).quantity));
                q2.setVisible(true);

                u2.setText(String.valueOf(ReceiptController.vec.get(1).price));
                u2.setVisible(true);

                t2.setText(String.valueOf(ReceiptController.vec.get(1).total_price));
                t2.setVisible(true);
            }

            else if(Sold.totalnumberofsoldelemewnt==3)
            {
                p1.setText(ReceiptController.vec.get(0).name);
                p1.setVisible(true);

                q1.setText(String.valueOf(ReceiptController.vec.get(0).quantity));
                q1.setVisible(true);

                u1.setText(String.valueOf(ReceiptController.vec.get(0).price));
                u1.setVisible(true);

                t1.setText(String.valueOf(ReceiptController.vec.get(0).total_price));
                t1.setVisible(true);



                p2.setText(ReceiptController.vec.get(1).name);
                p2.setVisible(true);

                q2.setText(String.valueOf(ReceiptController.vec.get(1).quantity));
                q2.setVisible(true);

                u2.setText(String.valueOf(ReceiptController.vec.get(1).price));
                u2.setVisible(true);

                t2.setText(String.valueOf(ReceiptController.vec.get(1).total_price));
                t2.setVisible(true);





                p3.setText(ReceiptController.vec.get(2).name);
                p3.setVisible(true);
                q3.setText(String.valueOf(ReceiptController.vec.get(2).quantity));
                q3.setVisible(true);
                u3.setText(String.valueOf(ReceiptController.vec.get(2).price));
                u3.setVisible(true);
                t3.setText(String.valueOf(ReceiptController.vec.get(2).total_price));
                t3.setVisible(true);
            }




        //total.setText(String.valueOf(Sold.sol.get(Sold.sol.size()-1).totalproduct));
        total.setText(String.valueOf(Sold.sol.get(Sold.sol.size()-1).totalocost));
            timeanddate.setText(Sold.sol.get(Sold.sol.size()-1).date);

    }


}
