package com.example.najwashop;

import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class SignUp_act extends AppCompatActivity {
    TextInputLayout regName,regUsername,regEmail,regPhoneNo,regPassword;
    Button register,regSignIn;
    SharedPreferences preferences;
    private static final String SHARED_PREF_NAME="mypref";
    private static final String KEY_NAME="fullname";
    private static final String KEY_USRNAME="username";
    private static final String KEY_EMAIL="email";
    private static final String KEY_NOPHONE="noPhone";
        private static final String KEY_PASS="password";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        regName=findViewById(R.id.fullname);
        regUsername=findViewById(R.id.username);
        regEmail=findViewById(R.id.email);
        regPhoneNo=findViewById(R.id.noPhone);
        regPassword=findViewById(R.id.password);
        register=findViewById(R.id.SignUp_button);
        regSignIn=findViewById(R.id.toLogIn);

        preferences=getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        String check = preferences.getString(KEY_USRNAME,null);
       /* if (check != null)
        {
            //cek data sudah tersimpan atau belum di shared Preferences

            Intent intent = new Intent(SignUp_act.this,login_act.class);
            startActivity(intent);
        }
            */
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString(KEY_NAME,regName.getEditText().toString());
                    editor.putString(KEY_USRNAME,regUsername.getEditText().toString());
                    editor.putString(KEY_EMAIL,regEmail.getEditText().toString());
                    editor.putString(KEY_NOPHONE,regPhoneNo.getEditText().toString());
                    editor.putString(KEY_PASS,regPassword.getEditText().toString());
                    editor.apply();

                Intent intent = new Intent(SignUp_act.this,login_act.class);
                startActivity(intent);
                Toast.makeText(SignUp_act.this, "User Registered !", Toast.LENGTH_SHORT).show();


            }
        });

       regSignIn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent  intent = new Intent(SignUp_act.this,login_act.class);
               startActivity(intent);
           }


       });


    }




}
