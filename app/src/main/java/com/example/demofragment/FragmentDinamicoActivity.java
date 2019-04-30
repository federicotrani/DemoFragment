package com.example.demofragment;

import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FragmentDinamicoActivity extends AppCompatActivity implements FragmentAzul.OnFragmentInteractionListener, FragmentVerde.OnFragmentInteractionListener, FragmentRojo.OnFragmentInteractionListener {

    FragmentRojo fragmentRojo;
    FragmentAzul fragmentAzul;
    FragmentVerde fragmentVerde;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_dinamico);

        fragmentAzul = new FragmentAzul();
        fragmentRojo = new FragmentRojo();
        fragmentVerde = new FragmentVerde();

        getSupportFragmentManager().beginTransaction().add(R.id.contenedorFragments,fragmentRojo).commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void onClic(View v){
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        switch (v.getId())
        {
            case(R.id.botonAzul):
                transaction.replace(R.id.contenedorFragments,fragmentAzul);
                break;
            case(R.id.botonRojo):
                transaction.replace(R.id.contenedorFragments,fragmentRojo);
                break;
            case(R.id.botonVerde):
                transaction.replace(R.id.contenedorFragments,fragmentVerde);
                break;
        }

        transaction.commit();
    }
}
