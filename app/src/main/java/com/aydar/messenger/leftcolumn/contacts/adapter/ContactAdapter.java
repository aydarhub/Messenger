package com.aydar.messenger.leftcolumn.contacts.adapter;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aydar.messenger.R;
import com.aydar.messenger.leftcolumn.contacts.Contact;

import java.util.List;


public class ContactAdapter extends RecyclerView.Adapter<ContactHolder> {

    private List<Contact> mContacts;
    private Context mContext;

    public ContactAdapter(Context context, List<Contact> contacts) {
        mContext = context;
        mContacts = contacts;
    }

    @Override
    public ContactHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.messages_contact_item, parent, false);
        return new ContactHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactHolder holder, int position) {
        Contact contact = mContacts.get(position);
        Log.i("Position", Integer.toString(position));

        holder.setIcon(contact.getIcon());
        holder.setName(contact.getName());
    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }
}
