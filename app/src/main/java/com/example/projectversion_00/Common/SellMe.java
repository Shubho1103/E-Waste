package com.example.projectversion_00.Common;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projectversion_00.Common.LoginSignup.StartupScreen;
import com.example.projectversion_00.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class SellMe extends AppCompatActivity {


    Button submit;
    private EditText Fname, UID, Email,Phn,Locality,Weight,Bid;


    FirebaseDatabase rootnode;
    DatabaseReference reference;
    FirebaseFirestore db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sellme);

        submit = (Button)findViewById(R.id.sumitseller_btn);
        Fname = (EditText) findViewById(R.id.FnameBuyer);
        UID = (EditText) findViewById(R.id.UIDbuyer);
        Email = (EditText) findViewById(R.id.Emailbuyer);
        Phn = (EditText) findViewById(R.id.Phnbuyer);
        Locality = (EditText) findViewById(R.id.pickuplocationbuyer);
        Weight = (EditText) findViewById(R.id.weightbuyer);
        Bid = (EditText) findViewById(R.id.bidbuyer);

        db=FirebaseFirestore.getInstance();


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name= Fname.getText().toString().trim();
                String uid= UID.getText().toString().trim();
                String email= Email.getText().toString().trim();
                String phn= Phn.getText().toString().trim();
                String locality= Locality.getText().toString().trim();
                Integer weight= Integer.valueOf(Weight.getText().toString().trim());
                Integer bid = Integer.valueOf(Bid.getText().toString().trim());


                if (name.isEmpty()) {
                    Fname.setError("Please Enter Your Full Name!");
                    Fname.requestFocus();
                    return;
                }

                if (uid.isEmpty()) {
                    UID.setError("Please Enter Your Full Name!");
                    UID.requestFocus();
                    return;
                }

                if (phn.isEmpty()) {
                    Phn.setError("Please Enter Your Full Name!");
                    Phn.requestFocus();
                    return;
                }


                if (email.isEmpty()) {
                    Email.setError("Please Enter Your Full Name!");
                    Email.requestFocus();
                    return;
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Email.setError("Please Enter Your Full Name!");
                    Email.requestFocus();
                    return;
                }
                if (locality.isEmpty()) {
                    Locality.setError("Please Enter Your Full Name!");
                    Locality.requestFocus();
                    return;
                }
                if (bid<=0) {
                    Bid.setError("Please Enter Your Full Name!");
                    Bid.requestFocus();
                    return;
                }
                if (weight<=0) {
                    Weight.setError("Please Enter Your Full Name!");
                    Weight.requestFocus();
                    return;
                }


                Buyer buyer = new Buyer(name, uid, phn, email,locality, weight, bid);

                CollectionReference dbSellers = db.collection("Buyers");

//                Seller seller = new Seller(name, uid, phn, email, exctloc, locality, weight, desc);

                dbSellers.add(buyer).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Intent intent=new Intent(getApplicationContext(),UserDashboard.class);
                        startActivity(intent);
                        Toast.makeText(SellMe.this, "Successful", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(SellMe.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                });



            }
        });





    }
    public void back_to_StartupScreen(View view) {
        Intent intent = new Intent(getApplicationContext(), UserDashboard.class);
        startActivity(intent);
    }
}