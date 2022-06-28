package com.example.myproject;

import com.example.Model.Admin;
import com.example.Model.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Vector;


public class StartingWindowController {

    int intotalselltoday= 900000;

    private Stage stage;
    private Scene scene;
    private Parent root;
    static int flag = 3;

    @FXML
    private Button loginbar;

    @FXML
    private PasswordField passwordbar;
/*
    public StartingWindowController(Button loginbar, PasswordField passwordbar) {
        this.loginbar = loginbar;
        this.passwordbar = passwordbar;
    }*/

    public void switchToAdminUserSelection(ActionEvent event) throws IOException {

        this.flag=2;
      /*  root= FXMLLoader.load(getClass().getResource("admin_user_selection.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();*/


        loginbar.setVisible(true);
        passwordbar.setVisible(true);


    }
    /*  @FXML
      public void Loginbarclicked(ActionEvent event) throws IOException {

          root= FXMLLoader.load(getClass().getResource("DashboardUpdate.fxml"));
          stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
          scene= new Scene(root);
          stage.setScene(scene);
          stage.show();
      }
  */
    @FXML
    public void switchToadmindashboard(ActionEvent event) throws IOException {

//        Vector<Product> p = Product.getAllProduct();
//        int cnt = 0;
//        while(cnt < p.size()) {
//            System.out.println(p.get(cnt).getName() +
//                    " " + p.get(cnt).getCount() +
//                    " " + p.get(cnt).getPrice());
//            cnt++;
//        }
//        System.out.println("***");

//        Sold.SetItems();
//
//        int i=0;
//        while (i<Dataclasss.Items.size())
//        {
//            System.out.println(Dataclasss.Items.get(i).Itemname);
//            i++;
//        }

        String pass;
        pass = passwordbar.getText();
        // System.out.println(pass);
        //System.out.println(Dataclasss.adminpassword);
        String done="12345";
//
        if(pass.equals(Admin.getPassword())) {

//            if(pass.equals(Dataclasss.adminpassword)) {


            System.out.println("if");
            root = FXMLLoader.load(getClass().getResource("adminDashboard.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else
        {
            System.out.println("else");
            passwordbar.setText(null);
        }
    }
    @FXML
    public void switchToCashierUserSelection(ActionEvent event) throws IOException {
        this.flag=2;
        root= FXMLLoader.load(getClass().getResource("cashier_user_selection.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void Maximized_clicked(MouseEvent event)
    {
        stage.setMaximized(true);
    }
    @FXML
    void aboutUsClicked(ActionEvent event) throws IOException {

        root= FXMLLoader.load(getClass().getResource("aboutus.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void infoclicked(ActionEvent event) throws IOException {

        root= FXMLLoader.load(getClass().getResource("Information.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    void userManualclicked(ActionEvent event) throws IOException {
        root= FXMLLoader.load(getClass().getResource("userManual.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();

    }




}
