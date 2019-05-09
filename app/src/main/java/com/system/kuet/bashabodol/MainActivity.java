package com.system.kuet.bashabodol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private Button InsertBtn;
    private Button ShowBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InsertBtn = (Button) findViewById(R.id.button1);
        ShowBtn = (Button) findViewById(R.id.button2);

        InsertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent insert_intent = new Intent(MainActivity.this, InsertActivity.class);
                startActivity(insert_intent);

            }
        });

        ShowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent show_intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(show_intent);

            }
        });
    }
}
