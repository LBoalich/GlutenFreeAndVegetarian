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

public class Saturday {
    private HBox hboxSaturday;
    private CheckBox cbSaturday;
    private ComboBox<String> cboSaturdayOpen;
    private ComboBox<String> cboSaturdayClose;
    private String saturdayOpen;
    private String saturdayClose;

    public Saturday() {
        saturday();
    }

    public Pane getSaturdayPane() {
        return this.hboxSaturday;
    }

    public boolean getSaturdaySelected() {
        return this.cbSaturday.isSelected();
    }

    public String getSaturdayOpen() {
        return this.saturdayOpen;
    }

    public String getSaturdayClose() {
        return this.saturdayClose;
    }

    private void saturday() {
        // Create open time observable list
        ObservableList<String> saturdayOpenHoursList = FXCollections.observableArrayList(HoursGui.HOURS_ARRAY);
        // Create clost time observable list
        ObservableList<String> saturdayCloseHoursList = FXCollections.observableArrayList(HoursGui.HOURS_ARRAY);
        
        // Create hbox for Saturday
        hboxSaturday = new HBox(20);

        // Create Saturday checkbox
        cbSaturday = new CheckBox("Saturday");
        cbSaturday.setMinWidth(100);
        // Add handler
        cbSaturday.setOnAction(e -> cbSaturdayHandler());

        // Create Saturday open and close combo boxes 
        cboSaturdayOpen = new ComboBox<>(saturdayOpenHoursList);
        cboSaturdayClose = new ComboBox<>(saturdayCloseHoursList);
        // Add event handlers
        cboSaturdayOpen.setOnAction(e -> cboSaturdayOpenHandler());
        cboSaturdayClose.setOnAction(e -> cboSaturdayCloseHandler());

        // Create labels for combos
        Label lbSaturdayOpen = new Label("Open From", cboSaturdayOpen);
        Label lbSaturdayClose = new Label("Open To", cboSaturdayClose);
        // Place combos to right of label
        lbSaturdayOpen.setContentDisplay(ContentDisplay.RIGHT);
        lbSaturdayClose.setContentDisplay(ContentDisplay.RIGHT);

        // Add labels to hbox
        hboxSaturday.getChildren().addAll(cbSaturday, lbSaturdayOpen, lbSaturdayClose);
        // Set alignment
        hboxSaturday.setAlignment(Pos.CENTER);
    }

    private void cboSaturdayOpenHandler() {
        this.saturdayOpen = cboSaturdayOpen.getValue();
    }

    private void cboSaturdayCloseHandler() {
        this.saturdayClose = cboSaturdayClose.getValue();
    }

    private void cbSaturdayHandler() {
        if (cbSaturday.isSelected()) {
            this.saturdayOpen = cboSaturdayOpen.getValue();
            this.saturdayClose = cboSaturdayClose.getValue();
        }
        else {
            this.clearSaturday();
        }
    }

    public void clearSaturday() {
        this.cbSaturday.selectedProperty().setValue(false);
        this.cboSaturdayOpen.getSelectionModel().clearSelection();
        this.cboSaturdayClose.getSelectionModel().clearSelection();
        this.saturdayOpen = this.cboSaturdayOpen.getValue();
        this.saturdayClose = this.cboSaturdayClose.getValue();
    }
}
