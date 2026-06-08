package sistema.application;

import java.text.ParseException;
import sistema.entities.classes.Departament;
import sistema.entities.classes.HourContract;
import sistema.entities.classes.Worker;
import sistema.entities.enums.WorkerLevel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    static void main() throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Departamento: ");
        String departamentNome = sc.nextLine();
        System.out.print("Nome: ");
        String nomeWorker = sc.nextLine();
        System.out.print("Level: ");
        String levelWorker = sc.nextLine();
        System.out.print("Salário Base: ");
        double salarioBase = sc.nextDouble();

        Worker trabalhador = new Worker(nomeWorker, WorkerLevel.valueOf(levelWorker), salarioBase, new Departament(departamentNome));
        System.out.print("Quantos contratos? ");
        int c = sc.nextInt();
        for (int i = 1; i <= c; i++) {

            System.out.println("Enter contract #" + i + " data:");
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate = dtf.parse(sc.next());
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            System.out.print("Duration (hours): ");
            int hours = sc.nextInt();
            HourContract contract = new HourContract(contractDate, valuePerHour, hours);
            trabalhador.addContract(contract);
        }
        System.out.println();
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));
        System.out.println("Name: " + trabalhador.getName());
        System.out.println("Department: " + trabalhador.getDepartament().getName(departamentNome));
        System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", trabalhador.income(year, month)));
        sc.close();
    }


}

