package com.example.myapplication.ui.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.SharedPreferences.SharedPreferencesEditor;
import com.example.myapplication.ui.OrderPage;
import com.example.myapplication.ui.SignUp_page1;
import com.example.myapplication.ui.SignUp_page2;
import com.example.myapplication.ui.SignUp_page3;
import com.example.myapplication.ui.splashScreen;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.vansuita.pickimage.bundle.PickSetup;
import com.vansuita.pickimage.dialog.PickImageDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class logIn extends AppCompatActivity {

    @BindView(R.id.et_email_login)
    EditText etEmail;
    @BindView(R.id.et_pass_login)
    EditText etPass;
    @BindView(R.id.tv_signUp_login)
    TextView tvSignUp;
    @BindView(R.id.btn_login)
    Button btnLogin;

    boolean isValidCheck=true;
    String mEmail;
    String mPass;
    private FirebaseAuth mAuth;

    TextView tvGoToSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        ButterKnife.bind(this);

        tvGoToSignUp=findViewById(R.id.tv_signUp_login);
        tvGoToSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(logIn.this, SignUp_page1.class));
                finish();

            }
        });

    }


    @OnClick(R.id.btn_login)
    public void login_btn_clicked() {


        etEmail=findViewById(R.id.et_email_login);
        etPass=findViewById(R.id.et_pass_login);

        mEmail= etEmail.getText().toString();
        mPass= etPass.getText().toString();

        if(isValid())
        {
            mAuth = FirebaseAuth.getInstance();
            mAuth.signInWithEmailAndPassword(mEmail, mPass)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                FirebaseUser user = mAuth.getCurrentUser();
                                startActivity(new Intent(logIn.this, OrderPage.class));
                                finish();




                            } else {
                                // If sign in fails, display a message to the user.Log.w(TAG, "signInWithEmail:failure", task.getException());
                                Toast.makeText(logIn.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();

                            }

                            // ...
                        }
                    });











           /* SharedPreferencesEditor sharedPreferencesEditor = new SharedPreferencesEditor(this);
            if(sharedPreferencesEditor.getUserID().equals(mEmail) && sharedPreferencesEditor.getPass().equals(mPass))
            {

            }
            else
            {
                Toast.makeText(logIn.this,"User not found",Toast.LENGTH_SHORT).show();
            }*/
        }
    }

    boolean isValid()
    {
        isValidCheck=true;
        if (TextUtils.isEmpty(mEmail)) {
            etEmail.setError("Please Enter Your E-mail Address");
            isValidCheck=false;
        }

/*
        if (!Patterns.EMAIL_ADDRESS.matcher(mEmail).matches()) {
            etEmail.setError("Please Enter Correct E-mail Address");
            isValidCheck=false;
        }
*/

        if (TextUtils.isEmpty(mPass)) {
            etPass.setError("Please Enter Your Correct Password");
            isValidCheck=false;
        }
        return isValidCheck;
    }



}
