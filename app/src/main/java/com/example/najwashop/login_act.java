package com.example.najwashop;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;


public class login_act extends AppCompatActivity {

    Button callSignUp,SignInBtn;
    ImageView imageView2;
    TextView  header_log,sub_log3,sub_log2;
    TextInputLayout username,password;
    SharedPreferences preferences;
    private static final String SHARED_PREF_NAME="mypref";
    private static final String KEY_EMAIL="email";
    private static final String KEY_PASS="password";
@Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        callSignUp=findViewById(R.id.createAccount);
        SignInBtn=findViewById(R.id.SignInBtn);
        imageView2=findViewById(R.id.imageView2);
        header_log=findViewById(R.id.header_log);
        sub_log2=findViewById(R.id.sub_log2);
        sub_log3=findViewById(R.id.sub_log3);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);

        callSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (login_act.this,SignUp_act.class);
                Pair[] pairs=new Pair[8];
                pairs[0] = new Pair <View,String>(imageView2,"logo_name");
                pairs[1] = new Pair <View,String>(header_log,"logo_text");
                pairs[2] = new Pair <View,String>(sub_log3,"logo_sub_text");
                pairs[3] = new Pair <View,String>(username,"fullname_tran");
                pairs[4] = new Pair <View,String>(password,"pass_tran");
                pairs[5] = new Pair <View,String>(sub_log2,"forgot_pass_tra");
                pairs[6] = new Pair <View,String>(SignInBtn,"signUp_tran");
                pairs[7] = new Pair <View,String>(callSignUp,"alreadyAcc_tran");

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(login_act.this,pairs);
                    startActivity(intent,options.toBundle());
                }
            }
        });

        SignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preferences=getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
                String email = preferences.getString(KEY_EMAIL,null);
                String pass = preferences.getString(KEY_PASS,null);

                if (email != null || pass != null)
                {
                    Intent intent1 = new Intent(login_act.this,MainActivity.class);
                    startActivity(intent1);

                    Toast.makeText(login_act.this, "Welcome to Najwa", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(login_act.this, "Data Tidak Tersedia", Toast.LENGTH_SHORT).show();
                }
            }
        });






    }


}
