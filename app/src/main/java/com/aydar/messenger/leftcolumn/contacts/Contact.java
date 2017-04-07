package com.aydar.messenger.leftcolumn.contacts;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.aydar.messenger.R;

import java.util.UUID;

public class Contact {
    private UUID mId;
    private Bitmap mIcon;
    private String mName;

   public Contact(Context context, String name) {
        mId = UUID.randomUUID();
        mIcon = BitmapFactory.decodeResource(context.getResources(), R.drawable.contact_icon);
        mName = name;
    }

    public UUID getId() {
        return mId;
    }

    public Bitmap getIcon() {
        return mIcon;
    }

    public String getName() {
        return mName;
    }
}
