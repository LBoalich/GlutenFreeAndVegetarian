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

public class Monday {
    private HBox hboxMonday;
    private CheckBox cbMonday;
    private ComboBox<String> cboMondayOpen;
    private ComboBox<String> cboMondayClose;
    private String mondayOpen;
    private String mondayClose;

    public Monday() {
        monday();
    }

    public Pane getMondayPane() {
        return this.hboxMonday;
    }

    public boolean getMondaySelected() {
        return this.cbMonday.isSelected();
    }

    public String getMondayOpen() {
        return this.mondayOpen;
    }

    public String getMondayClose() {
        return this.mondayClose;
    }

    private void monday() {
        // Create open time observable list
        ObservableList<String> mondayOpenHoursList = FXCollections.observableArrayList(HoursGui.HOURS_ARRAY);
        // Create clost time observable list
        ObservableList<String> mondayCloseHoursList = FXCollections.observableArrayList(HoursGui.HOURS_ARRAY);
        
        // Create hbox for Monday
        hboxMonday = new HBox(20);

        // Create Monday checkbox
        cbMonday = new CheckBox("Monday");
        cbMonday.setMinWidth(100);
        // Add handler
        cbMonday.setOnAction(e -> cbMondayHandler());

        // Create Monday open and close combo boxes 
        cboMondayOpen = new ComboBox<>(mondayOpenHoursList);
        cboMondayClose = new ComboBox<>(mondayCloseHoursList);
        // Add event handlers
        cboMondayOpen.setOnAction(e -> cboMondayOpenHandler());
        cboMondayClose.setOnAction(e -> cboMondayCloseHandler());

        // Create labels for combos
        Label lbMondayOpen = new Label("Open From", cboMondayOpen);
        Label lbMondayClose = new Label("Open To", cboMondayClose);
        // Place combos to right of label
        lbMondayOpen.setContentDisplay(ContentDisplay.RIGHT);
        lbMondayClose.setContentDisplay(ContentDisplay.RIGHT);

        // Add labels to hbox
        hboxMonday.getChildren().addAll(cbMonday, lbMondayOpen, lbMondayClose);
        // Set alignment
        hboxMonday.setAlignment(Pos.CENTER);
    }

    private void cboMondayOpenHandler() {
        this.mondayOpen = cboMondayOpen.getValue();
    }

    private void cboMondayCloseHandler() {
        this.mondayClose = cboMondayClose.getValue();
    }

    private void cbMondayHandler() {
        if (cbMonday.isSelected()) {
            this.mondayOpen = cboMondayOpen.getValue();
            this.mondayClose = cboMondayClose.getValue();
        }
        else {
            this.clearMonday();
        }
    }

    public void clearMonday() {
        this.cbMonday.selectedProperty().setValue(false);
        this.cboMondayOpen.getSelectionModel().clearSelection();
        this.cboMondayClose.getSelectionModel().clearSelection();
        this.mondayOpen = this.cboMondayOpen.getValue();
        this.mondayClose = this.cboMondayClose.getValue();
    }
}
