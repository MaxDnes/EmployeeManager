package data.functions;

import ui.UserInterface;
import data.Employee;

import java.util.Scanner;

public class ManipulateInfo
{
    private static int nrAngEntered = 0;

    public static int getNrAngEntered() {
        return nrAngEntered;
    }

    public static void enter(int nrAng, Employee[] e)
    {
        Scanner sc = new Scanner(System.in);

        String name,surname;
        boolean gen;
        boolean k = true;

        if(nrAngEntered < nrAng)
        {
            while(k&&nrAngEntered<nrAng)
            {
                System.out.println("Id:"+nrAngEntered+"\nName:");
                name = sc.nextLine();
                System.out.println("Surame:");
                surname = sc.nextLine();
                System.out.println("Gen(true - femeie /false - barbat):");
                gen = sc.nextBoolean();
                sc.nextLine();
                e[nrAngEntered] = new Employee(name,surname,gen,nrAngEntered);
                System.out.println("Angajatul cu id-ul"+nrAngEntered+"\nnumele:"+name+"\nprenumele:"+surname+"\ngenul:"+e[nrAngEntered].getGen() +"\n A fost creat cu succes");
                System.out.println("Doriti sa mai introduceti angajati:\n1.Confirm\nOricare alt buton meniu principal");
                if (sc.nextInt() == 2) k = false;
                sc.nextLine();
                UserInterface.pause();
                nrAngEntered++;
            }
        }
        else
        {
            System.out.println("\nDeja ati introdus nr-ul maxim de angajati");
            UserInterface.pause();
        }
    }
    public static void show(Employee[] e)
    {
        if (nrAngEntered > 0)
        {
            System.out.println("Doriti sa afisazi un angajat sau pe toti?\n1.Afisare un angajat\n2.Afisare toti angajatii \nOricare alt buton meniu principal");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("Introduceti id-ul angajat-ului:");
                    choice = sc.nextInt();
                    if (choice >= nrAngEntered) System.out.println("Nu exista un angajat cu acest id");
                    else System.out.println(e[choice].toString());
                    break;
                case 2:
                    System.out.println("\n");
                    for (int i = 0; i < nrAngEntered ; i++) System.out.println(e[i].toString());
                    break;
            }
            UserInterface.pause();
        }
        else
        {
            System.out.println("\nNu aveti angajati introdusi");
            UserInterface.pause();
        }


    }
    public static Employee[] edit(Employee[] e)
    {
        if (nrAngEntered > 0)
        {
            System.out.println("Introduceti pozitia angajatului informatia caruia doriti sa o editati:");
            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            Employee oldEmployee = new Employee(e[id].getName(),e[id].getSurname(),e[id].getGen(),e[id].getId());

            System.out.println("Care camp doriti sa il schimbati:\n1.Nume\n2.Prenume\n3.Gen\n4.Editarea tuturor campurilor\n5.Anulare editare");
            int option = sc.nextInt();
            sc.nextLine();
            switch (option)
            {
                case 1:
                    System.out.println("Care va fi numele nou a angajatului:");
                    e[id].setName(sc.nextLine());
                    System.out.println("Nume angajatului cu id-ul" + id + " va schimbat din "+oldEmployee.getName() +" in "+e[id].getName()+"\n1.Confirm\n2.Anulare");
                    option = sc.nextInt();
                    if (option == 2)
                    {
                        e[id].setName( oldEmployee.getName());
                        System.out.println("\nActiunea a fost anulata"); UserInterface.pause();
                        return e;
                    }

                    break;
                case 2:
                    System.out.println("Care va fi prenumele nou a angajatului:");
                    e[id].setSurname(sc.nextLine());
                    System.out.println("Prenume angajatului cu id-ul" + id + " va schimbat din "+oldEmployee.getSurname() +" in "+e[id].getSurname()+"\n1.Confirm\n2.Anulare");
                    option = sc.nextInt();
                    if (option == 2)
                    {
                        e[id].setSurname( oldEmployee.getSurname());
                        System.out.println("\nActiunea a fost anulata"); UserInterface.pause();
                        return e;
                    }
                    break;
                case 3:
                    System.out.println("Care va fi genul nou a angajatului:");
                    e[id].setGen(sc.nextBoolean());
                    System.out.println("Genul angajatului cu id-ul" + id + " va schimbat din "+oldEmployee.getGen() +" in "+e[id].getGen()+"\n1.Confirm\n2.Anulare");
                    option = sc.nextInt();
                    if (option == 2)
                    {
                        e[id].setGen( oldEmployee.getGen());
                        System.out.println("\nActiunea a fost anulata"); UserInterface.pause();
                        return e;
                    }
                    break;
                case 4:
                    System.out.println("Care va fi numele nou a angajatului:");
                    e[id].setName(sc.nextLine());
                    System.out.println("Care va fi prenumele nou a angajatului:");
                    e[id].setSurname(sc.nextLine());
                    System.out.println("Care va fi genul nou a angajatului:");
                    e[id].setGen(sc.nextBoolean());
                    System.out.println("Nume angajatului cu id-ul" + id + " va schimbat din "+oldEmployee.getName() +" in "+e[id].getName()+"\nPrenume angajatului cu id-ul" + id + " va schimbat din "+oldEmployee.getSurname() +" in "+e[id].getSurname()+"Genul angajatului cu id-ul" + id + " va schimbat din "+oldEmployee.getGen() +" in "+e[id].getGen()+"\n1.Confirm\n2.Anulare");
                    option = sc.nextInt();
                    if (option == 2)
                    {
                        e[id].setName( oldEmployee.getName());
                        e[id].setSurname( oldEmployee.getSurname());
                        e[id].setGen( oldEmployee.getGen());
                        System.out.println("\nActiunea a fost anulata"); UserInterface.pause();
                        return e;
                    }
                    break;
                default: return e;
            }
            System.out.println("\nDatele au fost modificate cu succes");
            UserInterface.pause();
        }
        else
        {
            System.out.println("\nNu aveti angajati introdusi");
            UserInterface.pause();
        }

        return e;
    }

    public static void removeInfo(Employee[] e)
    {
        if (nrAngEntered > 0)
        {
            System.out.println("\nIntroduceti id-ul angajatului datele caruia trebuie sterse");
            Scanner sc = new Scanner(System.in);
            int pos = sc.nextInt();
            System.out.println("\nDoriti sa stergeti datele angatului:"+"\nId:"+pos+"\nNume:"+e[pos].getName()+"\nPrenume:"+e[pos].getSurname()+"\nGen"+e[pos].getGen());
            System.out.println("1.Confirm\n2.Anulare");
            if (sc.nextInt() == 1)
            {
                e[pos].clear(e);
                System.out.println("\nDatele au fost sterse");
                nrAngEntered--;
            }
            else System.out.println("\nOperatia a fost anulata");
        }
        else
            {
                System.out.println("\nNu aveti angajati introdusi");
                UserInterface.pause();
            }
    }
}
