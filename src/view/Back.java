package view;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import java.util.Stack;

public class Back {
    private Button btBack;
    private Stack<Pane> backStack;

    public Back() {
        back();
    }

    public Button getBackButton() {
        return this.btBack;
    }

    private void back() {
        // Create back button
        btBack = new Button("Back");
        // Create stack to hold previous panes
        backStack = new Stack<>();
        // Set back button visibility
        btBackVisibility();
        // Add back button event handler
        btBack.setOnAction(e -> btBackEventHandler());
    }

    private void btBackEventHandler() {
        // Set main pain center to last viewed pane
        App.mainPane.setCenter(backStack.pop());
        // Set back button visibility
        btBackVisibility();
    }

    private void btBackVisibility() {
        // If on start pane
        if (backStack.isEmpty()) {
            // Make back button invisible
            btBack.setVisible(false);
        }
        // There are previous panes to view
        else {
            // Make back button visible
            btBack.setVisible(true);
        }
    }

    public void addPane(Pane pane) {
        // Add pane to back stack
        backStack.push(pane);
        // Set back button visibility
        btBackVisibility();
    }
}
