/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ST10360090 Tshembhani Trust Valoyi
 */
import java.util.Random;

public class Message {
    private String messageID;
    private int messageNum;
    private String recipient;
    private String messageText;
    private String messageHash;

    public Message(int messageNum, String recipient, String messageText) {
        this.messageID = generateMessageID();
        this.messageNum = messageNum;
        this.recipient = recipient;
        this.messageText = messageText;
        this.messageHash = createMessageHash();
    }

    private String generateMessageID() {
        Random rand = new Random();
        long id = 1000000000L + (long)(rand.nextDouble() * 8999999999L);
        return String.valueOf(id);
    }

    public boolean checkMessageID() {
        return this.messageID.length() == 10;
    }

    public boolean checkRecipientCell() {
        return this.recipient.length() <= 10 && this.recipient.startsWith("+");
    }

    public String createMessageHash() {
        String[] words = messageText.split(" ");
        String first = words[0];
        String last = words[words.length - 1];
        return messageID.substring(0, 2) + ":" + messageNum + ":" + (first + last).toUpperCase();
    }

    public String SentMessage(String choice) {
        return switch (choice.toLowerCase()) {
            case "send" -> "Message successfully sent.";
            case "disregard" -> "Press 0 to delete message.";
            case "store" -> "Message successfully stored.";
            default -> "Invalid option.";
        };
    }

    public String printMessages() {
        return String.format("ID: %s\nHash: %s\nTo: %s\nMsg: %s", messageID, messageHash, recipient, messageText);
    }

    public static void storeMessageToJson(List<Message> messages, String filename) {
        // Implement JSON writing here (Gson / Jackson)
    }

    public int returnTotalMessages() {
        return messageNum;
    }

    public String getMessageID() {
        return messageID;
    }

    public String getMessageHash() {
        return messageHash;
    }
}