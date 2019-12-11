package cz.cvut.fit.miadp.mvcgame.observer;

public interface IObservable {
    void attachObserver( IObserver observer );
    void detachObserver( IObserver observer );
    void notifyObservers();
}