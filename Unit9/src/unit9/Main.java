
package unit9;

public class Main {

    public static void main(String[] args) {
        Graph g = new Graph(53);
        g.insert("canyon lake", "sun city");
        g.insert("canyon lake", "lake elsinore");
        g.insert("sun city", "menifee");
        g.insert("lake elsinore", "murietta");
        g.insert("menifee", "murietta");
        g.insert("menifee", "temecula");
        g.insert("murietta", "temecula");
        g.insert("temecula", "canyon lake");

        g.printGraph();
        System.out.println("Check dfs String --");
        g.dfs("canyon lake");
    }
}
