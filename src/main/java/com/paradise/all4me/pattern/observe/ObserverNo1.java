package com.paradise.all4me.pattern.observe;

public class ObserverNo1 implements Observer {
    @Override
    public void update(String msg) {
        System.out.println(this.getClass().toString());
        System.out.println(msg);
    }
}
