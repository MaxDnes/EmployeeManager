package ui;

import data.Employee;
import data.functions.ManipulateInfo;

import java.util.Scanner;

public class UserInterface
{
    public static void pause()
    {
        System.out.println("Press Any Key To Continue...");
        new java.util.Scanner(System.in).nextLine();
    }
    public static boolean menu(int nrAng, Employee[] e)
    {
        int option;
        boolean k = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\n\n\n\n\n\t\tMeniu principal");
        System.out.println("1.Introducere info");
        System.out.println("2.Vizualizare date");
        System.out.println("3.Editare info");
        System.out.println("4.Stergere info");
        System.out.println("Oricare alt simbol: iesire din program");
        option = sc.nextInt();
        switch (option)
        {
            case 1: ManipulateInfo.enter(nrAng,e); break;
            case 2: ManipulateInfo.show(e); break;
            case 3: ManipulateInfo.edit(e); break;
            case 4: ManipulateInfo.removeInfo(e); break;
            default: k = false;
        }
        return k;
    }


}
