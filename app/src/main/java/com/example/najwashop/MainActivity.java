package com.example.najwashop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public void callTo(View view) {
        Intent dialIntent = new Intent(Intent. ACTION_DIAL ) ;
        dialIntent.setData(Uri. parse ( "tel:" + "08311631257" )) ;
        startActivity(dialIntent) ;
    }

    public void smsTo(View view) {
        Uri uri = Uri.parse("smsto:123");
        Intent it = new Intent(Intent.ACTION_SENDTO, uri);
        it.putExtra("sms_body", "Here you can set the SMS text to be sent");
        startActivity(it);
    }

    public void toMaps(View view) {
        Uri gmmIntentUri = Uri.parse("geo:-6.993221,110.4142299?q=-6.993221,110.4142299(TPU Bergota Krakal)");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }
}