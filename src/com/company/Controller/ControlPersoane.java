package com.company.Controller;

import com.company.Model.*;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlPersoane {

    private ArrayList<Persoana> listaPersoane;

    private String path;


    public ControlPersoane(String path){

        listaPersoane = new ArrayList<>();

        this.path = path;

        load();
    }

    public void add(Persoana persoana) {

        listaPersoane.add(persoana);
    }

    public void load(){

        try {
            File file = new File(path);

            Scanner scanner = new Scanner(file);


            while (scanner.hasNextLine()){

                String linie = scanner.nextLine();

                if (linie.equals("")==false){
                    String functie = linie.split(",")[3];

                    switch (functie){
                        case "client":
                            listaPersoane.add(new Client(linie));
                            break;

                        case "angajat":
                            listaPersoane.add(new Angajat(linie));
                            break;
                    }
                }

            }


        }catch (Exception e){

        }

    }

    public void afisare() {


        for (int i = 0; i< listaPersoane.size(); i++){

            System.out.println(listaPersoane.get(i));

        }

    }

    public int getPozitie(int id){

        for (Persoana p : listaPersoane){

            if (p.getId() == id){

                return listaPersoane.indexOf(p);

            }
        }
        return -1;

    }

    public String updateNume(int id, String nume){

        int index = getPozitie(id);

        if (index != -1){

            Persoana p = listaPersoane.get(index);

            p.setNume(nume);

        }
        return nume;

    }

    public String updatePrenume(int id, String prenume){

        int index = getPozitie(id);

        if (index != -1){

            Persoana p = listaPersoane.get(index);

            p.setPrenume(prenume);

        }
        return prenume;
    }

    public String updateFunctie(int id, String functie){

        int index = getPozitie(id);

        if (index != -1){

            Persoana p = listaPersoane.get(index);

            p.setFunctie(functie);
        }
        return functie;
    }

    public String updateEmail(int id, String email){

        int index = getPozitie(id);

        if (index != -1){

            Persoana p = listaPersoane.get(index);

            p.setEmail(email);
        }
        return email;
    }

    public String updateUsername(int id, String username){

        int index = getPozitie(id);

        if (index != -1){

            Persoana p = listaPersoane.get(index);

            p.setUsername(username);

        }
        return username;
    }

    public String updateParola(int id, String parola){

        int index = getPozitie(id);

        if (index != -1){

            Persoana p = listaPersoane.get(index);

            p.setParola(parola);
        }
        return parola;
    }

    public boolean delete(int id){

        int index = getPozitie(id);

        if (index != -1){

            listaPersoane.remove(index);
            return true;
        }
        return false;
    }

    public void afisarePersoane(){

        int clienti = 0;
        int angajati = 0;

        for (Persoana p : listaPersoane){

            if (p instanceof Client){

                clienti ++;
            }else if (p instanceof Angajat){
                angajati++;
            }

        }

        System.out.println(String.format("Clienti: %d, Angajati: %d",clienti,angajati));

    }

    public void sortbyname(){

        for (int i =0; i< listaPersoane.size(); i++){
            for (int j=i+1; j< listaPersoane.size();j++){

                if (listaPersoane.get(i).getNume().compareTo(listaPersoane.get(j).getNume())>0){

                    Persoana aux = listaPersoane.get(i);
                    listaPersoane.set(i, listaPersoane.get(j));
                    listaPersoane.set(j, aux);
                }
            }
        }
    }

    public void save(){

        try {

            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println(this);
            printWriter.close();



        }catch (Exception e){

        }

    }

    @Override
    public String toString(){

        String text = "";

        for (Persoana p : listaPersoane){

            text += p + "\n";

        }
        return text;

    }

    public void clear(){
        listaPersoane.clear();
    }

    public int nextId(){

        if (listaPersoane.size()>0){

            return listaPersoane.get(listaPersoane.size()-1).getId()+1;
        }
        return -1;
    }

    public Persoana login(String email, String parola){
        for (Persoana p : listaPersoane){

            if (p.getEmail().equals(email) && p.getParola().equals(parola)) {
                return p;
            }

        }
        return null;
    }


}
