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

public class Sunday {
    private HBox hboxSunday;
    private CheckBox cbSunday; 
    private ArrayList<String> allHours;
    private ObservableList<String> sundayOpenHoursList;
    private ObservableList<String> sundayCloseHoursList;
    private ComboBox<String> cboSundayOpen;
    private ComboBox<String> cboSundayClose;
    private String sundayOpen;
    private String sundayClose;

    public Sunday() {
        sunday();
    }

    public Pane getSundayPane() {
        return this.hboxSunday;
    }

    public boolean getSundaySelected() {
        return this.cbSunday.isSelected();
    }

    public String getSundayOpen() {
        return this.sundayOpen;
    }

    public String getSundayClose() {
        return this.sundayClose;
    }

    private void sunday() {
        // Create all hours array list
        allHours = new ArrayList<>();
        // Add all hours
        Collections.addAll(allHours, HoursGui.HOURS_ARRAY);
        // Create open time observable list
        sundayOpenHoursList = FXCollections.observableArrayList(HoursGui.HOURS_ARRAY);
        // Create clost time observable list
        sundayCloseHoursList = FXCollections.observableArrayList(HoursGui.HOURS_ARRAY);

        // Create hbox
        hboxSunday = new HBox(20);

        // Create Sunday checkbox
        cbSunday = new CheckBox("Sunday");
        cbSunday.setMinWidth(100);
        // Add handler
        cbSunday.setOnAction(e -> cbSundayHandler());
       
        // Create open and close combo boxes 
        cboSundayOpen = new ComboBox<>(sundayOpenHoursList);
        cboSundayClose = new ComboBox<>(sundayCloseHoursList);
        // Add event handlers
        cboSundayOpen.setOnAction(e -> cboSundayOpenHandler(cboSundayOpen.getValue()));
        cboSundayClose.setOnAction(e -> cboSundayCloseHandler());

        // Create labels for combos
        Label lbSundayOpen = new Label("Open From", cboSundayOpen);
        Label lbSundayClose = new Label("Open To", cboSundayClose);
        // Place combos to right of label
        lbSundayOpen.setContentDisplay(ContentDisplay.RIGHT);
        lbSundayClose.setContentDisplay(ContentDisplay.RIGHT);

        // Add labels to hbox
        hboxSunday.getChildren().addAll(cbSunday, lbSundayOpen, lbSundayClose);
        // Set alignment
        hboxSunday.setAlignment(Pos.CENTER);

    }

    private void cboSundayOpenHandler(String open) {
        // Set selected value
        this.sundayOpen = open;
        // Find index of selected time
        int openIndex = allHours.indexOf(open);
        if (openIndex >= 0) {
            // Create new list for close
            ArrayList<String> newCloseList = new ArrayList<>();
            newCloseList.addAll(allHours.subList(openIndex, allHours.size()));
            // Update close observable list to only keep new times
            sundayCloseHoursList.clear();
            sundayCloseHoursList.addAll(newCloseList);
        }
        else {
            // Set close hours to all hours
            sundayCloseHoursList.clear();
            sundayCloseHoursList.addAll(allHours);
        }
    }

    private void cboSundayCloseHandler() {
        this.sundayClose = cboSundayClose.getValue();
    }

    private void cbSundayHandler() {
        if (cbSunday.isSelected()) {
            this.sundayOpen = cboSundayOpen.getValue();
            this.sundayClose = cboSundayClose.getValue();
        }
        else {
            this.clearSunday();
        }
    }

    public void clearSunday() {
        this.cbSunday.selectedProperty().setValue(false);
        this.cboSundayOpen.getSelectionModel().clearSelection();
        this.cboSundayClose.getSelectionModel().clearSelection();
        this.sundayOpen = this.cboSundayOpen.getValue();
        this.sundayClose = this.cboSundayClose.getValue();
    }
}
