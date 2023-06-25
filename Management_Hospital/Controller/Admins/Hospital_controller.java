package Management_Hospital.Controller.Admins;

import Management_Hospital.Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Hospital_controller implements Initializable {
    public TableView table;
    public TableColumn admin;
    public TableColumn doctor;
    public TableColumn receptor;
    public TableColumn patient;
    public  ObservableList<Hospital> hospitals = FXCollections.observableArrayList();
    public ObservableList<Admin> adminObservableList = FXCollections.observableArrayList();
    public ObservableList<Doctor> doctorObservableList = FXCollections.observableArrayList();
    public ObservableList<Receptor> receptorObservableList = FXCollections.observableArrayList();
    public ObservableList<Patient> patientObservableList = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            adminObservableList = DataBase.getAdmins();
            doctorObservableList = DataBase.getDoctors();
            receptorObservableList = DataBase.getReceptors();
            patientObservableList = DataBase.get_Patient();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Hospital hospital = new Hospital(adminObservableList.size(), doctorObservableList.size(),
                receptorObservableList.size(), patientObservableList.size());
        hospitals.add(hospital);
        admin.setCellValueFactory(new PropertyValueFactory<Hospital, Integer>("admins"));
        doctor.setCellValueFactory(new PropertyValueFactory<Hospital, Integer>("doctors"));
        receptor.setCellValueFactory(new PropertyValueFactory<Hospital, Integer>("receptors"));
        patient.setCellValueFactory(new PropertyValueFactory<Hospital, Integer>("patient"));
        table.setItems(hospitals);
    }
}
