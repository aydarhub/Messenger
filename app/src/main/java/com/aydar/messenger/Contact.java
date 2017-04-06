package com.aydar.messenger;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.aydar.messenger.R;

import java.util.UUID;

class Contact {
    private UUID mId;
    private Bitmap mIcon;
    private String mName;

    Contact(Context context, String name) {
        mId = UUID.randomUUID();
        mIcon = BitmapFactory.decodeResource(context.getResources(), R.drawable.contact_icon);
        mName = name;
    }

    public UUID getId() {
        return mId;
    }

    Bitmap getIcon() {
        return mIcon;
    }

    public String getName() {
        return mName;
    }
}
