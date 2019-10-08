import java.io.*;

public class ManagerTest
{  public static void main(String[] args)
   {
      InputStreamReader isr = null;
      BufferedReader br = null;

      Employee[] staff = new Employee[3];

      staff[0] = new Employee("Harry Hacker", 35000,
         new Day(1989,10,1));
      staff[1] = new Manager("Carl Cracker", 75000,
         new Day(1987,12,15));
      staff[2] = new Employee("Tony Tester", 38000,
         new Day(1990,3,15));
      int i;
      for (i = 0; i < 3; i++) staff[i].raiseSalary(5);
      for (i = 0; i < 3; i++) staff[i].print();
      System.out.println("pension: £" + staff[0].calculatePension());
      System.out.println("pension: £" + staff[1].calculatePension());
      System.out.println("pension: £" + staff[2].calculatePension());


   }
}

class Employee
{  public Employee(String n, double s, Day d)
   {  name = n;
      salary = s;
      hireDay = d;
   }
   public void print()
   {  System.out.println(name + " " + salary + " "
         + hireYear());
   }
   public void raiseSalary(double byPercent)
   {  salary *= 1 + byPercent / 100;
   }
   public int hireYear()
   {  return hireDay.getYear();
   }
   
   public double calculatePension() {
       double monthly = salary/12;
       return monthly * 
               (new Day().getYear()-hireDay.getYear());
   }

   private String name;
   private double salary;
   private Day hireDay;
}

class Manager extends Employee
{  public Manager(String n, double s, Day d)
   {  super(n, s, d);
      secretaryName = "";
   }

   public void raiseSalary(double byPercent)
   {  // add 1/2% bonus for every year of service
      Day today = new Day();
      double bonus = 0.5 * (today.getYear() - hireYear());
      super.raiseSalary(byPercent + bonus);
   }
   
   public void setSecretaryName(String n)
   {  secretaryName = n;
   }

   public String getSecretaryName()
   {  return secretaryName;
   }
   
   private String secretaryName;
}


