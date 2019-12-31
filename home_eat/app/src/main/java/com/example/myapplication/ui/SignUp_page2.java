package com.example.myapplication.ui;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.myapplication.R;
import com.example.myapplication.ui.login.logIn;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class SignUp_page2 extends AppCompatActivity {

    @BindView(R.id.img_spice_low)
    CircleImageView imgSpiceLow;
    @BindView(R.id.img_spice_mild)
    CircleImageView imgSpiceMild;
    @BindView(R.id.img_spice_hot)
    CircleImageView imgSpiceHot;
    @BindView(R.id.img_spice_extreme)
    CircleImageView imgSpiceExtreme;
    @BindView(R.id.img_summer)
    CircleImageView imgSummer;
    @BindView(R.id.img_spring)
    CircleImageView imgSpring;
    @BindView(R.id.img_autumn)
    CircleImageView imgAutumn;
    @BindView(R.id.img_winter)
    CircleImageView imgWinter;
    @BindView(R.id.img_budget_low)
    CircleImageView imgBudgetLow;
    @BindView(R.id.img_budget_mid)
    CircleImageView imgBudgetMid;
    @BindView(R.id.img_budget_high)
    CircleImageView imgBudgetHigh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page2);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btn_continue_sign_up2)
    public void btn_continue_clicked() {
        startActivity(new Intent(SignUp_page2.this, SignUp_page3.class));
        finish();
    }

    @OnClick(R.id.img_spice_low)
    public void spice_low_clicked() {
        spiceSelectorRepositioning();
        imgSpiceLow.setBackgroundResource(R.drawable.spice_low_selected);

    }

    @OnClick(R.id.img_spice_mild)
    public void spice_mild_clicked() {
        spiceSelectorRepositioning();
        imgSpiceMild.setBackgroundResource(R.drawable.spice_medium_selected);


    }

    @OnClick(R.id.img_spice_hot)
    public void spice_hot_clicked() {
        spiceSelectorRepositioning();
        imgSpiceHot.setBackgroundResource(R.drawable.spice_hot_selected);
    }

    @OnClick(R.id.img_spice_extreme)
    public void spice_extreme_clicked() {
        spiceSelectorRepositioning();
        imgSpiceExtreme.setBackgroundResource(R.drawable.spice_extreme_selected);
    }

    void spiceSelectorRepositioning()
    {
        imgSpiceLow.setBackgroundResource(R.drawable.spice_low);
        imgSpiceMild.setBackgroundResource(R.drawable.spice_medium);
        imgSpiceHot.setBackgroundResource(R.drawable.spice_hot);
        imgSpiceExtreme.setBackgroundResource(R.drawable.spice_extreme);


    }

    @OnClick(R.id.img_summer)
    public void summer_clicked() {
        seasonsSelectorRepositioning();
        imgSummer.setBackgroundResource(R.drawable.summer_selected);

    }

    @OnClick(R.id.img_winter)
    public void winter_clicked() {
        seasonsSelectorRepositioning();
        imgWinter.setBackgroundResource(R.drawable.winter_selected);

    }

    @OnClick(R.id.img_autumn)
    public void autumn_clicked() {
        seasonsSelectorRepositioning();
        imgAutumn.setBackgroundResource(R.drawable.autumn_selected);

    }

    @OnClick(R.id.img_spring)
    public void spring_clicked() {
        seasonsSelectorRepositioning();
        imgSpring.setBackgroundResource(R.drawable.spring_selected);

    }


    void seasonsSelectorRepositioning()
    {
        imgSummer.setBackgroundResource(R.drawable.summer);
        imgAutumn.setBackgroundResource(R.drawable.autumn);
        imgWinter.setBackgroundResource(R.drawable.winter);
        imgSpring.setBackgroundResource(R.drawable.spring);


    }

    @OnClick(R.id.img_budget_low)
    public void budget_low_clicked() {
        budgetSelectorRepositioning();
        imgBudgetLow.setBackgroundResource(R.drawable.budget_low_selected);

    }

    @OnClick(R.id.img_budget_mid)
    public void budget_mid_clicked() {
        budgetSelectorRepositioning();
        imgBudgetMid.setBackgroundResource(R.drawable.budget_mid_selected);

    }

    @OnClick(R.id.img_budget_high)
    public void budget_high_clicked() {
        budgetSelectorRepositioning();
        imgBudgetHigh.setBackgroundResource(R.drawable.budget_high_selected);

    }


    void budgetSelectorRepositioning()
    {
        imgBudgetLow.setBackgroundResource(R.drawable.budget_low);
        imgBudgetMid.setBackgroundResource(R.drawable.budget_mid);
        imgBudgetHigh.setBackgroundResource(R.drawable.budget_high);

    }
}
