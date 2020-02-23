package com.example.lidingram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class HomepageActivity extends AppCompatActivity {

     ArrayList<String> taskList = new ArrayList<>();
     ArrayAdapter<String> arrayAdapter;

    ImageButton ib_aboutus,ib_chat,ib_setting,ib_newchat;
    TextView tv_edit,savedmessage;
    EditText plaintext;
    ListView taskListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        taskList.add("Chat Sample");
        taskList.add("CHAT WITH TA");


        arrayAdapter = new ArrayAdapter<String>(this, R.layout.listitem , taskList );

        ListView listView = findViewById(R.id.taskListView);

        listView.setAdapter(arrayAdapter);

        ib_aboutus=(ImageButton)findViewById(R.id.AboutUs_Button) ;
        ib_chat=(ImageButton)findViewById(R.id.Chat_Button);
        ib_setting=(ImageButton)findViewById(R.id.Setting_Button);
        tv_edit=(TextView)findViewById(R.id.Edit_View);
        ib_newchat=(ImageButton)findViewById(R.id.NewChat_Button);
        plaintext= (EditText) findViewById(R.id.plaintext);
        savedmessage=(TextView)findViewById(R.id.savedmessage5);
        savedmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomepageActivity.this,SavedMessageActivity.class);
                startActivity(i);
            }
        });
        ib_aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomepageActivity.this,AboutUsActivity.class);
                startActivity(i);
            }
        });
        ib_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomepageActivity.this,SettingActivity.class);
                startActivity(i);
            }
        });
        ib_newchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newcontact=plaintext.getText().toString();
                taskList.add(newcontact);
                ListView listView = findViewById(R.id.taskListView);
                listView.setAdapter(arrayAdapter);

            }
        });
        tv_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                taskList.remove(0);
                arrayAdapter.notifyDataSetChanged();

            }
        });

    }
    public void Add(String s){
        taskList.add(s);
    }
    public void onTaskClick(View view){
        TextView tv = (TextView) view;
        String taskName = tv.getText().toString();

//        tv.setTextColor( Color.BLUE );
//        tv.setBackgroundColor(getResources().getColor(R.color.banafsheNili));


        Intent intent = new Intent(this, MessageListActivity.class);

        intent.putExtra("Key", taskName);

//        intent.putExtra("taskName", tv.getText().toString());
        startActivity(intent);
    }


}
