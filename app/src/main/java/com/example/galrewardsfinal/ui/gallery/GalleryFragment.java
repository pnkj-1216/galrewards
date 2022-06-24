package com.example.galrewardsfinal.ui.gallery;

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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.galrewardsfinal.CartActivity;
import com.example.galrewardsfinal.R;
import com.example.galrewardsfinal.databinding.FragmentGalleryBinding;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private FragmentGalleryBinding binding;
    Intent intent;
    Button button;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

     //button = (Button) .findViewById(R.id.btnaddcartelectro);

   // button.setOnClickListener(new View.OnClickListener() {
     //   @Override
       // public void onClick(View v) {
         //       Intent intent = new Intent(getActivity(), CartActivity.class);
           // startActivity(intent);
        //}
    //});



        binding = FragmentGalleryBinding.inflate(inflater, container, false);

        View root = binding.getRoot();

        Button btncamera = (Button)root.findViewById(R.id.addtocartelectronic);
       Button  btncameranew = (Button)root.findViewById(R.id.addtocartelectronicnew);

        btncamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Successfully Add To Cart", Toast.LENGTH_LONG).show();
            }});

        btncameranew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Successfully Add To Cart",Toast.LENGTH_LONG).show();
            }
        });

        //final ImageView textView = binding.textGallery;
        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

                //textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}