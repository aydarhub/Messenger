package com.aydar.messenger;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.aydar.messenger.leftcolumn.contacts.Contact;
import com.aydar.messenger.leftcolumn.contacts.ContactLab;
import com.aydar.messenger.leftcolumn.contacts.adapter.ContactAdapter;
import com.aydar.messenger.rightcolumn.chat.Message;
import com.aydar.messenger.rightcolumn.chat.MessageLab;
import com.aydar.messenger.rightcolumn.chat.adapter.MessagesAdapter;
import com.neovisionaries.ws.client.WebSocket;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class MessengerFragment extends AbstractTabFragment {
    private static final int LAYOUT = R.layout.fragment_messenger;
    private static final String TAG = "Where am I?";
    private RecyclerView mChatsRecyclerView;
    private RecyclerView mChatRecyclerView;
    private ContactAdapter mChatsAdapter;
    private MessagesAdapter mChatAdapter;
    private Toolbar mLeftToolbar;
    private Toolbar mRightToolbar;

    private EditText mMessageEditText;
    private Button mSendMessageButton;

    private WebSocket mWebSocket;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        ConnectTask task = new ConnectTask();
        task.execute();
    }

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
        Log.i("Where am I?", "onCreateView");

        return inflater.inflate(LAYOUT, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i("Where am I?", "onViewCreated");
        mChatsRecyclerView = (RecyclerView) view.findViewById(R.id.contacts_recycler_view);
        mChatsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mChatRecyclerView = (RecyclerView) view.findViewById(R.id.messages_recycler_view);
        mChatRecyclerView.setLayoutManager((new LinearLayoutManager(getActivity())));
        initLeftToolbar(view);
        initRightToolbar(view);

        setChatsAdapter();
        setChatAdapter();

        mMessageEditText = (EditText) view.findViewById(R.id.write_message_field);
        mSendMessageButton = (Button) view.findViewById(R.id.send_message_button);

        mSendMessageButton.setOnClickListener(v -> {
            sendMessage(mMessageEditText.getText().toString());
            JSONObject obj = new JSONObject();
            try {
                obj.put("nickname", "Android");
                obj.put("message_text", mMessageEditText.getText().toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            mWebSocket.sendText("Android: " + mMessageEditText.getText().toString());

        });
    }

    private void initLeftToolbar(View view) {
        mLeftToolbar = (Toolbar) view.findViewById(R.id.left_toolbar);
        mLeftToolbar.setTitle(R.string.messages);
        mLeftToolbar.setOnMenuItemClickListener(item -> false);
        mLeftToolbar.inflateMenu(R.menu.left_menu);
    }

    private void initRightToolbar(View view) {
        mRightToolbar = (Toolbar) view.findViewById(R.id.right_toolbar);
        mRightToolbar.setTitle("Aydar");
        mRightToolbar.setSubtitle("last seen just now");
        mRightToolbar.setOnMenuItemClickListener(item -> false);
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
        if (mChatRecyclerView.getAdapter() == null) {
            mChatAdapter = new MessagesAdapter(getActivity(), messages);
            mChatRecyclerView.setAdapter(mChatAdapter);
        } else {
            ((MessagesAdapter) mChatRecyclerView.getAdapter()).updateChat(messages);
        }
        mChatRecyclerView.scrollToPosition(mChatRecyclerView.getAdapter().getItemCount() - 1);
    }

    private void sendMessage(String messageText) {
        Message message = new Message(Message.OUTGOING_MESSAGE, messageText, "1 мая, 2017", "22:48");
        MessageLab.get(getActivity()).addMessage(message);

        setChatAdapter();
    }


    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("Where am I?", "onDestroy");
        mWebSocket.disconnect();
    }

    class ConnectTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            Log.i(TAG, "onPreExecute");
        }

        @Override
        protected Void doInBackground(Void... voids) {
            Log.i(TAG, "doInBackground");
            ChatApplication app = (ChatApplication) getActivity().getApplication();
            mWebSocket = app.getWebSocketConnection();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Log.i(TAG, "onPostExecute");
        }
    }

}
