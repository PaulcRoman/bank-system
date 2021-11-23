package com.company;

import com.company.Model.Angajat;

import com.company.Model.Client;
import com.company.view.View;
import com.company.view.ViewUser;

public class Main {

    public static void main(String[] args) {


//        View view = new View(new Angajat("1,maria,popescu,client,maria@email.com,mariacont,parola1"));
//
//        view.play();

        ViewUser viewUser = new ViewUser(new Client("2, Andrei, Ciobanu, client, andrei@email.com, andreicont, parola2"));

        viewUser.play();

    }
}
