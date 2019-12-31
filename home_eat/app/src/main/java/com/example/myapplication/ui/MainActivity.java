package com.example.myapplication.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);






           /*     for (int i=0;i<8;i++)
                {



                        Items item1=new Items("pizza"+i,"piz1",1200,"desc1");
                        Items item2=new Items("Burger"+i,"burger1",650,"desc");
                        Items item3=new Items("drinks"+i,"piz1",1200,"desc");
                        Items item4=new Items("sides"+i,"piz1",1200,"desc");
                        Items item5=new Items("dessert"+i,"piz1",1200,"desc");


                        ArrayList<Items> arr=new ArrayList<Items>();
                            arr.add(item1);
                        arr.add(item2);
                        arr.add(item3);
                        arr.add(item4);
                        arr.add(item5);


                        Category category1=new Category("Pizza"+i+i,"catPiz",arr);
                        Category category2=new Category("Burgers"+i+i,"catPiz",arr);
                        Category category3=new Category("Drinks"+i+i,"catPiz",arr);
                        Category category4=new Category("Sides"+i+i,"catPiz",arr);
                        Category category5=new Category("Desserts"+i+i,"catPiz",arr);

                        ArrayList<Category> catArray=new ArrayList<Category>();

                        catArray.add(category1);
                        catArray.add(category2);
                        catArray.add(category3);
                        catArray.add(category4);
                        catArray.add(category5);

                        Menu mMenu=new Menu(catArray);


                        FirebaseDatabase database = FirebaseDatabase.getInstance();
                        DatabaseReference myRef = database.getReference("vendors");

                        String vendorID=myRef.push().getKey();


                        Vendor ven=new Vendor(vendorID,"Hassan Tariq"+i,"abduls03357@gmail.com","IH 122",
                                "123456",500,30,30.5,15.1,mMenu,"9:00 AM","10:00 PM");

                        myRef.child(ven.getName()).setValue(ven);


                }
*/


    }
}
