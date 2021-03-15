package com.example.polyfilms;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstFragment extends Fragment {



    private  ImageView affiche;
    /*Récupération de la zone de texte dans la zone de contenu*/
    private TextView titre;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        /*Récupération de l'image dans la zone de contenu*/
        affiche = getActivity().findViewById(R.id.imageView);
        /*Récupération de la zone de texte dans la zone de contenu*/
        titre = getActivity().findViewById(R.id.titre);

        titre.setText(((MainActivity)getActivity()).titres.get(((MainActivity)getActivity()).INDEX_AFFICHE-1));
        int idAffiche = getActivity().getResources().getIdentifier(((MainActivity)getActivity()).nomAffiche, "drawable", getActivity().getPackageName());
        affiche.setImageResource(idAffiche);

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });




        /*l'imageview sera sensible aux swipes*/
        affiche.setOnTouchListener(new onSwipeClickListener(){

            public void onSwipeTop() {
                Toast.makeText(getActivity(), "haut", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeRight() {
                Snackbar.make(affiche, "précédent", Snackbar.LENGTH_SHORT).show();

                if(((MainActivity)getActivity()).INDEX_AFFICHE>1) ((MainActivity)getActivity()).INDEX_AFFICHE--;
                titre.setText(((MainActivity)getActivity()).titres.get(((MainActivity)getActivity()).INDEX_AFFICHE-1));

                if(((MainActivity)getActivity()).INDEX_AFFICHE<10) ((MainActivity)getActivity()).nomAffiche =  "affiche_0"+((MainActivity)getActivity()).INDEX_AFFICHE;
                else ((MainActivity)getActivity()).nomAffiche =  "affiche_"+((MainActivity)getActivity()).INDEX_AFFICHE;

                int idAffiche = getActivity().getResources().getIdentifier(((MainActivity)getActivity()).nomAffiche, "drawable", getActivity().getPackageName());
                affiche.setImageResource(idAffiche);



            }
            public void onSwipeLeft() {
                Snackbar.make(affiche, "suivant", Snackbar.LENGTH_SHORT).show();



                if(((MainActivity)getActivity()).INDEX_AFFICHE<11) ((MainActivity)getActivity()).INDEX_AFFICHE++;

                titre.setText(((MainActivity)getActivity()).titres.get(((MainActivity)getActivity()).INDEX_AFFICHE-1));


                if(((MainActivity)getActivity()).INDEX_AFFICHE<10) ((MainActivity)getActivity()).nomAffiche =  "affiche_0"+((MainActivity)getActivity()).INDEX_AFFICHE;
                else ((MainActivity)getActivity()).nomAffiche =  "affiche_"+((MainActivity)getActivity()).INDEX_AFFICHE;

                int idAffiche = getActivity().getResources().getIdentifier(((MainActivity)getActivity()).nomAffiche, "drawable", getActivity().getPackageName());
                affiche.setImageResource(idAffiche);

            }
            public void onSwipeBottom() {
                Toast.makeText(getActivity(), "bas", Toast.LENGTH_SHORT).show();
            }

        });
        /* fin de la gestion du swipe */
        
    }


}