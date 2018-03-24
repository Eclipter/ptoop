package by.bsuir.ptoop.controller.module;

import by.bsuir.ptoop.model.FigureList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Menu;

public class DrawingModuleContainer {

    private Menu menu;
    private GraphicsContext context;
    private FigureList figureList;

    public DrawingModuleContainer(Menu menu, GraphicsContext context) {
        this.menu = menu;
        this.context = context;
        this.figureList = new FigureList();
    }

    public void addModule(DrawingModule module)
    {
        menu.getItems().add(module.getMenuItem());
        module.getDrawer().setGraphicsContext(context);
        module.setFigures(figureList);
    }

    public FigureList getFigureList() {
        return figureList;
    }
}
