package logo;


import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class DefaultArea implements Area{


    private double base = 600;
    private double height = 400;
    private Color backgroundColor = DEFAULT_BACKGROUND_COLOR;
    private static final Color DEFAULT_BACKGROUND_COLOR = Color.WHITE;
    private DefaultPoint HOME = new DefaultPoint(base/2, height/2);
    private ActionEnum lastAction;
    private final DefaultCursor associatedDefaultCursor;
    private final LinkedList<Segment> draw;
    private final List<polygon> closedAreas;


    public DefaultArea(){
        this.associatedDefaultCursor = new DefaultCursor();
        this.draw = new LinkedList<>();
        this.closedAreas = new ArrayList<>();
    }

    /**
     * Costruttore personalizzato che ci permette di creare un'area di disegno con
     * base, altezza e colore di sfondo personalizzati
     *
     * @param base dimensione della base dell'area di disegno
     * @param height dimensione dell'altezza dell'area di disegno
     * @param rRGB quantità di colore rosso di background dell'area di disegno
     * @param gRGB quantità di colore verde di background dell'area di disegno
     * @param bRGB  quantità di colore blue di background dell'area di disegno
     */
    public DefaultArea(int base, int height, int rRGB, int gRGB, int bRGB) {
        setBase(base);
        setHeight(height);
        setHome();
        setBackGroundColor(rRGB, gRGB, bRGB);

        this.associatedDefaultCursor = new DefaultCursor(HOME);
        this.draw = new LinkedList<>();
        this.closedAreas = new ArrayList<>();
    }

    public void setTurtlePosition(DefaultPoint pos){
        if (!isAValidPosition(pos)) {
            throw new IllegalArgumentException();
        }
        this.associatedDefaultCursor.setPosition(pos);
    }

    @Override
    public void setHome() {
        this.HOME = new DefaultPoint(getX()/2, getY()/2);
    }

    @Override
    public void setBase(int x) {
        this.base = x;
    }

    @Override
    public void setHeight(int y) {
        this.height = y;
    }

    @Override
    public double getX() {
        return this.base;
    }

    @Override
    public double getY() {
        return this.height;
    }

    @Override
    public void setBackGroundColor(int r, int g, int b) {
        this.backgroundColor = new Color(r, g, b);
    }

    @Override
    public Color getBackGroundColor() {
        return this.backgroundColor;
    }

   @Override
    public boolean isAValidPosition(DefaultPoint pos) {
        return (pos.getX() <= getX())&&(pos.getY() <= getY());
    }

    public void draw(DefaultPoint startingPoint, DefaultPoint endingPoint, SegmentType type, int radius){
        associatedDefaultCursor.setPlot(this.draw.add(new Segment(startingPoint, endingPoint, type, getAssociatedCursor().getDirection(), radius, associatedDefaultCursor.getColorLine(), associatedDefaultCursor.getPenSize())));
            //scanAndAddToClosedAreas();
            if (thereIsAClosedArea()){
                closedAreas.add(new polygon(findPolygon(),getAssociatedCursor().getColorArea()));
            }
        }

    /**
     * Metodo che controlla se nella nostra lista di segmenti si è creato un poligono
     *
     *
     * @return una LinkedList di tutti e soli i segmenti che hanno creato un'area chiusa
     */
    private LinkedList<Segment> findPolygon() {


        return new LinkedList<>();
    }

    /**
     * Metodo che che controlla se nella nostra lista di segmenti si è creato un poligono
     *
     * @return TRUE se si è creato un poligono, FALSE altrimenti
     */
    private boolean thereIsAClosedArea() {
        if (draw.size() < 3) return false;

        boolean found = false;

        for (int i = 0; i < draw.size(); i++) {
            DefaultPoint position = draw.get(i).p1();

            for (Segment segment : draw) {
                if (!position.equals(segment.p1())) {
                    return found;
                }
                position = segment.p2();
            }
            if(found = position.equals(draw.get(0).p1())){
                addToClosedArea(i);
            }
        }
        return found;
    }


    private void addToClosedArea(int i) {
        LinkedList<Segment> temp = new LinkedList<>();

        for (int j = i;j < draw.size();j++) {
            temp.add(draw.get(j));
            draw.get(j).setIsTaken();
            draw.remove(j);
        }

        closedAreas.add(new polygon(temp, associatedDefaultCursor.getColorArea()));

    }

    @Override
    public void clearScreen() {
        this.draw.clear();
        this.closedAreas.clear();
    }

    @Override
    public DefaultCursor getAssociatedCursor() {
        return associatedDefaultCursor;
    }
    @Override
    public void setLastAction(ActionEnum lastAction){
        this.lastAction = lastAction;
    }
    @Override
    public ActionEnum getLastAction() {
        return lastAction;
    }

    /**
     * Metodo che ci permette di avere la lista di tutti i segmenti che sono stati disegnati
     * in questa area di disegno
     *
     * @return lista di tutti i segmenti che sono stati disegnati nell'area
     */
    public LinkedList<Segment> getDraw() {
        return draw;
    }

    /**
     * Metodo che ci permette di avere la lista di tutti i poligoni che si sono creati
     * in questa area di disegno
     *
     * @return lista di tutti i poligono che si sono creati nell'area
     */
    public List<polygon> getClosedAreas() {
        return closedAreas;
    }

}

