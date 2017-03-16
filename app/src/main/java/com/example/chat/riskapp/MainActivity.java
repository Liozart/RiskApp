package com.example.chat.riskapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.view.Display;
import android.app.Dialog;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.DialogInterface;
import android.graphics.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.net.*;

public class MainActivity extends AppCompatActivity {

    public Socket socket;
    public static final int SERVERPORT = 666;
    public static final String SERVER_IP = "0.0.0.0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try { ConnectToServ(); }
        catch (IOException e1) {
            e1.printStackTrace(); }
    }

    public void ConnectToServ() throws IOException{
        try
        {
            InetAddress serverAddr = InetAddress.getByName(SERVER_IP);
            socket = new Socket(serverAddr, SERVERPORT);

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
