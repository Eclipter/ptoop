package by.bsuir.ptoop.action;

import by.bsuir.ptoop.controller.*;
import by.bsuir.ptoop.model.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    private static final int CANVAS_WIDTH = 600;
    private static final int CANVAS_HEIGHT = 600;
    private static final double LINE_WIDTH = 2.0;
    private static final Color FILL_COLOR = Color.BLACK;

    public static void main(String[] args) {
        Application.launch(args);
    }

    public void start(Stage stage) throws Exception {

        Canvas canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);

        GraphicsContext context = canvas.getGraphicsContext2D();
        context.setLineWidth(LINE_WIDTH);
        context.setFill(FILL_COLOR);

        draw(context);

        Pane root = new Pane();
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        root.getChildren().add(canvas);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("PTOOP lab");
        stage.show();
    }

    private void draw(GraphicsContext context)
    {
        FigureList list = new FigureList();
        list.add(new Point(60, 60));
        list.add(new Line(new Point(240, 230), new Point(320, 360)));
        list.add(new Circle(new Point(440, 340), 50));
        list.add(new Triangle(new Point(70, 70),  new Point(120, 80), new Point(120, 180)));
        list.add(new Ellipse(new Point(460, 250), 40, 60));
        list.add(new Rectangle(new Point(370, 440), 70, 30));

        AbstractDrawer drawer = new PointDrawer(context);
        DrawerChain chain = new DrawerChain(drawer);
        chain.addDrawer(new LineDrawer(context));
        chain.addDrawer(new CircleDrawer(context));
        chain.addDrawer(new EllipseDrawer(context));
        chain.addDrawer(new TriangleDrawer(context));
        chain.addDrawer(new RectangleDrawer(context));

        list.forEach(chain::draw);
    }
}
