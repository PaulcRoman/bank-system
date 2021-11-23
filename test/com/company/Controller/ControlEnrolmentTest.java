package com.company.Controller;

import com.company.Model.Enrolment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class ControlEnrolmentTest {

    ControlEnrolment controlEnrolment;

    @BeforeEach
    public void testInitial(){

        controlEnrolment= new ControlEnrolment(Path.of("test","ro","mycodeschool","data","enrolment.txt").toString());

    }

    @Test
    public void afisare(){
        controlEnrolment.afisare();

    }

    @Test
    public void testAdd(){

        controlEnrolment.add(new Enrolment("123,234,345"));
        controlEnrolment.afisare();


    }

}