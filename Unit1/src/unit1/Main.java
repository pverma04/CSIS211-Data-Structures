/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package unit1;

/**
 *
 * @author parthverma
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("12345.6789123456789");
        BigDecimal b = new BigDecimal("10");
        //System.out.println(b.toString());
        //System.out.println(a.toDouble());
        //System.out.println(a.add(b));
        System.out.println(b.ninesComplement());
        
    }
    
}
