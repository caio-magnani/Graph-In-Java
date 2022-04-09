package graph.components.egde.exceptions;

public class NotALoopException extends Exception {

    public NotALoopException() {
        super("Para ser Loop precisa de 2 vertices iguais. Os vertices são difetentes");
    }

    public NotALoopException(String message) {
        super(message);
    }
    
}
