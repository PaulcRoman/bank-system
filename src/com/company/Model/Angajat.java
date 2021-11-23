package com.company.Model;

public class Angajat extends Persoana{

    public Angajat(int id, String nume, String prenume, String functie, String email, String username, String parola){
        super(id, nume, prenume, "angajat", email,username,parola);
    }

    public Angajat(String text){

        super(Integer.parseInt(text.split(",")[0]),text.split(",")[1], text.split(",")[2],text.split(",")[3],
                text.split(",")[4], text.split(",")[5], text.split(",")[6]);
    }

    @Override
    public String toString(){
        return super.toString();
    }

    @Override
    public boolean equals(Object o){

        Angajat a = (Angajat) o;

        return super.equals(a);
    }


}
