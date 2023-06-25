package Management_Hospital.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;

public class DataBase {
    private static Connection connection;
    public static Statement statement;
    public static Admin admin;

    private DataBase() {

    }

    public static void makeConeCtiOn() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOSP", "root",
                    "sphKH450450450");
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeConeCtiOn() {
        if (connection != null) {
            try {
                statement.close();
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



    public static ObservableList<Admin> getAdmins() throws SQLException {
        ObservableList<Admin> admins = FXCollections.observableArrayList();
        makeConeCtiOn();
        ResultSet re = statement.executeQuery("SELECT * FROM admin");
        while (re.next()) {
            admins.add(new Admin(re.getString(1), re.getString(2), re.getString(3), re.getString(4)));
        }
        closeConeCtiOn();
        return admins;
    }

    public static void deleteAdmin(String user) throws SQLException {
        makeConeCtiOn();
        statement.executeUpdate(String.format("delete  from  admin where username='%s'", user));
        closeConeCtiOn();
    }

    public static ObservableList<Doctor> getDoctors() throws SQLException {
        ObservableList<Doctor> doctors = FXCollections.observableArrayList();
        makeConeCtiOn();
        ResultSet re = statement.executeQuery("SELECT * FROM doctors");
        while (re.next()) {
            doctors.add(new Doctor(re.getString(1), re.getString(2), re.getString(3),
                    re.getString(4), re.getString(5), re.getString(6),
                    re.getInt(7), re.getString(8), re.getFloat(9)));
        }
        closeConeCtiOn();
        return doctors;
    }

    public static ObservableList<Receptor> getReceptors() throws SQLException {
        ObservableList<Receptor> receptors = FXCollections.observableArrayList();
        makeConeCtiOn();
        ResultSet re = statement.executeQuery("SELECT * FROM receptors");
        while (re.next()) {
            receptors.add(new Receptor(re.getString(1), re.getString(2), re.getString(3),
                    re.getString(4), re.getString(5),re.getInt(6), re.getString(7) , re.getInt(8)));
        }
        closeConeCtiOn();
        return receptors;
    }

    public static ObservableList<Patient> get_Patient() throws SQLException {
        ObservableList<Patient> patients = FXCollections.observableArrayList();
        makeConeCtiOn();
        ResultSet re = statement.executeQuery("SELECT * FROM patients");
        while (re.next()) {
            patients.add(new Patient(re.getString(1), re.getString(2), re.getString(3),
                    re.getString(4), re.getString(5), re.getString(6), re.getInt(7)));

        }
        closeConeCtiOn();
        return patients;
    }


    public static void addAdmin(Admin admin) throws SQLException {
        makeConeCtiOn();
        statement.execute(String.format("insert into admin (name ,lastname , username, password) values ('%s', '%s' ,'%s', '%s')",
                admin.getName(), admin.getLastname() ,admin.getUsername(), admin.getPassword()));
        closeConeCtiOn();
    }

    public static Admin getAdmin(String username , String password ) throws SQLException {

        makeConeCtiOn();
        String sql = "select * from admin where username=? and password=?";
        ResultSet rs = null;
        PreparedStatement pre;

        try {
            pre = connection.prepareStatement(sql);
            pre.setString(1, username);
            pre.setString(2, password);
            rs = pre.executeQuery();

            if (rs.next()) {
               admin = new Admin(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));

            }

        }catch (SQLException e){
            e.printStackTrace();
            closeConeCtiOn();
        }

        return admin ;
    }

    public static Admin getAdminPass(String username , String name ) throws SQLException {

        makeConeCtiOn();
        String sql = "select * from admin where username=? and name=?";
        ResultSet rs = null;
        PreparedStatement pre;

        try {
            pre = connection.prepareStatement(sql);
            pre.setString(1, username);
            pre.setString(2, name);
            rs = pre.executeQuery();

            if (rs.next()) {
               admin = new Admin(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));

            }

        }catch (SQLException e){
            e.printStackTrace();
            closeConeCtiOn();
        }

        return admin ;
    }

    public static boolean loginAdmin(String username , String password) throws SQLException {
        makeConeCtiOn();
        String sql = "select * from admin where username=? and password=?";
        ResultSet rs = null;
        PreparedStatement pre;
        try {
            pre = connection.prepareStatement(sql);
            pre.setString(1,username);
            pre.setString(2,password);
            rs = pre.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConeCtiOn();
        return false;

    }

    public static void setAdmin(Admin admin1) throws SQLException {
        makeConeCtiOn();
        statement.executeUpdate(String.format("update admin set name='%s' , lastname='%s', username='%s', password='%s'"
                ,admin1.getName(), admin1.getLastname(), admin1.getUsername() , admin1.getPassword()));
        admin = admin1;
        closeConeCtiOn();
    }


    public static boolean loginDoctor(String username, String password) throws SQLException {
        makeConeCtiOn();
        String sql = "select * from doctors where username=? and password=?";
        ResultSet rs;
        PreparedStatement pre;
        try {
            pre = connection.prepareStatement(sql);
            pre.setString(1, username);
            pre.setString(2, password);
            rs = pre.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConeCtiOn();
        return false;

    }

    public static void addDoctor(Doctor doctor) {
        makeConeCtiOn();
        try {


            statement.execute(String.format("insert into doctors (name, lastname, email, username, password, expertise)" +
                            " values ('%s', '%s', '%s', '%s', '%s', '%s')", doctor.getName(), doctor.getLastname(),
                    doctor.getEmail(), doctor.getUsername(), doctor.getPassword(), doctor.getExpertise()));

        } catch (SQLException e) {
            System.out.println("error");
        }
        closeConeCtiOn();
    }

    public static void delete_doctor(Doctor doctor) throws SQLException {
        makeConeCtiOn();
        statement.executeUpdate(String.format("delete from doctors where username='%s'", doctor.getUsername()));
        closeConeCtiOn();
    }

    public static void update_doctor(Doctor doctor, Doctor doctor1) throws SQLException {
        makeConeCtiOn();
        statement.executeUpdate(String.format("update doctors set name='%s',lastname='%s',email='%s' ,username='%s'," +
                        "password='%s', expertise='%s' where username='%s'"
                , doctor1.getName(), doctor1.getLastname(), doctor1.getEmail(), doctor1.getUsername(), doctor1.getPassword(),
                doctor1.getExpertise(), doctor.getUsername()));

        closeConeCtiOn();
    }

    public static void add_Receptor(Receptor receptor) throws SQLException {
        makeConeCtiOn();
        String sql = "insert into receptors (name, lastname, email, username, password , shift , num , income) values" +
                " ('%s', '%s' ,'%s' ,'%s' ,'%s' , '%s' ,'%d' ,'%d')";
        statement.execute(String.format(sql, receptor.getName(), receptor.getLastname(), receptor.getEmail(),
                receptor.getUsername(), receptor.getPassword(), receptor.getShifts(), receptor.getNum(), receptor.getIncome()));

        closeConeCtiOn();

    }

    public static void add_Patient(Patient patient) throws SQLException {
        makeConeCtiOn();
        String sql = ("insert  into  patients (name, lastname, email, username, password , doctor , wallet) values " +
                "('%s', '%s' ,'%s' ,'%s' ,'%s' , '%s', '%d')");
        statement.execute(String.format(sql, patient.getName(), patient.getLastname(), patient.getEmail(), patient.getUsername(),
                patient.getPassword(), patient.getDoctor(), patient.getWallet()));
        closeConeCtiOn();
    }

}
