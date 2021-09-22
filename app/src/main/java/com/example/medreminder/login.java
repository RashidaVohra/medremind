package com.example.medreminder;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login<mDatabase> extends AppCompatActivity {

    private Button button1, button2;
    boolean isUsernameValid, isPasswordValid;
    EditText Email1, Password;
    private ProgressBar progressBar;
    private FirebaseAuth auth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        auth = FirebaseAuth.getInstance();

        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(String.valueOf(login.this)));
            finish();
        }

        setContentView(R.layout.activity_login2);

        auth = FirebaseAuth.getInstance();
        Email1 = (EditText) findViewById(R.id.email);
        Password = (EditText) findViewById(R.id.password);
        auth = FirebaseAuth.getInstance();
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);



//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SetValidation();
//            }
//        });
//
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to RegisterActivity
                Toast.makeText(getApplicationContext(), "Register Now", Toast.LENGTH_SHORT).show();
                Intent i1 = new Intent(getApplicationContext(),signup.class);
                startActivity(i1);
            }
        });


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Email1.getText().toString().trim();
                final String password = Password.getText().toString().trim();
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }


                 //progressBar.setVisibility(View.VISIBLE);
                auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(login.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),home.class));
                        } else {
                            Toast.makeText(login.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            //progressBar.setVisibility(View.GONE);
                        }
                    }
                });
//                DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");
//                Query checkUser = reference.orderByChild("email").equalTo(email);
//                checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if(snapshot.exists()) {
//                            String passwordFromDb = snapshot.child(email).child("Password").getValue(String.class);
//                            if(passwordFromDb.equals(password))
//                            {
//                                Intent intent = new Intent(getApplicationContext(), home.class);
//                                startActivity(intent);
//                            }
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });
//                 DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("U sers");
//                String data = reference.toString();
//                try {
//                    JSONObject myjson = new JSONObject();
//                    JSONArray arr = myjson.getJSONArray(data);
//
//                    ArrayList<JSONObject> arrays = new ArrayList<JSONObject>();
//                   String  arrjson[] = new String[arrays.size()];
//                    for(int i=0; i < arr.length(); i++)
//                    {
//                        JSONObject another_json_object = arr.getJSONObject(i);
//                        arrays.add(another_json_object);
//                    }
//                    for(int i = 0; i< arrjson.length; i++) {
//                        Log.e(null,arrjson[i]);
//                    }
//                } catch (Exception e)
//                {
//                    e.printStackTrace();
//                }
//
//
//                reference.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                            if(dataSnapshot.exists()) {
//                                Log.d("Data", dataSnapshot.getValue().toString());
//                            }
//                            else {
//                                Log.d(null,"not exists");
//                            }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });
//                mDatabase.child("user").child(email).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<DataSnapshot> task) {
//                        if (!task.isSuccessful()) {
//                            Log.e("firebase", "Error getting data", task.getException());
//                        }
//                        else {
//                            Log.d("firebase", String.valueOf(task.getResult().getValue()));
//                        }
//                    }
//                });
                //authenticate user
//                auth.signInWithEmailAndPassword(email, password)
//                        .addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>() {
//                            @Override
//                            public void onComplete(@NonNull Task<AuthResult> task) {
//                                // If sign in fails, display a message to the user. If sign in succeeds
//                                // the auth state listener will be notified and logic to handle the
//                                // signed in user can be handled in the listener.
////                                progressBar.setVisibility(View.GONE);
//                                if (!task.isSuccessful()) {
//                                    // there was an error
//                                    if (password.length() < 6) {
//
//
//
////                                        Intent i1 = new Intent(getApplicationContext(),home.class);
////                                        startActivity(i1);
//    //                                        password.setError(getString(R.string.minimum_password));
//                                    } else {
//                                        Toast.makeText(login.this, getString(R.string.auth_failed), Toast.LENGTH_LONG).show();
//                                    }
//                                } else {
//                                    Intent intent = new Intent(login.this, home.class);
//                                    startActivity(intent);
//                                    finish();
//                                }
//                            }
//                        });
            }
        });
    }
}
//    public static String EncodeString(String email)
//    {
//        return email.replace(".",",");
//    }
//    public static String DecodingString(String email)
//    {
//        return email.replace(",",".");
//    }

//    public void SetValidation() {
//        // Check for a valid username address.
//        if (Email1.getText().toString().isEmpty()) {
//
//            isUsernameValid = false;
//        } else {
//            isUsernameValid = true;
//        }
//
//
//        // Check for a valid password.
//        if (Password.getText().toString().isEmpty()) {
//
//            isPasswordValid = false;
//        } else if (Password.getText().length() < 8) {
//            Password.setError(getResources().getString(R.string.Error_invalid_password));
//            isPasswordValid = false;
//        } else  {
//            isPasswordValid = true;
//        }
//
//        if (isUsernameValid && isPasswordValid) {
//            Toast.makeText(getApplicationContext(), "Successfully", Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(getApplicationContext(), home.class);
//            startActivity(intent);
//
//        }
//
//
//    }
//
//}