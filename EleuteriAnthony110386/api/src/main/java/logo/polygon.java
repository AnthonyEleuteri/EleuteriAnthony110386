package logo;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * A polygon its is a sequence of lines united by the fact that each has the
 * startingPoint = endingPoint of another, a polygon must have at least 3 segments.
 */
public class polygon {

    private final LinkedList<Segment> polygon;
    private final Color polygonColor;
    private final int size;

    public polygon(LinkedList<Segment> draw, Color polygonColor) {
        this.polygon = new LinkedList<>();
        this.polygonColor = polygonColor;
        this.size = draw.size();
        Collections.copy(polygon, draw);
    }

    /**
     * Metodo che ci permette di avere un poligono sotto forma di stringa
     *
     * @return Poligono sotto forma di string
     *
     *      POLYGON <N> <b1> <b2> <b3>
     *      <x 0> <y 0> <fb1 0> <fb2 0> <fb3 0> <size 0>
     *      <x 1> <y 1> <fb1 1> <fb2 1> <fb3 1> <size 1>
     *      …
     *      <x n-1> <y n-1> <fb1 n-1> <fb2 n-1> <fb3 n-1> <size n-1>
     */
    public String toString() {

        List<String> toString = new ArrayList<>();
        toString.add("POLYGON" + "%s" + this.size + "%s" + polygonColor.toString() + "\n");
        for (Segment e : polygon) {
            toString.add(e.toString() + "\n");
        }

        return toString.toString();
    }


    public Color getPolygonColor() {
        return polygonColor;
    }

    public int getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        polygon polygon1 = (polygon) o;
        return size == polygon1.size && Objects.equals(polygon, polygon1.polygon) && Objects.equals(polygonColor, polygon1.polygonColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(polygon, polygonColor, size);
    }

}
