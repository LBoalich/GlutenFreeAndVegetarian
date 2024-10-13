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
        App.mainPane.setCenter(backStack.pop());
        btBackVisibility();
    }

    private void btBackVisibility() {
        if (backStack.isEmpty()) {
            btBack.setVisible(false);
        }
        else {
            btBack.setVisible(true);
        }
    }

    public void addPane(Pane pane) {
        backStack.push(pane);
        btBackVisibility();
    }
}
