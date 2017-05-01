package com.aydar.messenger.rightcolumn.chat.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aydar.messenger.R;
import com.aydar.messenger.rightcolumn.chat.Message;

import java.util.List;

public class MessagesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int CHAT_DATE = 0;
    private static final int INCOMING_MESSAGE = 1;
    private static final int OUTGOING_MESSAGE = 2;

    private List<Message> mMessages;
    private Context mContext;

    public MessagesAdapter(Context context, List<Message> messagesForDays) {
        mContext = context;
        mMessages = messagesForDays;
    }

    @Override
    public int getItemViewType(int position) {
        Message message = mMessages.get(position);
        if (position == 0 || !message.getDay().equals(mMessages.get(position - 1).getDay())) {
            return CHAT_DATE;
        } else if (message.isIncoming()) {
            return INCOMING_MESSAGE;
        } else {
            return OUTGOING_MESSAGE;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        RecyclerView.ViewHolder vh;
        View view;
        switch (viewType) {
            case CHAT_DATE:
                view = inflater.inflate(R.layout.chat_date, parent, false);
                vh = new ChatDateHolder(view);
                break;
            case INCOMING_MESSAGE:
                view = inflater.inflate(R.layout.chat_item_incoming, parent, false);
                vh = new IncomingMessageHolder(view);
                break;
            case OUTGOING_MESSAGE:
                view = inflater.inflate(R.layout.chat_item_outgoing, parent, false);
                vh = new OutgoingMessageHolder(view);
                break;
            default:
                vh = null;
        }

        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Message message = mMessages.get(position);

        switch (this.getItemViewType(position)) {
            case CHAT_DATE:
                ChatDateHolder chatDateHolder = (ChatDateHolder) holder;
                chatDateHolder.getDate().setText(message.getDay());
                break;
            case INCOMING_MESSAGE:
                IncomingMessageHolder incomingMessageHolder = (IncomingMessageHolder) holder;
                incomingMessageHolder.getTimeIncoming().setText(message.getTime());
                incomingMessageHolder.getTextIncoming().setText(message.getText());
                break;
            case OUTGOING_MESSAGE:
                OutgoingMessageHolder outgoingMessageHolder = (OutgoingMessageHolder) holder;
                outgoingMessageHolder.getTimeIncoming().setText(message.getTime());
                outgoingMessageHolder.getTextIncoming().setText(message.getText());
        }
    }

    @Override
    public int getItemCount() {
        return mMessages.size();
    }
}
