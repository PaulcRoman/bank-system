package com.company.Model;

public class ContEconomii extends Account{

    private double depozitContEconomii;
    private int perioadaInLuni;
    private double dobanda;

    public ContEconomii(int id, int numarCont, String tip, double balanta, double depozitContEconimii,int perioadaInLuni, double dobanda){
        super(id, numarCont, "economii", balanta);
        this.perioadaInLuni = perioadaInLuni;
        this.dobanda = dobanda;
        this.depozitContEconomii = depozitContEconimii;
    }

    public ContEconomii(String text){

        super(Integer.parseInt(text.split(",")[0]), Integer.parseInt(text.split(",")[1]),text.split(",")[2],
                Double.parseDouble(text.split(",")[3]));

        this.depozitContEconomii = Double.parseDouble(text.split(",")[4]);
        this.perioadaInLuni = Integer.parseInt(text.split(",")[5]);
        this.dobanda = Double.parseDouble(text.split(",")[6]);


    }

    public int getPerioadaInLuni() {
        return perioadaInLuni;
    }

    public void setPerioadaInLuni(int perioadaInLuni) {
        this.perioadaInLuni = perioadaInLuni;
    }

    public double getDobanda() {
        return dobanda;
    }

    public void setDobanda(double dobanda) {
        this.dobanda = dobanda;
    }

    public double getDepozitContEconomii() {
        return depozitContEconomii;
    }

    public void setDepozitContEconomii(double depozitContEconomii) {
        this.depozitContEconomii = depozitContEconomii;
    }

    @Override
    public String toString(){

        return super.toString()+","+this.depozitContEconomii +","+this.perioadaInLuni+","+this.dobanda;

    }

    @Override
    public boolean equals(Object o){

        if (o instanceof ContEconomii) {
            ContEconomii ce = (ContEconomii) o;

            return super.equals(ce);

        }
            return false;

    }


}
