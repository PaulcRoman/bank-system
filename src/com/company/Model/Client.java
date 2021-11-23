package com.company.Model;

public class Client extends Persoana{


    public Client(int id, String nume, String prenume, String functie, String email, String username, String parola){

        super(id,nume,prenume,"client",email,username,parola);


    }

    public Client(String text){

        super(Integer.parseInt(text.split(",")[0]), text.split(",")[1],text.split(",")[2], text.split(",")[3],
                text.split(",")[4], text.split(",")[5], text.split(",")[6]);


    }


    @Override
    public String toString(){
        return super.toString();
    }

    @Override
    public boolean equals(Object o){

        Client c = (Client) o;

      return super.equals(c);
    }

}
