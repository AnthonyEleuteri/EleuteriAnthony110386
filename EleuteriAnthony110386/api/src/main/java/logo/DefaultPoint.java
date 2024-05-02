package logo;


import java.util.Objects;

/**
 * Gestisce la localizzazione di un singolo punto nell'area di disegno
 */
public  class DefaultPoint implements Point {

    private final double pointX;
    private final double pointY;


    public DefaultPoint(double x, double y){
        this.pointY = y;
        this.pointX = x;
    }

    public double getX(){
        return pointX;
    }

    public double getY(){
        return pointY;
    }


    public boolean equals(Object test) {
        if (test instanceof DefaultPoint point) {
            return (getX() == point.getX()) && (getY() == point.getY());
        }
        return super.equals(test);
    }

    public int hashCode() {
        return Objects.hash(pointX, pointY);
    }
}