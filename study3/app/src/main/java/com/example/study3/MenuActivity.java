package com.example.study3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button button = findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("name","mike");
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        Button button1 = findViewById(R.id.back);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
        Intent intent = getIntent();
        processIntent(intent);

    }

    private void processIntent(Intent intent) {
        if(intent != null){
            Bundle bundle = intent.getExtras();
            SimpleData data=bundle.getParcelable("data");
            if(data!=null)
                Toast.makeText(this,"전달받은 객체" + data.code+", "+ data.message,Toast.LENGTH_LONG).show();
        }
    }
}