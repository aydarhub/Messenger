package com.aydar.messenger.rightcolumn.chat;

import android.content.Context;

import com.aydar.messenger.R;
import com.aydar.messenger.leftcolumn.contacts.Contact;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class MessageLab {
    private static MessageLab sMessageLab;

    private List<Message> mMessages;

    public static MessageLab get(Context context) {
        if (sMessageLab == null) {
            sMessageLab = new MessageLab(context);
        }
        return sMessageLab;
    }
    public List<Message> getMessages() {
        return mMessages;
    }

    public Message getMessage(UUID id) {
        for (Message message : mMessages) {
            if (message.getId().equals(id)) {
                return message;
            }
        }
        return null;
    }

    private MessageLab(Context context) {
        mMessages = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            for (int j = 0; j <= 10; j++) {
                Message message = new Message(j % 2 == 0, "Day #" + i + ", Message #" + j, i + " августа, 1997", "12:12");
                mMessages.add(message);
            }
        }
    }

}
