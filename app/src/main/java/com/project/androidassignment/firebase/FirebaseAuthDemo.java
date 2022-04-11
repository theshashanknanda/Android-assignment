package com.project.androidassignment.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.project.androidassignment.databinding.ActivityFirebaseAuthDemoBinding;

public class FirebaseAuthDemo extends AppCompatActivity {
    private ActivityFirebaseAuthDemoBinding binding;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFirebaseAuthDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        firebaseAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        binding.appCompatButton7.setOnClickListener(v -> {
            String email = binding.emailED.getText().toString().trim();
            String password = binding.passwordED.getText().toString();

            if(!email.isEmpty() && !password.isEmpty()){
                // create account
                firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Intent i = new Intent(FirebaseAuthDemo.this, DashboardActivity.class);

                                /* Here I have given sample static data rather than taking from user for registration*/
                                UserClass userClass = new UserClass("firstname", "lastname", "0123456789", email, "gender");
                                database.getReference().child("userdata").push().setValue(userClass)
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void unused) {
                                                startActivity(i);
                                            }
                                        })
                                        .addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Toast.makeText(FirebaseAuthDemo.this, "Data saving failed", Toast.LENGTH_SHORT).show();
                                            }
                                        });
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(FirebaseAuthDemo.this, "account creation failed", Toast.LENGTH_SHORT).show();
                            }
                        });
            }else{
                // show toast
                Toast.makeText(this, "Fields are empty", Toast.LENGTH_SHORT).show();
            }
        });

        binding.textView18.setOnClickListener(v -> {
            startActivity(new Intent(FirebaseAuthDemo.this, LoginActivity.class));
        });
    }
}
