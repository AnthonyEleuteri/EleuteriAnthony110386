package logo;

import java.awt.*;

import static java.util.Objects.requireNonNull;

/**
 * Implementazione dell'interfaccia cursore, classe che ci permette di
 * avere un oggetto capace di disegnare in un'area di disegno personalizzata
 */
public class DefaultCursor implements Cursor{

    private DefaultPoint actualPos;
    private Direction actualDir;
    private Color actualColorLine;
    private Color actualColorArea;
    private int penSize;
    private boolean plot = false;
    private boolean isPenDown = true;
    public static final Direction DEFAULT_DIRECTION = new Direction(0);
    public static final Color DEFAULT_AREA_COLOR = Color.WHITE;
    public static final Color DEFAULT_LINE_COLOR = Color.BLACK;
    private  static DefaultPoint HOME = new DefaultPoint(600.0/2,400.0/2);

    /**
     * Costruttore con una HOME personalizzata su un'area di disegno
     * con dimensioni personalizzate
     * @param home il nuovo punto HOME della tartaruga
     */
    public DefaultCursor(DefaultPoint home){
        this.actualPos = home;
        HOME = home;
        this.actualDir = DEFAULT_DIRECTION;
        this.actualColorArea = DEFAULT_AREA_COLOR;
        this.actualColorLine = DEFAULT_LINE_COLOR;
        this.penSize = 1;
    }

    public DefaultCursor(){
        this.actualPos = HOME;
        this.actualDir = DEFAULT_DIRECTION;
        this.actualColorLine = DEFAULT_LINE_COLOR;
        this.actualColorArea = DEFAULT_AREA_COLOR;
        this.penSize = 1;
    }


    @Override
    public void setPosition(DefaultPoint pos) {
        requireNonNull(pos);
        this.actualPos = pos;
        this.plot = false;
    }
    @Override
    public DefaultPoint getPosition() {
        return this.actualPos;
    }
    @Override
    public void setDirection(Direction direction) {
        this.actualDir = direction;
    }
    @Override
    public Direction getDirection() {
        return this.actualDir;
    }
    @Override
    public void setColorLine(int r, int g, int b) {
        this.actualColorLine = new Color(r,g,b);
    }
    @Override
    public Color getColorLine() {
        return this.actualColorLine;
    }
    @Override
    public void setColorArea(int r, int g, int b) {
        this.actualColorArea = new Color(r,g,b);
    }
    @Override
    public Color getColorArea() {
        return this.actualColorArea;
    }
    @Override
    public boolean getPlot() {
        return this.plot;
    }
    @Override
    public void setPlot(boolean plot){
        this.plot = true;
    }
    @Override
    public void setPenSize(int size){
        if (size < 1){
            throw new IllegalArgumentException("Pen Size should be at least 1");
        }
        this.penSize = size;
    }
    @Override
    public int getPenSize(){
        return this.penSize;
    }
    @Override
    public void setDir(Direction actualDir) {
        this.actualDir = actualDir;
    }
    @Override
    public Direction getActualDir() {
        return actualDir;
    }
    @Override
    public boolean isPenDown() {
        return this.isPenDown;
    }
    @Override
    public void setPenUp() {
        this.isPenDown = false;
    }
    @Override
    public void setPenDown() {
        this.isPenDown = true;
    }

    public static DefaultPoint getHOME() {
        return HOME;
    }
}

