package com.example.study;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity {
    ImageView imageView1,imageView2;
    int index=0;
    EditText editText;
    TextView incount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=findViewById(R.id.edittext1);
        incount=findViewById(R.id.inputCount);
    }

    public void onButton1Click(View v){
        int count = editText.length();
        incount.setText(count+" / 80바이트");
        Toast.makeText(this, editText.getText().toString(), Toast.LENGTH_SHORT).show();
    }

    public void onbutton2Click(View v){
        finish();
    }


}