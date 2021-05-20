package com.meintsot.firebaseapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private Button logoutButton;
    private FirebaseAuth auth;
    private FirebaseDatabase database;
    private DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logoutButton = findViewById(R.id.logoutButton);
        auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() == null) {
            startActivity(new Intent(getApplicationContext(), StartActivity.class));
            finish();
        }
//        database = FirebaseDatabase.getInstance();
//        ref = database.getReference();
//        ref.child("Users").push();
//        ref.child("Users").child("username").push();
//        ref.child("Users").child("username").setValue("TestUser");
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ref.child("test").setValue("This is a test");
                auth.signOut();
                startActivity(new Intent(getApplicationContext(), StartActivity.class));
                finish();
            }
        });
    }
}