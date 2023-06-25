package Management_Hospital.Controller.Patient;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.Objects;

public class PatientController {
    public BorderPane dashboard;

    public void patient_home(ActionEvent actionEvent) throws IOException {
        change_Scene("Management_Hospital/Viwe/Doctor/patient-home.fxml");
    }

    public void patient_list(ActionEvent actionEvent) throws IOException {

        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../viwe/patient/select-doctor.fxml")));
        dashboard.setCenter(parent);
    }

    public void patient_hospital(ActionEvent actionEvent) {
    }

    public void patient_page(ActionEvent actionEvent) {
    }

    public void change_Scene(String path) {
        try {


            Parent root;
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(path)));
            dashboard.setCenter(root);

        }catch (IOException | NullPointerException e ){
            e.printStackTrace();
        }
    }
    public void log_out(ActionEvent actionEvent) {
    }
}
