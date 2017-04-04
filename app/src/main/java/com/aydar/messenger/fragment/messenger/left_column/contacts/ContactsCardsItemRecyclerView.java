package com.aydar.messenger.fragment.messenger.left_column.contacts;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aydar.messenger.R;

import java.util.List;

public class ContactsCardsItemRecyclerView extends Fragment {
    private static final int LAYOUT = R.layout.fragment_messenger_leftcolumn_contacts_card_item;

    List<Contact> mContacts;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(LAYOUT, container, false);


        return view;
    }


}
