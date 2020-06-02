package com.example.online_veggie;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Sign_Up extends AppCompatActivity {
    EditText  email_field,password_field,repassword_field;
    Button sub_btn;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__up);
        sub_btn= (Button)findViewById(R.id.sub_btn_id);
        email_field= (EditText)findViewById(R.id.email_id);
        password_field= (EditText)findViewById(R.id.pass_id);
        repassword_field= (EditText)findViewById(R.id.repass_id);

        mAuth= FirebaseAuth.getInstance();


        sub_btn.setOnClickListener(new View.OnClickListener() {
            @Override
             public void onClick(View v) {
            String  email= email_field.getText().toString();
            String password= password_field.toString();
            String repassword= repassword_field.toString();

            if(!TextUtils.isEmpty(email)&!TextUtils.isEmpty(password)&&!TextUtils.isEmpty(repassword)){

                if(!password.equals(repassword)){

                    mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                startActivity(new Intent(Sign_Up.this,Categories_Activity.class));
                                finish();
                            }else {
                                Toast.makeText(Sign_Up.this, "Error"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

                }else {
                    Toast.makeText(Sign_Up.this,"Password not match",Toast.LENGTH_SHORT).show();
                }

            }else {
                Toast.makeText(Sign_Up.this, "Required All Field", Toast.LENGTH_SHORT).show();
            }

            }
        });



    }

}
