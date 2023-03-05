package com.example.fihgram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    MaterialToolbar materialToolbar;

    BottomNavigationView bottomNav;

    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        drawerLayout = findViewById(R.id.drawerLayout);
        materialToolbar = findViewById(R.id.toolBar);
        bottomNav = findViewById(R.id.bottomNav);
        navigationView = findViewById(R.id.navigationView);


        replaceFragment(new HomeFragment());


        ActionBarDrawerToggle  toggle = new ActionBarDrawerToggle(

                MainActivity.this, drawerLayout, materialToolbar, R.string.drawer_close, R.string.drawer_open
        );

        drawerLayout.addDrawerListener(toggle);




        navigationView.setNavigationItemSelectedListener(this);

        toggle.syncState();




       bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {


           switch (item.getItemId()){


               case   R.id.home:
                   replaceFragment(new HomeFragment());

                   break;

               case   R.id.search :
                   replaceFragment(new SearchFragment());

                   break;
               case   R.id.addpost:
                   replaceFragment(new AddPostFragment());

                   break;
               case   R.id.avatar:
                   replaceFragment(new FinalProfileFragment());

                   break;
           }


               return true;
           }
       });



//        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//
//                if (item.getItemId()== R.id.addpost) {
//
//                    Intent intent = new Intent(MainActivity.this, AddPostFragment.class);
//                    startActivity(intent);
//                }
//
//
//                return false;
//            }
//        });
//



        materialToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
          @Override
          public boolean onMenuItemClick(MenuItem item) {

              if (item.getItemId()== R.id.msg) {

                   Intent intent = new Intent(MainActivity.this, FriendsActivity.class);
                   startActivity(intent);
               }

               return false;
           }
       });



        FragmentManager fManager = getSupportFragmentManager();
        FragmentTransaction  fragmentTransaction = fManager.beginTransaction();
        fragmentTransaction.add(R.id.frameLayout, new HomeFragment());
        fragmentTransaction.commit();




    }


    private  void replaceFragment ( Fragment fragment){


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();




    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.home:
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new HomeFragment())
                    .commit();
            drawerLayout.closeDrawer(GravityCompat.START);

            break;


            case R.id.profile:
                Toast.makeText(this, "Profile Clicked", Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(GravityCompat.START);

                break;

        }




        return true;
    }
}