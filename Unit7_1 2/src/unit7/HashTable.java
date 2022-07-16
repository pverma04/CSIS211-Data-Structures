/**
 * ***********************************************
 * File: Main.java
 * Author: Parth Verma
 * Description: This file contains code for the HashTable class
 * Date: July 14, 2022
 * ***********************************************
 */
package unit7;

import java.util.ArrayList;

public class HashTable<T> {

    ArrayList<PairList<Pair>> mData;
    static int mTABLE_SIZE = 53;

    public HashTable() {
        mData = new ArrayList<PairList<Pair>>(mTABLE_SIZE);
        for (int i = 0; i < mTABLE_SIZE; i++) {
            mData.add(null);
        }
    }

    /**
     * ***********************************************
     * @par Name hashFunc
     * @purpose Determines the input position of a given string by finding the
     * hashcode of the string MOD by size of the table
     * @param [in] : String str
     * @return Int***********************************************
     */
    public int hashFunc(String str) {
        return Math.abs(str.hashCode() % mTABLE_SIZE);
    }

    /**
     * ***********************************************
     * @par Name add
     * @purpose Creates and adds a Pair to the HashTable, given the data first
     * and second of the pair
     * @param [in] : String name, String number
     * @return Void***********************************************
     */
    public void add(String name, String number) {
        Pair addOn = new Pair(name, number);
        int pos = hashFunc(name);
        PairList<Pair> listAtPos = null;
        if (mData.get(pos) == null) { //if pos holds an empty PairList, create a new one with the new data
            listAtPos = new PairList<Pair>();
            listAtPos.addPair(addOn);
            mData.set(pos, listAtPos);
        } else { //hold the PL at pos and adds to it, and resetts the PL at pos to the updated one
            listAtPos = mData.get(pos);
            listAtPos.addToEnd(addOn);
            mData.set(pos, listAtPos);
        }
    }

    /**
     * ***********************************************
     * @par Name lookup
     * @purpose Searches for the given name in the HashTable and returns all
     * data associated with the name
     * @param [in] : String name
     * @return String***********************************************
     */
    public String lookup(String name) {
        int pos = hashFunc(name);
        PairList<Pair> list = mData.get(pos); //PairList at the needed index
        if (list == null) { //if null, name does not exist in the HT
            return null;
        } else {
            Node p = list.getNode(0); //head node
            while (p.mNext != null) { //traverse
                if (((Pair) p.mData).getFirst().equals(name)) { //if name has been found
                    return ((Pair) p.mData).getFirst() + "(" + hashFunc("" + ((Pair) p.mData).getFirst()) + "-" + p.mOffset + ")" + " " + ((Pair) p.mData).getSecond();
                }
                p = p.mNext;
            }
            if (((Pair) p.mData).getFirst().equals(name)) { //for the last Pair in the PL
                return ((Pair) p.mData).getFirst() + "(" + hashFunc("" + ((Pair) p.mData).getFirst()) + "-" + p.mOffset + ")" + " " + ((Pair) p.mData).getSecond();
            }
            return "Name not found";
        }
    }

    /**
     * ***********************************************
     * @par Name printTable
     * @purpose Traverses through and prints data in the HT
     * @param [in] : None
     * @return Void***********************************************
     */
    public void printTable() {
        for (PairList pL : mData) {
            if (pL != null) {
                Node p = pL.getNode(0);
                while (p.mNext != null) {
                    System.out.println(((Pair) p.mData).getFirst() + "(" + hashFunc("" + ((Pair) p.mData).getFirst()) + "-" + p.mOffset + ")" + "; " + ((Pair) p.mData).getSecond() + ";");
                    p = p.mNext;
                }
                System.out.println(((Pair) p.mData).getFirst() + "(" + hashFunc("" + ((Pair) p.mData).getFirst()) + "-" + p.mOffset + ")" + "; " + ((Pair) p.mData).getSecond() + ";");
            }
        }
    }
}
