package AIMS.hust.soict.cybersec.aims.screen.controller;

import javafx.geometry.Insets;

import javax.naming.LimitExceededException;

import AIMS.hust.soict.cybersec.aims.cart.Cart;
import AIMS.hust.soict.cybersec.aims.PlayerException;
import AIMS.hust.soict.cybersec.aims.media.Media;
import AIMS.hust.soict.cybersec.aims.media.Playable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ItemController {

    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblCost;

    @FXML
    void btnAddToCartClicked(ActionEvent event) throws LimitExceededException {
        if (cart != null) {
            cart.addMedia(media);
        } else {
            System.out.println("Cart is not initialized.");
        }
    }

    @FXML
    void btnPlayClicked(ActionEvent event) throws PlayerException {
        if (media instanceof Playable) {
            ((Playable) media).play();
        }
    }

    private Media media;
    private Cart cart;

    public void setData(Media media) {
        this.media = media;
        lblTitle.setText(media.getTitle());
        lblCost.setText(media.getCost() + " $");
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
            HBox.setMargin(btnAddToCart, new Insets(0,0,0,60));
        }
    }

    public ItemController(Cart cart) {
        this.cart = cart;
    }

}