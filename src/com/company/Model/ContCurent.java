package com.company.Model;

public class ContCurent extends Account{

    public ContCurent(int id, int numarCont, String tip, double balanta){
        super(id, numarCont,"cont curent",balanta);
    }

    public ContCurent(String text){

        super(Integer.parseInt(text.split(",")[0]), Integer.parseInt(text.split(",")[1]),text.split(",")[2],
                Double.parseDouble(text.split(",")[3]));

    }

    @Override
    public String toString(){
      return   super.toString();
    }

    @Override
    public boolean equals(Object o){

        if (o instanceof ContCurent) {
            ContCurent cc = (ContCurent) o;

            return super.equals(cc);
        }
        return false;
    }
}
