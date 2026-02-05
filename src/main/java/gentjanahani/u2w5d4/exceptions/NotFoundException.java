package gentjanahani.u2w5d4.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long idItems) {
        super("Elemento con id " + idItems + " non trovato.");
    }
}
