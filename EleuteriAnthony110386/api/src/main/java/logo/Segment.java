package logo;


import java.awt.*;
import java.util.Objects;

public class Segment {
    /**
     * Oggetto punto di partenza che ci permette di avere coordinate (x ,y) del nostro segmento
     */
    private DefaultPoint startingPoint;
    /**
     * Oggetto punto di fine che ci permette di avere coordinate (x ,y) del nostro segmento.
     */
    private DefaultPoint endingPoint;
    /**
     * Ci permette di sapere se un segmento è rettilineo @STRAIGHT o curvo @CURVE
     */
    private final SegmentType segmentType;
    private final int radius;
    private final Direction dir;
    private boolean isTaken = false;
    private final double length;
    private final int size;
    private final Color myColor;

    /**
     * Costruttore che inizializza un segmento con coordinate (x1,y1) -> (x2,y2)
     *
     * @param x1          ascissa del punto di inizio
     * @param y1          ordinata del punto di inizio
     * @param x2          ascissa del punto di fine
     * @param y2          ordinata del punto di inizio
     * @param type        la tipologia del segmento
     * @param dir         direzione del segmento
     * @param myColor     colore del tratto del segmento
     * @param radius      raggio della curvatura di un segmento curvo
     * @param size        dimensione del tratto di un segmento
     */
    public Segment(int x1, int y1, int x2, int y2, SegmentType type, Direction dir, int radius, Color myColor, int size){
        this.segmentType = type;
        this.radius = radius;
        this.dir = dir;
        setSegment(x1, y1, x2, y2);
        this.myColor = myColor;
        this.length = segmentLength(x1, y1, x2, y2);
        this.size = size;
    }

    /**
     * Costruttore che inizializza un segmento con due punti nel piano
     *
     * @param p1          punto di inizio del segmento
     * @param p2          punto di fine del segmento
     * @param type        la tipologia del segmento
     * @param size        dimensione del tratto di un segmento
     * @param radius      raggio di curvatura di un segmento curvo
     * @param dir         direzione del segmento
     * @param myColor     colore del tratto del segmento
     */
    public Segment(DefaultPoint p1, DefaultPoint p2, SegmentType type, Direction dir, int radius, Color myColor, int size){
        this.segmentType = type;
        this.radius = radius;
        this.dir = dir;
        setSegment(p1,p2);
        this.myColor = myColor;
        this.length = segmentLength(p1.getX(),p1.getY(),p2.getX(),p2.getY());
        this.size = size;
        }

    /**
     * Metodo che ci permette di calcolare la lunghezza del segmento
     *
     * @param x1 Variabile X del punto di inizio del segmento
     * @param y1 Variabile Y del punto di inizio del segmento
     * @param x2 Variabile X del punto di fine del segmento
     * @param y2 Variabile X del punto di fine del segmento
     * @return la lunghezza del segmento
     */
    private double segmentLength(double x1, double y1, double x2, double y2) {
        x1 -= x2;
        y1 -= y2;
        return Math.sqrt(x1*x1 + y1*y1);
    }

    /**
     * Metodo usato dal costruttore che mi permette di nascondere l'implementazione
     *
     * @param p1 punto di inizio del segmento
     * @param p2 punto di fine del segmento
     */
    private void setSegment(DefaultPoint p1, DefaultPoint p2) {
        Objects.requireNonNull(p1);
        Objects.requireNonNull(p2);

        startingPoint = new DefaultPoint(p1.getY(),p1.getX());
        endingPoint = new DefaultPoint(p2.getY(),p2.getX());

    }

    /**
     * Metodo usato dal costruttore che mi permette di nascondere l'implementazione
     *
     * @param x1 ascissa del punto di inizio
     * @param y1 ordinata del punto di inizio
     * @param x2 ascissa del punto di fine
     * @param y2 ordinata del punto di inizio
     */
    private void setSegment(int x1, int y1, int x2, int y2) {
        this.startingPoint = new DefaultPoint(x1,y1);
        this.endingPoint = new DefaultPoint(x2,y2);
    }

    /**
     *
     * @return la coordinata X del punto di inizio
     */
    public double getPoint1X() {
        return startingPoint.getY();
    }

    /**
     *
     * @return la coordinata Y del punto di inizio
     */
    public double getPoint1Y() {
        return startingPoint.getX();
    }

    /**
     *
     * @return la coordinata X del punto di fine
     */
    public double getPoint2X() {
        return endingPoint.getY();
    }

    /**
     *
     * @return la coordinata Y del punto di fine
     */
    public double getPoint2Y() {
        return endingPoint.getX();
    }

    /**
     *
     * @return l'oggetto punto di inizio sul piano
     */
    public DefaultPoint p1(){
        return startingPoint;
    }

    /**
     *
     * @return l'oggetto punto di fine sul piano
     */
    public DefaultPoint p2(){
        return endingPoint;
    }

    /**
     * Metodo che ci restituisce la direzione con cui è stato costruito il nostro segmento
     *
     * @return la direzione con cui è stato costruito il nostro segmento
     */
    public Direction getDir(){
        return this.dir;
    }

    /**
     *  Metodo che ci restituisce il valore che indica il raggio della curvatura del nostro segmento
     *
     * @return il raggio che indica la curvatura del nostro segmento
     */
    public int getRadius(){
        return this.radius;
    }

    /**
     * Metodo che ci restituisce il valore che indica se il segmento fa parte di un poligono
     *
     * @return il valore boolean che indica se il segmento fa parte di un poligono
     */
    public boolean getIsTaken(){
        return this.isTaken;
    }

    /**
     *  Metodo che ci permette di impostare un segmento come parte di un poligono
     */
    public void setIsTaken(){
        this.isTaken = true;
    }

    /**
     * Metodo che ci permette di sapere il colore di un segmento dato.
     *
     * @return il colore del segmento
     */
    public Color getMyColor(){
        return this.myColor;
    }

    /**
     * Metodo che ci permette di avere la lunghezza di un dato segmento
     *
     * @return La lunghezza del dato segmento
     */
    public double getLength() {
        return length;
    }

    /**
     * Metodo che ci permette di avere la dimensione del tratto di un dato segmento
     *
     * @return La dimensione del tratto
     */
    public int getSize() {
        return size;
    }

    /**
     * Metodo che ci permette di avere un Segmento sotto forma di stringa
     *
     * @return Segmento sotto forma di stringa
     * es: LINE <x1> <y1> <x2> <y2> <b1> <b2> <b3> <size>
     */
    public String toString() {
        return startingPoint.toString()
                +"%s"
                +endingPoint.toString()
                +"%s"
                +myColor.getRed()
                +"%s"
                +myColor.getGreen()
                +"%s"
                +myColor.getBlue()
                +"%s"
                + size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Segment segment = (Segment) o;
        return radius == segment.radius &&
                length == segment.length &&
                size == segment.size &&
                startingPoint.equals(segment.startingPoint) &&
                endingPoint.equals(segment.endingPoint) &&
                segmentType == segment.segmentType &&
                dir.equals(segment.dir) &&
                myColor.equals(segment.myColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startingPoint,
                endingPoint,
                segmentType,
                radius,
                dir,
                length,
                myColor,
                size);
    }
}
