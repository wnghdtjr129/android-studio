package com.example.mission8;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    String menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button button1 = findViewById(R.id.customer);
        Button button2 = findViewById(R.id.money);
        Button button3 = findViewById(R.id.goods);
        Button button4 = findViewById(R.id.tologin);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CutomerActivity.class);
                intent.putExtra("titleMsg","고객관리화면");
                startActivityForResult(intent,201);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CutomerActivity.class);
                intent.putExtra("titleMsg","매출관리화면");
                startActivityForResult(intent,202);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CutomerActivity.class);
                intent.putExtra("titleMsg","상품관리화면");
                startActivityForResult(intent,203);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("message","ok");
                intent.putExtra("menu",menu);
                setResult(RESULT_OK,intent);
                finish();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if(requestCode == 201){
            if(resultCode==RESULT_OK) {
                String msg = intent.getStringExtra("message");
                if (msg != null) {
                    Toast.makeText(getApplicationContext(), "고객 관리응답, resultcode : " + resultCode + ", message : " + msg, Toast.LENGTH_LONG).show();
                    menu = intent.getStringExtra("menu");
                }
            }
        }
        else if(requestCode == 202){
            if(resultCode==RESULT_OK) {
                String msg = intent.getStringExtra("message");
                if (msg != null) {
                    Toast.makeText(getApplicationContext(), "매출 관리응답, resultcode : " + resultCode + ", message : " + msg, Toast.LENGTH_LONG).show();
                    menu = intent.getStringExtra("menu");
                }
            }
        }
        else if(requestCode == 203){
            if(resultCode==RESULT_OK) {
                String msg = intent.getStringExtra("message");
                if (msg != null) {
                    Toast.makeText(getApplicationContext(), "상품 관리응답, resultcode : " + resultCode + ", message : " + msg, Toast.LENGTH_LONG).show();
                    menu = intent.getStringExtra("menu");
                }
            }
        }
    }

}