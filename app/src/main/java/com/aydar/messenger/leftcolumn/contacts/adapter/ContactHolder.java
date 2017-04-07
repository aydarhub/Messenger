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

    private ImageView mLetterFavourite;
    private TextView mLetter;
    private ImageView mIcon;
    private TextView mName;
    private LinearLayout mItemLayout;

    public ContactHolder(View itemView) {
        super(itemView);
        mLetterFavourite = (ImageView) itemView.findViewById(R.id.contact_item_letter_favourite);
        mLetter = (TextView) itemView.findViewById(R.id.contact_item_letter);
        mIcon = (ImageView) itemView.findViewById(R.id.contact_item_icon);
        mName = (TextView) itemView.findViewById(R.id.contact_item_name);
        mItemLayout = (LinearLayout) itemView.findViewById(R.id.contact_item);
    }

    public void setLetterFavourite(Bitmap letterFavourite) {
        mLetterFavourite.setImageBitmap(letterFavourite);
    }

    public void setLetter(String letter) {
        mLetter.setText(letter);
    }

    public void clearLetter() {
        mLetter.setText("");
    }

    public void setIcon(Bitmap icon) {
        mIcon.setImageBitmap(icon);
    }

    public void setName(String name) {
        mName.setText(name);
    }

    public void clearUnderline(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mItemLayout.setBackgroundColor(context.getResources().getColor(R.color.colorWhite, null));
        } else {
            mItemLayout.setBackgroundColor(context.getResources().getColor(R.color.colorWhite));
        }
    }

    public void setItemUnderline() {
        mItemLayout.setBackgroundResource(R.drawable.contact_underline);
    }

}
