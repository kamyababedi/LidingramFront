package com.example.lidingram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class AboutUsActivity extends AppCompatActivity {
    ImageButton ib_aboutus,ib_chat,ib_setting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        ib_aboutus=(ImageButton)findViewById(R.id.AboutUs_Button) ;
        ib_chat=(ImageButton)findViewById(R.id.Chat_Button);
        ib_setting=(ImageButton)findViewById(R.id.Setting_Button);

        ib_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AboutUsActivity.this,HomepageActivity.class);
                startActivity(i);
            }
        });
        ib_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AboutUsActivity.this,SettingActivity.class);
                startActivity(i);
            }
        });
    }
}
