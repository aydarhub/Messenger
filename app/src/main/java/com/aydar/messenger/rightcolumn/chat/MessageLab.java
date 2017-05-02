package com.aydar.messenger.rightcolumn.chat;

import android.content.Context;

import com.aydar.messenger.R;
import com.aydar.messenger.leftcolumn.contacts.Contact;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class MessageLab {

    private static MessageLab sMessageLab;

    private List<List<Message>> mMessages;

    public static MessageLab get(Context context) {
        if (sMessageLab == null) {
            sMessageLab = new MessageLab(context);
        }
        return sMessageLab;
    }
    public List<Message> getMessages() {
        List<Message> messages = new ArrayList<>();
        for (List<Message> ms : mMessages) {
            messages.addAll(ms);
        }
        return messages;
    }

    public void addMessage(Message message) {
        if (mMessages.get(mMessages.size() - 1).get(mMessages.get(mMessages.size() - 1).size() - 1).getDay().equals(message.getDay())) {
            mMessages.get(mMessages.size() - 1).add(message);
        } else {
            mMessages.add(new ArrayList<Message>());
            mMessages.get(mMessages.size() - 1).add(new Message(Message.CHAT_DATE, null, message.getDay(), null));
            mMessages.get(mMessages.size() - 1).add(message);
        }
    }

    private MessageLab(Context context) {
        mMessages = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            Message message = new Message(Message.CHAT_DATE, null, i + " августа, 1997", null);
            mMessages.add(new ArrayList<Message>());
            mMessages.get(mMessages.size() - 1).add(message);
            for (int j = 1; j <= 10; j++) {
                message = new Message(j % 2 == 0 ? Message.INCOMING_MESSAGE : Message.OUTGOING_MESSAGE, "Day #" + i + ", Message #" + j, i + " августа, 1997", "12:122");
                mMessages.get(mMessages.size() - 1).add(message);
            }
        }
    }

}
