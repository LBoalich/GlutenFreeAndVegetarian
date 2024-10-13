package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Filter {
    private VBox paneFilter;
    private ToggleButton btCategory;
    private ToggleButton btNieghborhood;
    private ToggleButton btPrice;
    private ToggleButton btHours;
    private ToggleButton btSpecials;
    
    public Filter() {
        filter();
    }

    public VBox getFilterPane() {
        return this.paneFilter;
    }

    /* Create filter method */
    private void filter() {
        // Create vbox 
        paneFilter = new VBox(10);
        // Set to center alignment
        paneFilter.setAlignment(Pos.CENTER);

        // Create filter label
        Label label = new Label("Filter");
        // Add filter label to grid
        paneFilter.getChildren().add(label);

        //Create vbox
        VBox vbox = new VBox(10);
        // Center alignment
        vbox.setAlignment(Pos.CENTER);

        // Create category button
        btCategory = new ToggleButton("Category");
        // Add category button to grid
        vbox.getChildren().add(btCategory);
        // Set preferred width
        btCategory.setPrefWidth(100);
        // Add event handler
        btCategory.setOnAction(e -> handler(App.category.getCategoryPane()));
        
        // Create neighborhood button
        btNieghborhood = new ToggleButton("Neighborhood");
        // Add neighborhood button to grid
        vbox.getChildren().add(btNieghborhood);
        // Set preferred width
        btNieghborhood.setPrefWidth(100);
        // Add event handler
        btNieghborhood.setOnAction(e -> handler(App.neighborhood.getNeighborhoodPane()));

        // Create price button
        btPrice = new ToggleButton("Price");
        // Add price button to grid
        vbox.getChildren().add(btPrice);
        // Set preferred width
        btPrice.setPrefWidth(100);
        // Set event handler
        btPrice.setOnAction(e -> handler(App.price.getPricePane()));

        // Create hours button
        btHours = new ToggleButton("Hours");
        // Add hours button to grid
        vbox.getChildren().add(btHours);
        // Set preferred width
        btHours.setPrefWidth(100);
        // Set event handler
        btHours.setOnAction(e -> handler(App.hours.getHoursPane()));

        // Create specials button
        btSpecials = new ToggleButton("Specials");
        // Add specials button to grid
        vbox.getChildren().add(btSpecials);
        // Set preferred width
        btSpecials.setPrefWidth(100);
        // Set event handler
        btSpecials.setOnAction(e -> handler(App.specials.getSpecialsPane()));

        // Create hbox for clear button
        HBox hboxClearButton = new HBox();
        // Add clear button to pane
        hboxClearButton.getChildren().add(App.btClear.getClearButton());
        // Center align
        hboxClearButton.setAlignment(Pos.CENTER);
        // Add padding
        hboxClearButton.setPadding(new Insets(10));
        // Add clear pane to vbox
        vbox.getChildren().add(hboxClearButton);

        //Add flow pane to vbox
        paneFilter.getChildren().add(vbox);
    }

    // Toggle buttons handler
    private void handler(Pane pane) {
        // Toggles pane visibility
        App.refine.toggle(pane);
    }

    public boolean isCategorySelected() {
        return this.btCategory.isSelected();
    }

    public boolean isNeighborhoodSelected() {
        return this.btNieghborhood.isSelected();
    }

    public boolean isPriceSelected() {
        return this.btPrice.isSelected();
    }

    public boolean isHoursSelected() {
        return this.btHours.isSelected();
    }

    public boolean isSpecialsSelected() {
        return this.btSpecials.isSelected();
    }

    public void deselectCategoryButton() {
        this.btCategory.setSelected(false);
    }

    public void deselectNeighborhoodButton() {
        this.btNieghborhood.setSelected(false);
    }

    public void deselectPriceButton() {
        this.btPrice.setSelected(false);
    }

    public void deselectHoursButton() {
        this.btHours.setSelected(false);
    }

    public void deselectSpecialsButton() {
        this.btSpecials.setSelected(false);
    }

    public void deselectAllButtons() {
        deselectCategoryButton();
        deselectNeighborhoodButton();
        deselectPriceButton();
        deselectHoursButton();
        deselectSpecialsButton();
    }
}
