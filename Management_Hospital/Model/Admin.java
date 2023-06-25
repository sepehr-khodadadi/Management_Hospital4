package Management_Hospital.Model;

public class Admin {
    private String username ;
    private String name ;
    private String lastname ;
    private String password ;
    public Admin(){
        this.name="";
        this.lastname="";
        this.username="";
        this.password="";
    }

    public Admin(String name, String lastname, String username, String password) {
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
    }public Admin(String name, String lastname, String username) {
        this.name = name;
        this.lastname = lastname;
        this.username = username;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
