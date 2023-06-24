package Management_Hospital.Controller.Admins;

import Management_Hospital.Model.DataBase;
import Management_Hospital.Model.Patient;
import Management_Hospital.Model.Receptor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Patient_List implements Initializable {
    public TableView patient_tabel;
    public TableColumn dcr_cul_name;
    public TableColumn dcr_cul_lastname;
    public TableColumn dcr_cul_email;
    public TableColumn dcr_cul_username;
    public TableColumn dcr_cul_doctor;
    public TableColumn dcr_cul_wallet;
    public TextField name_patient;
    public TextField username_patient;
    public TextField email_patient;
    public TextField lastname_patient;
    public TextField password_patient;
    public ChoiceBox<Integer> choiceShifts;
    public TextField text_search_patient;
    ObservableList<Patient> observableList = FXCollections.observableArrayList();
    public void test_t(ActionEvent actionEvent) {
    }

    public void delete_patient(ActionEvent actionEvent) {
    }

    public void update_patient(ActionEvent actionEvent) {
    }

    public void add_patient(ActionEvent actionEvent) throws SQLException {
        Patient patient = new Patient(name_patient.getText(), lastname_patient.getText(), email_patient.getText(),
                username_patient.getText(), password_patient.getText(), choiceShifts.getValue());
        DataBase.add_Patient(patient);
        reloadTable();
    }

    public void reloadTable(){

        try {
            observableList = DataBase.get_Patient();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        dcr_cul_name.setCellValueFactory(new PropertyValueFactory<Patient, String>("name"));
        dcr_cul_lastname.setCellValueFactory(new PropertyValueFactory<Patient, String>("lastname"));
        dcr_cul_email.setCellValueFactory(new PropertyValueFactory<Patient, String>("email"));
        dcr_cul_username.setCellValueFactory(new PropertyValueFactory<Patient, String>("username"));
        dcr_cul_doctor.setCellValueFactory(new PropertyValueFactory<Patient , String>("doctor"));
        dcr_cul_wallet.setCellValueFactory(new PropertyValueFactory<Patient , Integer>("wallet"));
        patient_tabel.setItems(observableList);
    }

    public void clear(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        reloadTable();
        choiceShifts.getItems().addAll(1000 , 2000 ,3000 , 5000);

        FilteredList<Patient> filteredList = new FilteredList<>(observableList, b -> true);
        text_search_patient.textProperty().addListener((observable, oldValue, newValue) -> {
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
                }else if (String.valueOf(doctor.getDoctor()).contains(search)){
                    return true;
                } else if (String.valueOf(doctor.getWallet()).contains(search)){
                    return true;
                }else {
                    return false;
                }
            });
        });
        SortedList<Patient> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(patient_tabel.comparatorProperty());
        patient_tabel.setItems(sortedList);
    }
}
