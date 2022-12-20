package com.mandiri.shippoapps.common;

public class Message {
    public static final String MESSAGE_RESPONSE_NOT_FOUND = "%s with id=%d, not Found!";

    public static String generateNotFoundMessage(String entityName, String id){
        return String.format(Message.MESSAGE_RESPONSE_NOT_FOUND, entityName, id);
    }
}
