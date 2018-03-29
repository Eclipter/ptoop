package by.bsuir.ptoop.action;

import by.bsuir.ptoop.controller.drawer.AbstractDrawer;
import by.bsuir.ptoop.controller.drawer.CircleDrawer;
import by.bsuir.ptoop.controller.drawer.DrawerChain;
import by.bsuir.ptoop.controller.drawer.EllipseDrawer;
import by.bsuir.ptoop.controller.drawer.LineDrawer;
import by.bsuir.ptoop.controller.drawer.PointDrawer;
import by.bsuir.ptoop.controller.drawer.RectangleDrawer;
import by.bsuir.ptoop.controller.drawer.TriangleDrawer;
import by.bsuir.ptoop.controller.editor.EditorChain;
import by.bsuir.ptoop.controller.module.CircleModule;
import by.bsuir.ptoop.controller.module.CustomModuleLoadingModule;
import by.bsuir.ptoop.controller.module.DeserializingModule;
import by.bsuir.ptoop.controller.module.DrawingModule;
import by.bsuir.ptoop.controller.module.DrawingModuleContainer;
import by.bsuir.ptoop.controller.module.EllipseModule;
import by.bsuir.ptoop.controller.module.FigureModifyingModule;
import by.bsuir.ptoop.controller.module.LineModule;
import by.bsuir.ptoop.controller.module.PointModule;
import by.bsuir.ptoop.controller.module.RectangleModule;
import by.bsuir.ptoop.controller.module.SerializingModule;
import by.bsuir.ptoop.controller.module.TriangleModule;
import by.bsuir.ptoop.model.Circle;
import by.bsuir.ptoop.model.Ellipse;
import by.bsuir.ptoop.model.FigureList;
import by.bsuir.ptoop.model.Line;
import by.bsuir.ptoop.model.Point;
import by.bsuir.ptoop.model.Rectangle;
import by.bsuir.ptoop.model.Triangle;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    private static final int CANVAS_WIDTH = 600;
    private static final int CANVAS_HEIGHT = 600;
    private static final double LINE_WIDTH = 2.0;
    private static final Color FILL_COLOR = Color.RED;
    private static final String DRAW_MENU_TEXT = "File";

    public static void main(String[] args) {
        Application.launch(args);
    }

    /**
     * Creates base GUI with menu and canvas
     */
    public void start(Stage stage) throws Exception {

        Canvas canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);

        GraphicsContext context = canvas.getGraphicsContext2D();
        context.setLineWidth(LINE_WIDTH);
        context.setFill(FILL_COLOR);

        FigureList figures = draw(context);

        Pane root = new Pane();
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu(DRAW_MENU_TEXT);
        menuBar.getMenus().add(menu);

        initDrawingContainer(context, menu, figures);

        root.getChildren().add(canvas);
        Scene scene = new Scene(new VBox());
        ((VBox) scene.getRoot()).getChildren().addAll(menuBar, root);
        stage.setScene(scene);
        stage.setTitle("PTOOP lab");
        stage.show();
    }

    /**
     * Initializes drawer and figure editor chain and adds base drawing modules
     * + figure modifying module
     * + serializing/deserializing modules
     * + module for loading custom modules
     */
    private void initDrawingContainer(GraphicsContext context, Menu menu, FigureList figures) {
        DrawerChain chain = new DrawerChain();
        EditorChain editorChain = new EditorChain();
        DrawingModuleContainer container = new DrawingModuleContainer(menu, chain, editorChain, figures, context);
        List<DrawingModule> drawingModules = new ArrayList<>();
        drawingModules.add(new LineModule());
        drawingModules.add(new PointModule());
        drawingModules.add(new CircleModule());
        drawingModules.add(new EllipseModule());
        drawingModules.add(new TriangleModule());
        drawingModules.add(new RectangleModule());
        drawingModules.add(new FigureModifyingModule(context));
        drawingModules.forEach(container::addModule);

        container.addModule(new SerializingModule());
        container.addModule(new DeserializingModule());
        container.addModule(new CustomModuleLoadingModule(container, context));
    }

    /**
     * Creates, draws and returns initial set of figures (result of 1st lab, used for demo
     */
    private FigureList draw(GraphicsContext context)
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
        return list;
    }
}
