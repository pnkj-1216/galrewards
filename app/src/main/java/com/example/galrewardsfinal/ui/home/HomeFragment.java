package com.example.galrewardsfinal.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.galrewardsfinal.BestSellingProductActivity;
import com.example.galrewardsfinal.CartActivity;
import com.example.galrewardsfinal.LatestAddToCartCode;
import com.example.galrewardsfinal.ProfileActivity;
import com.example.galrewardsfinal.R;
import com.example.galrewardsfinal.databinding.FragmentHomeBinding;
import com.example.galrewardsfinal.ui.gallery.GalleryFragment;

public class HomeFragment extends Fragment {

    private HomeViewModel ho1meViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_home, container, false);
        //TextView tv = (TextView) rootView.findViewById(R.id.clickbestselling);
      //  ImageView img = (ImageView)rootView.findViewById(R.id.homeclickphone3);
     //   Button btn = (Button)rootView.findViewById(R.id.homeear);
       // Button btn1 = (Button)rootView.findViewById(R.id.homephone);

        /*
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Fragment fragment = getFragmentManager();
                Fragment GalleryFragment = new GalleryFragment();
                // consider using Java coding conventions (upper first char class names!!!)
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                // Replace whatever is in the fragment_container view with this fragment,
                // and add the transaction to the back stack
                transaction.replace(R.id.content,GalleryFragment);
                transaction.addToBackStack(null);

                // Commit the transaction
                transaction.commit();

            }
        });
        */


        //return rootView;

        /*btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Successfully Add To Cart", Toast.LENGTH_LONG).show();
        }});


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Successfully Add To Cart", Toast.LENGTH_LONG).show();
            }});



        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BestSellingProductActivity.class);
                startActivity(intent);
            }
        });
        */
        return rootView;

    }



      //  public void onClick(View v)
      //  {
           // FragmentManager fragmentManager = getFragmentManager();
           // FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
           // HomeFragment yourFragment= new HomeFragment();
           // fragmentTransaction.add(R.id.nav_slideshow, yourFragment, "FRAGMENT");
           // fragmentTransaction.commit();
       // }
        //homeViewModel =
            //    new ViewModelProvider(this).get(HomeViewModel.class);

       // binding = FragmentHomeBinding.inflate(inflater, container, false);
        //View root = binding.getRoot();

     //   final TextView textView = binding.textHome;
    //    final ImageView imageView = binding.textHome;

      // homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
       //     @Override
          //  public void onChanged(@Nullable String s) {
             //   //textView.setText(s);
                //imageView.setText(s);

      //  });
       // return root;
  //  }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    protected void onBackPressed() {
    }

 //   public void click(View v) {
    //    switch (v.getId()) {
          //  case R.id.start:
         //       Intent intent = new Intent(getActivity(), ProfileActivity.class);
                //startActivity(intent);
              //  break;
      //  }
    //}
}
