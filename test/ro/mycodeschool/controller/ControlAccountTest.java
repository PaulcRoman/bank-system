package ro.mycodeschool.controller;

import com.company.Controller.ControlAccount;
import com.company.Model.Account;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

class ControlAccountTest {

    ControlAccount controlAccount;

    @BeforeEach
    public void initiere(){

        controlAccount = new ControlAccount("D:\\Full Stack JAVA\\JavaBasics\\MostenirePolimorfism\\bank-system\\test\\ro\\mycodeschool\\data\\contTest");

    }

    @Test
    public void afisare(){

         controlAccount.afisare();

    }

    @Test
    public void load(){

        controlAccount.load();


    }

    @Test
    public void testGetByNumber(){

        System.out.println(controlAccount.getByNumber(1));
    }




//    @AfterEach
//    public void postConditie(){
//
////      controlAccount.clear();
//
//      controlAccount.add(new Account("1,1,economii,1234"));
//      controlAccount.add(new Account("2,2,curent,2120"));
//    }

}