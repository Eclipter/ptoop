package by.bsuir.ptoop.controller.module;

import by.bsuir.ptoop.controller.AbstractDrawer;
import by.bsuir.ptoop.controller.DrawerChain;
import by.bsuir.ptoop.model.Figure;
import by.bsuir.ptoop.model.FigureList;
import javafx.scene.control.MenuItem;

import java.util.Optional;

public abstract class DrawingModule {

    protected DrawerChain drawerChain;
    protected Optional<AbstractDrawer> drawer = Optional.empty();
    protected MenuItem menuItem;
    protected FigureList figures;

    public DrawingModule() {
    }

    public DrawingModule(String menuText) {
        this.menuItem = new MenuItem(menuText);
    }

    public void draw(Figure figure)
    {
        drawerChain.draw(figure);
        figures.add(figure);
    }

    public DrawerChain getDrawerChain() {
        return drawerChain;
    }

    public void setDrawerChain(DrawerChain drawerChain) {
        this.drawerChain = drawerChain;
    }

    public Optional<AbstractDrawer> getDrawer() {
        return drawer;
    }

    public void setDrawer(AbstractDrawer drawer) {
        this.drawer = Optional.of(drawer);
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public FigureList getFigures() {
        return figures;
    }

    public void setFigures(FigureList figures) {
        this.figures = figures;
    }
}
