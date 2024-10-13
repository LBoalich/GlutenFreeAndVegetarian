package view;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.TextAlignment;
import model.Restaurant;

public class RestaurantGui {
    private Restaurant restaurant;
    private BorderPane paneRestaurant;

    public RestaurantGui() {
        restaurant();
    }

    public RestaurantGui(Restaurant restaurant) {
        this.restaurant = restaurant;
        restaurant();
    }

    public BorderPane getRestaurantPane() {
        return this.paneRestaurant;
    }

    public Restaurant getRestaurant() {
        return this.restaurant;
    }

    private void restaurant() {
        // Create border pane
        paneRestaurant = new BorderPane();
        // Create restaurant label
        Label lbRestaurant = new Label(restaurant.toString());
        // Set text alaign
        lbRestaurant.setTextAlignment(TextAlignment.CENTER);
        // Add to pane
        paneRestaurant.setCenter(lbRestaurant);
    }
}
