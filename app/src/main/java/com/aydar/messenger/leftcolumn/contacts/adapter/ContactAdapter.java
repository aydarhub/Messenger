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
        View view = inflater.inflate(R.layout.contact_item, parent, false);
        return new ContactHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactHolder holder, int position) {
        Contact contact = mContacts.get(position);
        Log.i("Position", Integer.toString(position));
        if (position == 0 || mContacts.get(position).getName().charAt(0) != mContacts.get(position - 1).getName().charAt(0)) {
            holder.setLetter(Character.toString(contact.getName().charAt(0)));
        } else if (position != mContacts.size() - 1 && mContacts.get(position).getName().charAt(0) != mContacts.get(position + 1).getName().charAt(0)) {
            holder.setItemUnderline();
        } else {
            holder.clearLetter();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                holder.clearUnderline(mContext);
            } else {
                holder.clearUnderline(mContext);
            }

        }
        holder.setIcon(contact.getIcon());
        holder.setName(contact.getName());
    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }
}
