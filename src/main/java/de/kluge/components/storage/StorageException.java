package de.kluge.components.storage;

public class StorageException extends RuntimeException {

	private static final long serialVersionUID = 7465898785153790888L;

	public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
