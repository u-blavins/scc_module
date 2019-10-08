
import java.util.ArrayList;
import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author UBlavins
 */
public class MaxStr {
    
    public String findMax(ArrayList<String> arr){
        String maxLenString = "";
        for (String item: arr) {
            if (item.length() > maxLenString.length())
                maxLenString = item;
        }
        return maxLenString;
    }
}
