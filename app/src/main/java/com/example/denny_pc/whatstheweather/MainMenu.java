package com.example.denny_pc.whatstheweather;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainMenu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        // getSupportActionBar().hide();
        //getActionbar().hide();
        getActionBar().hide();
    }



    public void  btn_weather(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }


    public  void btn_2(View view){
        Intent i = new Intent(this, AboutActivity.class);
        startActivity(i);
    }


    public  void btn_3(View view){
        Intent i = new Intent(this, CreditsActivity.class);
        startActivity(i);

    }
}
