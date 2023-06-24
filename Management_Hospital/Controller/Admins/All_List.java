package Management_Hospital.Controller.Admins;

import Management_Hospital.Model.DataBase;
import Management_Hospital.Model.Doctor;
import Management_Hospital.Model.Patient;
import Management_Hospital.Model.Receptor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class All_List implements Initializable {

    @FXML
    public TableColumn<Doctor,String> dcr_cul_name;
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

    public ObservableList<Doctor> doctorObservableList = FXCollections.observableArrayList();
    public TableColumn<Receptor, Integer> rcp_number;
    public TextField text_search_receptor;
    public TextField text_search_patient;


    @FXML
    private TableColumn<Receptor, String> dcr_cul_email1;

    @FXML
    private TableColumn<Receptor, Integer> dcr_cul_income1;

    @FXML
    private TableColumn<Receptor, String> dcr_cul_lastname1;

    @FXML
    private TableColumn<Receptor, String> dcr_cul_name1;

    @FXML
    private TableColumn<Receptor, String> dcr_cul_shift;

    @FXML
    private TableColumn<Receptor, String> dcr_cul_username1;
    @FXML
    private TableView<Receptor> receptor_tabel;

    ObservableList<Receptor> receptorObservableList = FXCollections.observableArrayList();


    public TableColumn dcr_cul_name2;
    public TableColumn dcr_cul_lastname2;
    public TableColumn dcr_cul_email2;
    public TableColumn dcr_cul_username2;
    public TableColumn dcr_cul_doctor;
    public TableColumn dcr_cul_wallet;
    public TableView patient_tabel;
    ObservableList<Patient> patientObservableList = FXCollections.observableArrayList();
    public TextField text_search_doctor;
    public TextField dcr_res;

    public void clear(ActionEvent actionEvent) {
        System.out.println("...");
    }
    public void reloadTable(){

        try {
            doctorObservableList = DataBase.getDoctors();
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

        doctor_tabel.setItems(doctorObservableList);

        try {
            receptorObservableList = DataBase.getReceptors();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        dcr_cul_name1.setCellValueFactory(new PropertyValueFactory<Receptor, String>("name"));
        dcr_cul_lastname1.setCellValueFactory(new PropertyValueFactory<Receptor, String>("lastname"));
        dcr_cul_email1.setCellValueFactory(new PropertyValueFactory<Receptor, String>("email"));
        dcr_cul_username1.setCellValueFactory(new PropertyValueFactory<Receptor, String>("username"));
        dcr_cul_income1.setCellValueFactory(new PropertyValueFactory<Receptor , Integer>("income"));
        rcp_number.setCellValueFactory(new PropertyValueFactory<Receptor , Integer>("num"));
        dcr_cul_shift.setCellValueFactory(new PropertyValueFactory<Receptor , String>("shifts"));
        receptor_tabel.setItems(receptorObservableList);
        try {
            patientObservableList = DataBase.get_Patient();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        dcr_cul_name2.setCellValueFactory(new PropertyValueFactory<Patient, String>("name"));
        dcr_cul_lastname2.setCellValueFactory(new PropertyValueFactory<Patient, String>("lastname"));
        dcr_cul_email2.setCellValueFactory(new PropertyValueFactory<Patient, String>("email"));
        dcr_cul_username2.setCellValueFactory(new PropertyValueFactory<Patient, String>("username"));
        dcr_cul_doctor.setCellValueFactory(new PropertyValueFactory<Patient , String>("doctor"));
        dcr_cul_wallet.setCellValueFactory(new PropertyValueFactory<Patient , Integer>("wallet"));
        patient_tabel.setItems(patientObservableList);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        reloadTable();
        FilteredList<Doctor> filteredList = new FilteredList<>(doctorObservableList, b -> true);
        text_search_doctor.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate(doctor -> {
                if (newValue.isEmpty() || newValue.isBlank() || newValue==null){
                    return  true ;
                }
                String search = newValue.toLowerCase();
                if (doctor.getName().toLowerCase().contains(search)){
                    return true;
                } else if (doctor.getLastname().toLowerCase().contains(search)){
                    return true;
                } else if (doctor.getEmail().toLowerCase().contains(search)){
                    return true;
                } else if (doctor.getUsername().toLowerCase().contains(search)){
                    return true;
                }else if (String.valueOf(doctor.getPoint()).contains(search)){
                    return true;
                } else if (doctor.getPatient().toLowerCase().contains(search)){
                    return true;
                } else if (doctor.getExpertise().toLowerCase().contains(search)){
                    return true;
                } else if (String.valueOf(doctor.getIncome()).contains(search)){
                    return true;
                }else {
                    return false;
                }
            });
        });
        SortedList<Doctor> sortedList = new SortedList<>(filteredList);

        sortedList.comparatorProperty().bind(doctor_tabel.comparatorProperty());
        doctor_tabel.setItems(sortedList);
        dcr_res.setText(String.valueOf(sortedList.size()));



        FilteredList<Receptor> filteredList1 = new FilteredList<>(receptorObservableList, b -> true);
        text_search_receptor.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList1.setPredicate(receptor -> {
                if (newValue.isEmpty() || newValue.isBlank() || newValue==null){
                    return  true ;
                }
                String search = newValue.toLowerCase();
                if (receptor.getName().toLowerCase().contains(search)){
                    return true;
                } else if (receptor.getLastname().toLowerCase().contains(search)){
                    return true;
                } else if (receptor.getEmail().toLowerCase().contains(search)){
                    return true;
                } else if (receptor.getUsername().toLowerCase().contains(search)){
                    return true;
                }else if (receptor.getShifts().toLowerCase().contains(search)){
                    return true;
                } else if (String.valueOf(receptor.getIncome()).contains(search)){
                    return true;
                } else if (String.valueOf(receptor.getNum()).contains(search)){
                    return true;
                }else {
                    return false;
                }
            });
        });
        SortedList<Receptor> sortedList1 = new SortedList<>(filteredList1);
        sortedList1.comparatorProperty().bind(receptor_tabel.comparatorProperty());
        receptor_tabel.setItems(sortedList1);

        FilteredList<Patient> filteredList3 = new FilteredList<>(patientObservableList, b -> true);
        text_search_patient.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList3.setPredicate(doctor -> {
                if (newValue.isEmpty() || newValue.isBlank() || newValue==null){
                    return  true ;
                }
                String search = newValue.toLowerCase();
                if (doctor.getName().toLowerCase().contains(search)){
                    return true;
                } else if (doctor.getLastname().toLowerCase().contains(search)){
                    return true;
                } else if (doctor.getEmail().toLowerCase().contains(search)){
                    return true;
                } else if (doctor.getUsername().toLowerCase().contains(search)){
                    return true;
                }else if (String.valueOf(doctor.getDoctor()).contains(search)){
                    return true;
                } else if (String.valueOf(doctor.getWallet()).contains(search)){
                    return true;
                }else {
                    return false;
                }
            });
        });
        SortedList<Patient> sortedList2 = new SortedList<>(filteredList3);
        sortedList2.comparatorProperty().bind(patient_tabel.comparatorProperty());
        patient_tabel.setItems(sortedList2);

    }
}
