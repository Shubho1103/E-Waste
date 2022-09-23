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

import com.example.projectversion_00.Common.LoginSignup.Signup;
import com.example.projectversion_00.Common.LoginSignup.StartupScreen;
import com.example.projectversion_00.R;
import com.example.projectversion_00.User_data;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.CollectionReference;

public class BuyMe extends AppCompatActivity {

    private EditText Fname, UID, Email,Phn, Exctloc, Locality,Weight,Desc;
    Button submit;


    FirebaseFirestore db;





    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_me);


        submit=(Button)findViewById(R.id.sumitseller_btn);
        Fname = (EditText) findViewById(R.id.FnameSeller);
        UID = (EditText) findViewById(R.id.UIDseller);
        Email = (EditText) findViewById(R.id.Emailseller);
        Phn = (EditText) findViewById(R.id.Phnseller);
        Exctloc = (EditText) findViewById(R.id.locationseller);
        Locality = (EditText) findViewById(R.id.localityseller);
        Weight = (EditText) findViewById(R.id.weightseller);
        Desc = (EditText) findViewById(R.id.descseeler);

        db=FirebaseFirestore.getInstance();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name= Fname.getText().toString().trim();
                String uid= UID.getText().toString().trim();
                String email= Email.getText().toString().trim();
                String phn= Phn.getText().toString().trim();
                String exctloc = Exctloc.getText().toString().trim();
                String locality= Locality.getText().toString().trim();
                Integer weight= Integer.valueOf(Weight.getText().toString().trim());
                String desc = Desc.getText().toString().trim();





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

                if (exctloc.isEmpty()) {
                    Exctloc.setError("Please Enter Your Full Name!");
                    Exctloc.requestFocus();
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
                if (desc.isEmpty()) {
                    Desc.setError("Please Enter Your Full Name!");
                    Desc.requestFocus();
                    return;
                }
                if (weight<=0) {
                    Weight.setError("Please Enter Weight!");
                    Weight.requestFocus();
                    return;
                }

                Seller seller = new Seller(name, uid, phn, email, exctloc, locality, weight, desc);

                CollectionReference dbSellers = db.collection("Sellers");

//

                dbSellers.add(seller).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Intent intent=new Intent(getApplicationContext(),UserDashboard.class);
                        startActivity(intent);
                        Toast.makeText(BuyMe.this, "Successful", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(BuyMe.this, "Failed", Toast.LENGTH_SHORT).show();
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