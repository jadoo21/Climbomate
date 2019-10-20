package com.jadoo.risha.besafe;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link fragmentButton.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link fragmentButton#newInstance} factory method to
 * create an instance of this fragment.
 */


public class fragmentButton extends Fragment {
    public fragmentButton(){

    }

    int position;
    Context context;
    String location=null;
    SearchView search;

    public fragmentButton(int position, Context context){
        this.position = position;
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=null;
        switch(position){
            case 0:
                view = inflater.inflate(R.layout.fragment_button_one, container, false);
                ImageView imageOne = (ImageView) view.findViewById(R.id.image_one);
                ImageView imageTwo = (ImageView) view.findViewById(R.id.image_two);
                imageOne.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, MapsActivity.class);
                        intent.putExtra("Message", "live");
                        startActivity(intent);
                    }
                });

                imageTwo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        View viewDialog = getLayoutInflater().inflate(R.layout.dialog_search, null);
                        search = viewDialog.findViewById(R.id.dialog_search);
                        //location = search.getQuery().toString();
                        //Log.d("laudadialog", location);
                        Button button = viewDialog.findViewById(R.id.dialog_button);
                        builder.setTitle("SEARCH");
                        builder.setView(viewDialog);

                        AlertDialog dialog = builder.create();
                        dialog.setCanceledOnTouchOutside(true);

                        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                            @Override
                            public boolean onQueryTextSubmit(String query) {
                                //SearchView temp = viewDialog.findViewById(R.id.dialog_search);
                                location = search.getQuery().toString();
                                Log.d("laudaQuery", location);
                                Intent intent = new Intent(context, MapsActivity.class);
                                intent.putExtra("Message", location);
                                startActivity(intent);
                                return false;
                            }

                            @Override
                            public boolean onQueryTextChange(String newText) {
                                return false;
                            }
                        });

                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                location = search.getQuery().toString();
                                //Log.d("laudaButton", location);
                                Intent intent = new Intent(context, MapsActivity.class);
                                intent.putExtra("Message", location);
                                startActivity(intent);
                            }
                        });
                        dialog.show();
                    }
                });

                break;
            case 1:
                view = inflater.inflate(R.layout.fragment_button_two, container, false);
                ImageView tempImage = (ImageView) view.findViewById(R.id.imageView);
                tempImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast toast = Toast.makeText(context, "you can't call rescue now... ", Toast.LENGTH_LONG);
                        toast.show();
                    }
                });
                break;
        }
        return view;
    }
}
