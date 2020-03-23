package com.paradise.all4me.pattern.observe;

import java.util.ArrayList;
import java.util.List;

public class SubjectImpl implements Subject {
    protected List<Observer> observerList = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObserver(String msg) {
        for (Observer observer : observerList) {
            observer.update(msg);
        }
    }
}
