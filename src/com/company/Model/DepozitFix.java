package com.company.Model;

import java.util.Locale;

public class DepozitFix extends Account{

    private  double sumaDepozitata;

    public DepozitFix(int id, int numarCont, String tipCont, double balanta, double sumaDepozitata){
        super(id, numarCont, tipCont, balanta);
        this.sumaDepozitata = sumaDepozitata;
    }

    public double getSumaDepozitata() {
        return sumaDepozitata;
    }

    public void setSumaDepozitata(double sumaDepozitata) {
        this.sumaDepozitata = sumaDepozitata;
    }

    public DepozitFix(String text){

        super(Integer.parseInt(text.split(",")[0]), Integer.parseInt(text.split(",")[1]), text.split(",")[2],
                Double.parseDouble(text.split(",")[3]));
        this.sumaDepozitata = Double.parseDouble(text.split(",")[4]);

    }

    @Override
    public String toString(){

        return super.toString()+","+this.sumaDepozitata;
    }

    @Override
    public boolean equals(Object o){

        DepozitFix df = (DepozitFix) o;

      return super.equals(df) && this.sumaDepozitata == (df.getSumaDepozitata());

    }

}
