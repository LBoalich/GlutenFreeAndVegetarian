package view;

import javafx.scene.control.Button;

public class Clear {
    private Button btClear;

    public Clear() {
        clear();
    }

    public Button getClearButton() {
        return this.btClear;
    }

    private void clear() {
        // Create clear button
        btClear = new Button("Clear Filter");
        // Add event handler
        btClear.setOnAction(e -> btClearEventHandler());
    }

    private void btClearEventHandler() {
        // Set filter toggle buttons to not selected
        App.filter.deselectAllButtons();
        // Clear previous category selections
        App.category.clearCategory();
        // Deselct neighborhood selections
        App.neighborhood.clearNeighborhood();
        // Clear price selections
        App.price.clearCboLow();
        App.price.clearCboHigh();
        // Clear hours
        App.hours.clearHours();
        // Clear specials
        App.specials.clearSpecials();
        // Clear refine
        App.refine.clearRefine();
    }
}
