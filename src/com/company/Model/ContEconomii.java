package com.company.Model;

public class ContEconomii extends Account{

    private double depozitContEconimii;
    private int perioadaInLuni;
    private double dobanda;

    public ContEconomii(int id, int numarCont, String tip, double balanta, int perioadaInLuni, double dobanda, double depozitContEconimii){
        super(id, numarCont, "cont economii", balanta);
        this.perioadaInLuni = perioadaInLuni;
        this.dobanda = dobanda;
        this.depozitContEconimii = depozitContEconimii;
    }

    public ContEconomii(String text){
        super(Integer.parseInt(text.split(",")[0]), Integer.parseInt(text.split(",")[1]), text.split(",")[2],
                Double.parseDouble(text.split(",")[3]));
//        this(Double.parseDouble(text.split(",")[4]),Integer.parseInt(text.split(",")[5]),Double.parseDouble(text.split(",")[6]));
//        this(Integer.parseInt(text.split(",")[4]),Double.parseDouble(text.split(",")[5]),Double.parseDouble(text.split(",")[6]));
            this.depozitContEconimii = Double.parseDouble(text.split(",")[4]);
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

    public double getDepozitContEconimii() {
        return depozitContEconimii;
    }

    public void setDepozitContEconimii(double depozitContEconimii) {
        this.depozitContEconimii = depozitContEconimii;
    }

    @Override
    public String toString(){

        return super.toString()+this.depozitContEconimii+","+this.perioadaInLuni+","+this.dobanda+",";

    }

    @Override
    public boolean equals(Object o){

        ContEconomii ce = (ContEconomii) o;

        return super.equals(ce);

    }

//    public double calculDobanda(){
//
//        if (perioadaInLuni == 3){
//                return (depozitContEconimii+ 0.5*depozitContEconimii);
//        }else if (perioadaInLuni == 6){
//            return depozitContEconimii+0.10*depozitContEconimii;
//        }else if (perioadaInLuni == 12){
//            return depozitContEconimii+0.20*depozitContEconimii;
//        }else {
//            return depozitContEconimii;
//        }
//
//
//    }

}
