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
import java.util.ArrayList;
import java.util.Collections;

public class Saturday {
    private HBox hboxSaturday;
    private CheckBox cbSaturday;
    private ArrayList<String> allHours;
    private ObservableList<String> saturdayOpenHoursList;
    private ObservableList<String> saturdayCloseHoursList;
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
        // Create all hours array list
        allHours = new ArrayList<>();
        // Add all hours
        Collections.addAll(allHours, HoursGui.HOURS_ARRAY);
        // Create open time observable list
        saturdayOpenHoursList = FXCollections.observableArrayList(HoursGui.HOURS_ARRAY);
        // Create clost time observable list
        saturdayCloseHoursList = FXCollections.observableArrayList(HoursGui.HOURS_ARRAY);
        
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
        cboSaturdayOpen.setOnAction(e -> cboSaturdayOpenHandler(cboSaturdayOpen.getValue()));
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

    private void cboSaturdayOpenHandler(String open) {
        // Set selected value
        this.saturdayOpen = open;
        // Find index of selected time
        int openIndex = allHours.indexOf(open);
        if (openIndex >= 0) {
            // Create new list for close
            ArrayList<String> newCloseList = new ArrayList<>();
            newCloseList.addAll(allHours.subList(openIndex, allHours.size()));
            // Update close observable list to only keep new times
            saturdayCloseHoursList.retainAll(newCloseList);
        }
        else {
            // Set close hours to all hours
            saturdayCloseHoursList.clear();
            saturdayCloseHoursList.addAll(allHours);
        }
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
