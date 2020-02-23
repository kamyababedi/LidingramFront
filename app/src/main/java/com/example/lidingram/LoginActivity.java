package com.example.lidingram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText et_email,et_password;
    TextView tv_register;
    Button btn_login;

    //just for test
    String CurrectUsername="admin";
    String CurrectPassword="123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et_email=(EditText)findViewById(R.id.et_email);
        et_password=(EditText)findViewById(R.id.et_password);
        btn_login=(Button)findViewById(R.id.btn_login);
        tv_register=(TextView)findViewById(R.id.tv_register);



        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(i);
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //valid input
                if(TextUtils.isEmpty(et_email.getText().toString()) || TextUtils.isEmpty(et_password.getText().toString()) ){
                    Toast.makeText(LoginActivity.this,"Please Fill The Items",Toast.LENGTH_LONG).show();
                }
                else if(et_email.getText().toString().equals(CurrectUsername) && et_password.getText().toString().equals(CurrectPassword) ){

                    Toast.makeText(LoginActivity.this,"Succesfully Login",Toast.LENGTH_LONG).show();
                    Intent j = new Intent(LoginActivity.this,HomepageActivity.class);
                    startActivity(j);
                    Sendmassage send = new Sendmassage();
                    send.execute(et_email.getText().toString());


                }
                else{
                    Toast.makeText(LoginActivity.this,"Invalid Username Or Password",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}

