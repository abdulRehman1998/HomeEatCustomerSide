package com.example.myapplication.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.SharedPreferences.SharedPreferencesEditor;
import com.example.myapplication.models.customerModels.Customer;
import com.example.myapplication.models.Address;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUp_page1 extends AppCompatActivity {

    @BindView(R.id.et_name_register)
    EditText etName;
    @BindView(R.id.et_email_register)
    EditText etEmail;
    @BindView(R.id.et_pass_register)
    EditText etPass;
    @BindView(R.id.et_confirm_pass_register)
    EditText etConfirmPass;
    @BindView(R.id.et_number_register)
    EditText etNumber;
    @BindView(R.id.img_male)
    ImageView imgMale;
    @BindView(R.id.img_female)
    ImageView imgFemale;


    String mName;
    String mEmail;
    String mPass;
    String mConfirmPass;
    String mNumber;
    boolean isValidCheck=true;

    int genderCheck=-1;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page1);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.img_back_register1)
    public void login_btn_clicked() {
        startActivity(new Intent(SignUp_page1.this, splashScreen.class));
        finish();
    }


    @OnClick(R.id.img_male)
    public void male_clicked() {
        selectorRepositioning();
        genderCheck=1;
        imgMale.setBackgroundResource(R.drawable.male_selected);
    }

    @OnClick(R.id.img_female)
    public void female_clicked() {
        selectorRepositioning();
        genderCheck=0;
        imgFemale.setBackgroundResource(R.drawable.female_selected);
    }

    void selectorRepositioning()
    {
        imgFemale.setBackgroundResource(R.drawable.female_unselected);
        imgMale.setBackgroundResource(R.drawable.male_unselected);

    }



    @OnClick(R.id.btn_continue_sign_up1)
    public void register_btn_clicked() {


        mEmail= etEmail.getText().toString();
        mName= etName.getText().toString();
        mPass= etPass.getText().toString();
        mConfirmPass= etConfirmPass.getText().toString();
        mNumber= String.valueOf(etNumber.getText());

        if(isValid())
        {

            // Initialize Firebase Auth
            mAuth = FirebaseAuth.getInstance();

            mAuth.createUserWithEmailAndPassword(mEmail, mPass)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                FirebaseUser user = mAuth.getCurrentUser();

                                Address ad=new Address("ads","99","Meraj Park","Lahore","9",15.2,153.5,true);

                                Customer customer=new Customer(mEmail,mEmail,mPass,mName,mNumber,25,"saas");

                                SharedPreferencesEditor sharedPreferencesEditor = new SharedPreferencesEditor(SignUp_page1.this);
                                sharedPreferencesEditor.setUserID(mEmail);
                                sharedPreferencesEditor.setPass(mPass);


                                FirebaseDatabase database = FirebaseDatabase.getInstance();
                                DatabaseReference myRef = database.getReference("customers").child(user.getUid());

                                myRef.setValue(customer);

                                startActivity(new Intent(SignUp_page1.this, SignUp_page2.class));
                                finish();


                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(SignUp_page1.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                            }

                            // ...
                        }
                    });

        }
    }

    boolean isValid(){

        if(genderCheck==-1)
        {
            Toast.makeText(SignUp_page1.this,"Please Select Gender",Toast.LENGTH_LONG).show();
            isValidCheck=false;
        }

        isValidCheck = true;
        if (TextUtils.isEmpty(mEmail)) {
            etEmail.setError("Please Enter Your E-mail Address");
            isValidCheck = false;
        }

    /*    if (!Patterns.EMAIL_ADDRESS.matcher(mEmail).matches()) {
            etEmail.setError("Please Enter Correct E-mail Address");
            isValidCheck=false;
        }
*/
        if (TextUtils.isEmpty(mName)) {
            etName.setError("Please Enter Your name");
            isValidCheck=false;
        }
        if (TextUtils.isEmpty(mPass)) {
            etPass.setError("Please Enter Your Password");
            isValidCheck=false;
        }
        if (mPass.length()<6) {
            etPass.setError("Password must be at least 6 characters long.");
            isValidCheck=false;
        }

        if (TextUtils.isEmpty(mConfirmPass)) {
            etConfirmPass.setError("Please Confirm Your Password");
            isValidCheck=false;
        }

        if (!mPass.equals(mConfirmPass)) {
            etConfirmPass.setError("Incorrect! Please Confirm Your Password again");
            isValidCheck=false;
        }
        return isValidCheck;
    }




}
