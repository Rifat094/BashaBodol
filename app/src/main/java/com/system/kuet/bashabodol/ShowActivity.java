package com.system.kuet.bashabodol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

//import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
//import com.google.firebase.storage.FileDownloadTask;
//import com.google.firebase.storage.FirebaseStorage;
//import com.google.firebase.storage.StorageReference;
//import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.io.File;

public class ShowActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private DatabaseReference mUserDatabase;
    private FirebaseUser mCurrentUser;
    //private CircleImageView mDisplayImage;
    //private StorageReference mImageStorage;

    private RecyclerView mDatalist;

    private DatabaseReference mDatabase;

    private LinearLayoutManager mLayoutManager;
    // private    FirebaseRecyclerAdapter firebase


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show2);

        mDatalist = (RecyclerView) findViewById(R.id.data_list);
        mDatalist.setHasFixedSize(true);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Data");
        mDatalist.setLayoutManager(new LinearLayoutManager(this));
    }
    @Override
    protected void onStart(){
        super.onStart();
        FirebaseRecyclerOptions<Data>option =
                new FirebaseRecyclerOptions.Builder <Data>()
                .setQuery(mDatabase,Data.class)
                .setLifecycleOwner(this)
                .build();

        FirebaseRecyclerAdapter<Data, DataViewHolder>firebaseRecyclerAdapter= new FirebaseRecyclerAdapter<Data,DataViewHolder>(option) {


            @Override
            protected void onBindViewHolder(@NonNull DataViewHolder holder,  int position, @NonNull Data model) {
                holder.setuid(model.getuid());
                holder.setName(model.getName());
                holder.setPhonenumber(model.getPhonenumber());
                holder.setAddress(model.getAddress());
                holder.setBed(model.getBed());
                holder.setChair(model.getChair());
                holder.setFridge(model.getFridge());
                holder.setShowcase(model.getShowcase());
                holder.setWardrobe(model.getWardrobe());

                final String user_id=getRef(position).getKey();

                holder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Intent intent9 = new Intent(ShowActivity.this, ProfileActivity.class);
                        //intent9.putExtra("user_id", user_id);
                        //startActivity(intent9);
                    }
                });

            }


            @NonNull
            @Override
            public DataViewHolder  onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                return new DataViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.single_data,parent,false));
            }

        };

        mDatalist.setAdapter(firebaseRecyclerAdapter);

    }

    public class DataViewHolder extends RecyclerView.ViewHolder{
        View mView;

        public DataViewHolder(View itemView) {
            super(itemView);

            mView = itemView;

        }

        public void setuid(String name){

            TextView userNameView = (TextView) mView.findViewById(R.id.uid);
            userNameView.setText(name);
        }

        public void setName(String name){

            TextView userNameView = (TextView) mView.findViewById(R.id.name);
            userNameView.setText(name);
        }

        public void setPhonenumber(String phonenumber){

            TextView userStatusView = (TextView) mView.findViewById(R.id.phonenumber);
            userStatusView.setText(phonenumber);

        }
        public void setAddress(String address){

            TextView userStatusView = (TextView) mView.findViewById(R.id.address);
            userStatusView.setText(address);

        }
        public void setBed(String bed){

            TextView userStatusView = (TextView) mView.findViewById(R.id.bed);
            userStatusView.setText(bed);

        }
        public void setChair(String chair){

            TextView userStatusView = (TextView) mView.findViewById(R.id.chair);
            userStatusView.setText(chair);

        }
        public void setFridge(String fridge){

            TextView userStatusView = (TextView) mView.findViewById(R.id.fridge);
            userStatusView.setText(fridge);

        }
        public void setWardrobe(String wardrobe){

            TextView userStatusView = (TextView) mView.findViewById(R.id.wardrobe);
            userStatusView.setText(wardrobe);

        }
        public void setShowcase(String showcase){

            TextView userStatusView = (TextView) mView.findViewById(R.id.showcase);
            userStatusView.setText(showcase);

        }
    }
}



