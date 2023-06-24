package Management_Hospital.Model;

import java.sql.Date;
import java.time.LocalDate;

public class Receptor extends Personnel{

    private String shifts;
    private int num ;
    private int income ;

    public Receptor(String name, String lastname, String email, String username, String password,String shifts , int num) {
        super(name, lastname, email, username, password);
        this.shifts=shifts;
        if(shifts.equals("MORNING")){
            this.income = (num*2000);
        } else if (shifts.equals("AFTERNOON")){
            this.income = (num*1000);
        }else {
            this.income = (num*1500);
        }
        this.num=num;

    }

    public Receptor(String name, String lastname, String email, String username, String password , int income,String shifts, int num) {

        super(name, lastname, email, username, password);
        this.shifts = shifts;
        this.num = num;
        this.income = income;
    }

    public int getIncome(){

        return  income;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getShifts() {
        return shifts;
    }

    public void setShifts(String shifts) {
        this.shifts = shifts;
    }




    public void setIncome(int income) {
        this.income = income;
    }
}
