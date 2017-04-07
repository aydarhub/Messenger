package com.aydar.messenger.leftcolumn.contacts;

import android.content.Context;

import com.aydar.messenger.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class ContactLab {
    private static ContactLab sContactLab;

    private List<Contact> mContacts;

    public static ContactLab get(Context context) {
        if (sContactLab == null) {
            sContactLab = new ContactLab(context);
        }
        return sContactLab;
    }
    public List<Contact> getContacts() {
        return mContacts;
    }

    public Contact getContact(UUID id) {
        for (Contact contact : mContacts) {
            if (contact.getId().equals(id)) {
                return contact;
            }
        }
        return null;
    }

    private ContactLab(Context context) {
        mContacts = new ArrayList<>();
        List<String> names = Arrays.asList(context.getResources().getStringArray(R.array.contacts));
        for (String name : names) {
            mContacts.add(new Contact(context, name));
        }
    }

}
