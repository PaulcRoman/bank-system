package com.company.view;

import com.company.Controller.ControlAccount;
import com.company.Controller.ControlEnrolment;
import com.company.Controller.ControlPersoane;
import com.company.Model.Account;
import com.company.Model.Client;
import com.company.Model.Enrolment;
import org.w3c.dom.ls.LSOutput;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class ViewUser {

    private ControlEnrolment controlEnrolment;
    private ControlPersoane controlPersoane;
    private ControlAccount controlAccount;
    private Client client;
    private Scanner scanner;
    private Account account;
    private Enrolment enrolment;

    public ViewUser(Client client){

        controlPersoane = new ControlPersoane(Path.of("src","com","company","persoane").toString());
        controlAccount = new ControlAccount("D:\\Full Stack JAVA\\JavaBasics\\MostenirePolimorfism\\bank-system\\src\\com\\company\\resources\\cont");
        controlEnrolment = new ControlEnrolment(Path.of("src","com","company","enrolment.txt").toString());
        this.client = client;
        scanner = new Scanner(System.in);
//        account = new Account(account.getId(), account.getNumarCont(), account.getTipCont(),account.getBalanta());
//        enrolment = new Enrolment(enrolment.getId(),enrolment.getPersonId(),enrolment.getAccountId());

    }

    public void meniu(){

        System.out.println("========Meniu Client======");
        System.out.println("Apasati tasta 1 pentru a vizualiza conturile");
        System.out.println("Apasati tasta 2 pentru a adauga fonduri");
        System.out.println("Apasati tasta 3 pentru a retrage fonduri");
        System.out.println("Apasati tasta 4 pentru a transfera in alt cont");

    }

    public void play(){

        meniu();

        int alegere = Integer.parseInt(scanner.nextLine());

        switch (alegere){
            case 1:
                afisareConturi();
                break;
            case 2:
                depozitCont();
                break;
            case 3:
                retragere();
                break;
            case 4:
                transfer();
                break;
            case 5:
                contEconomii();
                break;

        }

    }

public  void  afisareConturi(){

  ArrayList<Enrolment>enrolments= controlEnrolment.afisareDupaId(this.client.getId());

  for (Enrolment e : enrolments){

      System.out.println(e);

  }

}

public void depozitCont(){


    System.out.println("Introduceti numarul de cont");

    int account = Integer.parseInt(scanner.nextLine());

    System.out.println("Introduceti suma pe care doriti sa o depozitati");

    double depozit = Double.parseDouble(scanner.nextLine());

    Account account1=controlAccount.getByNumber(account);

    if (account1!= null){

         account1.setBalanta(account1.getBalanta()+depozit);

        System.out.println("Tranzactia a fost reusita");

        controlAccount.save();
    }else{


        System.out.println("Contul nu a fost gasit ...............");
    }


}

public void retragere(){

    System.out.println("Introduceti numarul de cont");

    int account = Integer.parseInt(scanner.nextLine());

    System.out.println("Introduceti suma pe care doriti sa o retrageti");

    double amount = Double.parseDouble(scanner.nextLine());

    Account account2 =  controlAccount.getByNumber(account);

    if (account2 != null){

        account2.setBalanta(account2.getBalanta()-amount);

        System.out.println("Tranzactia a fost reusita");

        controlAccount.save();

    }else {

        System.out.println("Contul nu a fost gasit....");
    }

}

public void transfer(){

    System.out.println("Introduceti numarul de cont");

    int account = Integer.parseInt(scanner.nextLine());

    System.out.println("Introduceti suma pe care doriti sa o transferati");

    double sumaTransfer = Double.parseDouble(scanner.nextLine());

    System.out.println("Introduceti numarul de cont pentru transfer");

    int accountTransfer = Integer.parseInt(scanner.nextLine());

    Account account1 = controlAccount.getByNumber(account);

    Account transferAccount = controlAccount.getByNumber(accountTransfer);

    if (account1 != null && transferAccount != null){
        account1.setBalanta(account1.getBalanta()-sumaTransfer);

        transferAccount.setBalanta(transferAccount.getBalanta() + sumaTransfer);
    }else {
        System.out.println("Contul nu a fost gasit");
    }

    }

    public void contEconomii(){


        System.out.println("Introduceti numarul contului de economii.");

        int account = Integer.parseInt(scanner.nextLine());

        System.out.println("Introduceti suma pe care doriti sa o transferati");

        double sumaTransfer = Double.parseDouble(scanner.nextLine());

        System.out.println("Introduceti numarul de luni(3, 6, 12)");

        int luni = Integer.parseInt(scanner.nextLine());

        Account account1 = controlAccount.getByNumber(account);

        if (account1 != null){

            switch (luni){
                case 3:
                    account1.setBalanta(account1.getBalanta()+(sumaTransfer*0.10));
                    break;
                case 6:
                    account1.setBalanta(account1.getBalanta()+(sumaTransfer*0.30));
                    break;
                case 12:
                    account1.setBalanta(account1.getBalanta()+(sumaTransfer*0.70));
                    break;
                default:
                    System.out.println("Please insert: 3 or 6 or 12 as your deposit term.");
            }

        }else {
            System.out.println("Contul nu a fost gasit");
        }


    }



}



