package com.example.demo.eventTest.buttonDemo;

import java.util.EventListener;

public interface ClickEventListener extends EventListener {
    void click(ClickEvent e);
}