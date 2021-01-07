package com.example.study3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivityForResult(intent,101);
            }
        });
        EditText number = findViewById(R.id.tel);
        Button button1 = findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = number.getText().toString();
                String data1 = data.substring(0,3);
                String data2 = data.substring(3,7);
                String data3 = data.substring(7,11);
                String result = "tel:"+data1+"-"+data2+"-"+data3;
                print(result);
                Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(result));
                startActivity(intent1);
            }
        });

        Button button2 = findViewById(R.id.parcelbutton);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
                SimpleData data = new SimpleData(201, "OK");
                intent.putExtra("data",data);
                startActivity(intent);
            }
        });
    }

    public void print(String data){
        Toast.makeText(this,"응답으로받은데이터"+data ,Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==101){
            if(data !=null) {
                String name = data.getStringExtra("name");
                if(name != null)
                    Toast.makeText(this,"응답으로받은데이터"+name,Toast.LENGTH_LONG).show();
            }
        }
    }
}