package com.aydar.messenger.fragment.messenger;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aydar.messenger.R;
import com.aydar.messenger.fragment.AbstractTabFragment;
import com.aydar.messenger.fragment.messenger.left_column.contacts.ContactItem;
import com.aydar.messenger.fragment.messenger.left_column.contacts.ContactsCardsItemRecyclerView;
import com.aydar.messenger.fragment.messenger.left_column.contacts.ContactsRecyclerView;
import com.aydar.messenger.fragment.messenger.left_column.ToolbarFragment;

public class MessengerFragment extends AbstractTabFragment {
    private static final int LAYOUT = R.layout.fragment_messenger;

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
        Fragment toolbarFragment = new ToolbarFragment();
        Fragment contactsFragment = new ContactsRecyclerView();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.left_column, toolbarFragment);
        ft.add(R.id.left_column, contactsFragment);
        ft.commit();
        view = inflater.inflate(LAYOUT, container, false);


        return view;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
