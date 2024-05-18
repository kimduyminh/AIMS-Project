package AIMS.hust.soict.cybersec.aims;

import AIMS.hust.soict.cybersec.aims.media.DigitalVideoDisc;
import AIMS.hust.soict.cybersec.aims.media.media;

import java.util.Arrays;

public class Store {
    private media[] itemsInStore;
    private media[] temp1;
    private media[] temp2;
    public void addDVD(DigitalVideoDisc dvd){
        itemsInStore[itemsInStore.length]=dvd;
    }
    public void removeDVD(DigitalVideoDisc dvd){
        for (int i=0;i<itemsInStore.length;i++){
            if (itemsInStore[i].equals(dvd)){
                System.arraycopy(itemsInStore,0,temp1,i-1,i);
                System.arraycopy(itemsInStore,i+1,temp2,itemsInStore.length-1,itemsInStore.length-i-1);
                Arrays.fill(itemsInStore, 0);
                System.arraycopy(temp1, 0, itemsInStore, 0, temp1.length);
                System.arraycopy(temp2, 0, itemsInStore, temp1.length, temp2.length);
            }
        }
    }
}