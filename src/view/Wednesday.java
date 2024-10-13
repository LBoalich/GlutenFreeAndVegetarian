package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class Wednesday {
    private HBox hboxWednesday;
    private CheckBox cbWednesday;
    private ComboBox<String> cboWednesdayOpen;
    private ComboBox<String> cboWednesdayClose;
    private String wednesdayOpen;
    private String wednesdayClose;

    Wednesday() {
        wednesday();
    }

    public Pane getWednesdayPane() {
        return this.hboxWednesday;
    }

    public boolean getWednesdaySelected() {
        return this.cbWednesday.isSelected();
    }

    public String getWednesdayOpen() {
        return this.wednesdayOpen;
    }

    public String getWednesdayClose() {
        return this.wednesdayClose;
    }

    public void wednesday() {
        // Create open time observable list
        ObservableList<String> wednesdayOpenHoursList = FXCollections.observableArrayList(HoursGui.HOURS_ARRAY);
        // Create clost time observable list
        ObservableList<String> wednesdayCloseHoursList = FXCollections.observableArrayList(HoursGui.HOURS_ARRAY);
        
        // Create hbox for Wednesday
        hboxWednesday = new HBox(20);

        // Create Wednesday checkbox
        cbWednesday = new CheckBox("Wednesday");
        cbWednesday.setMinWidth(100);
        // Add handler
        cbWednesday.setOnAction(e -> cbWednesdayHandler());

        // Create Wednesday open and close combo boxes 
        cboWednesdayOpen = new ComboBox<>(wednesdayOpenHoursList);
        cboWednesdayClose = new ComboBox<>(wednesdayCloseHoursList);
        // Add event handlers
        cboWednesdayOpen.setOnAction(e -> cboWednesdayOpenHandler());
        cboWednesdayClose.setOnAction(e -> cboWednesdayCloseHandler());

        // Create labels for combos
        Label lbWednesdayOpen = new Label("Open From", cboWednesdayOpen);
        Label lbWednesdayClose = new Label("Open To", cboWednesdayClose);
        // Place combos to right of label
        lbWednesdayOpen.setContentDisplay(ContentDisplay.RIGHT);
        lbWednesdayClose.setContentDisplay(ContentDisplay.RIGHT);

        // Add labels to hbox
        hboxWednesday.getChildren().addAll(cbWednesday, lbWednesdayOpen, lbWednesdayClose);
        // Set alignment
        hboxWednesday.setAlignment(Pos.CENTER);
    }

    private void cboWednesdayOpenHandler() {
        this.wednesdayOpen = cboWednesdayOpen.getValue();
    }

    private void cboWednesdayCloseHandler() {
        this.wednesdayClose = cboWednesdayClose.getValue();
    }

    private void cbWednesdayHandler() {
        if (cbWednesday.isSelected()) {
            this.wednesdayOpen = cboWednesdayOpen.getValue();
            this.wednesdayClose = cboWednesdayClose.getValue();
        }
        else {
            this.clearWednesday();
        }
    }

    public void clearWednesday() {
        this.cbWednesday.selectedProperty().setValue(false);
        this.cboWednesdayOpen.getSelectionModel().clearSelection();
        this.cboWednesdayClose.getSelectionModel().clearSelection();
        this.wednesdayOpen = this.cboWednesdayOpen.getValue();
        this.wednesdayClose = this.cboWednesdayClose.getValue();
    }
}
