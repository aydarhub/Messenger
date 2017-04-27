package com.aydar.messenger;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aydar.messenger.leftcolumn.contacts.Contact;
import com.aydar.messenger.leftcolumn.contacts.ContactLab;
import com.aydar.messenger.leftcolumn.contacts.adapter.ContactAdapter;
import com.aydar.messenger.rightcolumn.chat.Message;
import com.aydar.messenger.rightcolumn.chat.MessageLab;
import com.aydar.messenger.rightcolumn.chat.adapter.MessagesAdapter;

import java.util.List;

public class MessengerFragment extends AbstractTabFragment {
    private static final int LAYOUT = R.layout.fragment_messenger;
    private RecyclerView mChatsRecyclerView;
    private RecyclerView mChatRecyclerView;
    private ContactAdapter mChatsAdapter;
    private MessagesAdapter mChatAdapter;
    private Toolbar mLeftToolbar;
    private Toolbar mRightToolbar;

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
        mChatsRecyclerView = (RecyclerView) view.findViewById(R.id.contacts_recycler_view);
        mChatsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mChatRecyclerView = (RecyclerView) view.findViewById(R.id.messages_recycler_view);
        mChatRecyclerView.setLayoutManager((new LinearLayoutManager(getActivity())));
        initLeftToolbar(view);
        initRightToolbar(view);

        setChatsAdapter();
        setChatAdapter();

        return view;
    }

    private void initLeftToolbar(View view) {
        mLeftToolbar = (Toolbar) view.findViewById(R.id.left_toolbar);
        mLeftToolbar.setTitle(R.string.messages);
        mLeftToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });
        mLeftToolbar.inflateMenu(R.menu.left_menu);
    }

    private void initRightToolbar(View view) {
        mRightToolbar = (Toolbar) view.findViewById(R.id.right_toolbar);
        mRightToolbar.setTitle("Aydar");
        mRightToolbar.setSubtitle("last seen just now");
        mRightToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });
    }

    private void setChatsAdapter() {
        ContactLab contactLab = ContactLab.get(getActivity());
        List<Contact> contacts = contactLab.getContacts();
        mChatsAdapter = new ContactAdapter(getActivity(), contacts);
        mChatsRecyclerView.setAdapter(mChatsAdapter);
    }

    private void setChatAdapter() {
        MessageLab messageLab = MessageLab.get(getActivity());
        List<Message> messages = messageLab.getMessages();
        mChatAdapter = new MessagesAdapter(getActivity(), messages);
        mChatRecyclerView.setAdapter(mChatAdapter);
    }


    public void setContext(Context context) {
        this.context = context;
    }

}
