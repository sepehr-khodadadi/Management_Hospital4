package Management_Hospital.Model;



public class Doctor extends Personnel{

    private String active ;
    private String expertise;
    private int income ;
    private String patient ;
    private float point ;



    public Doctor(String name, String lastname, String email, String username, String password, String expertise, int income, String patient, float point) {

        super(name,lastname,email,username,password);
        this.expertise = expertise;
        this.income = income;
        this.point = point ;
        this.active = "NO" ;
        if(patient == null){
            this.patient="";
        }
        else {
            this.patient = patient;
        }
    }
    public Doctor(String name, String lastname, String email, String username, String password, String expertise) {
        super(name, lastname, email ,username ,password);
        this.expertise = expertise;
        this.active = "NO" ;

    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public float getPoint() {
        return point;
    }

    public void setPoint(float point) {
        this.point = point;
    }




    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

}
