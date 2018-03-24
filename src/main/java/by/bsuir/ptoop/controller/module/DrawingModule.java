package by.bsuir.ptoop.controller.module;

import by.bsuir.ptoop.controller.AbstractDrawer;
import by.bsuir.ptoop.model.Figure;
import javafx.scene.control.MenuItem;

public abstract class DrawingModule {

    protected AbstractDrawer drawer;
    protected MenuItem menuItem;

    public DrawingModule() {
    }

    public DrawingModule(String menuText) {
        this.menuItem = new MenuItem(menuText);
    }

    public void draw(Figure figure)
    {
        drawer.draw(figure);
    }

    public AbstractDrawer getDrawer() {
        return drawer;
    }

    public void setDrawer(AbstractDrawer drawer) {
        this.drawer = drawer;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }
}
