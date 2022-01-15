package com.company.view;

import com.company.Controller.ControlAccount;
import com.company.Controller.ControlPersoane;
import com.company.Model.Account;
import com.company.Model.Angajat;
import com.company.Model.Client;

import java.nio.file.Path;
import java.util.Scanner;

public class View {

    private ControlPersoane controlPersoane;
    private ControlAccount controlAccount;
    private Angajat angajat;
    private Scanner scanner;
    private Account account;


    public View(Angajat angajat){

        controlPersoane = new ControlPersoane(Path.of("src","com","company","persoane").toString());
        controlAccount = new ControlAccount(Path.of("src","com","company","cont").toString());
        this.angajat = angajat;
        scanner = new Scanner(System.in);
        account = new Account(controlAccount.nextId(),account.getId(),account.getTipCont(),account.getBalanta());

    }

    public void meniu(){

        System.out.println("=============Meniu Angajat=============");
        System.out.println("Apasati tasta 1 petru a va loga");
//        System.out.println("Apasati tasta 2 pentru a iesi");

    }

    public void play(){

        meniu();

        int alegere = Integer.parseInt(scanner.nextLine());

        switch (alegere){
            case 1:
                controlAccount.afisare();
                break;
            case 2:
                controlAccount.add(account);
                controlAccount.updateNumarCont(1,1234);

        }

    }



}
