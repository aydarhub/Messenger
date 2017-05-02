package com.aydar.messenger.rightcolumn.chat;

import java.util.UUID;

public class Message {

    public static final int CHAT_DATE = 0;
    public static final int INCOMING_MESSAGE = 1;
    public static final int OUTGOING_MESSAGE = 2;

    private UUID mId;
    private int mMessageType;
    private String mDay;
    private String mTime;
    private String mText;

    public Message(int messageType, String text, String day, String time) {
        mId = UUID.randomUUID();
        mMessageType = messageType;
        mText = text;
        mDay = day;
        mTime = time;
    }

    public UUID getId() {
        return mId;
    }

    public int getMessageType() {
        return mMessageType;
    }

    public String getText() {
        return mText;
    }

    public String getDay() {
        return mDay;
    }

    public String getTime() {
        return mTime;
    }
}
