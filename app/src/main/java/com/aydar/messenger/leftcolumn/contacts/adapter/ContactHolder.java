package com.aydar.messenger.leftcolumn.contacts.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aydar.messenger.R;

public class ContactHolder extends RecyclerView.ViewHolder {

    private ImageView mIcon;
    private TextView mName;
    private LinearLayout mItemLayout;

    public ContactHolder(View itemView) {
        super(itemView);
        mIcon = (ImageView) itemView.findViewById(R.id.contact_item_icon);
        mName = (TextView) itemView.findViewById(R.id.contact_item_name);
        mItemLayout = (LinearLayout) itemView.findViewById(R.id.contact_item);
    }

    public void setIcon(Bitmap icon) {
        mIcon.setImageBitmap(icon);
    }

    public void setName(String name) {
        mName.setText(name);
    }


}
