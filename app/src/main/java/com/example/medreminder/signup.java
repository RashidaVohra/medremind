package com.example.medreminder;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class signup extends AppCompatActivity {
    private Button button3;
    private FirebaseAuth mAuth;
    EditText Username1, Birthdate1, Phonenumber1, Password1, Email1;
    boolean isUsernameValid1, isBirthdateValid1, isEmailValid1, isPasswordValid1, isPhonenumberValid1;

    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("Users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Username1 = (EditText) findViewById(R.id.Username1);
        Birthdate1 = (EditText) findViewById(R.id.Birthdate1);
        Email1 = (EditText) findViewById(R.id.Email1);
        Phonenumber1 = (EditText) findViewById(R.id.Phonenumber1);
        Password1 = (EditText) findViewById(R.id.Password);
        button3 = (Button) findViewById(R.id.button3);
        mAuth = FirebaseAuth.getInstance();
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetValidation();
                String username = Username1.getText().toString();
                String birthdate = Birthdate1.getText().toString();
                String email = Email1.getText().toString();
                String phonenum = Phonenumber1.getText().toString();
                String password = Password1.getText().toString();
                HashMap<String, String> userMap = new HashMap<>();
                userMap.put("username", username);
                userMap.put("BirthDate", birthdate);
                userMap.put("email", email);
                userMap.put("Phonenumber", phonenum);
                userMap.put("Password", password);
                root.push().setValue(userMap);
                //root.child("Username").setValue(username);
                //root.child("EmailId").setValue(email);
                //root.child("Birthdate").setValue(birthdate);
                //root.child("PhoneNumber").setValue(phonenum);
                //root.child("Password").setValue(password);
                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            // send verification link

                            FirebaseUser fuser = mAuth.getCurrentUser();
                            fuser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(signup.this, "Verification Email Has been Sent.", Toast.LENGTH_SHORT).show();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                private static final String TAG = "";

                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG, "onFailure: Email not sent " + e.getMessage());
                                }
                            });
                        }

                    }
                });
            }

                    private void SetValidation() {
                        if (Username1.getText().toString().isEmpty()) {
                            Username1.setError(getResources().getString(R.string.error_invalid_username));
                            Username1.setError("Username is required");
                            isUsernameValid1 = false;
                        } else {
                            isUsernameValid1 = true;
                        }
                        // Check for a valid birthdate

                        if (Birthdate1.getText().toString().isEmpty()) {
                            Birthdate1.setError(getResources().getString(R.string.error_invalid_Birthdate));
                            Birthdate1.setError("Birthdate is required");
                            isBirthdateValid1 = false;
                        } else {
                            isBirthdateValid1 = true;
                        }

                        // Check for a valid phone number.
                        String val1 = Phonenumber1.getEditableText().toString().trim();
                        String MobilePattern = "[0-9]{10}";
                        if (Phonenumber1.getText().toString().matches(MobilePattern)) {
                            isPhonenumberValid1 = true;

                        } else if (!Phonenumber1.getText().toString().matches(MobilePattern)) {

                            Phonenumber1.setError(getResources().getString(R.string.error_invalid_Phonenumber));
                            Phonenumber1.setError("Phonenumber is required");
                            isPhonenumberValid1 = false;
                        } else {

                            isPhonenumberValid1 = true;
                        }
                        if (Email1.getText().toString().isEmpty()) {
                            Email1.setError(getResources().getString(R.string.email_error));
                            Email1.setError("Email is required");
                            isEmailValid1 = false;
                        } else if (!Patterns.EMAIL_ADDRESS.matcher(Email1.getText().toString()).matches()) {
                            Email1.setError(getResources().getString(R.string.error_invalid_email));
                            Email1.setError("Enter valid Email formate");

                            isEmailValid1 = false;
                        } else {
                            isEmailValid1 = true;
                        }


                        // Check for a valid password.
                        if (Password1.length() == 0) {
                            Password1.setError("Password is required");
                            isPasswordValid1 = false;
                        } else if (Password1.length() < 8) {
                            Password1.setError("Password must be minimum 8 characters");
                            isPasswordValid1 = false;
                        } else {
                            isPasswordValid1 = true;
                        }
                        if (isUsernameValid1 && isBirthdateValid1 && isEmailValid1 && isPasswordValid1 && isPhonenumberValid1) {
                            Toast.makeText(getApplicationContext(), "Successfully login", Toast.LENGTH_SHORT).show();
                            Intent i1 = new Intent(getApplicationContext(), home.class);
                            startActivity(i1);
                        }
                    }
                });
            }


}




