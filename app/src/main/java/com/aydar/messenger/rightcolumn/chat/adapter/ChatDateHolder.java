package com.aydar.messenger.rightcolumn.chat.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.aydar.messenger.R;

class ChatDateHolder extends RecyclerView.ViewHolder {

    private TextView mDate;


    ChatDateHolder(View itemView) {
        super(itemView);
        mDate = (TextView) itemView.findViewById(R.id.chat_date);
    }

    public TextView getDate() {
        return mDate;
    }
}
