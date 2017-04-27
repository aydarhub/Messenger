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

public class MessagesAdapter extends RecyclerView.Adapter<MessagesHolder> {

    private List<Message> mMessages;
    private Context mContext;

    public MessagesAdapter(Context context, List<Message> messagesForDays) {
        mContext = context;
        mMessages = messagesForDays;
    }

    @Override
    public MessagesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.message_item, parent, false);

        return new MessagesHolder(view);
    }

    @Override
    public void onBindViewHolder(MessagesHolder holder, int position) {
        Message message = mMessages.get(position);
        Log.i("Position", Integer.toString(position));

        if (position == 0 || !message.getDay().equals(mMessages.get(position - 1).getDay())) {
            holder.getIncomingMessageLayout().setVisibility(View.GONE);
            holder.getMessagesDateLayout().setVisibility(View.VISIBLE);
            holder.getOutgoingMessageLayout().setVisibility(View.GONE);

            holder.getDay().setText(message.getDay());
        } else if (message.isIncoming()) {
            holder.getIncomingMessageLayout().setVisibility(View.VISIBLE);
            holder.getMessagesDateLayout().setVisibility(View.GONE);
            holder.getOutgoingMessageLayout().setVisibility(View.GONE);

            holder.getTextIncoming().setText(message.getText());
            holder.getTimeIncoming().setText(message.getTime());
        } else {
            holder.getIncomingMessageLayout().setVisibility(View.GONE);
            holder.getMessagesDateLayout().setVisibility(View.GONE);
            holder.getOutgoingMessageLayout().setVisibility(View.VISIBLE);

            holder.getTextOutgoing().setText(message.getText());
            holder.getTimeOutgoing().setText(message.getTime());
        }

    }

    @Override
    public int getItemCount() {
        return mMessages.size();
    }
}
