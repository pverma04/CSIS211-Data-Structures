/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package midterm;

/**
 *
 * @author parthverma
 */
public class MidTerm {

    /**
     * @param args the command line arguments   
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int sum = 0;
        int n = 15;
        for (int i = 1; i < n;) {
            for (int j = 1; j < i * i; j++) {
                if (j % i == 0) {
                    for (int k = 0; k < j; k++) {
                        sum++;
                    }
                }
            }
        }
        System.out.println(sum);
    }   
}
