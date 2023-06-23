package Management_Hospital.Model;

public class Patient extends  Personnel{
    private  int wallet;
    private String doctor;
    public Patient(String name, String lastname, String email, String username, String password, int wallet) {
        super(name, lastname, email, username, password);
        this.wallet=wallet;
    }

    public Patient(String name, String lastname, String email, String username, String password, String doctor , int wallet) {
        super(name, lastname, email, username, password);
        this.wallet = wallet;
        this.doctor = doctor;
    }

    public int getWallet() {
        return wallet;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }
}
