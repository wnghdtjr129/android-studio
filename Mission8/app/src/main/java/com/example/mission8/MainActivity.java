package com.example.mission8;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText id=findViewById(R.id.id);
        EditText password=findViewById(R.id.password);
        Button login = findViewById(R.id.Login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Id = id.getText().toString();
                String Pw = password.getText().toString();

                if(Id.equals("") || Pw.equals("")){
                    print("제대로 입력해주시기 바랍니다.");
                }
                else{
                    Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                    startActivityForResult(intent, 101);
                }
            }
        });

    }

    public void print(String data){
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 101){
            if(resultCode==RESULT_OK){
                String menu = data.getStringExtra("menu");
                String message = data.getStringExtra("message");

                Toast.makeText(getBaseContext(), "result code : " + resultCode + ", menu : "+menu+",message : "+message,Toast.LENGTH_LONG).show();
            }
        }
    }
}