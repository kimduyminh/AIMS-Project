package AIMS.hust.soict.cybersec.aims.cart;

import AIMS.hust.soict.cybersec.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ObservableList<Media> itemsOrdered;

    public Cart() {
        this.itemsOrdered = FXCollections.observableArrayList();
    }

    public void addMedia(Media media) {
        if (contains(media)) {
            System.out.println("Already in cart");
        } else {
            if (MAX_NUMBERS_ORDERED - itemsOrdered.size() > 0) {
                itemsOrdered.add(media);
                if (MAX_NUMBERS_ORDERED - itemsOrdered.size() < 3) {
                    System.out.println("Cart almost full");
                }
            } else {
                System.out.println("Cart is full, can't add items");
            }
        }
    }

    public void removeMedia(Media media) {
        itemsOrdered.remove(media);
    }

    public void clearCart() {
        itemsOrdered.clear();
    }

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public boolean contains(Media media) {
        return itemsOrdered.contains(media);
    }
}
