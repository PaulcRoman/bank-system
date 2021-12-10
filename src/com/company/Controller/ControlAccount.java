package com.company.Controller;

import com.company.Model.Account;
import com.company.Model.ContCurent;
import com.company.Model.ContEconomii;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlAccount {

    private ArrayList<Account> listaConturi;
    private String path;


    public ControlAccount(String path){
        listaConturi = new ArrayList<>();
        this.path = path;
        load();

    }

    public void add(Account account){

        listaConturi.add(account);

    }

    public void load(){

        try {

            File file = new File(path);

            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()){


                String linie = scanner.nextLine();

//                System.out.println(linie);

                if (linie.equals("")==false){


                    String tipCont = linie.split(",")[2];

                    switch (tipCont){

                        case "curent":
                            listaConturi.add(new ContCurent(linie));
                            break;
                        case "economii":
                            listaConturi.add(new ContEconomii(linie));
                            break;
                    }


                }


            }


        }catch (Exception e){

            e.printStackTrace();
        }
    }

    public void afisare(){

        for (int i =0; i<listaConturi.size();i++){
            System.out.println(listaConturi.get(i));
        }
    }

    public int getPozitie(int id){

        for (Account a : listaConturi){

            if (a.getId() == id){

                return listaConturi.indexOf(a);
            }

        }
        return -1;

    }

    public void updateNumarCont(int id, int numarCont){

        int index = getPozitie(id);

        if (index != -1){

            Account a = listaConturi.get(index);

            a.setNumarCont(numarCont);
        }

    }

    public void updateTipCont(int id, String tipCont){

        int index = getPozitie(id);

        if (index != -1 ){

            Account a = listaConturi.get(index);
                a.setTipCont(tipCont);

        }
    }
    public void updateBalanta(int id, double balanta){

        int index = getPozitie(id);

        if (index != -1) {

            Account a = listaConturi.get(index);

            a.setBalanta(balanta);


        }
    }

    public void depozit(int id, double amount){

        int index = getPozitie(id);

        if (index != -1) {

            Account a = listaConturi.get(index);

            a.deposit(id,amount);



        }

    }

    public boolean delete(int id){

        int index = getPozitie(id);

        if (index != -1){

            listaConturi.remove(index);

            return true;
        }

        return false;

    }

    public void tipuriDeCont(){

        int contCurent = 0;
        int contEconomii=0;

        for (Account a : listaConturi){

            if (a instanceof ContCurent){
                contCurent ++;
            }else if (a instanceof  ContEconomii){
                contEconomii++;
            }
        }

        System.out.println(String.format("Cont curent: %d, Cont economii: ", contCurent, contEconomii));

    }

    public void sortByTipCont(){

        for (int i = 0; i< listaConturi.size(); i++){
            for (int j = i +1; j< listaConturi.size();j++){

                if (listaConturi.get(i).getTipCont().compareTo(listaConturi.get(j).getTipCont())>0){

                    Account aux = listaConturi.get(i);

                    listaConturi.set(i, listaConturi.get(j));
                    listaConturi.set(j, aux);

                }

            }
        }


    }

    public Account getByNumber(int  number){

        for (Account a : listaConturi){

            if (a.getNumarCont()== number){

                return a;

            }

        }

        return  null;

    }

    public void save(){

        try {

            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println(this);
            printWriter.close();


        }catch (Exception e){

        }

    }

    @Override
    public String toString(){

        String text = "";

        for (Account a : listaConturi){

            text += a + "\n";

        }

        return text;
    }

    public int nextId(){

        if (listaConturi.size()>0){

            return listaConturi.get(listaConturi.size()-1).getNumarCont()+1;
        }

        return 1;
    }

    public void clear(){

        listaConturi.clear();
    }



}
