import java.util.ArrayList;
import java.util.List;

/*
 * TOPIC: Observer pattern
 * Analogy: You subscribe to a channel and get notified on new uploads.
 */
public class ObserverPatternDemo {
    interface Observer { void update(String msg); }
    static class Subscriber implements Observer {
        private final String name;
        Subscriber(String name) { this.name = name; }
        @Override public void update(String msg) { System.out.println(name + " got: " + msg); }
    }
    static class Channel {
        private final List<Observer> observers = new ArrayList<>();
        void subscribe(Observer o) { observers.add(o); }
        void publish(String msg) { for (Observer o : observers) o.update(msg); }
    }

    public static void main(String[] args) {
        Channel ch = new Channel(); // Subject maintains observer list to broadcast events.
        ch.subscribe(new Subscriber("Ana")); // Register listener so it receives updates.
        ch.publish("Beginner lesson uploaded"); // Trigger notification to all subscribers.

        ch.subscribe(new Subscriber("Ben"));
        ch.publish("Intermediate challenge uploaded");

        System.out.println("Pro: observer decouples sender from many receivers.");
    }
}

/*
 * Pitfalls: memory leaks from never unsubscribing, notification storms, synchronous slow observers blocking publisher.
 * Practice: stock price alerts, chat room notifications, UI event listeners.
 */

