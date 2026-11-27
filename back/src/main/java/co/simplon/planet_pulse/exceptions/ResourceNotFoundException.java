package co.simplon.planet_pulse.exceptions;

/**
 * Exception thrown when an entity does not exist in database
 */
public class ResourceNotFoundException extends RuntimeException {

    /**
     * Constructor
     * @param message name of the resource not found
     */
    public ResourceNotFoundException(String message) {
        super(message + " not found.");
    }
}
