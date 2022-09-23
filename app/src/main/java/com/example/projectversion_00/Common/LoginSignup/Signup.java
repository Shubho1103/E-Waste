package com.example.projectversion_00.Common.LoginSignup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projectversion_00.Common.UserDashboard;
import com.example.projectversion_00.R;
import com.example.projectversion_00.User_data;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {

    private EditText Fname, UID, Email, Pwd, Phn;

    FirebaseAuth Auth;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.signup);

        Auth = FirebaseAuth.getInstance();

        Fname = (EditText) findViewById(R.id.Fname);
        UID = (EditText) findViewById(R.id.UID);
        Email = (EditText) findViewById(R.id.Email);
        Phn = (EditText) findViewById(R.id.Phn);
        Pwd = (EditText) findViewById(R.id.Pwd);


    }

    public void back_to_StartupScreen(View view) {
        Intent intent = new Intent(getApplicationContext(), UserDashboard.class);
        startActivity(intent);
    }

    public void signupbtn(View view)
    {
        String email = Email.getText().toString().trim();
        String phone = Phn.getText().toString().trim();
        String password = Pwd.getText().toString().trim();
        String uname = UID.getText().toString().trim();
        String name = Fname.getText().toString().trim();

        if (name.isEmpty()) {
            Fname.setError("Please Enter Your  Name!");
            Fname.requestFocus();
            return;
        }

        if (uname.isEmpty()) {
            UID.setError("Please Enter Your User Name!");
            UID.requestFocus();
            return;
        }

        if (phone.isEmpty()) {
            Phn.setError("Please Enter Your Phone No.!");
            Phn.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            Pwd.setError("Please Enter Your Password!");
            Pwd.requestFocus();
            return;
        }

        if (email.isEmpty()) {
            Email.setError("Please Enter Your Email!");
            Email.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Email.setError("Please Enter Your Full Name!");
            Email.requestFocus();
            return;
        }

        Auth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        User_data user_data = new User_data(name, uname, email, phone, password);
                        if (task.isSuccessful()) {


                            FirebaseDatabase.getInstance().getReference("User")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user_data).addOnCompleteListener(new OnCompleteListener<Void>()
                                    {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {

                                            if (task.isSuccessful()) {
                                                Toast.makeText(Signup.this, "You have been succesfully registered", Toast.LENGTH_LONG).show();
                                                Intent intent=new Intent(getApplicationContext(),UserDashboard.class);
                                                startActivity(intent);
                                            } else {
                                                Toast.makeText(Signup.this, "unsucessfull please try again", Toast.LENGTH_LONG).show();
                                            }


                                        }

                                    });

                        }
                        else {


                                                Toast.makeText(Signup.this, "unsucessfull please try again", Toast.LENGTH_LONG).show();

                        }
                    }
                });

    }

}