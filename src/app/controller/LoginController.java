package app.controller;

import app.database.DBConnect;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {

    @FXML
    private TextField tf_login;

    @FXML
    private PasswordField pf_password;

    @FXML
    private Button btn_login;

    DBConnect db;
    Connection con;

    @FXML
    void loginAction(MouseEvent event){

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM logowanie WHERE (login = ? and hasło = ?)");
            ps.setString(1,tf_login.getText());
            ps.setString(2,pf_password.getText());
            ResultSet loginResult = ps.executeQuery();
            if (loginResult.next()){
                if (loginResult.getString("uprawnienia").equals("admin")) {
                    System.out.println("Witamy Admina");
                    ((Node)(event.getSource())).getScene().getWindow().hide();
                    try{
                        Stage adminStage = new Stage();
                        Parent root = FXMLLoader.load(getClass().getResource("/app/view/AdminView.fxml"));
                        adminStage.setTitle("PANEL ADMINISTRATORA");
                        adminStage.setScene(new Scene(root));
                        adminStage.show();

                    } catch(IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Nie ma takiego użytkownika");
                    tf_login.clear();
                    pf_password.clear();
                }
            } else{
                System.out.println("Nie ma takiego użytkownika");
                tf_login.clear();
                pf_password.clear();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("OK");
    }

    public void initialize(){
        db = new DBConnect();
        db.driverRegistration();
        con = db.setConnection();
    }
}
