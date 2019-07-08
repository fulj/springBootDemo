package com.example.demo.eventTest.buttonDemo;

import java.util.EventObject;

public class ClickEvent extends EventObject {
    private EventSource src;
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ClickEvent(EventSource source) {
        super(source);
        this.src = source;
    }
}
