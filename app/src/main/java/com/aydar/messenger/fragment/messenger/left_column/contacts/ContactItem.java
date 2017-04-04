package com.aydar.messenger.fragment.messenger.left_column.contacts;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aydar.messenger.R;

public class ContactItem extends Fragment {
    private static final int LAYOUT = R.layout.fragment_messenger_leftcolumn_contacts_card_item;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(LAYOUT, container, false);

        return view;
    }
}
