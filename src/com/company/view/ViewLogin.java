package com.company.view;

import com.company.Controller.ControlAccount;
import com.company.Controller.ControlEnrolment;
import com.company.Controller.ControlPersoane;
import com.company.Model.Client;
import com.company.Model.Persoana;

import java.nio.file.Path;
import java.util.Calendar;
import java.util.Scanner;

public class ViewLogin {

    private ControlPersoane controlPersoane;
    private ControlAccount controlAccount;
    private ControlEnrolment controlEnrolment;
    private Scanner scanner;
    private Client client;

    public ViewLogin(){

        controlPersoane = new ControlPersoane(Path.of("src","com","company","resources","persoane").toString());
        scanner = new Scanner(System.in);
        controlAccount = new ControlAccount(Path.of("src","com","company","resources","cont").toString());
        controlEnrolment = new ControlEnrolment(Path.of("src","com","company","resources","enrolment.txt").toString());

    }


    public void meniu(){
        System.out.println("Apasati tasta 1 petru a va loga");
        System.out.println("Apasati tasta 2 pentru a iesi");
    }

    public void go(){

        boolean running = true;

        while (running == true){
            meniu();

            int alegere = Integer.parseInt(scanner.nextLine());

            switch (alegere){
                case 1:
                    login();
                    break;
                case 2:
                    controlPersoane.save();
                    controlAccount.save();
                    controlEnrolment.save();
                    System.out.println("La revedere");
                    running=false;
                    break;

            }
        }

    }

    public void login(){

        System.out.println("Introduceti emailul ");

        String email = scanner.nextLine();

        System.out.println("Introduceti parola");

        String parola = scanner.nextLine();

        Persoana persoana = controlPersoane.login(email,parola);

        if (persoana!=null && persoana instanceof Client){
            ViewUsers viewUsers = new ViewUsers((Client) persoana);
            viewUsers.go();
        }else {

            System.out.println("Credentiale incorecte!");
        }


    }

}
