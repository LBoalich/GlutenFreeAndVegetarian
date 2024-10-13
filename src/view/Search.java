package view;

import model.Restaurant;
import model.RestaurantsData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class Search {
    private HBox paneSearch;
    private ObservableList<String> namesList;
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
        // Create the pane
        paneSearch = new HBox();
        // Set alignment
        paneSearch.setAlignment(Pos.CENTER);
    
        // Get list view items
        namesList = FXCollections.observableArrayList(RestaurantsData.RESTAURANTS.getNames());
        // Create combo box to choose a restaurant
        cboSearch = new ComboBox<>(namesList);
        // Add cbo event handler
        cboSearch.setOnAction(e -> cboHandler());

        // Create combo box label
        Label lbSearch = new Label("Search", cboSearch);
        lbSearch.setContentDisplay(ContentDisplay.RIGHT);
        // Add padding
        lbSearch.setPadding(new Insets(0, 20, 20, 20));

        // Add search cbo to pane
        paneSearch.getChildren().add(lbSearch);
    }

    private void cboHandler() {
        // Get user selection
        String name = cboSearch.getValue();
        // Get matching restaurant
        Restaurant restaurant = RestaurantsData.RESTAURANTS.nameMatch(name);
        // Add current pane to back button stack
        App.btBack.addPane((Pane) App.mainPane.getCenter());
        // Update main page
        App.mainPane.setCenter(new RestaurantGui(restaurant).getRestaurantPane());
    }
}
