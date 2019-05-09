package com.system.kuet.bashabodol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Random;

public class InsertActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText Name;
    private EditText PhoneNumber;
    private EditText Address;
    private EditText Bed;
    private EditText Chair;
    private EditText Fridge;
    private EditText Showcase;
    private EditText Wardrobe;
    private Button Insert;

    private Toolbar mToolbar;

    //progress
    private ProgressDialog mRegProgress;

    private DatabaseReference mDatabase;
    FirebaseDatabase database;
    DatabaseReference ref;
    Data data;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);


        mRegProgress = new ProgressDialog(this);



        mAuth = FirebaseAuth.getInstance();

        // Android Fields

        Name =  findViewById(R.id.name);
        PhoneNumber =findViewById(R.id.phonenumber);
        Address =  findViewById(R.id.address);
        Bed =  findViewById(R.id.bed);
        Chair =  findViewById(R.id.chair);
        Fridge =  findViewById(R.id.fridge);
        Showcase =  findViewById(R.id.showcase);
        Wardrobe =  findViewById(R.id.wardrobe);
        Insert = (Button) findViewById(R.id.InsertBtn);
        database = FirebaseDatabase.getInstance();
        ref = database.getReference("Data");
        data = new Data();

        //String username = Name.getText().toString();
        //String userphone = PhoneNumber.getText().toString();
        //String useraddress = Address.getText().toString();

        //insert_data(username, userphone, useraddress);



        /*Insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = Name.getText().toString();
                String phonenumber = PhoneNumber.getText().toString();
                String address = Address.getText().toString();
                String bed = Bed.getText().toString();
                String chair = Chair.getText().toString();
                String fridge = Fridge.getText().toString();
                String showcase = Showcase.getText().toString();
                String wardrobe = Wardrobe.getText().toString();

                if(!TextUtils.isEmpty(name) || !TextUtils.isEmpty(phonenumber) || !TextUtils.isEmpty(address)) {

                    mRegProgress.setTitle("inserting data");
                    mRegProgress.setMessage("Please wait while we insert your data !");
                    mRegProgress.setCanceledOnTouchOutside(false);
                    mRegProgress.show();

                    //insert_data(name, phonenumber, address,bed,chair,fridge,showcase,wardrobe);

                }


            }
        });*/

    }

    private  void getValues() {
        data.setName(Name.getText().toString());
        data.setPhonenumber(PhoneNumber.getText().toString());
        data.setAddress(Address.getText().toString());
        data.setBed(Bed.getText().toString());
        data.setChair(Chair.getText().toString());
        data.setFridge(Fridge.getText().toString());
        data.setShowcase(Showcase.getText().toString());
        data.setWardrobe(Wardrobe.getText().toString());

    }


    public void InsertBtn (View view){
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //FirebaseUser current_user = FirebaseAuth.getInstance().getCurrentUser();
                //String uid = current_user.getUid();
                getValues();
                if (!TextUtils.isEmpty(data.name) || !TextUtils.isEmpty(data.phonenumber) || !TextUtils.isEmpty(data.address)) {

                    ref.child(data.name + data.phonenumber).setValue(data);
                    Toast.makeText(InsertActivity.this, "inserting data.", Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(InsertActivity.this, "try again", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }




    /*private void insert_data(final String name, final String phonenumber, final String address, final String bed, final String chair, final String fridge, final String showcase, final String wardrobe) {
        mAuth.createUserWithEmailAndPassword(name,phonenumber).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){

                    FirebaseUser current_user = FirebaseAuth.getInstance().getCurrentUser();
                    String uid = current_user.getUid();

                    mDatabase = FirebaseDatabase.getInstance().getReference().child("Data").child(uid);


                    HashMap<String, String> userMap = new HashMap<>();
                    userMap.put("name", name);
                    userMap.put("phonenumber", phonenumber);
                    userMap.put("address", address);
                    userMap.put("bed", bed);
                    userMap.put("chair", chair);
                    userMap.put("fridge", fridge);
                    userMap.put("showcase", showcase);
                    userMap.put("wardrobe", wardrobe);


                    mDatabase.setValue(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if(task.isSuccessful()){

                                mRegProgress.dismiss();

                                Intent mainIntent = new Intent(InsertActivity.this, MainActivity.class);
                                mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(mainIntent);
                                finish();

                            }

                        }
                    });

                }
                else{
                    mRegProgress.hide();
                    Toast.makeText(InsertActivity.this,"You got some error.",Toast.LENGTH_LONG).show();
                }
            }
        });
    }*/
}
