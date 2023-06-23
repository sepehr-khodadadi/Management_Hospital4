package Management_Hospital.Controller.Admins;

import Management_Hospital.Model.DataBase;
import Management_Hospital.Model.Receptor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Receptor_List implements Initializable {

    @FXML
    private ChoiceBox<String> choiceShifts;

    @FXML
    private TableColumn<Receptor, String> dcr_cul_email;

    @FXML
    private TableColumn<Receptor, Integer> dcr_cul_income;

    @FXML
    private TableColumn<Receptor, String> dcr_cul_lastname;

    @FXML
    private TableColumn<Receptor, String> dcr_cul_name;

    @FXML
    private TableColumn<Receptor, Integer> dcr_cul_shift;

    @FXML
    private TableColumn<Receptor, String> dcr_cul_username;

    @FXML
    private TextField email_receptor;

    @FXML
    private TextField lastname_receptor;

    @FXML
    private TextField name_receptor;

    @FXML
    private TextField password_receptor;

    @FXML
    private TableView<Receptor> receptor_tabel;

    @FXML
    private TextField text_search;

    @FXML
    ChoiceBox<Integer> choiceShifts1;
    @FXML
    private TextField username_receptor;

    ObservableList<Receptor> observableList = FXCollections.observableArrayList();

    @FXML
    void add_receptor(ActionEvent event) throws SQLException {
        Receptor receptor = new Receptor(name_receptor.getText(),lastname_receptor.getText(),
                email_receptor.getText(), username_receptor.getText() ,password_receptor.getText(),choiceShifts.getValue(), choiceShifts1.getValue());
        DataBase.add_Receptor(receptor);

    }

    @FXML
    void clear(ActionEvent event) {
        name_receptor.setText("");
        lastname_receptor.setText("");
        email_receptor.setText("");
        password_receptor.setText("");
        username_receptor.setText("");
        choiceShifts.setValue("AFTERNOON");
        choiceShifts1.setValue(3);

    }

    @FXML
    void delete_receptor(ActionEvent event) {

    }

    @FXML
    void test_t(ActionEvent event) {
        try{
            Receptor receptor = receptor_tabel.getSelectionModel().getSelectedItem();
            name_receptor.setText(receptor.getName());
            lastname_receptor.setText( receptor.getLastname());
            email_receptor.setText( receptor.getEmail());
            username_receptor.setText(receptor.getUsername());
            choiceShifts.setValue(receptor.getShifts());

            password_receptor.setText( receptor.getPassword());
            choiceShifts1.setValue(receptor.getNum());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void update_receptor(ActionEvent event) {

    }
    public void reloadTable(){
        try {
            observableList = DataBase.getReceptors();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        dcr_cul_name.setCellValueFactory(new PropertyValueFactory<Receptor, String>("name"));
        dcr_cul_lastname.setCellValueFactory(new PropertyValueFactory<Receptor, String>("lastname"));
        dcr_cul_email.setCellValueFactory(new PropertyValueFactory<Receptor, String>("email"));
        dcr_cul_username.setCellValueFactory(new PropertyValueFactory<Receptor, String>("username"));
        dcr_cul_income.setCellValueFactory(new PropertyValueFactory<Receptor , Integer>("income"));
        dcr_cul_shift.setCellValueFactory(new PropertyValueFactory<Receptor , Integer>("num"));
        receptor_tabel.setItems(observableList);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        reloadTable();
        choiceShifts.getItems().addAll("MORNING", "AFTERNOON","NIGHT");

        choiceShifts1.getItems().addAll(3 , 6);
        choiceShifts.setValue("AFTERNOON");
        choiceShifts1.setValue(3);
    }
}
