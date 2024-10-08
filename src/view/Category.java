package view;

import model.Restaurants;
import model.RestaurantsData;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class Category {
    private VBox paneCategory;

    public Category() {
        category();
    }

    public VBox getCategoryPane() {
        return this.paneCategory;
    }

    private void category() {
        // Get restaurants
        Restaurants restaurants = RestaurantsData.restaurants;
        
        // Create category vbox
        paneCategory = new VBox(10);

        // Create category label
        Label lbCateogry = new Label("Categories");

        // Create category flow pane
        FlowPane fpCategory = new FlowPane();
        // Add cateogry buttons
        for (String category : restaurants.getCategories()) {
            Button btCategory = new Button(category);
            btCategory.setPrefWidth(100);
            fpCategory.getChildren().add(btCategory);
        }
        // Center align buttons
        fpCategory.setAlignment(Pos.CENTER);
        // Set hgap and vgap
        fpCategory.setHgap(10);
        fpCategory.setVgap(5);

        // Add all to vbox
        paneCategory.getChildren().addAll(lbCateogry, fpCategory);
        // Center align children
        paneCategory.setAlignment(Pos.CENTER);
    }
}
