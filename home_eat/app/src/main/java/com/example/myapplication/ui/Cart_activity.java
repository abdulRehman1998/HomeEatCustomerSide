package com.example.myapplication.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.adapters.cartItemsAdapter;
import com.example.myapplication.models.Order;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Cart_activity extends AppCompatActivity {

    Order mOrder;
    TextView tvSubtotal;
    TextView tvTotal;
    TextView tvTax;
    TextView tvDeliveryCharges;
    private FirebaseAuth mAuth;
    RecyclerView rv;

    Button btnOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        mOrder= (Order) getIntent().getSerializableExtra("EXTRA_ORDER");

        tvSubtotal=findViewById(R.id.subTotal_cart);
        //total
        tvSubtotal.setText("Rs. " +String.valueOf(mOrder.getTotalPrice()));
        float totalPrice =mOrder.getTotalPrice();
        float tax= (float) (totalPrice*(0.16));
        totalPrice=totalPrice+tax+150;

        tvDeliveryCharges=findViewById(R.id.deliveryCharges_cart);
        tvDeliveryCharges.setText("Rs. 150");
        tvTotal=findViewById(R.id.total_cart);
        tvTotal.setText(String.valueOf(totalPrice));
        tvTax=findViewById(R.id.tax_cart);
        tvTax.setText("Rs. " +String.valueOf(tax));

        btnOrder=findViewById(R.id.btnOrder);
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mAuth = FirebaseAuth.getInstance();
                FirebaseUser user = mAuth.getCurrentUser();

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Orders").child(user.getUid());

                myRef.setValue(mOrder);

                Toast.makeText(Cart_activity.this,"Order Confirmed ",Toast.LENGTH_LONG).show();
                startActivity(new Intent(Cart_activity.this, OrderPage.class));
                finish();



            }
        });


        rv=findViewById(R.id.rv_cart);
        rv.setLayoutManager(new LinearLayoutManager(Cart_activity.this));
        cartItemsAdapter adapter = new cartItemsAdapter(Cart_activity.this,mOrder);
        rv.setAdapter(adapter);




    }
}
