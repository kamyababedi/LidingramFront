package com.example.lidingram;


import android.os.AsyncTask;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Sendmassage extends AsyncTask <String,Void,Void>{
    Socket s;
    DataOutputStream ds;
    PrintWriter printWriter;

    @Override
    protected Void doInBackground(String ... voids) {
        String massage = voids[0];
        try {
            s = new Socket("192.168.1.2",4000);
            printWriter = new PrintWriter(s.getOutputStream());
            printWriter.write(massage);
            printWriter.flush();
            printWriter.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

