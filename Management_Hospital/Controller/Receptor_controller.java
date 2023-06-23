package Management_Hospital.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Receptor_controller {
    public BorderPane admin_main;

    public void receptor_home(ActionEvent actionEvent) {
    }

    public void receptor_list(ActionEvent actionEvent) {
    }

    public void receptor_hospital(ActionEvent actionEvent) {
    }

    public void receptor_page(ActionEvent actionEvent) {
    }

    public void log_out(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) admin_main.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("../Viwe/login-receptor.fxml"));
        stage.setScene(new Scene(root,500,700 ));
        stage.show();
    }
}
