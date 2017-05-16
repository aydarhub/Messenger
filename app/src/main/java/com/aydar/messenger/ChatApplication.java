package com.aydar.messenger;

import android.app.Application;
import android.util.Log;

import com.neovisionaries.ws.client.WebSocket;
import com.neovisionaries.ws.client.WebSocketAdapter;
import com.neovisionaries.ws.client.WebSocketException;
import com.neovisionaries.ws.client.WebSocketExtension;
import com.neovisionaries.ws.client.WebSocketFactory;
import com.neovisionaries.ws.client.WebSocketFrame;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ChatApplication extends Application {
    private WebSocket mWebSocketConnection;
    private static final String SERVER = "ws://192.168.0.102:8080/ChatServer/echo";
    private static final String TAG = "Where am I?";

    public WebSocket getWebSocketConnection() {
        if (mWebSocketConnection == null) {
            try {
                mWebSocketConnection = connect();
            } catch (IOException | WebSocketException e) {
                e.printStackTrace();
            }
        }
        return mWebSocketConnection;
    }

    private static WebSocket connect() throws IOException, WebSocketException {
        return new WebSocketFactory()
                .createSocket(SERVER)
                .addListener(new WebSocketAdapter() {
                    @Override
                    public void onTextMessage(WebSocket websocket, String text) throws Exception {
                        Log.i(TAG, "onTextMessage");
                    }

                    @Override
                    public void onConnected(WebSocket websocket, Map<String, List<String>> headers) throws Exception {
                        Log.i(TAG, "onConnected");
                    }

                    @Override
                    public void onConnectError(WebSocket websocket, WebSocketException exception) throws Exception {
                        Log.i(TAG, "onConnectError");
                    }

                    @Override
                    public void onDisconnected(WebSocket websocket, WebSocketFrame serverCloseFrame, WebSocketFrame clientCloseFrame, boolean closedByServer) throws Exception {
                        Log.i(TAG, "onDisconnected");
                    }
                })
                .connect();
    }
}
