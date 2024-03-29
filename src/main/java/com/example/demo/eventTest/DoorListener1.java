package com.example.demo.eventTest;

/**
 * 该类为 门1监听接口的实现，做具体的开门，关门动作
 */


public class DoorListener1 implements DoorListener {
    @Override
    public void doorEvent(DoorEvent event) {
        // TODO Auto-generated method stub
        if (event.getDoorState() != null && event.getDoorState().equals("open")) {
            System.out.println("门1打开");
        } else {
            System.out.println("门1关闭");
        }
    }

}

/**

 * 该类为 门2监听接口的实现，做具体的开门，关门，以及开灯，关灯动作
 */
class DoorListener2 implements DoorListener {

    @Override
    public void doorEvent(DoorEvent event) {
        // TODO Auto-generated method stub
        if (event.getDoorState() != null && event.getDoorState().equals("open")) {
            System.out.println("门2打开，同时打开走廊的灯");
        } else {
            System.out.println("门2关闭，同时关闭走廊的灯");
        }
    }

}