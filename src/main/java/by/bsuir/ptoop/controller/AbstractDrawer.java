package by.bsuir.ptoop.controller;

import by.bsuir.ptoop.model.Figure;
import javafx.scene.canvas.GraphicsContext;

public abstract class AbstractDrawer
{
    private GraphicsContext graphicsContext;
    private AbstractDrawer nextDrawer;

    public AbstractDrawer() {
    }

    public AbstractDrawer(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
    }

    public abstract boolean supports(Figure figure);

    public void draw(Figure figure)
    {
        if(!supports(figure))
        {
            nextDrawer.draw(figure);
        }
        else
        {
            drawFigure(figure);
        }
    }

    public abstract void drawFigure(Figure figure);

    public GraphicsContext getGraphicsContext() {
        return graphicsContext;
    }

    public void setGraphicsContext(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
    }

    public AbstractDrawer getNextDrawer() {
        return nextDrawer;
    }

    public void setNextDrawer(AbstractDrawer nextDrawer) {
        this.nextDrawer = nextDrawer;
    }
}
