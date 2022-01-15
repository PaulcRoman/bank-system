package ro.mycodeschool.controller;

import com.company.Controller.ControlAccount;
import com.company.Model.ContCurent;
import com.company.Model.ContEconomii;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class ControlAccountTest {

    ControlAccount controlAccount;

    @BeforeEach
    public void initiere(){

        controlAccount = new ControlAccount("D:\\Full Stack JAVA\\JavaBasics\\MostenirePolimorfism\\bank-system\\test\\ro\\mycodeschool\\data\\contTest");

    }

    @AfterEach

    public  void  clear(){
        controlAccount.clear();

        controlAccount.save();
    }

    @Test
    public void afisare(){

         controlAccount.afisare();



    }

    @Test
    public void load(){

//        controlAccount.load();

        assertEquals(true,controlAccount.getSize()>0);

    }


    @Test
    public void testGetPozitie(){
        assertEquals(0, controlAccount.getPozitie(1));
    }

    @Test
    public void testUpdateNumarCont(){
        assertEquals(5, controlAccount.updateNumarCont(1,5));
    }

    @Test
    public void testUpdateTipCont(){

        assertEquals("economii", controlAccount.updateTipCont("economii",1));
    }

    @Test
    public void testUpdateBalanta(){

        Assertions.assertEquals(1000.50, controlAccount.updateBalanta(1,1000.50));
    }

    @Test
    public void testDelete(){
        assertEquals(true,controlAccount.delete(1));

        assertEquals(false,controlAccount.delete(6));
    }

    @Test
    public void testTipCont(){
        controlAccount.tipuriDeCont();
    }

    @Test
    public void testGetAccountByNumber(){
        System.out.println(controlAccount.getByNumber(1));
        System.out.println(controlAccount.getByNumber(2));
    }

    @Test
    public void testAvailableAccount(){
        assertEquals(true,controlAccount.availableCont(6));
        assertEquals(false,controlAccount.availableCont(1));
    }

    @Test
    public void testNumarAccount(){


        ContCurent contCurent = new ContCurent("5,5,curent,1234.5");

        ContCurent contCurent1 = new ContCurent("6,6,curent,23455.6");

        controlAccount.add(contCurent);
        controlAccount.add(contCurent1);

        controlAccount.save();

//        controlAccount.load();


        assertEquals(2,controlAccount.numarContEconomii("curent"));




    }

    @Test
    public void testNumerConr2(){

        ContCurent contCurent = new ContCurent("5,5,curent,1234.5");
        ContCurent contCurent1 = new ContCurent("6,6,curent,23455.6");
        ContEconomii contEconomii1 = new ContEconomii("4,4,economii,534.0,20.5,6,15.25");

        controlAccount.add(contCurent);
        controlAccount.add(contCurent1);
        controlAccount.add(contEconomii1);

        controlAccount.save();



        assertEquals("4,4,economii,534.0,20.5,6,15.25", controlAccount.getByNumber(4).toString());
        assertEquals("5,5,curent,1234.5", controlAccount.getByNumber(5).toString());




    }


    @AfterEach
    public void postConditie(){

//      controlAccount.clear();
//
//      controlAccount.add(new Account("2,2,economii,658.0,10.3,3,10.5"));
//      controlAccount.add(new Account("4,4,economii,534.0,20.5,6,15.25"));
//        controlAccount.add(new Account("3,3,curent,23234.5"));
//        controlAccount.add(new Account("1,1,curent,12667.2"));
//
//        controlAccount.save();
    }

}