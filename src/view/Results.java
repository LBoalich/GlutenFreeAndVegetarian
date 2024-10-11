package view;

import model.Restaurant;
import java.util.TreeSet;

import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class Results {
    private TreeSet<Restaurant> results;
    private VBox paneResults;
    public static Button btBack;

    public Results() {
        results();
    }

    public Results(TreeSet<Restaurant> resultsTree) {
        this.results = resultsTree;
        results();
    }

    public VBox getResultsPane() {
        return this.paneResults;
    }

    private void results() {
        // Create results vbox
        paneResults = new VBox(20);

        // Create results label
        Label lbResults = new Label("Results");

        // Create results flow pane
        FlowPane fpResults = new FlowPane();
        // Set hgap
        fpResults.setHgap(30);
        // Set vgap
        fpResults.setVgap(20);
        // Center algin
        fpResults.setAlignment(Pos.CENTER);
        // Populate flow pane
        if (!results.contains(null)) {
            for (Restaurant restaurant : results) {
                // Get restaurant info
                String name = restaurant.getName();
                String category = restaurant.getCategory();
                String neighborhood = restaurant.getNeighborhood();
                int lowPrice = restaurant.getLowPrice();
                int highPrice = restaurant.getHighPrice();

                // Create info labels
                Label lbName = new Label(name);
                Label lbCategory = new Label(category);
                Label lbNeighborhood = new Label(neighborhood);
                Label lbPrice = new Label("Price Range: " + Integer.toString(lowPrice) + " to " + Integer.toString(highPrice));

                // Create restaurant hbox
                VBox vbox = new VBox(5);
                // Add labels
                vbox.getChildren().addAll(lbName, lbCategory, lbNeighborhood, lbPrice);
                // Set alignment
                vbox.setAlignment(Pos.CENTER);
                // Change cursor on hover
                vbox.setOnMouseEntered(e -> mouseEnterHandler());
                vbox.setOnMouseExited(e -> mouseExitHandler());
                // Add click event handler
                vbox.setOnMouseClicked(e -> clickHandler(name));
                // Add to flow pane
                fpResults.getChildren().add(vbox);
            }
        }
        else {
            // Create no results label
            Label lbNoResults = new Label("No Matching Restaurants");
            // Add to flow pane
            fpResults.getChildren().add(lbNoResults);
        }

        // Add label and fp to vbox
        paneResults.getChildren().addAll(lbResults, fpResults);
        // Center align
        paneResults.setAlignment(Pos.CENTER);

        // Make back button visible
        App.btBack.setVisible(true);
    }

    private void clickHandler(String name) {
        // Update restaurant gui
        App.restaurantGUI.setRestaurant(name);
        // Add pane to main pane
        App.mainPane.setCenter(App.restaurantGUI.getRestaurantPane());
    }

    private void mouseEnterHandler() {
        paneResults.setCursor(Cursor.HAND);
    }

    private void mouseExitHandler() {
        paneResults.setCursor(Cursor.DEFAULT);
    }
}
