package com.company.view;

import com.company.Controller.ControlAccount;
import com.company.Controller.ControlEnrolment;
import com.company.Controller.ControlPersoane;
import com.company.Model.Account;
import com.company.Model.Client;
import com.company.Model.Enrolment;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class ViewUsers {

    private ControlEnrolment controlEnrolment;
    private ControlAccount controlAccount;
    private Client client;
    private Scanner scanner;

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

        }
    }

    public void afisareConturi(){
        ArrayList<Enrolment>enrolments = controlEnrolment.afisareDupaId(client.getId());
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

            System.out.println("Transferul s-a efectuat cu succcess. Balanta resuduala in contul curent este de: "+account1.getBalanta()+
                    " Balanta in contul de transfer este de: "+account2.getBalanta());
        }else {
            System.out.println("Numar cont/balanta error.");
        }
    }

    public void newCont(){
        System.out.println("Introduceti tipul contului: curent/economii");
        String tipCont = scanner.nextLine();

         controlAccount.nextAvailableAccount();

         controlAccount.save();
    }
}
