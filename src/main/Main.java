package main;

import ui.UserInterface;
import data.Employee;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        boolean k = true;

        Scanner sc = new Scanner(System.in);
        System.out.println("Acest program este menit pentru o organizare primitiva a informatiei depsre angajati.");
        System.out.println("Puteti introduce,edita,vizualiza,sterge date despre persoane prin intermediul acestui program.");
        System.out.println("Veti fi redirectionati in meniul principal dupa ce introduceti nr de angajati maxim pentru acest program.");

        System.out.println("Introduceti nr de angajati maxim:");
        int nrAng = sc.nextInt();

        Employee[] e = new Employee[nrAng];

        while (k)
        {
             k = UserInterface.menu(nrAng,e);
        }

    }
}