package unit7;
import java.util.ArrayList;

public class HashTable<T> {

    ArrayList<PairList<Pair>> mData;
    static int mTABLE_SIZE = 53;

    public HashTable() {
        mData = new ArrayList<PairList<Pair>>(mTABLE_SIZE);
        for(int i = 0; i < mTABLE_SIZE; i++) {
            mData.add(null);
        }
    }
    private int hashFunc (String str) {
        return Math.abs(str.hashCode() % mTABLE_SIZE);
    }
    
    public void add(String name, String number) {
        Pair addOn = new Pair(name, number);
        int pos = hashFunc(name);
        //System.out.println(name + " hash: " + pos);
        PairList<Pair> listAtPos = null;
        if (mData.get(pos) == null) {
            listAtPos = new PairList<Pair>();
            listAtPos.addPair(addOn);
            mData.set(pos, listAtPos);
        } else {
            listAtPos = mData.get(pos);
            listAtPos.addToEnd(addOn);
            mData.set(pos, listAtPos);
        }
    }
    public String lookup(String name) {
        int pos = hashFunc(name);
        PairList<Pair> list = mData.get(pos);
        if(list == null){
            return null;
        } else {
            //return "";
            Node p = list.getNode(0); //head node
            while (p.mNext != null) {
               System.out.println(((Pair) p.mData).getFirst());
               if (((Pair)p.mData).getFirst().equals(name)) {
                   return "" + ((Pair) p.mData).getSecond();
               }
               p = p.mNext;
            }
            if (((Pair) p.mData).getFirst().equals(name)) {
                return "" + ((Pair) p.mData).getSecond();
            }
            return "Name not found";
        }
    }    
    public void printTable() {
        //int offset = 0;
        for (PairList pL : mData) {
            if (pL != null) {
                Node p = pL.getNode(0);
                while (p.mNext != null) {
                    System.out.println(((Pair) p.mData).getFirst() + "(" + hashFunc("" + ((Pair) p.mData).getFirst()) + "-" + p.mOffset + ")" + "; " + ((Pair) p.mData).getSecond() + ";");
                    //offset++;
                    p = p.mNext;
                }
                System.out.println(((Pair) p.mData).getFirst() + "(" + hashFunc("" + ((Pair) p.mData).getFirst()) + "-" + p.mOffset + ")" + "; " + ((Pair) p.mData).getSecond() + ";");
            }
            //offset = 0;
        }
    }
}
