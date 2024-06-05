package painter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private ToggleGroup color;

    @FXML
    private RadioButton pen;

    @FXML
    private RadioButton eraser;

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Color selectedColor = Color.BLACK;

        if (pen.isSelected()) {
            selectedColor = Color.BLACK;
        } else if (eraser.isSelected()) {
            selectedColor = Color.WHITE;
        }

        Circle newCircle = new Circle(event.getX(), event.getY(), 4, selectedColor);
        drawingAreaPane.getChildren().add(newCircle);
    }

    @FXML
    void drawingAreaMousePressed(MouseEvent event) {
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
        drawingAreaPane.getChildren().add(newCircle);
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

}
