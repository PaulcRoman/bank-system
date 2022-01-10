package com.company.view;

import com.company.Model.Client;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ViewUserTest {

    ViewUser viewUser = new ViewUser(new Client("2, Andrei, Ciobanu, client, andrei@email.com, andreicont, parola2"));


    @Test
    public void afisare(){
//        viewUser.afisareConturi();
    }

}