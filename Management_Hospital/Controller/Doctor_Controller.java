package Management_Hospital.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Doctor_Controller {
    public BorderPane admin_main;

    public void doctor_home(ActionEvent actionEvent) {
    }

    public void doctor_list(ActionEvent actionEvent) {
    }

    public void doctor_hospital(ActionEvent actionEvent) {
    }

    public void doctor_page(ActionEvent actionEvent) {
    }

    public void log_out(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) admin_main.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("../Viwe/login-doctor.fxml"));
        stage.setScene(new Scene(root,500,700 ));
        stage.show();
    }
}
