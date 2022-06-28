package com.example.myproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Vector;

public class AddItemController {

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
    private TextField u1;

    @FXML
    private TextField u2;

    @FXML
    private TextField u3;

    @FXML
    private TextField u4;

    @FXML
    private TextField u5;

    @FXML
    private TextField u6;


    int count=0,total=0,temp=0,current_product_price=0;
    String Buyer_Name,Seller_Name;

    private Stage stage;
    private Scene scene;
    private Parent root;

    Vector<Sold> vec = new Vector<Sold>();

    @FXML
    void BackButtonPressed(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("adminDashboard.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void CreateClicked(ActionEvent event) throws IOException {
        count++;

      if(count==2) {
          CurrentProductName = d2.getText();
          quantity = Integer.parseInt(q2.getText());
          unitprice = Integer.parseInt(u2.getText());
          int i = 0;

          while (i < Dataclasss.Items.size()) {

              if (CurrentProductName == Dataclasss.Items.get(i).Itemname) {
                  Dataclasss.Items.get(i).Itemquantaty = Dataclasss.Items.get(i).Itemquantaty + quantity;
                  flag = 1;
                  break;
              }
              i++;
          }
          if (flag == 0) {
              Item myitem = new Item(CurrentProductName, unitprice, quantity);
              Dataclasss.Items.add(myitem);

          }


          temp = unitprice * quantity;
          t2.setText(String.valueOf(temp));
          t2.setVisible(true);
          Sold myobj = new Sold(temp);
          vec.add(myobj);


      }

        if(count==3) {
            CurrentProductName = d3.getText();
            quantity = Integer.parseInt(q3.getText());
            unitprice = Integer.parseInt(u3.getText());
            int i = 0;
            while (i < Dataclasss.Items.size()) {

                if (CurrentProductName == Dataclasss.Items.get(i).Itemname) {
                    Dataclasss.Items.get(i).Itemquantaty = Dataclasss.Items.get(i).Itemquantaty + quantity;
                    flag = 1;
                    break;
                }
                i++;
            }
            if (flag == 0) {
                Item myitem = new Item(CurrentProductName, unitprice, quantity);
                Dataclasss.Items.add(myitem);

            }


            temp = unitprice * quantity;
            t3.setText(String.valueOf(temp));
            t3.setVisible(true);
            Sold myobj = new Sold(temp);
            vec.add(myobj);


        }



        int i = 0;
        while (i < vec.size()) {
            total=total+vec.get(i).price;
            i++;
        }
        Purches obj= new Purches(from.getText(),i,total);
        Sold.pur.add(obj);

        root = FXMLLoader.load(getClass().getResource("Buymemo.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        vec.clear();

    }

    String CurrentProductName;
    int flag=0,quantity=0,unitprice=0;

    @FXML
    void MoreClicked(ActionEvent event) {

        flag=0;
        count++;
        if(count==1)
        {


            CurrentProductName=d1.getText();
            quantity=Integer.parseInt(q1.getText());
            unitprice=Integer.parseInt(u1.getText());
            int i=0;
            while (i<Dataclasss.Items.size())
            {

                if(CurrentProductName==Dataclasss.Items.get(i).Itemname)
                {
                    Dataclasss.Items.get(i).Itemquantaty=Dataclasss.Items.get(i).Itemquantaty+quantity;
                    flag=1;
                    break;
                }
                i++;
            }
            if(flag==0)
            {
                Item myitem= new Item(CurrentProductName,unitprice,quantity);
                Dataclasss.Items.add(myitem);

            }
            temp= unitprice*quantity;
            t1.setText(String.valueOf(temp));
            t1.setVisible(true);
            d2.setVisible(true);
            q2.setVisible(true);
            u2.setVisible(true);



            //   currentd1.getText()

        }

        else if(count==2)
        {

            //System.out.println("mycount");
            CurrentProductName=d2.getText();
            quantity=Integer.parseInt(q2.getText());
            unitprice=Integer.parseInt(u2.getText());
            int i=0;

             System.out.println("oky");
            while (i<Dataclasss.Items.size())
            {

                if(CurrentProductName==Dataclasss.Items.get(i).Itemname)
                {
                    Dataclasss.Items.get(i).Itemquantaty=Dataclasss.Items.get(i).Itemquantaty+quantity;
                    flag=1;
                    break;
                }
                i++;
            }
            if(flag==0)
            {
                Item myitem= new Item(CurrentProductName,unitprice,quantity);
                Dataclasss.Items.add(myitem);

            }


            temp= unitprice*quantity;
            t2.setText(String.valueOf(temp));
            t2.setVisible(true);
            d3.setVisible(true);
            q3.setVisible(true);
            u3.setVisible(true);
        }

        Sold myobj= new Sold(temp);
        vec.add(myobj);


    }

}
