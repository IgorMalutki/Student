package app.controller;

import app.database.DBConnect;
import app.model.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.cell.TextFieldTableCell;

import java.math.BigInteger;
import java.sql.*;

public class AdminController {

    @FXML
    private TextField tf_nr_kursanta;

    @FXML
    private Button btn_select;

    @FXML
    private TableColumn<Student, String> c_project1grade;

    @FXML
    private TableColumn<Student, String> c_project1descgrade;

    @FXML
    private TableColumn<Student, String> c_project2grade;

    @FXML
    private TableColumn<Student, String> c_project2descgrade;

    @FXML
    private TableColumn<Student, String> c_project3grade;

    @FXML
    private TableColumn<Student, String> c_project3descgrade;

    @FXML
    private TableColumn<Student, String> c_project4grade;

    @FXML
    private TableColumn<Student, String> c_project4descgrade;

    @FXML
    private Button btn_submit;

    @FXML
    private TableColumn<Student, BigInteger> c_student_id;

    @FXML
    private TableColumn<Student, String> c_name;

    @FXML
    private TableColumn<Student, String> c_lname;

    @FXML
    private TableColumn<Student, String> c_email;

    @FXML
    private TableColumn<Student, String> c_passwd;

    @FXML
    private TableColumn<Student, String> c_git_hub;

    @FXML
    private TableColumn<Student, String> c_phone;

    @FXML
    private TableColumn<Student, String> c_role;

    @FXML
    private TableView<Student> tab;

    @FXML
    private TableView<Student> tab1;

    @FXML
    void selectAction(MouseEvent event) {
        externalSelect();
    }

    @FXML
    void submitAction(MouseEvent event) {
        Long id_selected = tab.getSelectionModel().getSelectedItem().getStudentId();
        String field_selected = tab.getSelectionModel().getSelectedItem().getProject1grade();
        String field1_selected = tab.getSelectionModel().getSelectedItem().getProject1descgrade();
        String field2_selected = tab.getSelectionModel().getSelectedItem().getProject2grade();
        String field3_selected = tab.getSelectionModel().getSelectedItem().getProject2descgrade();
        String field4_selected = tab.getSelectionModel().getSelectedItem().getProject3grade();
        String field5_selected = tab.getSelectionModel().getSelectedItem().getProject3descgrade();
        String field6_selected = tab.getSelectionModel().getSelectedItem().getProject4grade();
        String field7_selected = tab.getSelectionModel().getSelectedItem().getProject4descgrade();

        try {

            PreparedStatement ps = con.prepareStatement("UPDATE student SET project1_grade = ? WHERE student_id = ?");
            ps.setString(1, field_selected);
            ps.setLong(2,id_selected);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {

            PreparedStatement ps = con.prepareStatement("UPDATE student SET project1_descriptive_grade = ? WHERE student_id = ?");
            ps.setString(1, field1_selected);
            ps.setLong(2,id_selected);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
// table view get cursor
        try {

            PreparedStatement ps = con.prepareStatement("UPDATE student SET project2_grade = ? WHERE student_id = ?");
            ps.setString(1, field2_selected);
            ps.setLong(2,id_selected);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {

            PreparedStatement ps = con.prepareStatement("UPDATE student SET project2_descriptive_grade = ? WHERE student_id = ?");
            ps.setString(1, field3_selected);
            ps.setLong(2,id_selected);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {

            PreparedStatement ps = con.prepareStatement("UPDATE student SET project3_grade = ? WHERE student_id = ?");
            ps.setString(1, field4_selected);
            ps.setLong(2,id_selected);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {

            PreparedStatement ps = con.prepareStatement("UPDATE student SET project3_descriptive_grade = ? WHERE student_id = ?");
            ps.setString(1, field5_selected);
            ps.setLong(2,id_selected);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {

            PreparedStatement ps = con.prepareStatement("UPDATE student SET project4_grade = ? WHERE student_id = ?");
            ps.setString(1, field6_selected);
            ps.setLong(2,id_selected);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {

            PreparedStatement ps = con.prepareStatement("UPDATE student SET project4_descriptive_grade = ? WHERE student_id = ?");
            ps.setString(1, field7_selected);
            ps.setLong(2,id_selected);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @FXML
    void c_project1grade_edit_commit(ActionEvent event) {
//        Long id_selected = tab.getSelectionModel().getSelectedItem().getStudentId();
//
//        try {
//
//            PreparedStatement ps = con.prepareStatement("UPDATE student SET project1_grade = ? WHERE student_id = ?");
//            ps.setString(1,"yyy");
//            ps.setLong(2,id_selected);
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
 }


    DBConnect db;
    Connection con;

    public void initialize() {
        db = new DBConnect();
        db.driverRegistration();
        con = db.setConnection();
        tab.setEditable(true);

        c_project1grade.setCellValueFactory(new PropertyValueFactory<Student,String>("project1_grade"));
        c_project1grade.setCellFactory(TextFieldTableCell.forTableColumn());
        c_project1grade.setOnEditCommit(
                (TableColumn.CellEditEvent<Student,String> t)->{
                    (t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setProject1grade(t.getNewValue());
                });
        c_project1descgrade.setCellValueFactory(new PropertyValueFactory<Student,String>("project1_descriptive_grade"));
        c_project1descgrade.setCellFactory(TextFieldTableCell.forTableColumn());
        c_project1descgrade.setOnEditCommit(
                (TableColumn.CellEditEvent<Student,String> t)->{
                    (t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setProject1descgrade(t.getNewValue());
                });

        c_project2grade.setCellValueFactory(new PropertyValueFactory<Student,String>("project2_grade"));
        c_project2grade.setCellFactory(TextFieldTableCell.forTableColumn());
        c_project2grade.setOnEditCommit(
                (TableColumn.CellEditEvent<Student,String> t)->{
                    (t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setProject2grade(t.getNewValue());
                });
        c_project2descgrade.setCellValueFactory(new PropertyValueFactory<Student,String>("project2_descriptive_grade"));
        c_project2descgrade.setCellFactory(TextFieldTableCell.forTableColumn());
        c_project2descgrade.setOnEditCommit(
                (TableColumn.CellEditEvent<Student,String> t)->{
                    (t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setProject2descgrade(t.getNewValue());
                });
        c_project3grade.setCellValueFactory(new PropertyValueFactory<Student,String>("project3_grade"));
        c_project3grade.setCellFactory(TextFieldTableCell.forTableColumn());
        c_project3grade.setOnEditCommit(
                (TableColumn.CellEditEvent<Student,String> t)->{
                    (t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setProject3grade(t.getNewValue());
                });
        c_project3descgrade.setCellValueFactory(new PropertyValueFactory<Student,String>("project3_descriptive_grade"));
        c_project3descgrade.setCellFactory(TextFieldTableCell.forTableColumn());
        c_project3descgrade.setOnEditCommit(
                (TableColumn.CellEditEvent<Student,String> t)->{
                    (t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setProject3descgrade(t.getNewValue());
                });

        c_project4grade.setCellValueFactory(new PropertyValueFactory<Student,String>("project4_grade"));
        c_project4grade.setCellFactory(TextFieldTableCell.forTableColumn());
        c_project4grade.setOnEditCommit(
                (TableColumn.CellEditEvent<Student,String> t)->{
                    (t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setProject4grade(t.getNewValue());
                });
        c_project4descgrade.setCellValueFactory(new PropertyValueFactory<Student,String>("project4_descriptive_grade"));
        c_project4descgrade.setCellFactory(TextFieldTableCell.forTableColumn());
        c_project4descgrade.setOnEditCommit(
                (TableColumn.CellEditEvent<Student,String> t)->{
                    (t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setProject4descgrade(t.getNewValue());
                });



    }
    private ObservableList<Student> lista_Studentow = FXCollections.observableArrayList();

    private void externalSelect(){

        try {
            lista_Studentow.clear();
            tab.setItems(lista_Studentow);
            tab1.setItems(lista_Studentow);

            PreparedStatement ps = con.prepareStatement("SELECT * FROM student ");

//            PreparedStatement ps = con.prepareStatement("SELECT * FROM student WHERE student_id= ?");
//            ps.setString(1,tf_nr_kursanta.getText());

            ResultSet wynik = ps.executeQuery();
            while(wynik.next()){ // next czyta aktualny element i sprawdza czy jest kolejny
                //pobiera wartości kolumn z zapytania do bazy danych i tworzy instancje obiektu Student
                Student st = new Student(
                         //wpisujemy nazwy kolumn z bazy
                        wynik.getLong("student_id"),
                        wynik.getString("student_name"),
                        wynik.getString("student_surname"),
                        wynik.getString("email"),
                        wynik.getString("password"),
                        wynik.getString("git_hub_login"),
                        wynik.getString("phone_number"),
                        wynik.getString("project1_grade"),
                        wynik.getString("project1_descriptive_grade"),
                        wynik.getString("project2_grade"),
                        wynik.getString("project2_descriptive_grade"),
                        wynik.getString("project3_grade"),
                        wynik.getString("project3_descriptive_grade"),
                        wynik.getString("project4_grade"),
                        wynik.getString("project4_descriptive_grade"),
                        wynik.getString("role")
                );
                lista_Studentow.add(st);
            }

            //przypisuje do poł z AdminView wartości odpowiednich pól z obiektu Student
            c_student_id.setCellValueFactory(new PropertyValueFactory<>("studentId"));
            c_name.setCellValueFactory(new PropertyValueFactory<>("name"));
            c_lname.setCellValueFactory(new PropertyValueFactory<>("lname"));
            c_email.setCellValueFactory(new PropertyValueFactory<>("email"));
            c_passwd.setCellValueFactory(new PropertyValueFactory<>("passwd"));
            c_git_hub.setCellValueFactory(new PropertyValueFactory<>("gitHub"));
            c_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
            c_project1descgrade.setCellValueFactory(new PropertyValueFactory<>("project1descgrade")); //wpisujemy nazwy pól z konstruktora klasy
            c_project1grade.setCellValueFactory(new PropertyValueFactory<>("project1grade"));
            c_project2descgrade.setCellValueFactory(new PropertyValueFactory<>("project2descgrade")); //wpisujemy nazwy pól z konstruktora klasy
            c_project2grade.setCellValueFactory(new PropertyValueFactory<>("project2grade"));
            c_project3descgrade.setCellValueFactory(new PropertyValueFactory<>("project3descgrade")); //wpisujemy nazwy pól z konstruktora klasy
            c_project3grade.setCellValueFactory(new PropertyValueFactory<>("project3grade"));
            c_project4descgrade.setCellValueFactory(new PropertyValueFactory<>("project4descgrade")); //wpisujemy nazwy pól z konstruktora klasy
            c_project4grade.setCellValueFactory(new PropertyValueFactory<>("project4grade"));
            c_role.setCellValueFactory(new PropertyValueFactory<>("role"));

            tab.setItems(lista_Studentow);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    } //external select


}

