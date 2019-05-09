package com.system.kuet.bashabodol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    private EditText Name;
    private EditText Password;
    private Button LoginBtn;

    private String pass="12345";
    private String name ="abcd";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Name =  findViewById(R.id.name);
        Password =findViewById(R.id.password);
        LoginBtn = (Button) findViewById(R.id.button);


          //final String username = Name.getText().toString();
          //final String userpass = Password.getText().toString();



        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login(Name.getText().toString(), Password.getText().toString());
            }
        });





        /*LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if ((username == "admin") && (userpass=="1234")) {
                    Toast.makeText(LoginActivity.this, "showing data.", Toast.LENGTH_LONG).show();
                    Intent show_intent = new Intent(LoginActivity.this, ShowActivity.class);
                    startActivity(show_intent);

                }
                else{

                    Toast.makeText(LoginActivity.this, "error", Toast.LENGTH_LONG).show();
                }
            }
        });*/



    }

    private void Login(String uname,String upass){
        if ((uname.equals("admin"))&&(upass.equals("1234"))){
            Intent show_intent = new Intent(LoginActivity.this, ShowActivity.class);
            startActivity(show_intent);
        }
    }


}
