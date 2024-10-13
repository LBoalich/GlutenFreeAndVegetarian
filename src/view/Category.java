package view;

import model.Restaurant;
import model.RestaurantsData;
import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class Category {
    private VBox paneCategory;
    private ArrayList<String> selectedCategories = new ArrayList<>();
    private ArrayList<Restaurant> categoryMatches = new ArrayList<>();

    public Category() {
        category();
    }

    public VBox getCategoryPane() {
        return this.paneCategory;
    }

    public ArrayList<Restaurant> getCategoryMatches() {
        return this.categoryMatches;
    }

    private void category() {      
        // Create category vbox
        paneCategory = new VBox(10);

        // Create category label
        Label lbCateogry = new Label("Categories");

        // Create category flow pane
        FlowPane fpCategory = new FlowPane();
        // Add cateogry buttons
        for (String category : RestaurantsData.RESTAURANTS.getCategories()) {
            ToggleButton btCategory = new ToggleButton(category);
            btCategory.setPrefWidth(100);
            fpCategory.getChildren().add(btCategory);
            // Add handler
            btCategory.setOnAction(e -> btCategoryHandler(category));
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

    // Cateogry button event handler
    private void btCategoryHandler(String categtory) {
        if (selectedCategories.contains(categtory)) {
            selectedCategories.remove(categtory);
        }
        else {
            selectedCategories.add(categtory);
        }
        // Clear previous matches
        categoryMatches.clear();
        // If selections not empty
        if (!selectedCategories.isEmpty()) {
            // Find new matches
            categoryMatches.addAll(RestaurantsData.RESTAURANTS.categoryMatch(selectedCategories));
            
        }
    }
}
