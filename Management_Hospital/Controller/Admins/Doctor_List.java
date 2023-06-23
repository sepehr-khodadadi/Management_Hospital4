package Management_Hospital.Controller.Admins;

import Management_Hospital.Model.DataBase;
import Management_Hospital.Model.Doctor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Doctor_List implements Initializable {
    public TextField text_search;
    public Button show;

    public Doctor_List(){

    }


    @FXML
    public TableColumn<Doctor ,String> dcr_cul_name;
    @FXML
    public TableColumn<Doctor, String> dcr_cul_lastname;
    @FXML
    public TableColumn<Doctor, String> dcr_cul_email;
    @FXML
    public TableColumn<Doctor, String> dcr_cul_username;
    @FXML
    public TableColumn<Doctor, Float> dcr_cul_point;
    @FXML
    public TableColumn<Doctor, String> dcr_cul_patient;
    @FXML
    public TableColumn<Doctor, String> dcr_cul_active;
    @FXML
    public TableColumn<Doctor, String> dcr_cul_expertise;
    @FXML
    public TableColumn<Doctor, Integer> dcr_cul_income;

    @FXML
    public TableView<Doctor> doctor_tabel ;

    public ObservableList<Doctor> observableList = FXCollections.observableArrayList();
    @FXML
    private TextField email_doctor;

    @FXML
    private MenuButton expert;

    @FXML
    private TextField lastname_doctor;

    @FXML
    private TextField name_doctor;

    @FXML
    private TextField password_doctor;

    @FXML
    private TextField username_doctor;
    //----------------------------------------------------------------------------------------------------------------->
    @FXML
    void add_doctor(ActionEvent event) {
        Doctor doctor = new Doctor(name_doctor.getText(), lastname_doctor.getText(), email_doctor.getText(),
                username_doctor.getText(), password_doctor.getText(), expert.getText());
        DataBase.addDoctor(doctor);
        reloadTable();
    }

//--------------------------------------------------------------------------------------------------------------------->


    public void comb_SURGEON(ActionEvent actionEvent) {
        expert.setText("SURGEON" );
    }

    public void comb_GENERAL_PRACTITIONER(ActionEvent actionEvent) {
        expert.setText("GENERAL PRACTITIONER" );
    }

    public void comb_PLASTIC_SURGEON(ActionEvent actionEvent) {
        expert.setText("PLASTIC SURGEON" );
    }

    public void comb_PEDIATRICIAN(ActionEvent actionEvent) {
        expert.setText("PEDIATRICIAN" );
    }

    public void comb_OPHTHALMOLOGIST(ActionEvent actionEvent) {
        expert.setText("OPHTHALMOLOGIST" );
    }

    public void comb_INFECTIOUS_DISEASE_SPECIALIST(ActionEvent actionEvent) {
        expert.setText("INFECTIOUS DISEASE SPECIALIST" );
    }

    public void comb_ONCOLOGIST(ActionEvent actionEvent) {
        expert.setText("ONCOLOGIST" );
    }

    public void comb_OBSTETRICIAN(ActionEvent actionEvent) {
        expert.setText("OBSTETRICIAN" );
    }

    public void comb_ANESTHESIOLOGIST(ActionEvent actionEvent) {
        expert.setText("ANESTHESIOLOGIST" );
    }




//--------------------------------------------------------------------------------------------------------------------->



    @FXML
    void test_t(ActionEvent event) {
        try {


            Doctor doctor = doctor_tabel.getSelectionModel().getSelectedItem();
            name_doctor.setText(doctor.getName());
            lastname_doctor.setText( doctor.getLastname());
            email_doctor.setText( doctor.getEmail());
            username_doctor.setText(doctor.getUsername());
            expert.setText(doctor.getExpertise());
            password_doctor.setText( doctor.getExpertise());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void reloadTable(){

        try {
            observableList = DataBase.getDoctors();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        dcr_cul_name.setCellValueFactory(new PropertyValueFactory<Doctor, String>("name"));
        dcr_cul_lastname.setCellValueFactory(new PropertyValueFactory<Doctor, String>("lastname"));
        dcr_cul_email.setCellValueFactory(new PropertyValueFactory<Doctor, String>("email"));
        dcr_cul_username.setCellValueFactory(new PropertyValueFactory<Doctor, String>("username"));
        dcr_cul_point.setCellValueFactory(new PropertyValueFactory<Doctor, Float>("point"));
        dcr_cul_patient.setCellValueFactory(new PropertyValueFactory<Doctor, String>("patient"));
        dcr_cul_expertise.setCellValueFactory(new PropertyValueFactory<Doctor, String>("expertise"));
        dcr_cul_income.setCellValueFactory(new PropertyValueFactory<Doctor, Integer>("income"));

        doctor_tabel.setItems(observableList);

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        reloadTable();

        FilteredList<Doctor> filteredList = new FilteredList<>(observableList, b -> true);
        text_search.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate(doctor -> {
                if (newValue.isEmpty() || newValue.isBlank() || newValue==null){
                    return  true ;
                }
                String search = newValue.toLowerCase();
                if (doctor.getName().toLowerCase().indexOf(search) > -1){
                    return true;
                } else if (doctor.getLastname().toLowerCase().indexOf(search) > -1){
                    return true;
                } else if (doctor.getEmail().toLowerCase().indexOf(search) > -1){
                    return true;
                } else if (doctor.getUsername().toLowerCase().indexOf(search) > -1){
                    return true;
                }else if (String.valueOf(doctor.getPoint()).indexOf(search) > -1){
                    return true;
                } else if (doctor.getPatient().toLowerCase().indexOf(search) > -1){
                    return true;
                } else if (doctor.getExpertise().toLowerCase().indexOf(search) > -1){
                    return true;
                } else if (String.valueOf(doctor.getIncome()).indexOf(search) > -1){
                    return true;
                }else {
                    return false;
                }
            });
        });
        SortedList<Doctor> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(doctor_tabel.comparatorProperty());
        doctor_tabel.setItems(sortedList);


    }


    public void clear(ActionEvent actionEvent) {
        name_doctor.setText("");
        lastname_doctor.setText("");
        email_doctor.setText("");
        password_doctor.setText("");
        username_doctor.setText("");
        expert.setText("EXPERTISE");
        text_search.setText("");
    }

    public void delete_doctor(ActionEvent actionEvent) {
        try {
            DataBase.delete_doctor(new Doctor(name_doctor.getText(),lastname_doctor.getText(),email_doctor.getText(),
                    username_doctor.getText(),password_doctor.getText(),expert.getText()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        reloadTable();
    }

    public void update_doctor(ActionEvent actionEvent) {
        Doctor doctor = doctor_tabel.getSelectionModel().getSelectedItem();
        Doctor doctor1 = new Doctor(name_doctor.getText(),lastname_doctor.getText(),email_doctor.getText(),
                username_doctor.getText(),password_doctor.getText(),expert.getText());
        try {
            DataBase.update_doctor(doctor, doctor1);
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        reloadTable();
    }
}
