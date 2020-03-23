package com.paradise.all4me.pattern.observe;

public interface Subject {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObserver(String msg);

}
