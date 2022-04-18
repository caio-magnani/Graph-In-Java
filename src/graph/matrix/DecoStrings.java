package graph.matrix;

public class DecoStrings {

    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String BLUE = "\u001B[34m";
    public static final String YELLOW = "\u001B[33m";
    public static final String RED = "\u001B[31m";
    public static final String BLACK = "\u001B[30m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    public static String sameLength(String str, int length) {
        int i = 0;
        while (str.length() < length) {
            if (i % 2 == 0) {
                str = " " + str;
            } else {
                str += " ";
            }
            i++;
        }
        return str;
    }

    public static String GREEN(String str) {
        return GREEN + str + RESET;
    }

    public static String BLUE(String str) {
        return BLUE + str + RESET;
    }

    public static String YELLOW(String str) {
        return YELLOW + str + RESET;
    }

    public static String RED(String str) {
        return RED + str + RESET;
    }

    public static String BLACK(String str) {
        return BLACK + str + RESET;
    }

    public static String PURPLE(String str) {
        return PURPLE + str + RESET;
    }

    public static String CYAN(String str) {
        return CYAN + str + RESET;
    }

    public static String WHITE(String str) {
        return WHITE + str + RESET;
    }
}
