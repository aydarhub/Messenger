package com.aydar.messenger.fragment.messenger.left_column.contacts;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aydar.messenger.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContactsRecyclerView extends Fragment {
    private static final int LAYOUT = R.layout.fragment_messenger_leftcolumn_contacts_recyclerview;

    private RecyclerView mContactsRecyclerView;
    private ContactsAdapter mAdapter;
    private List<List<Contact>> mContacts;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContacts = initContacts();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(LAYOUT, container, false);
        mContactsRecyclerView = (RecyclerView) view.findViewById(R.id.contacts_recyclerview);
        mContactsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    private void updateUI() {
        mAdapter = new ContactsAdapter(mContacts);
        mContactsRecyclerView.setAdapter(mAdapter);
    }

    private List<List<Contact>> initContacts() {
        List<List<Contact>> contacts = new ArrayList<>();
        List<String> stringContacts = Arrays.asList(getResources().getStringArray(R.array.favourite_contacts));
        List<Contact> item = new ArrayList<>();
        for (String name : stringContacts) {
            item.add(new Contact(name));
        }
        contacts.add(item);
        stringContacts = Arrays.asList(getResources().getStringArray(R.array.a_contacts));
        item.clear();
        for (String name : stringContacts) {
            item.add(new Contact(name));
        }
        contacts.add(item);
        stringContacts = Arrays.asList(getResources().getStringArray(R.array.b_contacts));
        item.clear();
        for (String name : stringContacts) {
            item.add(new Contact(name));
        }
        contacts.add(item);
        stringContacts = Arrays.asList(getResources().getStringArray(R.array.i_contacts));
        item.clear();
        for (String name : stringContacts) {
            item.add(new Contact(name));
        }
        contacts.add(item);
        item.clear();

        return contacts;
    }

    private class ContactsHolder extends RecyclerView.ViewHolder {

        public CardView mContactsCardView;
        public RecyclerView mContactItemsRecyclerView;

        public ContactsHolder(View itemView) {
            super(itemView);
            mContactsCardView = (CardView) itemView.findViewById(R.id.contacts_cardview);
            mContactItemsRecyclerView = (RecyclerView) itemView.findViewById(R.id.contact_items_recyclerview);
        }
    }

    private class ContactsAdapter extends RecyclerView.Adapter<ContactsHolder> {

        private static final int LAYOUT = R.layout.fragment_messenger_leftcolumn_contacts_card_item;

        private List<List<Contact>> mContacts;

        public ContactsAdapter(List<List<Contact>> contacts) {
            mContacts = contacts;
        }

        @Override
        public ContactsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(LAYOUT, parent, false);

            return new ContactsHolder(view);
        }

        @Override
        public void onBindViewHolder(ContactsHolder holder, int position) {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            List<Fragment> contactFragmentsList = new ArrayList<>();
            contactFragmentsList.add(new ContactItem());
            //ТУТ ДОБАВЬ ФРАГМЕНТЫ В МАССИВ ЧЕРЕЗ ЦИКЛ contactFragmentsList.add(new ContactItem());
            for (Contact contact : mContacts.get(position)) {
                ft.add(R.id.contact_item, contactFragmentsList.get(position));
            }

        }

        @Override
        public int getItemCount() {
            return mContacts.size();
        }
    }
}
