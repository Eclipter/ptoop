package by.bsuir.ptoop.controller.module;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Menu;

public class DrawingModuleContainer {

    private Menu menu;
    private GraphicsContext context;

    public DrawingModuleContainer(Menu menu, GraphicsContext context) {
        this.menu = menu;
        this.context = context;
    }

    public void addModule(DrawingModule module)
    {
        menu.getItems().add(module.getMenuItem());
        module.getDrawer().setGraphicsContext(context);
    }
}
