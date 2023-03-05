package com.example.fihgram;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;

public class FriendsActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    MaterialToolbar materialToolbar;

    private RecyclerView recyclerView;
    private ArrayList<User>users;
    private ProgressBar progressBar;
    private UsersAdapter usersAdapter;

    UsersAdapter.OnUserClickListener onUserClickListener;

    String myImageUrl;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        drawerLayout = findViewById(R.id.drawerLayout2);
        materialToolbar = findViewById(R.id.toolBar2);

        progressBar = findViewById(R.id.progressBar1);
        users = new ArrayList<>();
        recyclerView = findViewById(R.id.rec);



        getOnBackPressedDispatcher().addCallback(new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                startActivity(new Intent( FriendsActivity.this, MainActivity.class ));
            }
        });




        materialToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {


                if (item.getItemId() == R.id.profile) {

                    startActivity(new Intent(FriendsActivity.this, Profile.class));
                    finish();

                }

                return false;
            }
        });


        onUserClickListener = new UsersAdapter.OnUserClickListener() {
            @Override
            public void onUserClicked(int position) {
                startActivity(new Intent(FriendsActivity.this, MessageActivity.class)

                        .putExtra("username_of_roommate", users.get(position).getUsername())
                        .putExtra("email_of_roommate" , users.get(position).getEmail())
                        .putExtra("img_of_roommate" , users.get(position).getProfilePicture())
                        .putExtra("my_img",myImageUrl));




            }


        };

        getUsers();



        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

       getMenuInflater().inflate(R.menu.profile_menu,menu);
        return true;
    }




    private  void getUsers(){

        FirebaseDatabase.getInstance().getReference("user").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


                for (DataSnapshot dataSnapshot : snapshot.getChildren()){

                    users.add(dataSnapshot.getValue(User.class));

                }
                usersAdapter = new UsersAdapter(users, FriendsActivity.this,onUserClickListener);
                recyclerView.setLayoutManager(new LinearLayoutManager(FriendsActivity.this));
                recyclerView.setAdapter(usersAdapter);
                progressBar.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);

                for (User user : users){

                    try {
                        if (user.getEmail().equals(FirebaseAuth.getInstance().getCurrentUser().getEmail())) {

                            myImageUrl = user.getProfilePicture();
                            return;
                        }
                    }catch (Exception e){
                        Log.e(this.getClass().getSimpleName(),e.getMessage());
                    }
                }






            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }







}