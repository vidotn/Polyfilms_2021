package com.example.polyfilms;

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

public class FirstFragment extends Fragment {

    String nomAffiche="";
    int n = 1;

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

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

        /*Récupération de l'image dans la zone de contenu*/
        final ImageView affiche = getActivity().findViewById(R.id.imageView);
        /*Récupération de la zone de texte dans la zone de contenu*/
        final TextView titre = getActivity().findViewById(R.id.titre);


        /*l'imageview sera sensible aux swipes*/
        affiche.setOnTouchListener(new onSwipeClickListener(){

            public void onSwipeTop() {
                Toast.makeText(getActivity(), "haut", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeRight() {
                Snackbar.make(affiche, "précédent", Snackbar.LENGTH_SHORT).show();

                if(n>1) n--;

                if(n<10) nomAffiche =  "affiche_0"+n;
                else nomAffiche =  "affiche_"+n;

                int idAffiche = getActivity().getResources().getIdentifier(nomAffiche, "drawable", getActivity().getPackageName());
                affiche.setImageResource(idAffiche);

            }
            public void onSwipeLeft() {
                Snackbar.make(affiche, "suivant", Snackbar.LENGTH_SHORT).show();

                if(n<11) n++;

                if(n<10) nomAffiche =  "affiche_0"+n;
                else nomAffiche =  "affiche_"+n;

                int idAffiche = getActivity().getResources().getIdentifier(nomAffiche, "drawable", getActivity().getPackageName());
                affiche.setImageResource(idAffiche);

            }
            public void onSwipeBottom() {
                Toast.makeText(getActivity(), "bas", Toast.LENGTH_SHORT).show();
            }

        });
        /* fin de la gestion du swipe */
        
    }
}