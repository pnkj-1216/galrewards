package com.example.galrewardsfinal;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import androidx.core.view.GravityCompat;
import androidx.core.view.MenuItemCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.galrewardsfinal.databinding.ActivityAppMainScreenBinding;

public class AppMainScreenActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityAppMainScreenBinding binding;

    private ImageView imgbasket;
    private DrawerLayout drawerLayout;
    int count = 0;
    private Context context;
    //TextView textCartItemCount;
   // ImageView img_basket;
    MenuItem searchItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAppMainScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarAppMainScreen.toolbar);
        drawerLayout =(DrawerLayout) findViewById(R.id.drawer_layout);

        imgbasket =(ImageView) findViewById(R.id.img_basket);


        

     //   NavigationView navigationView = (NavigationView) findViewById(R.id.nav_bestdeal);
       // View nav_header = LayoutInflater.from(this).inflate(R.layout.item_bestseal, null);
//        ((TextView) nav_header.findViewById(R.id.name)).setText("UserName");
       // navigationView.addHeaderView(nav_header);

     /*  imgbasket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AppMainScreenActivity.this, LatestAddToCartCode.class);
                    startActivity(intent);
                }

        });*/
       // return rootview;



        //  img_basket.setOnClickListener((View.OnClickListener) this);
        //binding.appBarAppMainScreen.fab.setOnClickListener(new View.OnClickListener() {
           // @Override
          //  public void onClick(View view) {
               // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        //.setAction("Action", null).show();
         //   }
       // });

      //  NavigationView mNavigationView = (NavigationView) findViewById(R.id.account_navigation_view);

        //if (mNavigationView != null) {
            //mNavigationView.setNavigationItemSelectedListener(this);
       // }
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.menu_icon,R.id.nav_home, R.id.nav_galleryPrev, R.id.nav_slideshow,R.id.nav_game,R.id.nav_comput,R.id.nav_vouchers,R.id.nav_account,R.id.nav_profile,R.id.nav_help,
                R.id.nav_ticket,R.id.nav_orderhistory,R.id.nav_bestdeal,R.id.nav_logout,R.id.img_basket,R.id.nav_cart,R.id.action_cart,R.id.nav_health,R.id.nav_about, R.id.nav_newproduct,R.id.nav_slide)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_app_main_screen);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }






    //private void setSupportActionBar(HeaderLayBinding header) {
   // }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.app_main_screen, menu);
       final MenuItem menuItem = menu.findItem(R.id.action_cart);
       View actionView = MenuItemCompat.getActionView(menuItem);


       //COde For Search
        MenuItem searchItem = menu.findItem(R.id.action_search);
        //SearchView searchView = (SearchView)MenuItemCompat.getActionView(searchItem);

//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){



           // @Override
           // public boolean onQueryTextSubmit(String query) {
           //     return false;
        //    }

         //   @Override
         //   public boolean onQueryTextChange(String newText) {
             //   return false;
            //}
    //    });

        SearchManager searchManager = (SearchManager)getSystemService(Context.SEARCH_SERVICE);
    //    ComponentName componentName = new ComponentName(context, SearchableActivity.class);
    //    searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName));

        //textCartItemCount  =(TextView) actionView.findViewById(R.id.cart_badge);
       setupBadge();

//       actionView.setOnClickListener(new View.OnClickListener() {
  //         @Override
    //       public void onClick(View v) {
      //         onOptionsItemSelected(menuItem);
        //   }
       //
        // :});
        return true;
      //  MenuItem item =  menu.findItem(R.id.img_basket);
        //MenuItemCompat.setActionView(item,R.layout.actionbar_badge_layout);
        // Inflate the menu; this adds items to the action bar if it is present.
      //  getMenuInflater().inflate(R.menu.app_main_screen, menu);
       // RelativeLayout badgeLayout = (RelativeLayout)
              //  menu.findItem(R.id.badge).getActionView();
        //TextView tv = (TextView)findViewById(R.id.actionbar_notifcation_textview);
//        tv.setText("12");
       // return true;
    }
  //  return super.onOptionsItemSelected(item);



    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_app_main_screen);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();


    }

    public boolean onNavigationItemSelected(MenuItem item) {



        // Handle navigation view item clicks here.

        //int id = item.getItemId();
        switch (item.getItemId()) {

       //    if(item == R.id.action_drawer_cart)

           case R.id.menu_icon:

               if (drawerLayout.isDrawerOpen(Gravity.LEFT)) {
                    //ib_navigation.setImageResource(R.mipmap.back_arrow);

                    drawerLayout.closeDrawer(Gravity.LEFT);
                } else {
                    //ib_navigation.setImageResource(R.mipmap.back_arrow);
                    drawerLayout.openDrawer(Gravity.LEFT);

               }
                break;


            case R.id.nav_cart:

                if (drawerLayout.isDrawerOpen(Gravity.LEFT)) {
                    //ib_navigation.setImageResource(R.mipmap.back_arrow);

                    Intent cart = new Intent(AppMainScreenActivity.this,LatestAddToCartCode.class);
                    startActivity(cart);


                    drawerLayout.closeDrawer(Gravity.LEFT);
                } else {
                    //ib_navigation.setImageResource(R.mipmap.back_arrow);
                    drawerLayout.openDrawer(Gravity.LEFT);


                }
                break;

            //   drawerLayout.closeDrawer(Gravity.LEFT);
               // drawerLayout.closeDrawer(Gravity.RIGHT);

            //   break;
                //return true;

       //     case R.id.nav_cart:
         //       Intent nav = new Intent(AppMainScreenActivity.this,CartActivity.class);
           //     startActivity(nav);
             //   break;
            case R.id.nav_health:
             //   Intent navhealth = new Intent(AppMainScreenActivity.this,HealthnBeauty.class);
               // startActivity(navhealth);
                break;
            case R.id.nav_home:
                Intent home = new Intent(AppMainScreenActivity.this,AppMainScreenActivity.class);
                startActivity(home);
            case R.id.nav_galleryPrev:
                Intent pro = new Intent(AppMainScreenActivity.this,DynamicCategory.class);
                startActivity(pro);
            //case R.id.nav_slideshow:

            case R.id.nav_logout:

                //Do some thing here
                // add navigation drawer item onclick method here
                Intent logout = new Intent(AppMainScreenActivity.this, MainActivity.class);
                logout.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(logout);
                finish();
                break;
            //Do some thing here
                // add navigation drawer item onclick method here
            case R.id.nav_game:
                //Intent iv = new Intent(AppMainScreenActivity.this, ComputingActivity.class);
                //startActivity(iv);
                //Do some thing here
                // add navigation drawer item onclick method here
                break;

            case R.id.nav_comput:
               // Intent Comput = new Intent(AppMainScreenActivity.this, ComputingActivity.class);
               // startActivity(Comput);

            case R.id.nav_vouchers:
                Intent v = new Intent(this, VouchersActivity.class);
                startActivity(v);
                //final String url = "http://192.168.177.120/GetRewards/public/api/product/en";
                //Do some thing here
                // add navigation drawer item onclick method here
                break;

            case R.id.nav_account:
                Intent ac = new Intent(this, AccountBalance.class);
                startActivity(ac);
                //Do some thing here
                // add navigation drawer item onclick method here
                break;

            case R.id.nav_profile:
                Intent vi = new Intent(this, ProfileActivity.class);
                startActivity(vi);
                break;

            case R.id.nav_ticket:
                Intent ticket = new Intent(this, RaiseANewTicket.class);
                startActivity(ticket);
                break;

            case R.id.nav_orderhistory:
                Intent order = new Intent(this, DynamicOrderHistory.class);
                startActivity(order);
                break;

            case R.id.nav_bestdeal:
                Intent bestdeal = new Intent(this, BestSellingProductActivity.class);
                startActivity(bestdeal);
                break;

            case R.id.nav_help:
                Intent help = new Intent(this, MyTicketList.class);
                startActivity(help);
                break;


            case R.id.nav_slide:
                Intent slide = new Intent(this, SliderActivity.class);
                startActivity(slide);
                break;
            //loginscreen.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            //this.finish();

            case R.id.nav_newproduct:
                Intent newproduct = new Intent(this,NewProductCodeForCart.class);
                startActivity(newproduct);
                break;

            case R.id.nav_about:
                Intent navabout = new Intent(this,AboutUs.class);
                startActivity(navabout);
                break;

           //  DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        //drawer.closeDrawer(GravityCompat.START);
           // return true;

        }

    return super.onOptionsItemSelected(item);



   } // return super.OnOptionsItemSelected(Item);
    private void setupBadge() {

     //   button.set
    }


}