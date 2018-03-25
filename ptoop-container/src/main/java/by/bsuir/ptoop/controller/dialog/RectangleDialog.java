package by.bsuir.ptoop.controller.dialog;

import by.bsuir.ptoop.model.Figure;
import by.bsuir.ptoop.model.Point;
import by.bsuir.ptoop.model.Rectangle;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class RectangleDialog extends AbstractDialog<Figure> {

    private TextField oX;
    private TextField oY;
    private TextField width;
    private TextField height;

    public RectangleDialog() {

        this.setTitle("Add Rectangle");
        ButtonType drawButton = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
        this.getDialogPane().getButtonTypes().addAll(drawButton, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        oX = new TextField();
        oX.setPromptText("x");
        oY = new TextField();
        oY.setPromptText("y");
        width = new TextField();
        width.setPromptText("width");
        height = new TextField();
        height.setPromptText("height");

        grid.add(oX, 0, 0);
        grid.add(oY, 0, 1);
        grid.add(width, 1, 0);
        grid.add(height, 1, 1);

        this.getDialogPane().setContent(grid);

        this.setResultConverter(button ->
        {
            if(button == drawButton)
            {
                return new Rectangle(new Point(Integer.parseInt(oX.getText()), Integer.parseInt(oY.getText())),
                        Integer.parseInt(width.getText()), Integer.parseInt(height.getText()));
            }
            return null;
        });
    }

    public RectangleDialog(Figure figure) {
        this();
        Rectangle rectangle = (Rectangle) figure;
        oX.setText(String.valueOf(rectangle.getA().getX()));
        oY.setText(String.valueOf(rectangle.getA().getY()));
        width.setText(String.valueOf(rectangle.getWidth()));
        height.setText(String.valueOf(rectangle.getHeight()));
    }
}
