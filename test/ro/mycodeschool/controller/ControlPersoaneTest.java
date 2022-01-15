package ro.mycodeschool.controller;

import com.company.Controller.ControlPersoane;
import com.company.Model.Client;
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

    @Test
    public void testAdd(){
        Persoana persoana = new Persoana("2,Ion,Popescu,client,ion@gmail.com,ioncont,parola2");
        controlPersoane.add(persoana);
//        controlPersoane.save();

        assertEquals(3,controlPersoane.getPozitie(2));
        assertEquals(0,controlPersoane.getPozitie(1));
    }

    @Test
    public void testGetPozitie(){
        assertEquals(0,controlPersoane.getPozitie(1));
        controlPersoane.afisare();
    }

    @Test
    public void testUpdateName(){
        assertEquals("mariana",controlPersoane.updateNume(0,"mariana"));
    }

    @Test
    public void testUpdateprenume(){
        assertEquals("alupeste",controlPersoane.updatePrenume(1,"alupeste"));
    }

    @Test
    public void testUpdateFunctie(){
        assertEquals("director",controlPersoane.updateFunctie(2,"director"));

    }

    @Test
    public void testUpdateEmail(){
        assertEquals("mariana@email.co",controlPersoane.updateEmail(0,"mariana@email.co"));
    }

    @Test
    public void testUsername(){
        assertEquals("username1",controlPersoane.updateUsername(2,"username1"));
    }

    @Test
    public void testUpdateparola(){
        assertEquals("parolauser001",controlPersoane.updateParola(1,"parolauser001"));
    }

    @Test
    public void testDelete(){


        assertEquals(true,controlPersoane.delete(1));
    }

    @Test
    public void testLogin(){

        //GIVE
        Client client = new Client("4,Ion,Ionescu,client,ion@email.com,ioncont,parola9");
        controlPersoane.add(client);
        assertEquals("ion@email.com", controlPersoane.login("ion@email.com","parola9").getEmail());
    }


    @AfterEach
    public void postConditie(){

        controlPersoane.clear();

        controlPersoane.add(new Persoana("1,Andrei,Ciobanu,client,andrei@email.com,andreicont,parola1"));
        controlPersoane.add(new Persoana("2,Marius,Nistor,client,marius@email.com,mariuscont,parola2"));
        controlPersoane.add(new Persoana("4,Ducu,Bertu,client,demail@email.com,ducucont,parola4"));
        controlPersoane.save();
    }

}