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

public class Price {
    private VBox panePrice;

    public Price() {
        price();
    }

    public VBox getPricePance() {
        return this.panePrice;
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
        ComboBox<Integer> cboLow = new ComboBox<>(priceListLow);
        // Create high combo
        ComboBox<Integer> cboHigh = new ComboBox<>(priceListHigh);

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
}
