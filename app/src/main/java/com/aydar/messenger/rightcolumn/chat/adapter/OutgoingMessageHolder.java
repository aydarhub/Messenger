package com.aydar.messenger.rightcolumn.chat.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.aydar.messenger.R;

class OutgoingMessageHolder extends RecyclerView.ViewHolder {

    private TextView mTimeOutgoing;
    private TextView mTextOutgoing;

    OutgoingMessageHolder(View itemView) {
        super(itemView);
        mTimeOutgoing = (TextView) itemView.findViewById(R.id.outgoing_message_time);
        mTextOutgoing = (TextView) itemView.findViewById(R.id.outgoing_message_text);
    }

    public TextView getTimeIncoming() {
        return mTimeOutgoing;
    }

    public TextView getTextIncoming() {
        return mTextOutgoing;
    }

}
