package com.deepmodi.firebaserealtimedatabaseprojectone;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.deepmodi.firebaserealtimedatabaseprojectone.Model.UserData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    EditText user_edit_name,user_edit_surname,user_edit_phoneNumber;
    Button btn_uploadData;
    FirebaseDatabase database;
    DatabaseReference user_data;
    String userStName,userStSurname,userStNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //firebase init
        database = FirebaseDatabase.getInstance();
        user_data = database.getReference("User Data");

        user_edit_name = (EditText)findViewById(R.id.user_name);
        user_edit_surname = (EditText)findViewById(R.id.user_surname);
        user_edit_phoneNumber = (EditText)findViewById(R.id.userphone_number);



        btn_uploadData = (Button)findViewById(R.id.btn_upload_data);

        btn_uploadData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userStName = user_edit_name.getText().toString();
                userStSurname = user_edit_surname.getText().toString();
                userStNumber = user_edit_phoneNumber.getText().toString();

                user_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(userStName.isEmpty())
                        {
                            user_edit_name.setError("Please enter your name");
                            user_edit_name.requestFocus();
                        }
                        else if(userStSurname.isEmpty())
                        {
                            user_edit_surname.setError("Please enter your surname");
                            user_edit_surname.requestFocus();
                        }
                        else if(userStNumber.isEmpty() || userStNumber.length() < 10)
                        {
                            user_edit_phoneNumber.setError("Please enter valid number");
                            user_edit_phoneNumber.requestFocus();
                        }
                        else
                        {
                            UserData userData = new UserData(userStName,userStSurname,userStNumber);
                            user_data.child(userStNumber).setValue(userData);
                            Toast.makeText(MainActivity.this, "Data is uploaded.", Toast.LENGTH_SHORT).show();
                        }


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });


    }
}
