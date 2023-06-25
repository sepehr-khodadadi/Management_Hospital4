package Management_Hospital.Model;

public class Hospital {
    private int admins ;
    private int doctors ;
    private int receptors ;
    private int patient ;

    public Hospital(int admins, int doctors, int receptors, int patient) {
        this.admins = admins;
        this.doctors = doctors;
        this.receptors = receptors;
        this.patient = patient;
    }

    public int getAdmins() {
        return admins;
    }

    public void setAdmins(int admins) {
        this.admins = admins;
    }

    public int getDoctors() {
        return doctors;
    }

    public void setDoctors(int doctors) {
        this.doctors = doctors;
    }

    public int getReceptors() {
        return receptors;
    }

    public void setReceptors(int receptors) {
        this.receptors = receptors;
    }

    public int getPatient() {
        return patient;
    }

    public void setPatient(int patient) {
        this.patient = patient;
    }
}
