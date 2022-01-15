package com.company.Model;

public class Account {

    int id;
    int numarCont;
    String tipCont;
    double balanta;

    public Account(int id, int numarCont, String tipCont, double balanta){
        this.id = id;
        this.numarCont = numarCont;
        this.tipCont = tipCont;
        this.balanta = balanta;
    }

    public Account(String text){
        this(Integer.parseInt(text.split(",")[0]),Integer.parseInt(text.split(",")[1]), text.split(",")[2],Double.parseDouble(text.split(",")[3]));

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumarCont() {
        return numarCont;
    }

    public void setNumarCont(int numarCont) {
        this.numarCont = numarCont;
    }

    public String getTipCont() {
        return tipCont;
    }

    public void setTipCont(String tipCont) {
        this.tipCont = tipCont;
    }

    public double getBalanta() {
        return balanta;
    }

    public void setBalanta(double balanta) {
        this.balanta = balanta;
    }

    @Override
    public String toString(){
        return this.id+","+this.numarCont+","+this.tipCont+","+this.balanta;
    }

    @Override
    public boolean equals(Object o){

        Account a = (Account) o;

        if (a.getId()==id){

            return true;
        }
        return false;

    }

    public String toSave(){

        return id+","+numarCont+","+tipCont+","+balanta;
    }


}
