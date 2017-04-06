package com.aydar.messenger;

import android.content.Context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

class ContactLab {
    private static ContactLab sContactLab;

    private List<Contact> mContacts;

    static ContactLab get(Context context) {
        if (sContactLab == null) {
            sContactLab = new ContactLab(context);
        }
        return sContactLab;
    }
    List<Contact> getContacts() {
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
