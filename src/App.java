import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import entitiesEnum.WorkerLevel;



public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter department's name: ");
        String departmentName = sc.nextLine();

       System.out.println("Enter worker Data: ");
       System.out.print("Name: ");
       String workerName = sc.nextLine();
       System.out.print("Level: ");
       String workerLevel = sc.nextLine();
       System.out.print("Base Salary: ");
       double baseSalary = sc.nextDouble();
       Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel),baseSalary, new Departament(departmentName));

       System.out.print("How many contracts to this worker? ");
       int n = sc.nextInt();

       for(int i=1; i<=n; i++){
        System.out.println("Enter contract #"+ i + " data: ");
        System.out.print("Date (DD/MM/YYYY): ");
        Date contracDate = sdf.parse(sc.next());
        System.out.print("Value per Hour: ");
        double valuePerHour = sc.nextDouble();
        System.out.print("Duration (hours): ");
        int hours = sc.nextInt();
        HourContract contract = new HourContract(contracDate, valuePerHour, hours);
        worker.addContract(contract);
       }
    

       System.out.println();
       System.out.print("Enter month and year to calculate income (MM/YYYY): ");
       String monthAndYear = sc.next();
       int month = Integer.parseInt(monthAndYear.substring(0, 2));
       int year = Integer.parseInt(monthAndYear.substring(3));
       System.out.println("Name: "+ worker.getName());
       System.out.println("Department: "+ worker.getDepartament().getName());
       System.out.println("Income for "+ monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));





        sc.close();
    }
}
