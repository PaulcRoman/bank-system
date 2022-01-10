package com.company.view;

import com.company.Controller.ControlAccount;
import com.company.Controller.ControlEnrolment;
import com.company.Model.*;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class ViewUsers {

    private ControlEnrolment controlEnrolment;
    private ControlAccount controlAccount;
    private Client client;
    private Scanner scanner;
    private Account account;
    private ContEconomii contEconomii;
    private ContCurent contCurent;

    public ViewUsers (Client client){
        controlEnrolment = new ControlEnrolment(Path.of("src","com","company","resources","enrolment.txt").toString());
        controlAccount = new ControlAccount(Path.of("src","com","company","resources","cont").toString());
        this.client = client;
        scanner = new Scanner(System.in);

    }

    public void meniu(){

        System.out.println("Apasati tasta 1 pentru a vizualiza conturile.");
        System.out.println("Apasati tasta 2 pentru a adauga fonduri.");
        System.out.println("Apasati tasta 3 pentru a retrage fonduri.");
        System.out.println("Apasati tasta 4 pentru a transfera fonduri.");
        System.out.println("Apasati tasta 5 pentru a crea un cont nou");


    }

    public void go(){
        meniu();

        int alegere = Integer.parseInt(scanner.nextLine());

        switch (alegere){
            case 1:
                controlEnrolment.afisare();
                afisareConturi();
                go();
                break;
            case 2:
                adaugareFonduri();
                break;
            case 3:
                retragereFonduri();
                break;
            case 4:
                trasfer();
                break;
            case 5:
                newCont();
                break;
            default:
                System.out.println("Introduceti un numar de la 1 la 5");
                go();

        }
    }

    //pentru implementarea afisareConturi trebuie implementata o metoda de login
    public void afisareConturi(){
        ArrayList<Enrolment>enrolments = controlEnrolment.afisareDupaId(this.client.getId());
        for (Enrolment e : enrolments){
            System.out.println(e);
        }
    }

    public void adaugareFonduri(){
        System.out.println("Selectati contul pentru a adauga fonduri.");
        int account = Integer.parseInt(scanner.nextLine());

        System.out.println("Selectati suma pe care doriti sa o adaugai.");
        double depozit = Integer.parseInt(scanner.nextLine());

        Account account1 = controlAccount.getByNumber(account);

        if (account1 != null){

            account1.setBalanta(account1.getBalanta()+depozit);

            System.out.println("Suma a fost depozitata. Total balanta: " + account1);

            controlAccount.save();

        }else {
            System.out.println("Cont inexistent.");
        }

    }

    public void retragereFonduri(){
        System.out.println("Selectati contul petru a efectua retragerea.");
        int account = Integer.parseInt(scanner.nextLine());

        System.out.println("Introduce suma dorita.");
        double retragere = Double.parseDouble(scanner.nextLine());

        Account account1 = controlAccount.getByNumber(account);

        if (account1 != null && account1.getBalanta()>retragere){

            account1.setBalanta(account1.getBalanta() - retragere);

            System.out.println("Ati retras suma de: "+retragere+ " sold residual: "+account1.getBalanta());

        }else {
            System.out.println("Numar cont/balanta indisponibil.");
        }
    }

    public void trasfer(){

        //-->din ce cont transferam

        System.out.println("Introduceti numarul contului.");
        int account = Integer.parseInt(scanner.nextLine());

        System.out.println("Introduceti suma pe care doriti sa o transferati.");
        double sumaTransfer =  Double.parseDouble(scanner.nextLine());

        System.out.println("Introduceti numarul contului pentru transfer.");
        int accountT = Integer.parseInt(scanner.nextLine());

        Account account1 = controlAccount.getByNumber(account);
        Account account2 = controlAccount.getByNumber(accountT);

        if (account1 !=null && account1.getBalanta()>sumaTransfer && account2 != null){

            account1.setBalanta(account1.getBalanta() - sumaTransfer);
            account2.setBalanta(account2.getBalanta()+sumaTransfer);


            System.out.println("Transferul s-a efectuat cu success. Balanta residuala in contul curent este de: "+account1.getBalanta()+
                    " Balanta in contul de transfer este de: "+account2.getBalanta());
        }else {
            System.out.println("Numar cont/balanta error.");
        }
    }

    public void newCont(){
        System.out.println("Introduceti tipul contului: curent sau economii");

        String tipCont = scanner.nextLine();

        switch (tipCont){
            case "curent":
                ContCurent contC = new ContCurent(controlAccount.nextAvailableAccount(),controlAccount.nextAvailableAccount(),"curent",0.0);

                this.controlAccount.add(contC);

                controlAccount.save();

                System.out.println("S-a adaugat contul curent cu numarul: " + contC.getNumarCont());

                break;

            case "economii":
                ContEconomii contE = new ContEconomii(controlAccount.nextAvailableAccount(),controlAccount.nextAvailableAccount(),"economii",0.0,
                        0.00,0,0.00);
                this.controlAccount.add(contE);

                controlAccount.save();

                System.out.println("S-a adaugat contul economii cu numarul: "+ contE.getNumarCont());

                break;

        }

    }
}
