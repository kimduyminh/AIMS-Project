package Aims;

import java.util.ArrayList;

public class Cart {
    public static final int MAX_NUMBER_ORDERED=20;
    private int quantity=0;
    private ArrayList<DigitalVideoDisc> query=new ArrayList<>();

    public Cart(){
        this.quantity=0;
    }
    public void add(DigitalVideoDisc dvd){
        if (MAX_NUMBER_ORDERED-this.quantity>0){
        query.add(dvd);
        this.quantity++;
        if (MAX_NUMBER_ORDERED-this.quantity<3){
            System.out.println("Cart almost full");
        }
    }
        else{
            System.out.println("Cart is full, can't add items");
        }
    }
    public void getCart(){
        float currentPrice=0;
        StringBuilder message= new StringBuilder();
        message.append("Cart: "+"\n");
        for (DigitalVideoDisc digitalVideoDisc : query) {
            message.append(digitalVideoDisc.getInfo()).append("\n");
            currentPrice+=digitalVideoDisc.getCost();
        }
        System.out.println(message);
        System.out.println("Current cart price: "+currentPrice);
    }
    public void sortTitle(){
        for (int i=0;i<query.size();i++){
            for (int j=i+1;j<query.size();j++){
                if(query.get(i).getTitle().compareTo(query.get(j).getTitle())<=0){
                    DigitalVideoDisc temp=query.get(i);
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
                    DigitalVideoDisc temp = query.get(i);
                    query.set(i, query.get(j));
                    query.set(j, temp);
                }
            }
        }
    }
}
