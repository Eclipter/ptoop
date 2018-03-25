package by.bsuir.ptoop.controller.dialog;

import by.bsuir.ptoop.model.Figure;
import by.bsuir.ptoop.model.Line;
import by.bsuir.ptoop.model.Point;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LineDialog extends AbstractDialog<Figure> {

    private TextField aX;
    private TextField aY;
    private TextField bX;
    private TextField bY;

    public LineDialog() {

        this.setTitle("Add Line");
        ButtonType drawButton = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
        this.getDialogPane().getButtonTypes().addAll(drawButton, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        aX = new TextField();
        aX.setPromptText("x1");
        aY = new TextField();
        aY.setPromptText("y1");
        bX = new TextField();
        bX.setPromptText("x2");
        bY = new TextField();
        bY.setPromptText("y2");

        grid.add(aX, 0, 0);
        grid.add(aY, 0, 1);
        grid.add(bX, 1, 0);
        grid.add(bY, 1, 1);

        this.getDialogPane().setContent(grid);

        this.setResultConverter(button ->
        {
            if(button == drawButton)
            {
                return new Line(new Point(Integer.parseInt(aX.getText()), Integer.parseInt(aY.getText())),
                        new Point(Integer.parseInt(bX.getText()), Integer.parseInt(bY.getText())));
            }
            return null;
        });
    }

    public LineDialog(Figure figure) {
        this();
        Line line = (Line) figure;
        aX.setText(String.valueOf(line.getA().getX()));
        aY.setText(String.valueOf(line.getA().getY()));
        bX.setText(String.valueOf(line.getB().getX()));
        bY.setText(String.valueOf(line.getB().getY()));
    }
}
