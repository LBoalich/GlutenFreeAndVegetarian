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

public class Sunday {
    private HBox hboxSunday;
    private CheckBox cbSunday; 
    private ComboBox<String> cboSundayOpen;
    private ComboBox<String> cboSundayClose;
    private String sundayOpen;
    private String sundayClose;

    Sunday() {
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

    public void sunday() {
        // Create open time observable list
        ObservableList<String> sundayOpenHoursList = FXCollections.observableArrayList(HoursGui.HOURS_ARRAY);
        // Create clost time observable list
        ObservableList<String> sundayCloseHoursList = FXCollections.observableArrayList(HoursGui.HOURS_ARRAY);

        // Create hbox
        hboxSunday = new HBox(20);

        // Create Sunday checkbox
        cbSunday = new CheckBox("Sunday");
        cbSunday.setMinWidth(100);
       
        // Create open and close combo boxes 
        cboSundayOpen = new ComboBox<>(sundayOpenHoursList);
        cboSundayClose = new ComboBox<>(sundayCloseHoursList);
        // Add event handlers
        cboSundayOpen.setOnAction(e -> cboSundayOpenHandler());
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

    private void cboSundayOpenHandler() {
        this.sundayOpen = cboSundayOpen.getValue();
    }

    private void cboSundayCloseHandler() {
        this.sundayClose = cboSundayClose.getValue();
    }
}
