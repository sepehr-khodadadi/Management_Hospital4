package Management_Hospital.Controller.Admins;

import Management_Hospital.Controller.LoginPagecontrol;
import Management_Hospital.Model.Admin;
import Management_Hospital.Model.DataBase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Admin_Prof implements Initializable {

    public TableColumn adminname_col;
    public TableColumn adminlast_col;
    public TableColumn adminuser_col;
    public TableView<Admin> admin_table;
    public TextField password_field;
    public TextField user_field;
    public TextField last_field;
    public TextField name_field;

    public ObservableList<Admin> observableList = FXCollections.observableArrayList();
    Admin admin ;

    public void reload(){
        admin = DataBase.admin;
        if (observableList.isEmpty()){
            observableList.add(admin);
        }
        else {
            observableList.set(0 , admin);
        }

        adminname_col.setCellValueFactory(new PropertyValueFactory<Admin, String>("name"));
        adminlast_col.setCellValueFactory(new PropertyValueFactory<Admin, String>("lastname"));
        adminuser_col.setCellValueFactory(new PropertyValueFactory<Admin, String>("username"));
        admin_table.setItems(observableList);
    }
    public void update(ActionEvent actionEvent) throws SQLException {
        Admin admin1 = new Admin(name_field.getText(), last_field.getText(),
                user_field.getText(), password_field.getText());
        DataBase.setAdmin(admin1);
        reload();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        reload();

        admin = DataBase.admin;
        name_field.setText(admin.getName());
        last_field.setText(admin.getLastname());
        user_field.setText(admin.getUsername());
        password_field.setText(admin.getPassword());
    }
}
