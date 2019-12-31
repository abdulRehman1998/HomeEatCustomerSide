package com.example.myapplication.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.ServiceGenerator.servicesGenerator;
import com.example.myapplication.adapters.horizontalAdapter;
import com.example.myapplication.clients.customerClient;
import com.example.myapplication.clients.vendorsClient;
import com.example.myapplication.fragments.ordersLandingPage_Fragment;
import com.example.myapplication.fragments.searchResults_Fragment;
import com.example.myapplication.models.Category;
import com.example.myapplication.models.Items;
import com.example.myapplication.models.Menu;
import com.example.myapplication.models.Order;
import com.example.myapplication.models.Reviews;
import com.example.myapplication.models.customerModels.Customer;
import com.example.myapplication.models.vendorModels.Vendor;
import com.google.firebase.database.DatabaseReference;
import com.vansuita.pickimage.bean.PickResult;
import com.vansuita.pickimage.bundle.PickSetup;
import com.vansuita.pickimage.dialog.PickImageDialog;
import com.vansuita.pickimage.listeners.IPickResult;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;

public class OrderPage extends AppCompatActivity implements IPickResult {

    @BindView(R.id.btn_back_search)
    Button btnBackSearch;
    @BindView(R.id.btn_search)
    Button btnSearch;
    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.txtSearchText)
    TextView txtSearchText;

    String searchText;

    DrawerLayout mDrawer;
    ImageView imgMenu;
    ImageView imgProfile;

    ImageView imgProfileOrder;
    TextView tvProfile;
    Menu mMenu;
    List<Vendor> vendorsList;
    ArrayList<Vendor> searchList;
    private DatabaseReference mRef;
    boolean itemFound=false;

    Vendor vendor;
    Order mOrder=new Order();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);
        ButterKnife.bind(this);


        vendorsList=new ArrayList<Vendor>();


        final ProgressDialog progressDialog = new ProgressDialog(this);

        progressDialog.setTitle("Loading Vendors...");
        progressDialog.show();


        Customer customer=new Customer("id","abdul@gmail.com","12345678","Abdul","03357870139",15,"99 Meraj Park");






        //   values();
        getAllVendors();


        inflateDrawer();
        btnClicks();


        progressDialog.dismiss();








    }


    void getAllVendors()
    {
        vendorsClient service = servicesGenerator.getRetrofitInstance().create(vendorsClient.class);
        Call<List<Vendor>> call = service.getVendors();
            call.enqueue(new Callback<List<Vendor>>() {
                @Override
                public void onResponse(Call<List<Vendor>> call, Response<List<Vendor>> response) {
                    if(response.code() == 200) {


                        vendorsList=response.body();
                        loadFragment(new ordersLandingPage_Fragment(vendorsList),0);


                    }
                    else if(response.errorBody() != null)
                        Toast.makeText(OrderPage.this, "Error "+response.errorBody().toString(),Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(OrderPage.this, Integer.toString(response.code()), Toast.LENGTH_SHORT).show();

                }

                @Override
                public void onFailure(Call<List<Vendor>> call, Throwable t) {
                    Log.d("123321",t.getMessage());
                    Toast.makeText(OrderPage.this, "Please check your connectivity...", Toast.LENGTH_SHORT).show();

                }
            });



    }









    public  boolean loadFragment(Fragment fragment, int check) {

        if(check==1)
        {
            btnBackSearch.setEnabled(true);
            btnBackSearch.setBackgroundResource(R.drawable.ic_cross);
            txtSearchText.setText("Search Results");
        }
        else
        {   btnBackSearch.setEnabled(false);
            txtSearchText.setText("");
            btnBackSearch.setBackgroundResource(0);
        }


        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fl_orderPage, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    void inflateDrawer()
    {
        mDrawer = findViewById(R.id.drawerLayout);
        imgMenu = findViewById(R.id.img_menu);

        imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawer.openDrawer(Gravity.LEFT);
            }
        });

    }

    void btnClicks()
    {
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchList=new ArrayList<Vendor>();

                searchText = etSearch.getText().toString();
                if (TextUtils.isEmpty(searchText)) {
                    etSearch.setError("Please Fill Text Field");

                } else
                {
                    //searchLoop
                    for (int i = 0; i < vendorsList.size(); i++) {

                        if (vendorsList.get(i).getName().toLowerCase().contains(searchText.toLowerCase()) ||
                                searchText.toLowerCase().contains(vendorsList.get(i).getName().toLowerCase())) {
                            searchList.add(vendorsList.get(i));
                            continue;
                        }

                        for (int j = 0; j < vendorsList.get(i).getMenu().getcategoriesList().size(); j++) {
                            if (itemFound) {
                                itemFound = false;
                                break;
                            }
                            if (vendorsList.get(i).getMenu().getcategoriesList().get(j).getName().toLowerCase().contains(searchText.toLowerCase()) ||
                                    searchText.toLowerCase().contains(vendorsList.get(i).getMenu().getcategoriesList().get(j).getName().toLowerCase())) {
                                searchList.add(vendorsList.get(i));
                                break;
                            } else {
                                for (int k = 0; k < vendorsList.get(i).getMenu().getcategoriesList().get(j).getItems().size(); k++) {
                                    if (vendorsList.get(i).getMenu().getcategoriesList().get(j).getItems().get(k).getName().toLowerCase().contains(searchText.toLowerCase())
                                            || searchText.toLowerCase().contains(vendorsList.get(i).getMenu().getcategoriesList().get(j).getItems().get(k).getName().toLowerCase())) {
                                        searchList.add(vendorsList.get(i));
                                        itemFound = true;
                                        break;
                                    }
                                }

                            }


                        }


                    }

                loadFragment(new searchResults_Fragment(searchList), 1);
            }

            }
        });

        btnBackSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loadFragment(new ordersLandingPage_Fragment(vendorsList), 0);


            }
        });

        imgProfile=findViewById(R.id.img_profile);
        imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PickImageDialog.build(new PickSetup()).show(OrderPage.this);
            }
        });

        imgProfileOrder=findViewById(R.id.img_profile_order);
        imgProfileOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OrderPage.this, Profile_page.class));
                finish();
            }
        });

        tvProfile=findViewById(R.id.tv_profile_order);
        tvProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OrderPage.this, Profile_page.class));
                finish();
            }
        });
    }

    void values()
    {

        Items item1=new Items("sad0","Burger","juicy Burger",0,650,65);
        Items item2=new Items("sad0","Pizza","juicy Burger",0,650,65);
        Items item3=new Items("sad0","Burger","juicy Burger",0,650,65);
        Items item4=new Items("sad0","Drink","juicy Burger",0,650,65);
        Items item5=new Items("sad0","Burger","juicy Burger",0,650,65);


        ArrayList<Items> arr=new ArrayList<Items>();
        arr.add(item1);
        arr.add(item2);
        arr.add(item3);
        arr.add(item4);
        arr.add(item5);


        Category category1 =new Category("Pizza","catPiz",arr);
        Category category2 =new Category("Burgers","catPiz",arr);
        Category category3 =new Category("Drinks","catPiz",arr);
        Category category4 =new Category("Sides","catPiz",arr);
        Category category5 =new Category("Desserts","catPiz",arr);

        ArrayList<Category> catArray=new ArrayList<Category>();

        catArray.add(category1);
        catArray.add(category2);
        catArray.add(category3);
        catArray.add(category4);
        catArray.add(category5);

        mMenu=new Menu(catArray);




        for (int i=0;i<8;i++)
        {
            Vendor ven= new Vendor("id","Abdul","123456","abdul123","1232123132123","asd",
                    "abdul@rehman.com",12,"99Meraj Park",5,231.21,231.21,321.54,
                    false,mMenu);

            vendorsList.add(ven);
        }

        Items item11=new Items("sad0","chiko","juicy Burger",0,650,65);
        Items item21=new Items("sad0","Pizza","juicy Burger",0,650,65);
        Items item31=new Items("sad0","Burger","juicy Burger",0,650,65);
        Items item41=new Items("sad0","Drink","juicy Burger",0,650,65);
        Items item51=new Items("sad0","Burger","juicy Burger",0,650,65);


        ArrayList<Items> arr1=new ArrayList<Items>();
        arr1.add(item11);
        arr1.add(item21);
        arr1.add(item31);
        arr1.add(item41);
        arr1.add(item51);


        Category category11 =new Category("Pizza","catPiz",arr1);
        Category category21 =new Category("rotiyan","catPiz",arr1);
        Category category31 =new Category("Drinks","catPiz",arr1);
        Category category41 =new Category("Sides","catPiz",arr1);
        Category category51 =new Category("Desserts","catPiz",arr1);

        ArrayList<Category> catArray1=new ArrayList<Category>();

        catArray1.add(category11);
        catArray1.add(category21);
        catArray1.add(category31);
        catArray1.add(category41);
        catArray1.add(category51);

        mMenu=new Menu(catArray1);



        Vendor ven= new Vendor("id","Hassan","123456","abdul123","1232123132123","asd",
                "abdul@rehman.com",12,"99Meraj Park",5,231.21,231.21,321.54,
                false,mMenu);

        vendorsList.add(ven);


    }

    @Override
    public void onPickResult(PickResult r) {

        imgProfile.setImageBitmap(r.getBitmap());
    }
}
