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

public class Wednesday {
    private HBox hboxWednesday;
    private CheckBox cbWednesday;
    private ArrayList<String> allHours;
    private ObservableList<String> wednesdayOpenHoursList;
    private ObservableList<String> wednesdayCloseHoursList;
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
        // Create all hours array list
        allHours = new ArrayList<>();
        // Add all hours
        Collections.addAll(allHours, HoursGui.HOURS_ARRAY);
        // Create open time observable list
        wednesdayOpenHoursList = FXCollections.observableArrayList(HoursGui.HOURS_ARRAY);
        // Create clost time observable list
        wednesdayCloseHoursList = FXCollections.observableArrayList(HoursGui.HOURS_ARRAY);
        
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
        cboWednesdayOpen.setOnAction(e -> cboWednesdayOpenHandler(cboWednesdayOpen.getValue()));
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

    private void cboWednesdayOpenHandler(String open) {
        // Set selected value
        this.wednesdayOpen = open;
        // Find index of selected time
        int openIndex = allHours.indexOf(open);
        if (openIndex >= 0) {
            // Create new list for close
            ArrayList<String> newCloseList = new ArrayList<>();
            newCloseList.addAll(allHours.subList(openIndex, allHours.size()));
            // Update close observable list to only keep new times
            wednesdayCloseHoursList.clear();
            wednesdayCloseHoursList.addAll(newCloseList);
        }
        else {
            // Set close hours to all hours
            wednesdayCloseHoursList.clear();
            wednesdayCloseHoursList.addAll(allHours);
        }
    }

    private void cboWednesdayCloseHandler() {
        // Get selected close time
        this.wednesdayClose = cboWednesdayClose.getValue();
    }

    private void cbWednesdayHandler() {
        // Day selected
        if (cbWednesday.isSelected()) {
            // Get selected times
            this.wednesdayOpen = cboWednesdayOpen.getValue();
            this.wednesdayClose = cboWednesdayClose.getValue();
        }
        // Day not selected
        else {
            // Clear data
            this.clearWednesday();
        }
    }

    public void clearWednesday() {
        // Set checkbox to not selected
        this.cbWednesday.selectedProperty().setValue(false);
        // Clear comboboxes
        this.cboWednesdayOpen.getSelectionModel().clearSelection();
        this.cboWednesdayClose.getSelectionModel().clearSelection();
        // Clear previous selections
        this.wednesdayOpen = this.cboWednesdayOpen.getValue();
        this.wednesdayClose = this.cboWednesdayClose.getValue();
    }
}
