package com.company.Controller;

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

    public void updateAccountId(int id, int accountId) {

        int pozitie = getPozitie(id);

        if (pozitie != -1) {

            Enrolment e = listaEnrolment.get(pozitie);
            e.setAccountId(accountId);

        }

    }

    public void updatePersonId(int id, int personId) {

        int pozitie = getPozitie(id);

        if (pozitie != -1) {

            Enrolment e = listaEnrolment.get(pozitie);
            e.setPersonId(personId);

        }

    }


    public void delete(int id) {

        int pozitie = getPozitie(id);

        if (pozitie != -1) {
            listaEnrolment.remove(pozitie);
        }

    }

    public void save() {

        try {

            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println(this);
            printWriter.close();


        } catch (Exception e) {

        }
    }

    @Override
    public String toString() {

        String text = "";

        for (Enrolment e : listaEnrolment) {

            text += e + "\n";

        }
        return text;

    }

    //CA PARAMETRU PRIMIM ID CLIENTULUI SI  RETURNAM O LISTA  TOATE CONTURILE

    public ArrayList<Enrolment> afisareDupaId(int idClient) {

        ArrayList<Enrolment> enrolments = new ArrayList<>();

        for (Enrolment e : enrolments) {

            if (e.getPersonId() == idClient) {

                enrolments.add(e);

            }

        }

        return enrolments;

    }
}

