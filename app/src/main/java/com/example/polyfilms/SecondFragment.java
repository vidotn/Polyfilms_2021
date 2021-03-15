package com.example.polyfilms;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import org.w3c.dom.Text;

public class SecondFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });

        ImageView affichette = getActivity().findViewById(R.id.affichette);
        affichette.setImageResource(getActivity().getResources().getIdentifier(((MainActivity)getActivity()).nomAffiche,"drawable",getActivity().getPackageName()));

        TextView duree = getActivity().findViewById(R.id.dureetxt);
        TextView date = getActivity().findViewById(R.id.datetxt);
        TextView synopsis = getActivity().findViewById(R.id.synopsistxt);
        TextView acteurs = getActivity().findViewById(R.id.acteurstxt);

        int indice = ((MainActivity)getActivity()).INDEX_AFFICHE-1;
        duree.setText(((MainActivity)getActivity()).durees.get(indice));
        date.setText(((MainActivity)getActivity()).dates.get(indice));
        synopsis.setText(((MainActivity)getActivity()).synopsis.get(indice));
        acteurs.setText(((MainActivity)getActivity()).acteurs.get(indice));


    }

    public void details(String message) {
        /*Récupération de l'image dans la zone de contenu*/
        final ImageView affiche = getActivity().findViewById(R.id.affichette);

        affiche.setImageResource(getActivity().getResources().getIdentifier(message,"drawable",getActivity().getPackageName()));
    }
}