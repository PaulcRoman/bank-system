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
        controlAccount = new ControlAccount(Path.of("src","com","company","cont").toString());
        controlEnrolment = new ControlEnrolment(Path.of("src","com","company","enrolment.txt").toString());
        this.client = client;
        scanner = new Scanner(System.in);
        account = new Account(account.getId(), account.getNumarCont(), account.getTipCont(),account.getBalanta());
        enrolment = new Enrolment(enrolment.getId(),enrolment.getPersonId(),enrolment.getAccountId());

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
                account.deposit(123,00.00);
                break;
            case 3:
                account.retragere(123, 00.00);
                break;
            case 4:
                account.transfer(123,0.00);
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

        controlAccount.depozit(this.client.getId(), this.account.getBalanta());



}


}
