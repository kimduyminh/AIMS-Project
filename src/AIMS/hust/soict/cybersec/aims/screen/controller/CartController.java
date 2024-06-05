package AIMS.hust.soict.cybersec.aims.screen.controller;

import java.io.IOException;

import AIMS.hust.soict.cybersec.aims.PlayerException;
import AIMS.hust.soict.cybersec.aims.Store;
import AIMS.hust.soict.cybersec.aims.media.Media;
import AIMS.hust.soict.cybersec.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import AIMS.hust.soict.cybersec.aims.cart.Cart;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartController {
    @FXML
    private Button btnPlaceOrder;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private Label costLabel;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    private Cart cart;
    private Store store;

    public CartController(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
    }

    public CartController() {
        // Default constructor
    }


    public CartController(Cart cart) {
        this.cart = cart;
    }


    @FXML
    void btnPlaceOrderClicked(ActionEvent event) {
        cart.clearCart();
        updateCostLabel();
    }

    @FXML
    void btnPlayPressed(ActionEvent event) throws PlayerException {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof Playable) {
            ((Playable) media).play();
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
        updateCostLabel();
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
        try {
            final String STORE_FXML_FILE_PATH = "/hust/soict/cybersec/aims/screen/customer/view/Store.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
            fxmlLoader.setController(new ViewStoreController(store, cart));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Store");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize() {
        colMediaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        tblMedia.setItems(cart.getItemsOrdered());

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                updateButtonBar(newValue);
            }

            void updateButtonBar(Media media) {
                if (media == null) {
                    btnPlay.setVisible(false);
                    btnRemove.setVisible(false);
                } else {
                    btnRemove.setVisible(true);
                    if (media instanceof Playable) {
                        btnPlay.setVisible(true);
                    } else {
                        btnPlay.setVisible(false);
                    }
                }
            }
        });

        FilteredList<Media> filteredData = new FilteredList<>(cart.getItemsOrdered(), p -> true);
        tblMedia.setItems(filteredData);

        tfFilter.textProperty().addListener((observable, oldValue, newValue) -> {
            showFilteredMedia(newValue, filteredData);
        });

        cart.getItemsOrdered().addListener((ListChangeListener<Media>) c -> {
            updateCostLabel();
        });

        updateCostLabel();
    }

    private void updateCostLabel() {
        float totalCost = 0;
        for (Media media : cart.getItemsOrdered()) {
            totalCost += media.getCost();
        }
        costLabel.setText(String.format("%.2f", totalCost));
    }

    public void showFilteredMedia(String filterString, FilteredList<Media> filteredData) {
        if (filterString == null || filterString.isEmpty()) {
            filteredData.setPredicate(null);
        } else {
            filteredData.setPredicate(media -> {
                String lowerCaseFilter = filterString.toLowerCase();
                if (radioBtnFilterTitle.isSelected() && media.getTitle().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches title.
                } else if (radioBtnFilterId.isSelected() && String.valueOf(media.getId()).equals(lowerCaseFilter)) {
                    return true; // Filter matches ID.
                }
                return false; // Does not match.
            });
        }
    }
}
