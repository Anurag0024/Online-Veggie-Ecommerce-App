package Authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.online_veggie.Categories_Activity;
import com.example.online_veggie.Expandable_list_items;
import com.example.online_veggie.R;
import com.example.online_veggie.Sign_Up;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Login_Activity extends AppCompatActivity {
   public Button login_btn,sign_up_btn;
    public EditText emailAddress,passwords;
  public  TextView tv;

  private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
        emailAddress= findViewById(R.id.email_id);
        passwords= findViewById(R.id.password_id);
        login_btn= findViewById(R.id.login_btn_id);
        sign_up_btn= findViewById(R.id.signup_btn_id);
        tv= findViewById(R.id.tv_id);


        mAuth= FirebaseAuth.getInstance();
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email= emailAddress.getText().toString();
                String pass= passwords.getText().toString();

                if(!TextUtils.isEmpty(email)&&!TextUtils.isEmpty(pass)){
                    mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                startActivity(new Intent(Login_Activity.this,Categories_Activity.class));
                                finish();
                            }else {
                              Toast.makeText(Login_Activity.this,"Error:"+ task.getException().getMessage(),Toast.LENGTH_SHORT);

                            }
                        }
                    });

                }else {
                    Toast.makeText(Login_Activity.this, "  you forget to put some data", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
    public  void signup(View v1){
       Intent in = new Intent(Login_Activity.this,Sign_Up.class);
       startActivity(in);
    }
    public  void expand(View v3){
        Intent in = new Intent(Login_Activity.this, Expandable_list_items.class);
        startActivity(in);
    }



}
