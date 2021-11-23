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

        controlAccount = new ControlAccount(Path.of("test","ro","mycodeschool","data","contTest").toString());

    }

    @Test
    public void afisare(){

        controlAccount.afisare();

    }

    @Test
    public void testPlay(){


    }


    @AfterEach
    public void postConditie(){

      controlAccount.clear();

      controlAccount.add(new Account("1,1,economii,1234,60"));
    }

}