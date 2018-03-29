package by.bsuir.ptoop.controller.drawer;

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

    /**
     * Indicates if this particular drawer can draw this figure
     */
    public abstract boolean supports(Figure figure);

    /**
     * drawing method working according to Chain Of Responsibility pattern
     * @param figure abstract figure to draw
     */
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

    /**
     * Method for drawing figures (putting them to canvas using graphics context class field
     */
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
