package com.example.chat.riskapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.app.Dialog;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.DialogInterface;
import android.graphics.*;
import android.view.*;
import android.widget.*;

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
        /*try { ConnectToServ(); }
        catch (IOException e1) {
            e1.printStackTrace(); }*/
        setContentView(R.layout.activity_main);
        int[][] positions = getPlntTextPositions();

        RelativeLayout relView = (RelativeLayout)findViewById(R.id.activity_main);
        for( int i = 0; i < 40; i++ )
        {
            TextView textView = new TextView(this);
            textView.setText(String.valueOf(i));
            textView.setX(positions[i][0]);
            textView.setY(positions[i][1]);
            textView.setTextColor(Color.WHITE);
            relView.addView(textView);
        }
    }

    public int[][] getPlntTextPositions(){
        int[][] pos = new int[40][2];

        //Galaxie 1
        //   X                Y
        pos[0][0] = 110; pos[0][1] = 65;
        pos[1][0] = 260; pos[1][1] = 8;
        pos[2][0] = 310; pos[2][1] = 65;
        pos[3][0] = 480; pos[3][1] = 62;
        pos[4][0] = 695; pos[4][1] = 50;
        pos[5][0] = 570; pos[5][1] = 165;
        pos[6][0] = 585; pos[6][1] = 285;
        pos[7][0] = 290; pos[7][1] = 285;
        pos[8][0] = 130; pos[8][1] = 220;
        pos[9][0] = 35; pos[9][1] = 290;

        //Galaxie 2
        //   X                Y
        pos[10][0] = 875; pos[10][1] = 70;
        pos[11][0] = 1145; pos[11][1] = 45;
        pos[12][0] = 1375; pos[12][1] = 50;
        pos[13][0] = 1595; pos[13][1] = 53;
        pos[14][0] = 1380; pos[14][1] = 160;
        pos[15][0] = 1620; pos[15][1] = 235;
        pos[16][0] = 1340; pos[16][1] = 265;
        pos[17][0] = 1105; pos[17][1] = 300;
        pos[18][0] = 1190; pos[18][1] = 220;
        pos[19][0] = 1485; pos[19][1] = 330;

        //Galaxie 3
        //   X                Y
        pos[20][0] = 930; pos[20][1] = 395;
        pos[21][0] = 1090; pos[21][1] = 470;
        pos[22][0] = 1250; pos[22][1] = 590;
        pos[23][0] = 1480; pos[23][1] = 490;
        pos[24][0] = 1480; pos[24][1] = 630;
        pos[25][0] = 1640; pos[25][1] = 630;
        pos[26][0] = 1510; pos[26][1] = 760;
        pos[27][0] = 1290; pos[27][1] = 745;
        pos[28][0] = 1055; pos[28][1] = 735;
        pos[29][0] = 1000; pos[29][1] = 585;

        //Galaxie 4
        //   X                Y
        pos[30][0] = 465; pos[30][1] = 388;
        pos[31][0] = 400; pos[31][1] = 495;
        pos[32][0] = 215; pos[32][1] = 505;
        pos[33][0] = 310; pos[33][1] = 600;
        pos[34][0] = 465; pos[34][1] = 610;
        pos[35][0] = 220; pos[35][1] = 703;
        pos[36][0] = 730; pos[36][1] = 515;
        pos[37][0] = 655; pos[37][1] = 622;
        pos[38][0] = 620; pos[38][1] = 715;
        pos[39][0] = 530; pos[39][1] = 770;

        return pos;
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
