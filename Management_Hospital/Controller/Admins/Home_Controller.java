package Management_Hospital.Controller.Admins;

import Management_Hospital.Model.Admin;
import Management_Hospital.Model.DataBase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Home_Controller implements Initializable {
    public TableColumn adminname_col;
    public TableColumn adminlast_col;
    public TableColumn adminuser_col;
    public TableView admin_table;
    public Label name_admin;
    public TextField name_field;
    public TextField last_field;
    public TextField user_field;
    public TextField pass_field;
    public TextField text_search;

    private ObservableList<Admin> observableList = FXCollections.observableArrayList();
    public void delete_admin(ActionEvent actionEvent) throws SQLException {
        DataBase.deleteAdmin(user_field.getText());
        reload();
    }


    public void add_admin(ActionEvent actionEvent) throws SQLException {
        DataBase.addAdmin(new Admin(name_field.getText(), last_field.getText(), user_field.getText(),
                pass_field.getText()));
        reload();
    }


    public void search(ActionEvent actionEvent) throws SQLException {
       Admin admin = new Admin();
       admin = (Admin) admin_table.getSelectionModel().getSelectedItem();
       admin = DataBase.getAdminPass(admin.getUsername(), admin.getName());
       name_field.setText(admin.getName());
       pass_field.setText(admin.getPassword());
       last_field.setText(admin.getLastname());
       user_field.setText(admin.getUsername());

    }
    public void  reload(){
        try {
            observableList = DataBase.getAdmins();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        adminname_col.setCellValueFactory(new PropertyValueFactory<Admin, String>("name"));
        adminlast_col.setCellValueFactory(new PropertyValueFactory<Admin, String>("lastname"));
        adminuser_col.setCellValueFactory(new PropertyValueFactory<Admin, String>("username"));
        admin_table.setItems(observableList);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        reload();

        FilteredList<Admin> filteredList = new FilteredList<>(observableList , b ->true);
        text_search.textProperty().addListener((observable, oldValue, newValue) ->{
            filteredList.setPredicate(admin ->{
                if (newValue.isEmpty() || newValue.isBlank() || newValue==null){
                    return  true ;
                }
                String search = newValue.toLowerCase();
                if (admin.getName().toLowerCase().contains(search)){
                    return true;
                }else if (admin.getLastname().toLowerCase().contains(search)){
                    return true;
                }else if(admin.getUsername().toLowerCase().contains(search)){
                    return true;
                }else {
                    return false;
                }
            });
        } );
        SortedList<Admin> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(admin_table.comparatorProperty());
        admin_table.setItems(sortedList);

    }

    public void clear(ActionEvent actionEvent) {
        name_field.setText("");
        last_field.setText("");
        user_field.setText("");
        pass_field.setText("");
    }
}
