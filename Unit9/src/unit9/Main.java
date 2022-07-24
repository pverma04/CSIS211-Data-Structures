/** ***********************************************
 * File: Main.java
 * Author: Parth Verma
 * Description: This file contains code for the Main class
 * Date: July 24, 2022
 ************************************************ */
package unit9;

public class Main {

    public static void main(String[] args) {
        
        Graph g = new Graph();
        
        g.insert("canyon lake", "sun city");
        g.insert("canyon lake", "lake elsinore");
        g.insert("sun city", "menifee");
        g.insert("lake elsinore", "murietta");
        g.insert("menifee", "murietta");
        g.insert("menifee", "temecula");
        g.insert("murietta", "temecula");
        
        
        g.printGraph();
        System.out.println("Check dfs String --");
        g.dfs(5);
    }
}
