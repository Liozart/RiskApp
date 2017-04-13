package com.example.chat.riskapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_17;
import org.java_websocket.handshake.ServerHandshake;
import java.net.URI;
import java.net.URISyntaxException;

public class MainActivity extends AppCompatActivity {

    public static final int SERVER_PORT = 666;
    public static final String SERVER_IP = "172.20.4.21";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.map);
        try {
            final WebSocketClient webSocketClient = new WebSocketClient(new URI("ws://" + SERVER_IP + ":" + SERVER_PORT), new Draft_17()) {
                @Override
                public void onOpen(ServerHandshake handshakedata) {
                    Log.d("Client","Open");
                    this.send("[0,1]");
                }

                @Override
                public void onMessage(String message) {
                    Log.d("Client","Message");
                    char id = message.charAt(1);
                    switch (id){
                        case '0' :
                            Log.d("Client","Login");
                            break;
                        case '1':
                            Log.d("Client","Logout");
                            break;
                        case '2':
                            Log.d("Client","Kick");
                            break;
                        case '3':
                            Log.d("Client","List player");
                            break;
                        case '4':
                            Log.d("Client","State");
                            break;
                        case '5':
                            Log.d("Client","Troop");
                            break;
                        case '6':
                            Log.d("Client","DisplayTroops on planet");
                            String[] planets = message.substring(3, message.length()-3).replace("[", "").split("],");
                            for(String planet : planets){
                                //0 = id, 1 = is player, 2 = troops, 3 = color
                                String[] data = planet.split(",");
                                int idBtn = getResources().getIdentifier("p" + data[0], "id", getPackageName());
                                Button btn = ((Button) findViewById(idBtn));
                                btn.setText(data[2]);
                                btn.setTextColor(Color.parseColor("#ffffff"));
                                btn.setTextSize(12);
                            }
                            break;
                        case '7':
                            Log.d("Client","Chat");
                            break;
                        case '8':
                            Log.d("Client","Objectifs");
                            break;
                        case '9':
                            Log.d("Client","Score");
                            break;
                    }
                    Log.d("Client", message);
                }

                @Override
                public void onClose(int code, String reason, boolean remote) {
                    Log.d("Client","Close");
                }

                @Override
                public void onError(Exception ex) {
                    Log.e("MYAPP", "exception: " + ex.getMessage());
                    Log.e("MYAPP", "exception: " + ex.toString());
                }
            };

            webSocketClient.connect();
            Log.d("Client","Connect");
        } catch (URISyntaxException e) {
            Log.e("MYAPP", "exception: " + e.getMessage());
            Log.e("MYAPP", "exception: " + e.toString());
        }

    }
}
