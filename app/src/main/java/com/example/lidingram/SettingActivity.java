package com.example.lidingram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class SettingActivity extends AppCompatActivity {
    ImageButton ib_aboutus,ib_chat,ib_setting;
    Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        ib_aboutus=(ImageButton)findViewById(R.id.AboutUs_Button) ;
        ib_chat=(ImageButton)findViewById(R.id.Chat_Button);
        ib_setting=(ImageButton)findViewById(R.id.Setting_Button);
        logout=(Button)findViewById(R.id.btn_logout) ;
        ib_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SettingActivity.this,HomepageActivity.class);
                startActivity(i);
            }
        });
        ib_aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SettingActivity.this,AboutUsActivity.class);
                startActivity(i);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SettingActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });
    }
}
