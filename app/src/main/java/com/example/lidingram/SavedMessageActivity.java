package com.example.lidingram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class SavedMessageActivity extends AppCompatActivity implements MyRecyclerViewAdapter2.ItemClickListener {


    MyRecyclerViewAdapter2 sendadapter;
    ImageButton ib_back;
    EditText et;
    ArrayList<String> senddmessage = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_message);
        // data to populate the RecyclerView with



        RecyclerView recyclerView2 = findViewById(R.id.reyclerview_message_list2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        sendadapter = new MyRecyclerViewAdapter2(this, senddmessage);
        sendadapter.setClickListener(this);
        recyclerView2.setAdapter(sendadapter); ///!!!!!!!!

        ib_back=(ImageButton)findViewById(R.id.ib_back);
        et = findViewById(R.id.edittext_chatbox);
        ib_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(SavedMessageActivity.this,HomepageActivity.class);
                startActivity(j);
            }
        });
    }


    public void send_data(View view){
        String message=et.getText().toString();
        senddmessage.add(message);
        Sendmassage b1=new Sendmassage();
        b1.execute(message);

    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You are replying " /* adapter.getItem(position)  /*" on row number " + position*/, Toast.LENGTH_SHORT).show();
    }

    /*class backgroundtask extends AsyncTask<String,Void,Void>{
        Socket s;
        PrintWriter writer;

        @Override
        protected Void doInBackground(String... voids) {
            try {
                String message=voids[0];
                s=new Socket("localhost",1800);
                writer=new PrintWriter(s.getOutputStream());
                writer.write(message);
                writer.flush();
                writer.close();
                s.close(); //

            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
    }*/
}
