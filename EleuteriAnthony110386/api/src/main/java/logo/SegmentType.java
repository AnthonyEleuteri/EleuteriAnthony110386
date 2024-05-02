package logo;

import java.util.function.Supplier;
import java.util.stream.IntStream;

/**
 * Enumerazione che ci permette di distinguere i due tipi di segmenti esistenti
 */
public enum SegmentType {


    /**
     * Un segmento di tipo STRAIGHT indica un'entità che è parte di una
     * retta compresa tra due punti detti estremi
     */
    STRAIGHT( () -> IntStream.range(0, 1) ),

    /**
     * Un semento di tipo CURVE è un segmento con i due estremi che si
     * trovano su una curva
     */
    CURVE( () -> IntStream.range(1, 181) );

    /**
     * Supplier che prende IntStream che saranno in range
     */
    private final Supplier<IntStream> range;

    /**
     * Costruttore che mi permette di associare al segmento di tipo straight anche il suo raggio.
     * @param range curvatura
     */
    SegmentType(Supplier<IntStream> range) {
        this.range = range;
    }

    /**
     *
     * @return il range in interi
     */
    public IntStream getRange(){
        return this.range.get();
    }

    /**
     * Un segmento può essere curvo se e solo se ha un raggio>0 viceversa per un segmento rettilineo
     *
     * @param radius raggio della curvatura
     * @return TRUE se il segmento è valido
     */

    public boolean isValid(int radius){
        return((this == STRAIGHT)&&(radius == 0)) || ((this == CURVE)&&(radius>0));
    }

}

