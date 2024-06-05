package AIMS.hust.soict.cybersec.aims.screen;

import javax.swing.*;
import AIMS.hust.soict.cybersec.aims.cart.Cart;
import AIMS.hust.soict.cybersec.aims.screen.controller.CartController;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class CartScreen extends JFrame {
    private Cart cart;
    public CartScreen(Cart cart) {
        super();
        this.cart = cart;
        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);
        this.setTitle("Cart");
        this.setVisible(true);
        Platform.runLater(new Runnable(){
            public void run() {
                try{
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/screen/fxml/cart.fxml"));
                    CartController controller=new CartController(cart);
                    fxmlLoader.setController(controller);
                    Parent root = fxmlLoader.load();
                    fxPanel.setScene(new Scene(root));
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
    }
}
