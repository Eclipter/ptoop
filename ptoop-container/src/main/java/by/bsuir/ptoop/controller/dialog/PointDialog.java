package by.bsuir.ptoop.controller.dialog;

import by.bsuir.ptoop.model.Figure;
import by.bsuir.ptoop.model.Point;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PointDialog extends AbstractDialog<Figure> {

    private TextField x;
    private TextField y;

    public PointDialog() {

        this.setTitle("Add Point");
        ButtonType drawButton = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
        this.getDialogPane().getButtonTypes().addAll(drawButton, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        x = new TextField();
        x.setPromptText("x");
        y = new TextField();
        y.setPromptText("y");

        grid.add(x, 0, 0);
        grid.add(y, 0, 1);

        this.getDialogPane().setContent(grid);

        this.setResultConverter(button ->
        {
            if(button == drawButton)
            {
                return new Point(Integer.parseInt(x.getText()), Integer.parseInt(y.getText()));
            }
            return null;
        });
    }

    public PointDialog(Figure figure) {
        Point point = (Point) figure;
        x.setText(String.valueOf(point.getX()));
        y.setText(String.valueOf(point.getY()));
    }
}
