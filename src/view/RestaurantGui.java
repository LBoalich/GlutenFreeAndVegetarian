package view;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.TextAlignment;
import model.Restaurant;
import model.RestaurantsData;

public class RestaurantGui {
    private Restaurant restaurant;
    private BorderPane paneRestaurant;
    private Label lbRestaurant;

    public RestaurantGui() {
        restaurant();
    }

    public RestaurantGui(Restaurant restaurant) {
        this.restaurant = restaurant;
        restaurant();
        this.lbRestaurant.setText(this.restaurant.toString());
    }

    public BorderPane getRestaurantPane() {
        return this.paneRestaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
        this.lbRestaurant.setText(restaurant.toString());
    }

    public void setRestaurant(String name) {
        this.restaurant = RestaurantsData.restaurants.nameMatch(name);
        setRestaurant(restaurant);
    }

    private void restaurant() {
        // Create border pane
        paneRestaurant = new BorderPane();

        // Create restaurant label
        lbRestaurant = new Label();
        // Set text alaign
        lbRestaurant.setTextAlignment(TextAlignment.CENTER);
        // Add to pane
        paneRestaurant.setCenter(lbRestaurant);
    }
}
