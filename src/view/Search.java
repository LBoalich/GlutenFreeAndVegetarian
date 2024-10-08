package view;

import model.Restaurants;
import model.RestaurantsData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class Search {
    private HBox paneSearch;
    private ComboBox<String> cboSearch; 

    public Search() {
        search();
    };

    // Get search pane
    public HBox getSearchPane() {
        return this.paneSearch;
    }

    // Get search combobox
    public ComboBox<String> getSerachCBO() {
        return this.cboSearch;
    }

    /* Create the search pane */
    private void search() {
        // Get restaurants
        Restaurants restaurants = RestaurantsData.restaurants;
        // Create the pane
        paneSearch = new HBox();
        // Set alignment
        paneSearch.setAlignment(Pos.CENTER);
    
        // Get list view items
        ObservableList<String> namesList = FXCollections.observableArrayList(restaurants.getNames());
        // Create combo box to choose a restaurant
        this.cboSearch = new ComboBox<>(namesList);

        // Create combo box label
        Label lbSearch = new Label("Search", cboSearch);
        lbSearch.setContentDisplay(ContentDisplay.RIGHT);
        // Add padding
        lbSearch.setPadding(new Insets(0, 20, 30, 20));

        // Add search cbo to pane
        paneSearch.getChildren().add(lbSearch);
    }
}
