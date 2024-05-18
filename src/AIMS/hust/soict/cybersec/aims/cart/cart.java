package AIMS.hust.soict.cybersec.aims.cart;

import AIMS.hust.soict.cybersec.aims.media.DigitalVideoDisc;
import AIMS.hust.soict.cybersec.aims.media.media;

import java.util.ArrayList;
import java.util.Objects;

public class cart {
    public static final int MAX_NUMBERS_ORDERED=20;
    private int quantity=0;
    private ArrayList<media> query=new ArrayList<>();

    public cart(){
        this.query=new ArrayList<>();
        this.quantity=0;
    }
    public void addMedia(media media){
        if(contains(media)){
            System.out.println("Already in cart");
        }else{
            if (MAX_NUMBERS_ORDERED-this.quantity>0){
                query.add(media);
                this.quantity++;
                if (MAX_NUMBERS_ORDERED-this.quantity<3){
                    System.out.println("Cart almost full");
                }
            }
        else{
            System.out.println("Cart is full, can't add items");
            }
        }
    }
    public void removeMedia(media media){
        query.remove(media);
    }

    public void getCart(){
        float currentPrice=0;
        StringBuilder message= new StringBuilder();
        message.append("***********************CART***********************"+"\n");
        message.append("Ordered Items:");
        for (media media : query) {
            message.append(media.getInfo()).append("\n");
            currentPrice+=media.getCost();
        }
        System.out.println(message);
        System.out.println("Total cost: "+currentPrice);
        System.out.println("***************************************************");
    }
    public void sortTitle(){
        for (int i=0;i<query.size();i++){
            for (int j=i+1;j<query.size();j++){
                if(query.get(i).getTitle().compareTo(query.get(j).getTitle())<=0){
                    media temp=query.get(i);
                    query.set(i,query.get(j));
                    query.set(j,temp);
                }
            }
        }
    }
    public void sortPrice() {
        for (int i = 0; i < query.size(); i++) {
            for (int j = i + 1; j < query.size(); j++) {
                if (query.get(i).getCost()>query.get(j).getCost()) {
                    media temp = query.get(i);
                    query.set(i, query.get(j));
                    query.set(j, temp);
                }
            }
        }
    }
    public boolean contains(media media){
        int states=0;
        for (media m : query) {
            if (m.equals(media)) {
                states++;
            }
        }
        return states != 0;
    }
}
