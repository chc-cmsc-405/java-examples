/**
 * A custom UNCHECKED exception for programming errors.
 *
 * Extends RuntimeException, so callers are NOT required
 * to handle it. This represents a bug, not a recoverable condition.
 */
public class InvalidAccountException extends RuntimeException {

    public InvalidAccountException(String message) {
        super(message);
    }
}
