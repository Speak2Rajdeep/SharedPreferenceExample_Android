package com.example.sharedpreferenceexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    Button savebtn,showbtn;
    ArrayList al = new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.putdata);
        savebtn = (Button) findViewById(R.id.savedata);
        showbtn = (Button) findViewById(R.id.viewdata);
        textView = (TextView) findViewById(R.id.showdata);

        //Save Details Button
        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp = getSharedPreferences("text", MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("Name",editText.getText().toString());
                editor.apply();
                editText.setText("");
                textView.setText(editText.getText().toString());
            }
        });

        //View Details Button
        showbtn.setOnClickListener(new View.OnClickListener() {
            SharedPreferences sp = getSharedPreferences("text", MODE_PRIVATE);
            @Override
            public void onClick(View view) {
                String s = sp.getString("Name", "");
                textView.setText(s);
            }
        });
    }
}