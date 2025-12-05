package com.example.AlrorithmHW;

public class ElementNotFoundException extends RuntimeException {
    public ElementNotFoundException() {
        super("Element not found in list");
    }

    public ElementNotFoundException(String message) {
        super(message);
    }
}
