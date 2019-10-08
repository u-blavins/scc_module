/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prac2;

/**
 *
 * @author UBlavins
 */
public class Prac2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Long[] salaries = {24000L, 34000L, 40000L, 21000L, 18000L};
        String[] profession = {"nurse", "teacher", "Architect",
            "Bus Driver", "Postman"};
        
//        System.out.println("Number of salaries under 20K: " + 
//                Integer.toString(countLowTaxSalary(salaries)));
//        System.out.println("Profession with highest Sal: " + 
//                printHighSalProfession(salaries, profession));
        Long[] test = {2345L, 23455L, 54L, 7654L};
        System.out.println("Highest Amount: " + findHighestAmount(test));
    }

    private static int countLowTaxSalary(Long[] salaries) {
        int count = 0;
        for (int i = 0; i < salaries.length; i++) {
            if (salaries[i] < 20000L) {
                count ++;
            }
        }
        return count;
    }
    
    private static String printHighSalProfession(
            Long[] salaries, String[] profession) {
        int highestSalIndex = 0;
        long highestSal = 0;
        for (int i = 0; i < salaries.length; i++) {
            if (salaries[i] > highestSal) {
                highestSalIndex = i;
                highestSal = salaries[i];
            }
        }
        return profession[highestSalIndex];
    }
    
    private static Long findHighestAmount(Long[] anArray) {
        long highestValue = 0;
        for (Long value: anArray) {
            if (value > highestValue) {
                highestValue = value;
            }
        }
        return highestValue;
    }
    
}
