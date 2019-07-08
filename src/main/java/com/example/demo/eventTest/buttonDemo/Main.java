package com.example.demo.eventTest.buttonDemo;

/**
 * @author fulj
 * @date 2019年07月08日 1:43 PM
 */
public class Main {
    public static void main(String[] args) {
        EventSource source = new EventSource();
        try {
            source.addListener((e) -> System.out.println("Click event performed!"));
            source.actionPerformed();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
