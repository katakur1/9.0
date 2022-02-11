package com.example.app_seting;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {

    private SharedPreferences preferences;  //ссылка на объект-настройку
    private EditText etBox1, etBox2, etBox3;

    final static String svtxtI = "simpTest1";
    final static String svtxtII = "Text2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);
        etBox1 = (EditText)findViewById(R.id.etBox1);
        etBox2 = (EditText)findViewById(R.id.etBox2);
        etBox3 = (EditText)findViewById(R.id.etBox3);

        preferences = getSharedPreferences("",MODE_PRIVATE);
    }

    @Override
    protected void onResume() {
        super.onResume();

        String intElKey = "";
        String saved1= preferences.getString(svtxtI,"");
        String saved2= preferences.getString(svtxtII,"");
        int intEl = preferences.getInt(intElKey, 5);

        etBox1.setText(saved1);
        etBox2.setText(saved2);
        etBox3.setText(Integer.valueOf(intEl).toString());
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString(svtxtI, etBox1.getText().toString());
        editor.putString(svtxtII, etBox2.getText().toString());
        editor.putInt("", Integer.parseInt(etBox3.getText().toString()));

        editor.commit();
    }
}
