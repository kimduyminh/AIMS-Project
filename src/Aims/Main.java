package Aims;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        database db=new database();
        ArrayList<DigitalVideoDisc> data=new ArrayList<>();
        data.add(db.disc1);
        data.add(db.disc2);
        data.add(db.disc3);
        data.add(db.disc4);
        data.add(db.disc5);
        data.add(db.disc6);
        Cart cart = new Cart();
        String searchKeyword="KPOP";
        System.out.println(db.searchByCategory(data,searchKeyword));
        System.out.println(db.searchByPrice(data,5,20));
        cart.add(db.disc2);
        cart.add(db.disc1);
        cart.sortPrice();
        cart.getCart();
    }
}