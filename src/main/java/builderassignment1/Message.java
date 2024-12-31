package builderassignment1;

public class Message {

    private MessageType messageType;
    private String content;
    private String sender;
    private String recipient;
    private boolean isDelivered;
    private long timestamp;

    private Message(MessageBuilder mb) {
        this.messageType = mb.getMessageType();
        this.content = mb.getContent();
        this.sender = mb.getSender();
        this.recipient = mb.getRecipient();
        this.isDelivered = mb.getDelivered();
        this.timestamp = mb.getTimestamp();
    }

    public static MessageBuilder getMessageBuilder() {
        return new MessageBuilder();
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public String getContent() {
        return content;
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public boolean isDelivered() {
        return isDelivered;
    }

    public long getTimestamp() {
        return timestamp;
    }


    @WithBuilder
    static class MessageBuilder {
        private MessageType messageType;
        private String content;
        private String sender;
        private String recipient;
        private boolean isDelivered;
        private long timestamp;

        public Message build() {
            return new Message(this);
        }

        public MessageBuilder setMessageType(MessageType messageType) {
            this.messageType = messageType;
            return this;
        }

        public MessageBuilder setContent(String content) {
            this.content = content;
            return this;
        }

        public MessageBuilder setSender(String sender) {
            this.sender = sender;
            return this;
        }

        public MessageBuilder setRecipient(String recipient) {
            this.recipient = recipient;
            return this;
        }

        public MessageBuilder setDeliverted(boolean isDelivered) {
            this.isDelivered = isDelivered;
            return this;
        }

        public MessageBuilder setTimestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public MessageType getMessageType() {
            return messageType;
        }

        public String getContent() {
            return content;
        }

        public String getSender() {
            return sender;
        }

        public String getRecipient() {
            return recipient;
        }

        public boolean getDelivered() {
            return isDelivered;
        }

        public long getTimestamp() {
            return timestamp;
        }
    }
}