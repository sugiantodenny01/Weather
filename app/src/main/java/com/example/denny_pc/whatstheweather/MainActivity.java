package com.example.denny_pc.whatstheweather;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;


public class MainActivity extends Activity {

    EditText cityName;
    TextView resultTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityName = (EditText) findViewById(R.id.cityName);
        resultTextView = (TextView) findViewById(R.id.resultTextView);

    }

    public void findWeather(View view) {

        //compile 'com.koushikdutta.ion:ion:2.+'
        Ion.with(this)
                .load("http://api.openweathermap.org/data/2.5/weather?q="+cityName.getText().toString()+
                        "&APPID=35abd4eda59ade35c2e837a099ee2843")
                .asString()
                .setCallback(new FutureCallback<String>() {
                    @Override
                    public void onCompleted(Exception e, String result) {

                        olahData(result);
                    }
                });
        }


    public void olahData(String result){

        try {
            JSONObject json = new JSONObject(result);
            JSONArray weatherInfo = json.getJSONArray("weather");
            JSONObject insideWeather = weatherInfo.getJSONObject(0);
            String info = insideWeather.getString("main");



            resultTextView.setText(info);

        }catch (JSONException e){
            //Toast.makeText(getApplicationContext(), "Could not find weather", Toast.LENGTH_LONG);
            resultTextView.setText("Could not find weather");

        }
    }

}
