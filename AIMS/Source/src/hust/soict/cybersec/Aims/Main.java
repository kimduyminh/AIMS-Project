package hust.soict.cybersec.Aims;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        //import database
        database db=new database();
        ArrayList<DigitalVideoDisc> data=new ArrayList<>();
        data.add(db.disc1);
        data.add(db.disc2);
        data.add(db.disc3);
        data.add(db.disc4);
        data.add(db.disc5);
        data.add(db.disc6);

        //create new cart
        Cart cart = new Cart();

        System.out.println("Testing search function:");
        System.out.println(db.searchByTitle(data,"Maniac"));
        System.out.println(db.searchByCategory(data,"KPOP"));
        System.out.println(db.searchByPrice(data,5,20));

        //add disc to cart
        cart.addDigitalVideoDisc(db.disc2);
        cart.addDigitalVideoDisc(db.disc1);

        //sorting in cart
        System.out.println("Sorting cart test: ");
        cart.sortPrice();
        cart.sortTitle();

        //show cart info
        System.out.println("Show cart info: ");
        cart.getCart();
    }
}