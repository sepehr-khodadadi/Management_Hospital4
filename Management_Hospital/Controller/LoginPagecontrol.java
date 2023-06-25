package Management_Hospital.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import Management_Hospital.Model.*;
import java.io.IOException;
import java.sql.*;


public class LoginPagecontrol {

    public Admin admin;
    public MenuButton hospita;
    public Label lable_temp;
    public  TextField username_admin;
    public  PasswordField password_admin;
    public TextField show_pass_admin;
    public CheckBox check_box;
    public PasswordField password_doctor;
    public TextField username_doctor;
    public String user ;
    public String pass ;
    public TextField patient_name;
    public PasswordField patient_pass;
    public TextField show_pass_doc;


    public void doctor_btn(ActionEvent actionEvent) throws IOException {
     change_sce("../Viwe/login-doctor.fxml");
    }

    public void receptor_btn(ActionEvent actionEvent) throws IOException {
        change_sce("../Viwe/login-receptor.fxml");
    }

    public void patient_btn(ActionEvent actionEvent) throws IOException {
        change_sce("../Viwe/login-patient.fxml");
    }

    public void admin_btn(ActionEvent actionEvent) throws IOException {
        change_sce("../Viwe/login-page.fxml");
    }
    public void change_sce(String path) throws IOException {
        Stage stage = (Stage) hospita.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource(path));
        stage.setScene(new Scene(root,500,700));
        stage.show();
    }
    public void change_dashbord(String path) throws IOException {
        Stage stage = (Stage) hospita.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource(path));
        stage.setScene(new Scene(root,1550,800));
        stage.show();
    }

    public void signup_link(ActionEvent actionEvent) throws IOException {
        change_sce("../Viwe/signup-patient.fxml");
    }

    public void back_login(ActionEvent actionEvent) throws IOException {

        Stage stage = (Stage)  lable_temp.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("../Viwe/login-patient.fxml"));
        stage.setScene(new Scene(root,500,700));
        stage.show();
    }



    public  void login(ActionEvent actionEvent) throws IOException, SQLException {
        boolean bol = false ;
        if (String.valueOf(Hspit.ADMIN).equals(hospita.getText())){
            bol = DataBase.loginAdmin(username_admin.getText(), password_admin.getText());
            if(bol){
                DataBase.admin = DataBase.getAdmin(username_admin.getText(), password_admin.getText());
                change_dashbord("../viwe/Admin/admin-dashbord.fxml");


            }
            else {
                System.out.println("error");
            }
        }


        if (String.valueOf(Hspit.DOCTOR).equals(hospita.getText())){
            bol = DataBase.loginDoctor(username_doctor.getText(),password_doctor.getText());
            if(bol) {
                change_dashbord("../viwe/Doctor/doctor-dashbord.fxml" );
            }
            else {
                System.out.println("error");
            }
        }
        if (String.valueOf(Hspit.RECEPTOR).equals(hospita.getText())){
            change_dashbord("../viwe/Receptor/receptor-dashbord.fxml");

        }
        if (String.valueOf(Hspit.PATIENT).equals(hospita.getText())){
            bol = DataBase.loginPatient(patient_name.getText(), patient_pass.getText());
            if(bol){
                change_dashbord("../viwe/Patient/patient-dashbord.fxml");
            }else {
                System.out.println("error");
            }
        }
    }


    public void click_box(ActionEvent actionEvent) {
        if (check_box.isSelected()){
            if(password_admin != null) {
                password_admin.setVisible(false);
                show_pass_admin.setText(password_admin.getText());
                show_pass_admin.setVisible(true);

            }
            else if(password_doctor != null) {
                password_doctor.setVisible(false);
                show_pass_doc.setText(password_doctor.getText());
                show_pass_doc.setVisible(true);
            }
        }
        else {
            if(password_admin != null) {
                password_admin.setVisible(true);
                show_pass_admin.setVisible(false);
            }
            else if(password_doctor != null) {
                password_doctor.setVisible(true);
                show_pass_doc.setVisible(false);
            }
        }
    }

    public void signup_patient(ActionEvent actionEvent) throws SQLException {


    }
    }

