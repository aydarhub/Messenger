package com.aydar.messenger.rightcolumn.chat.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aydar.messenger.R;

class MessagesHolder extends RecyclerView.ViewHolder {

    private TextView mDay;
    private TextView mTimeIncoming;
    private TextView mTextIncoming;
    private TextView mTimeOutgoing;
    private TextView mTextOutgoing;
    private LinearLayout mIncomingMessageLayout;
    private LinearLayout mOutgoingMessageLayout;
    private LinearLayout mMessagesDateLayout;

    MessagesHolder(View itemView) {
        super(itemView);
        mIncomingMessageLayout = (LinearLayout) itemView.findViewById(R.id.incoming_message);
        mOutgoingMessageLayout = (LinearLayout) itemView.findViewById(R.id.outgoing_message);
        mMessagesDateLayout = (LinearLayout) itemView.findViewById(R.id.date_messages);
        mDay = (TextView) itemView.findViewById(R.id.messages_date);
        mTimeIncoming = (TextView) itemView.findViewById(R.id.incoming_message_time);
        mTextIncoming = (TextView) itemView.findViewById(R.id.incoming_message_text);
        mTimeOutgoing = (TextView) itemView.findViewById(R.id.outgoing_message_time);
        mTextOutgoing = (TextView) itemView.findViewById(R.id.outgoing_message_text);
    }

    public TextView getDay() {
        return mDay;
    }

    public TextView getTimeIncoming() {
        return mTimeIncoming;
    }

    public TextView getTextIncoming() {
        return mTextIncoming;
    }

    public TextView getTimeOutgoing() {
        return mTimeOutgoing;
    }

    public TextView getTextOutgoing() {
        return mTextOutgoing;
    }

    public LinearLayout getIncomingMessageLayout() {
        return mIncomingMessageLayout;
    }

    public LinearLayout getOutgoingMessageLayout() {
        return mOutgoingMessageLayout;
    }

    public LinearLayout getMessagesDateLayout() {
        return mMessagesDateLayout;
    }
}
