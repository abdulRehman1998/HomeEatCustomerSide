package com.example.myapplication.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.adapters.cuisineAdapter;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUp_page3 extends AppCompatActivity {

    RecyclerView rvFirstChoice;
    RecyclerView rvSecondChoice;
    RecyclerView rvThirdChoice;

    String[] firstChoice={"Pakistani","Italian","Mexican","Chinese","American","Asian"};
    private static final Integer[] firstChoiceImgs ={ R.drawable.pakistani_selected, R.drawable.italian_unselected, R.drawable.mexican_unselected, R.drawable.chinese_unselected, R.drawable.american_unselected, R.drawable.asian_unselected};

    String[] secondChoice={"Burger","Pizza","Beverages","Sandwiches"};
    private static final Integer[] secondChoiceImgs ={ R.drawable.burger_unselected, R.drawable.pizza_selected, R.drawable.beverages_unselected, R.drawable.sandwiches_unselected};

    String[] thirdChoice={"SeaFood","FastFood","Bakery","Healthy","Vegetarian","Desserts"};
    private static final Integer[] thirdChoiceImgs ={ R.drawable.sea_food_selected, R.drawable.fast_food_selected, R.drawable.backery_unselected, R.drawable.healthy_unselected, R.drawable.vegeterian_unselected, R.drawable.desserts_unselected};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page3);
        ButterKnife.bind(this);

        setSeasons();
        setSpices();
        setBudget();

    }


    void setBudget()
    {
        rvFirstChoice = findViewById(R.id.rv_first_choice);
        cuisineAdapter spiceAdapter = new cuisineAdapter (firstChoice,firstChoiceImgs);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        rvFirstChoice.setLayoutManager(layoutManager);
        rvFirstChoice.setAdapter(spiceAdapter);

    }

    void setSpices()
    {
        rvSecondChoice = findViewById(R.id.rv_second_choice);
        cuisineAdapter spiceAdapter = new cuisineAdapter(secondChoice,secondChoiceImgs);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        rvSecondChoice.setLayoutManager(layoutManager);
        rvSecondChoice.setAdapter(spiceAdapter);

    }

    void setSeasons()
    {
        rvThirdChoice = findViewById(R.id.rv_third_choice);
        cuisineAdapter seasonAdapter = new cuisineAdapter(thirdChoice,thirdChoiceImgs);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        rvThirdChoice.setLayoutManager(layoutManager);
        rvThirdChoice.setAdapter(seasonAdapter);

    }

    @OnClick(R.id.btn_continue_sign_up3)
    public void btn_continue_clicked() {
        startActivity(new Intent(SignUp_page3.this, OrderPage.class));
        finish();
    }


}
