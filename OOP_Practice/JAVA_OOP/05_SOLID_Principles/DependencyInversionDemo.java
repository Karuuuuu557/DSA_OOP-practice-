/*
 * TOPIC: DIP (Dependency Inversion Principle)
 * Analogy: Wall socket standard lets appliances swap brands without rewiring the house.
 */
public class DependencyInversionDemo {
    interface MessageSender { void send(String msg); }
    static class EmailSender implements MessageSender {
        @Override public void send(String msg) { System.out.println("Email: " + msg); }
    }
    static class NotificationService {
        private final MessageSender sender;
        NotificationService(MessageSender sender) { this.sender = sender; }
        void notifyUser(String msg) { sender.send(msg); }
    }

    public static void main(String[] args) {
        MessageSender sender = new EmailSender(); // Depend on abstraction, not concrete implementation details.
        NotificationService service = new NotificationService(sender); // Inject dependency to decouple creation and usage.
        service.notifyUser("Beginner hello"); // Works through interface contract.

        service.notifyUser("Intermediate decoupled architecture");
        System.out.println("Pro: swap EmailSender with SmsSender later without touching NotificationService.");
    }
}

/*
 * Pitfalls: new-ing concrete dependencies inside business class, service locator abuse, over-abstraction too early.
 * Practice: payment gateway interface, storage provider abstraction, logger injection.
 */

