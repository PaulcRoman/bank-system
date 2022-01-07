package com.company;

import com.company.Model.Client;
import com.company.view.ViewUsers;

public class Main {

    public static void main(String[] args) {


//        ViewUser viewUser = new ViewUser(new Client("2, Andrei, Ciobanu, client, andrei@email.com, andreicont, parola2"));
//
//        viewUser.play();

        ViewUsers viewUsers = new ViewUsers(new Client("2,Andrei,Ciobanu,client,andrei@email.com,andreicont,parola1"));
        viewUsers.go();
//            viewUsers.afisareConturi();
    }
}
