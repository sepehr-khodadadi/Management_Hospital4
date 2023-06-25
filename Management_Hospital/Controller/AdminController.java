package Management_Hospital.Controller;


import Management_Hospital.Controller.Admins.Admin_Prof;
import Management_Hospital.Model.Admin;
import Management_Hospital.Model.DataBase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;


import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

import java.sql.SQLException;
import java.util.EventListener;
import java.util.ResourceBundle;

public class AdminController implements Initializable{
    public BorderPane admin_main;
    public BorderPane staf_list;
    public Button all_but;
    public Button home_but;


    public void admin_home() throws IOException {

        Parent root = null;
        root = FXMLLoader.load(getClass().getResource("../Viwe/Admin/home-admin.fxml"));

        this.admin_main.setCenter(root);


    }

    public void admin_list() throws IOException {

        Parent root = null;
        root = FXMLLoader.load(getClass().getResource("../viwe/Admin/list-stuff.fxml"));

        this.admin_main.setCenter(root);
        this.staf_list = (BorderPane) root;

        Parent roott = null;
        roott = FXMLLoader.load(getClass().getResource("../Viwe/Admin/Liststaff/list-all.fxml"));

        this.staf_list.setCenter(roott);




    }

    public void admin_hospital(ActionEvent actionEvent) throws IOException {
        set_sCen("../Viwe/Admin/admin-hospital.fxml");

    }

    public void admin_page(ActionEvent actionEvent) throws IOException {
        set_sCen("../Viwe/Admin/aadminprof.fxml");

    }

    public void log_out(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) admin_main.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("../Viwe/login-page.fxml" ));
        stage.setScene(new Scene(root, 500, 700));
        stage.show();
    }

    public void set_sCen(String path) throws IOException {
        Parent root = null;
        root = FXMLLoader.load(getClass().getResource(path));

        admin_main.setCenter(root);
    }

    public void set_Admilist(String path) throws IOException {
        Parent roott = null;
        roott = FXMLLoader.load(getClass().getResource(path));

        staf_list.setCenter(roott);
    }


    public void doctor_list(ActionEvent actionEvent) throws IOException {
        set_Admilist("../viwe/Admin/Liststaff/list-doctor.fxml" );
    }

    public void receptor_list(ActionEvent actionEvent) throws IOException {
        set_Admilist("../viwe/Admin/Liststaff/list-receptor.fxml" );
    }

    public void patient_list(ActionEvent actionEvent) throws IOException {
        set_Admilist("../viwe/Admin/Liststaff/list-patient.fxml" );
    }

    public void clear(ActionEvent actionEvent) {

    }

    public void all_personel() throws IOException {
        set_Admilist("../Viwe/Admin/Liststaff/list-all.fxml");

    }
    public void reloadTable(){



    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    //-------------------------------------------------------------------------------------->


    public void delete_admin(ActionEvent actionEvent) {
    }

    public void Update_admin(ActionEvent actionEvent) {
    }

    public void add_admin(ActionEvent actionEvent) {
    }

    public void search(ActionEvent actionEvent) {
    }


    //<-------------------------------------------------------------------------------------





}
