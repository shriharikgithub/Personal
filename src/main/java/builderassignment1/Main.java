package builderassignment1;

public class Main {
    public static void main(String[] args) {
        Message m = Message.getMessageBuilder()
                .setMessageType(MessageType.IMAGE)
                .setContent("c")
                .setDeliverted(true)
                .setRecipient("r")
                .setTimestamp(123)
                .build();
        System.out.println(m);
    }
}
