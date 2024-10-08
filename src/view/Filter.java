package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Filter {
    private VBox paneFilter;
    private Button btCategory;
    private Button btNieghborhood;
    private Button btPrice;
    private Button btHours;
    private Button btSpecials;
    private Refine refine;
    
    public Filter(Refine refine) {
        this.refine = refine;
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

        //Create flow pane
        FlowPane flow = new FlowPane();
        // Set flow pane preferred width
        flow.setMaxWidth(350);
        // Center alignment
        flow.setAlignment(Pos.CENTER);
        // Set hgap
        flow.setHgap(15);
        // Set vgap
        flow.setVgap(10);

        // Create category button
        btCategory = new Button("Category");
        // Add category button to grid
        flow.getChildren().add(btCategory);
        // Set preferred width
        btCategory.setPrefWidth(100);
        // Add event handler
        btCategory.setOnAction(e -> handler(refine.getCategoryPane()));
        
        // Create neighborhood button
        btNieghborhood = new Button("Neighborhood");
        // Add neighborhood button to grid
        flow.getChildren().add(btNieghborhood);
        // Set preferred width
        btNieghborhood.setPrefWidth(100);
        // Add event handler
        btNieghborhood.setOnAction(e -> handler(refine.getNeighborhoodPane()));

        // Create price button
        btPrice = new Button("Price");
        // Add price button to grid
        flow.getChildren().add(btPrice);
        // Set preferred width
        btPrice.setPrefWidth(100);
        // Set event handler
        btPrice.setOnAction(e -> handler(refine.getPricePane()));

        // Create hours button
        btHours = new Button("Hours");
        // Add hours button to grid
        flow.getChildren().add(btHours);
        // Set preferred width
        btHours.setPrefWidth(100);
        // Set event handler
        btHours.setOnAction(e -> handler(refine.getHoursPane()));

        // Create specials button
        btSpecials = new Button("Specials");
        // Add specials button to grid
        flow.getChildren().add(btSpecials);
        // Set preferred width
        btSpecials.setPrefWidth(100);
        // Set event handler
        btSpecials.setOnAction(e -> handler(refine.getSpecialsPane()));

        //Add flow pane to vbox
        paneFilter.getChildren().add(flow);
    }

    private void handler(Pane pane) {
        refine.toggle(pane);
    }
}
