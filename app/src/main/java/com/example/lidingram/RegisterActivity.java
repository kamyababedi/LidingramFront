package com.example.lidingram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText et_req_email,et_req_password,et_req_confirm_password,et_req_name;
    Button btn_register;
    CheckBox cb_agree;
    public final User one= new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        et_req_name=(EditText)findViewById(R.id.et_req_name);
        et_req_email=(EditText)findViewById(R.id.et_req_email);
        et_req_password=(EditText)findViewById(R.id.et_req_password);
        et_req_confirm_password=(EditText)findViewById(R.id.et_req_confirm_password);
        btn_register=(Button)findViewById(R.id.btn_register);
        cb_agree=(CheckBox)findViewById(R.id.agree_checkBox);




        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(TextUtils.isEmpty(et_req_email.getText().toString()) || TextUtils.isEmpty(et_req_confirm_password.getText().toString())
                        || TextUtils.isEmpty(et_req_name.getText().toString())){
                    Toast.makeText(RegisterActivity.this,"Please Fill The Items",Toast.LENGTH_LONG).show();
                }
               /* else if(!(et_req_password.getText().toString().equals(et_req_confirm_password.getText().toString())){
                    Toast.makeText(RegisterActivity.this,"password didn't match",Toast.LENGTH_LONG).show();
                }*/
                else{
                    if(cb_agree.isChecked()){
                        one.setBio(et_req_password.getText().toString());
                        one.setName(et_req_name.getText().toString());

                        Intent j = new Intent(RegisterActivity.this,HomepageActivity.class);
                        startActivity(j);
                    }
                    else
                        Toast.makeText(RegisterActivity.this,"please accept the rules",Toast.LENGTH_LONG).show();
                }


            }
        });
    }
}
