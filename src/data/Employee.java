package data;

import data.functions.ManipulateInfo;

public class Employee
{
    private String name;
    private String surname;
    //private int id;
    private boolean gen; // 0/false -> male    1/true - female
    private int id;

    public Employee(String n,String s,boolean g, int id)
    {
        this.name = n;
        this.surname = s;
        this.gen = g;
        this.id = id;
    }

    public String toString() {return "Employee:\n"+"id: " + id + "\nname: " + name + "\nsurname: "+ surname + "\ngen:" + (!gen ? " barbat" : " femeie") ;}


    public void copy(Employee e)
    {
        this.name = e.getName();
        this.surname = e.getName();
        this.id = e.getId();
        this.gen = e.getGen();
    }

    public void copy(String name,String surname,int id,boolean gen)
    {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.gen = gen;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setGen(boolean gen)
    {
        this.gen = gen;
    }

    public String getName() {
        return name;
    }

    public String getSurname()
    {
        return surname;
    }

    public boolean getGen() {
        return gen;
    }

    public int getId() {
        return id;
    }

    public void clear(Employee[] e)
    {
        //this.name="";this.surname="";this.gen=false;
        for (int i=this.id;i< ManipulateInfo.getNrAngEntered()-1;i++) e[i].copy(e[i+1].getName(),e[i+1].getSurname(),e[i].getId(),e[i+1].getGen());
        e[ManipulateInfo.getNrAngEntered()-1] = null;
    }

    public int length()
    {
        return 0;
    }
}
