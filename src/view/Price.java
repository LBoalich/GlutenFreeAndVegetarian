package view;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Restaurant;
import model.RestaurantsData;

public class Price {
    private VBox panePrice;
    private ComboBox<Integer> cboLow;
    private ComboBox<Integer> cboHigh;
    private int selectedLowPrice;
    private int selectedHighPrice;
    private ArrayList<Restaurant> priceMatches = new ArrayList<>();

    public Price() {
        price();
    }

    public VBox getPricePane() {
        return this.panePrice;
    }

    public ArrayList<Restaurant> getPriceMatches() {
        // Clear previous matches
        priceMatches.clear();
        // If selections made
        if (!cboLow.getSelectionModel().isEmpty() && !cboHigh.getSelectionModel().isEmpty()) {
            // Find price matches
            priceMatches = RestaurantsData.RESTAURANTS.priceRangeMatch(selectedLowPrice, selectedHighPrice);
        }
        // Return matches
        return this.priceMatches;
    }

    private void price() {
        // Create price vbox
        panePrice = new VBox(10);

        // Create price label
        Label lbPrice = new Label("Price Range");
        
        // Create range hbox
        HBox hboxRange = new HBox(20);

         /* Create low and high price combo boxes */
        // Create list of price ranges
        ArrayList<Integer> priceArray = new ArrayList<>();
        // Populate price list
        int i = 5;
        while (i < 150) {
            priceArray.add(i);
            i += 5;
        }
        // Create observable list for low price
        ObservableList<Integer> priceListLow = FXCollections.observableArrayList(priceArray);
        // Create observable list for high
        ObservableList<Integer> priceListHigh = FXCollections.observableList(priceArray);
        // Create low combo
        cboLow = new ComboBox<>(priceListLow);
        // Add low combo event handler
        cboLow.setOnAction(e -> cboLowHandler());
        // Create high combo
        cboHigh = new ComboBox<>(priceListHigh);
        // Add high combo event handler
        cboHigh.setOnAction(e -> cboHighHandler());

        /* Add combos to labels */
        // Create low label
        Label lbLow = new Label("Low Price", cboLow);
        // Create high label
        Label lbHigh = new Label("High Price", cboHigh);
        // Put combos to right of labels
        lbLow.setContentDisplay(ContentDisplay.RIGHT);
        lbHigh.setContentDisplay(ContentDisplay.RIGHT);

        // Add labels to hbox
        hboxRange.getChildren().addAll(lbLow, lbHigh);
        // Center align
        hboxRange.setAlignment(Pos.CENTER);

        // Add label and hbox to vbox
        panePrice.getChildren().addAll(lbPrice, hboxRange);
        // Center align
        panePrice.setAlignment(Pos.CENTER);
    }

    private void cboLowHandler() {
        // Set selected low price
        selectedLowPrice = cboLow.getValue();
    }

    private void cboHighHandler() {
        // Set selected high price
        selectedHighPrice = cboHigh.getValue();
    }
}
