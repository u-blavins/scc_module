/**
 * A simple program that prints a greeting message
 * File: myID.java
 */

import java.io.*;
import java.util.Scanner;

public class myID_1
{
   public static void main(String[] args)
   {
      String[] student = {"","",""};
      InputStreamReader isr = null;
      BufferedReader br = null;
      //create streams to process user input
      Scanner sUser = new Scanner(System.in);
      
      System.out.println("Please Enter your name1");
      student[0] = sUser.nextLine();
      System.out.println("Please Enter your email");
      student[1] = sUser.nextLine();
      System.out.println("Please Enter your module");
      student[2] = sUser.nextLine();
      
      selectChoice(sUser, student);

   }
   
   /**
    * Method that prints out the menu details
   */
   private static void displayMenu()
   {
       System.out.println("Select from the following options:\n"+
               "[1] print Name\n"+ "[2] print Email\n" + "[3] print Module\n" +
               "[4] display menu options\n" + "[5] display module info\n" + 
               "[6] quit\n");
   }
   
   
   /**
    * Go through a file to print out info about a module
    * @param module the name of the module
    */
   private static void displayModuleInfo(Scanner sUser) throws 
           FileNotFoundException 
   {
       int lines;
       int count = 0;
       System.out.println("How many lines of text?");
       lines = sUser.nextInt();
       Scanner sFile = new Scanner( new File(
               "/Users/UBlavins/ntu_year3/sc_cloud/prac/module.txt"));
       while (sFile.hasNextLine() && count < lines)
       {
           count ++;
           System.out.println(sFile.nextLine());
       }
   }
   
   /**
    * Method that prints out a menu for the user
    * @param br buffered reader so user can input answer
   */
   private static void selectChoice(Scanner sUser, String[] student)
   {
       int choice;
       displayMenu();
       choice = sUser.nextInt();
       switch (choice)
       {
           case 1: System.out.println(student[0]);
               break;
           case 2: System.out.println(student[1]);
               break;
           case 3: System.out.println(student[2]);
               break;
           case 4: selectChoice(sUser, student);
               break;
           case 5:
               try {
                   displayModuleInfo(sUser);
               } catch (FileNotFoundException e) {
                   System.out.println("FileNotFoundException: " + e);
               } 
               break;
           case 6: break;
       }
   }
}

