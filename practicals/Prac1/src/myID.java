/**
 * A simple program that prints a greeting message
 * File: myID.java
 */

import java.io.*;

public class myID
{
   public static void main(String[] args)
   {
      String[] student = {"","",""};
      InputStreamReader isr = null;
      BufferedReader br = null;
      //create streams to process user input
      isr = new InputStreamReader(System.in);
      br = new BufferedReader(isr);
      try {
        System.out.println("Please Enter your name");
        student[0] = (br.readLine());
        System.out.println("Please Enter your email");
        student[1] = br.readLine();
        System.out.println("Please Enter your module");
        student[2] = br.readLine();
      } 
      catch(IOException e) {
        System.out.println("IO Exception ocuured " + e);
      }
      
      selectChoice(br, student);

   }
   
   /**
    * Method that prints out the menu details
   */
   private static void displayMenu()
   {
       System.out.println("Select from the following options:\n"+
               "[1] print Name\n"+ "[2] print Email\n" + "[3] print Module\n" +
               "[4] display menu options\n" + "[5] quit\n");
   }
   
   /**
    * Method that prints out a menu for the user
    * @param br buffered reader so user can input answer
   */
   private static void selectChoice(BufferedReader br, String[] student)
   {
       int choice;
       try {
           displayMenu();
           choice = Integer.parseInt(br.readLine());
           
           switch (choice) 
           {
               case 1: System.out.println(student[0]);
                   break;
               case 2: System.out.println(student[1]);
                   break;
               case 3: System.out.println(student[2]);
                   break;
               case 4: selectChoice(br, student);
                   break;
               case 5: break;
           }
           
       } catch(IOException e) {
           System.out.println("IO Exception ocuured " + e);
       }
   }
}

