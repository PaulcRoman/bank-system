package com.company;

import com.company.Controller.ControlAccount;
import com.company.Controller.ControlPersoane;
import com.company.Model.Account;
import com.company.Model.Client;
import com.company.Model.ContCurent;
import com.company.Model.ContEconomii;
import com.company.view.ViewLogin;
import com.company.view.ViewUsers;

import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {

//        ControlAccount controlAccount= new ControlAccount(Path.of("src","com","company","resources","cont").toString());
//
//        controlAccount.add(new Account("5,5,curent,1234.50"));
//        controlAccount.save();
//        controlAccount.numarContEconomii("curent");
//
//        controlAccount.tipuriDeCont();

//        ControlPersoane controlPersoane = new ControlPersoane(Path.of("src","com","company","resources","persoane").toString());

//        ViewUsers viewUsers = new ViewUsers(new Client("1,Andrei,Ciobanu,client,andrei@email.com,andreicont,parola1"));
//        viewUsers.go();

        ViewLogin viewLogin = new ViewLogin();
        viewLogin.go();
    }

}
