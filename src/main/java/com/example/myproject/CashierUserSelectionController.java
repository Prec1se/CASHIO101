package com.example.myproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class CashierUserSelectionController {

    int usr=0;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button forgottenpasswordbutton;

    @FXML
    private TextField intotal;

    @FXML
    private TextField namebar;

    @FXML
    private PasswordField passwordbar;


    @FXML
    private Label label;

    @FXML
    void forgottenpasswordclicked(ActionEvent event) {
        label.setText("Please ask admin for newly set the password");

        System.out.println("donme");
        //label.setAccessibleText("done");
        forgottenpasswordbutton.setVisible(false);

    }


    @FXML
    void user1clicked(ActionEvent event) {
        usr=1;
        namebar.clear();
        namebar.setText(Dataclasss.User1Name);
        //  System.out.println("done");

    }

    @FXML
    void user2clicked(ActionEvent event) {
        usr=2;
        namebar.clear();
        namebar.setText(Dataclasss.User2Name);
        // System.out.println("User3");

    }


    @FXML
    void user3clicked(ActionEvent event) {
        usr=3;
        //System.out.println("done");
        namebar.clear();
        namebar.setText(Dataclasss.User3Name);
    }
   /* @Override
    public void handle(KeyEvent ke) {
        if (ke.getCode().equals(KeyCode.ENTER)) {
           // doSomething();
            switchToCashierDashboard();
        }
    }*/

    @FXML
    public void switchToCashierDashboard(ActionEvent event) throws IOException {

        boolean flag=false;
        String pass;
        pass = passwordbar.getText();
        String name;

        name = namebar.getText();
        if(name.equals(Dataclasss.User1Name))
        {
            usr=1;
        }
        else if(name.equals(Dataclasss.User2Name))
        {
            usr=2;
        }
        if(name.equals(Dataclasss.User3Name))
        {
            usr=3;
        }


        Dataclasss.CurrentCashierUser=usr;
      //  System.out.println(name+"ok: "+usr);

       // System.out.println(pass);
       // System.out.println(Dataclasss.adminpassword);
       // String done="12345";

        if(usr==1)
        {
            flag=pass.equals(Dataclasss.User1Password);
        }
        else if(usr==2)
        {
            flag=pass.equals(Dataclasss.User2Password);
        }
        else if(usr==3)
        {
            flag=pass.equals(Dataclasss.User3Password);
        }

        if(flag) {
            root = FXMLLoader.load(getClass().getResource("CashierDashboard.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else
        {
            passwordbar.setText(null);
        }
    }
    @FXML
    void backbuttonpressed(ActionEvent event) throws IOException {

        root= FXMLLoader.load(getClass().getResource("startingwindow.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();


    }



}
