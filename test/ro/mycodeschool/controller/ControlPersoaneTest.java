package ro.mycodeschool.controller;

import com.company.Controller.ControlPersoane;
import com.company.Model.Persoana;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class ControlPersoaneTest {

    ControlPersoane controlPersoane;

    @BeforeEach
    public void initiere(){

        controlPersoane  = new ControlPersoane(Path.of("test","ro","mycodeschool","data","persoaneTest.txt").toString());

    }

    @Test
    public void testAfisare(){

        controlPersoane.afisare();
    }




    @AfterEach
    public void postConditie(){

        controlPersoane.clear();

        controlPersoane.add(new Persoana("1,maria,popescu,client,maria@email.com,mariacont,parola1"));
    }

}