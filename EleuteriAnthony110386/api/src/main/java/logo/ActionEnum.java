package logo;

/**
 * ENUM di tutte e sole le possibili Azioni
 */
public enum ActionEnum {

    FORWARD("BACKWARD"), BACKWARD("BACKWARD"),

    LEFT("LEFT"), RIGHT("RIGHT"),

    CLEARSCREEN("CLEARSCREEN"),

    HOME("HOME"),

    PENUP("PENUP"), PENDOWN("PENDOWN"),

    SETPENCOLOR("SETPENCOLOR"), SETFILLCOLOR("SETFILLCOLOR"), SETSCREENCOLOR("SETSCREENCOLOR"), SETPENSIZE("SETPENSIZE"),

    REPEAT("REPEAT");


    private final String name;
    ActionEnum(String s) {
        this.name = s;
    }

    public String getName() {
        return name;
    }
}
