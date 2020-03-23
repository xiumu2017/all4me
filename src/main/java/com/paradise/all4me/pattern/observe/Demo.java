package com.paradise.all4me.pattern.observe;

public class Demo {
    public static void main(String[] args) {
        SubjectImpl subject = new SubjectImpl();
        subject.registerObserver(new ObserverNo1());
        subject.registerObserver(new ObserverNo2());
        subject.notifyObserver("Hello~");
    }
}
