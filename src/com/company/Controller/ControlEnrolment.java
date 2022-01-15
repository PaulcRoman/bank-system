package com.company.Controller;

import com.company.Model.Account;
import com.company.Model.Enrolment;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlEnrolment {

    private ArrayList<Enrolment> listaEnrolment;

    private String path;

    public ControlEnrolment(String path) {

        listaEnrolment = new ArrayList<>();
        this.path = path;
        load();
//        this.afisare();

    }

    public void add(Enrolment enrolment) {
        listaEnrolment.add(enrolment);
    }

    public void load() {

        try {

            File file = new File(path);

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {

                String linie = scanner.nextLine();

                if (linie.equals("") == false) {

                    listaEnrolment.add(new Enrolment(linie));

                }

            }

        } catch (Exception e) {

        }

    }

    public void afisare() {

        for (int i = 0; i < listaEnrolment.size(); i++) {

            System.out.println(listaEnrolment.get(i));

        }

    }

    public int getPozitie(int id) {

        for (Enrolment e : listaEnrolment) {

            if (e.getId() == id) {

                return listaEnrolment.indexOf(e);

            }

        }
        return -1;
    }

    public int updateAccountId(int id, int accountId) {

        int pozitie = getPozitie(id);

        if (pozitie != -1) {

            Enrolment e = listaEnrolment.get(pozitie);
            e.setAccountId(accountId);

        }
        return accountId;
    }

    public int updatePersonId(int id, int personId) {

        int pozitie = getPozitie(id);

        if (pozitie != -1) {

            Enrolment e = listaEnrolment.get(pozitie);
            e.setPersonId(personId);

        }
        return personId;
    }

    public boolean delete(int id) {

        int pozitie = getPozitie(id);

        if (pozitie != -1) {
            listaEnrolment.remove(pozitie);

            return true;
        }
            return false;
    }

    public void clear(){
        listaEnrolment.clear();
    }

    public String toSave(){

        String text = "";

        for (Enrolment enrolment : listaEnrolment) {

            text += enrolment.toSave()+"\n";
        }

        return text;

    }

    public void save() {

        try {

            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println(this.toSave());
            printWriter.close();


        } catch (Exception e) {

        }
    }

    @Override
    public String toString() {

        String text = "";

        for (int i = 0; i< listaEnrolment.size()-1;i++) {


            text += listaEnrolment.get(i) + "\n";

        }

        text += listaEnrolment.get(listaEnrolment.size()-1);

        return text;

    }

    //CA PARAMETRU PRIMIM ID CLIENTULUI SI  RETURNAM O LISTA  TOATE CONTURILE

    public ArrayList<Enrolment> afisareDupaId(int idClient) {

        ArrayList<Enrolment> enrolments = new ArrayList<>();

        for (Enrolment e : listaEnrolment) {

            if (e.getPersonId() == idClient) {

                enrolments.add(e);

            }

        }

        return enrolments;

    }

    public int nextId() {

        if (listaEnrolment.size() > 0) {

            return listaEnrolment.get(listaEnrolment.size() - 1).getAccountId() + 1;
        }

        return 1;
    }
}

