package Management_Hospital.Controller;


import javafx.event.ActionEvent;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;


import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

import java.util.EventListener;
import java.util.ResourceBundle;

public class AdminController implements Initializable{
    public BorderPane admin_main;
    public BorderPane staf_list;
    public Button all_but;


    public void admin_home() throws IOException {
        Stage stage = (Stage) admin_main.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("../Viwe/Admin/admin-dashbord.fxml" ));
        stage.setScene(new Scene(root, 1550, 800));
        stage.show();
    }

    public void admin_list() throws IOException {

        Parent root = null;
        root = FXMLLoader.load(getClass().getResource("../viwe/Admin/list-stuff.fxml"));

        admin_main.setCenter(root);
        staf_list = (BorderPane) root;

        Parent roott = null;
        roott = FXMLLoader.load(getClass().getResource("../Viwe/Admin/Liststaff/list-all.fxml"));

        staf_list.setCenter(roott);




    }

    public void admin_hospital(ActionEvent actionEvent) {
    }

    public void admin_page(ActionEvent actionEvent) {
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



    //<-------------------------------------------------------------------------------------





}
