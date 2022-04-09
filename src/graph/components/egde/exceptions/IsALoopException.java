package graph.components.egde.exceptions;

public class IsALoopException extends Exception{
    public IsALoopException() {
        super("Para criar uma aresta desse tipo voce deve ter dois vertices diferentes.");
    }

    public IsALoopException(String message) {
        super(message);
    }
}
