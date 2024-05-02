package logo;

import java.util.Objects;

/**
 * Classe Direzione che mi permette di avere
 */
public class Direction {
    private int direction;

    public Direction(int dir){
        if (!isValid(dir)){
            throw new IllegalArgumentException();
        }
        this.direction = dir;
    }

    /**
     * Metodo che ci permette di sapere se un intero è una direzione valida per la nostra area
     *
     * @param dir direzione che vogliamo testare
     * @return TRUE se la direzione è valida, FALSE altrimenti
     */
    public static boolean isValid(int dir){
        return dir <= 360;
    }

    /**
     * Metodo che ci restituisce la direzione in interi
     *
     * @return l'intero associato alla direzione
     */
    public int getDirectionInDegree(){
        return this.direction;
    }
    @Override
    public int hashCode() {
        return Objects.hash(direction);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction that = (Direction) o;
        return direction == that.direction;
    }

    /**
     * Metodo che data una direzione ci fornisce la direzione opposta
     *
     * @param dir La direzione da cui vogliamo derivare la direzione opposta
     * @return la direzione opposta di 'dir'
     */
    public static Direction oppositeDirection(Direction dir){
        Objects.requireNonNull(dir);
        return new Direction ((dir.getDirectionInDegree() + 180) % 360);
    }

    /**
     * Metodo che ci permette di cambiare l'angolo della nostra direzione
     *
     * @param dir angolo su cui vogliamo impostare la nuova direzione
     */
    public void setDirection(int dir){
        if (isValid(dir)) {
            this.direction = dir;
        }
    }

    /**
     * Metodo utile per l'output del programma su file
     *
     * @return la direzione in stringa
     */
    public String toString() {
        return "direction=" + direction;
    }
}
