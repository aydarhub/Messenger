package com.aydar.messenger.rightcolumn.chat;

import java.util.UUID;

public class Message {
    private UUID mId;
    private boolean mIsIncoming;
    private String mDay;
    private String mTime;
    private String mText;

    public Message(boolean isIncoming, String text, String day, String time) {
        mId = UUID.randomUUID();
        mIsIncoming = isIncoming;
        mText = text;
        mDay = day;
        mTime = time;
    }

    public UUID getId() {
        return mId;
    }

    public boolean isIncoming() {
        return mIsIncoming;
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
