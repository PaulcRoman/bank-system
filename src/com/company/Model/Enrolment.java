package com.company.Model;

public class Enrolment {

    private int id;
    private int  personId;
    private int accountId;

    public Enrolment(int id, int personId, int accountId){

        this.id = id;
        this.accountId = accountId;
        this.personId = personId;

    }

   public Enrolment(String text){

        this(Integer.parseInt(text.split(",")[0]), Integer.parseInt(text.split(",")[1]), Integer.parseInt(text.split(",")[2]));

   }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString(){

        return this.id+","+this.personId+","+this.accountId;

    }

    public String toSave(){
        return id+","+personId+","+accountId;
    }

}
