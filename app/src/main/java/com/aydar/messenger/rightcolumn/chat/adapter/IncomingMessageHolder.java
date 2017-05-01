package com.aydar.messenger.rightcolumn.chat.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aydar.messenger.R;

class IncomingMessageHolder extends RecyclerView.ViewHolder {

    private TextView mTimeIncoming;
    private TextView mTextIncoming;

    IncomingMessageHolder(View itemView) {
        super(itemView);
        mTimeIncoming = (TextView) itemView.findViewById(R.id.incoming_message_time);
        mTextIncoming = (TextView) itemView.findViewById(R.id.incoming_message_text);
    }

    public TextView getTimeIncoming() {
        return mTimeIncoming;
    }

    public TextView getTextIncoming() {
        return mTextIncoming;
    }

}
