package com.aydar.messenger;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MessengerFragment extends AbstractTabFragment {
    private static final int LAYOUT = R.layout.fragment_messenger;
    private RecyclerView mContactsRecyclerView;
    private ContactAdapter mAdapter;

    public static MessengerFragment getInstance(Context context) {
        Bundle args = new Bundle();
        MessengerFragment fragment = new MessengerFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.tab_item_messenger));

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(LAYOUT, container, false);
        mContactsRecyclerView = (RecyclerView) view.findViewById(R.id.contacts_recycler_view);
        mContactsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    private void updateUI() {
        ContactLab contactLab = ContactLab.get(getActivity());
        List<Contact> contacts = contactLab.getContacts();
        mAdapter = new ContactAdapter(contacts);
        mContactsRecyclerView.setAdapter(mAdapter);
    }

    private class ContactHolder extends RecyclerView.ViewHolder {

        private ImageView mLetterFavourite;
        private TextView mLetter;
        private ImageView mIcon;
        private TextView mName;
        private LinearLayout mItemLayout;

        private ContactHolder(View itemView) {
            super(itemView);
            mLetterFavourite = (ImageView) itemView.findViewById(R.id.contact_item_letter_favourite);
            mLetter = (TextView) itemView.findViewById(R.id.contact_item_letter);
            mIcon = (ImageView) itemView.findViewById(R.id.contact_item_icon);
            mName = (TextView) itemView.findViewById(R.id.contact_item_name);
            mItemLayout = (LinearLayout) itemView.findViewById(R.id.contact_item);
        }
    }

    private class ContactAdapter extends RecyclerView.Adapter<ContactHolder> {

        private List<Contact> mContacts;

        ContactAdapter(List<Contact> contacts) {
            mContacts = contacts;
        }

        @Override
        public ContactHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View view = inflater.inflate(R.layout.contact_item, parent, false);
            return new ContactHolder(view);
        }

        @Override
        public void onBindViewHolder(ContactHolder holder, int position) {
            Contact contact = mContacts.get(position);
            Log.i("Position", Integer.toString(position));
            if (position == 0 || mContacts.get(position).getName().charAt(0) != mContacts.get(position - 1).getName().charAt(0)) {
                holder.mLetter.setText(Character.toString(contact.getName().charAt(0)));
            } else if (position != mContacts.size() - 1 && mContacts.get(position).getName().charAt(0) != mContacts.get(position + 1).getName().charAt(0)) {
                holder.mItemLayout.setBackgroundResource(R.drawable.bg);
            } else {
                holder.mLetter.setText("");
                holder.mItemLayout.setBackgroundColor(getResources().getColor(R.color.colorWhite));

            }
            holder.mIcon.setImageBitmap(contact.getIcon());
            holder.mName.setText(contact.getName());
        }

        @Override
        public int getItemCount() {
            return mContacts.size();
        }
    }

    public void setContext(Context context) {
        this.context = context;
    }

}
