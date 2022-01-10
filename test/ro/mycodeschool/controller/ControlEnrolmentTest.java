package ro.mycodeschool.controller;

import com.company.Controller.ControlEnrolment;
import com.company.Model.Enrolment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.Assert.assertEquals;

class ControlEnrolmentTest {

    ControlEnrolment controlEnrolment;

    @BeforeEach
    public void testInitial(){

        controlEnrolment= new ControlEnrolment(Path.of("test","ro","mycodeschool","data","enrolmentTest.txt").toString());

    }

    @Test
    public void afisare(){
        controlEnrolment.afisare();

    }


    @Test
    public void testAdd(){

        controlEnrolment.add(new Enrolment("123,234,345"));

        controlEnrolment.afisare();
        assertEquals(4,controlEnrolment.getPozitie(123));
    }

    @Test
    public void testUpdateAccountId(){
        assertEquals(666, controlEnrolment.updateAccountId(2,666));
        controlEnrolment.afisare();
    }
    @Test
    public void testGetPozitie(){
        assertEquals(2,controlEnrolment.getPozitie(3));
    }

    @Test
    public void testUpdatePersonId(){

        assertEquals(666,controlEnrolment.updatePersonId(1,666));
        controlEnrolment.afisare();
    }

    @Test
    public void testDelete(){
        assertEquals(true,controlEnrolment.delete(3));
        controlEnrolment.afisare();
    }

    @Test
    public void testAfisareDupaPersonId(){
        controlEnrolment.afisareDupaId(3);

    }

    @AfterEach
    public void postConditie() {
        controlEnrolment.clear();

        controlEnrolment.add(new Enrolment("1,2,1"));
        controlEnrolment.add(new Enrolment("2,2,2"));
        controlEnrolment.add(new Enrolment("3,3,1"));
        controlEnrolment.add(new Enrolment("4,2,3"));

        controlEnrolment.save();
    }


}