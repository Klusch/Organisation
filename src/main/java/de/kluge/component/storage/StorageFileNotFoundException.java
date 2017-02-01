package de.kluge.component.storage;

public class StorageFileNotFoundException extends StorageException {

	private static final long serialVersionUID = -7188774440344806114L;

	public StorageFileNotFoundException(String message) {
        super(message);
    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}