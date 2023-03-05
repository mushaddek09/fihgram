package com.example.fihgram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

public class SignupActivity extends AppCompatActivity {

    private EditText edtUsername ,  edtEmail , edtPassword  ;
    private TextView txtLoginInfo;
    private Button btnSubmit;

    private  boolean isSigninUp = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        edtUsername = findViewById(R.id.edtUsername);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        txtLoginInfo = findViewById(R.id.txtLoginInfo);


      btnSubmit   = findViewById(R.id.btnSubmit);


        if (FirebaseAuth.getInstance().getCurrentUser() !=null) {


            startActivity(new Intent(SignupActivity.this, MainActivity.class));
            finish();




        }



      btnSubmit.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              if (isSigninUp) {

                  handleSignUp();

              }else {
                  handlelogin();
              }
          }
      });


        txtLoginInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (edtEmail.getText().toString().isEmpty() || edtPassword.getText().toString().isEmpty()) {

                    Toast.makeText(SignupActivity.this, "Please Login", Toast.LENGTH_SHORT).show();


//                    if (isSigninUp && edtUsername.getText().toString().isEmpty()){
//
//                        Toast.makeText(SignupActivity.this, "Invalid", Toast.LENGTH_SHORT).show();
//                        return;
//                    }


                }
                if (isSigninUp) {

                    isSigninUp = false;
                    edtUsername.setVisibility(View.GONE);
                    btnSubmit.setText("Login");
                    txtLoginInfo.setText("Don't Have an Account ? Sign up");
                    
                }else {

                    isSigninUp = true;
                    edtUsername.setVisibility(View.VISIBLE);
                    btnSubmit.setText("Sign Up");

                    txtLoginInfo.setText("Already have an Account ? Log in ");
                }
            }
        });



    }

    private  void handleSignUp (){

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(edtEmail.getText().toString(),edtPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {



                if (task.isSuccessful()) {

                    FirebaseDatabase.getInstance().getReference("user/"+FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(new User(edtUsername.getText().toString(),edtEmail.getText().toString(), ""));

                    startActivity(new Intent(SignupActivity.this, MainActivity.class));

                    Toast.makeText(SignupActivity.this, "Signup Successfully", Toast.LENGTH_SHORT).show();

                }else {


                    Toast.makeText(SignupActivity.this, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });



    }

    private  void handlelogin (){

        FirebaseAuth.getInstance().signInWithEmailAndPassword(edtEmail.getText().toString(),edtPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {


                if (task.isSuccessful()) {

                    startActivity(new Intent(SignupActivity.this, MainActivity.class));

                    Toast.makeText(SignupActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();

                }else {


                    Toast.makeText(SignupActivity.this, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}