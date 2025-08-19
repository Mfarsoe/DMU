/*
 * Chat message with sender, recipient and the message text.
 */
public class Message {
    private final String to;
    private final String from;
    private final String message;

    /*
     * Constructor for Message with following parameters:
     * to       = recipient
     * from     = sender
     * message  = text of the message
     */
    public Message(String to, String from, String message) {
        this.to = to;
        this.from = from;
        this.message = message;
    }

    //Checks if message is addressed to the given user. Used in ClientManager.getMessages();
    public boolean isTo(String user) {
        return to.equals(user);
    }

    //Returns formatted version of the message with sender + message text
    public String getMessage() {
        return "From " + from + ": " + message;
    }
}
