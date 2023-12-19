package com.example.contenedores_is_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener,  AdapterView.OnItemClickListener{


TextView txtItemSelecter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] datos = new String[]{"Alvarez","Morales","Navas","Triana","Reyes","Vera"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datos);
        Spinner cdOpciones =(Spinner)findViewById(R.id.cdOpciones);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cdOpciones.setAdapter(adaptador);

        txtItemSelecter= findViewById(R.id.txtItemS);
        cdOpciones.setOnItemSelectedListener(this);

        ArrayAdapter<String> adaptador2 =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datos);
        ListView lstOpciones = (ListView)findViewById(R.id.lstlist);
        lstOpciones.setAdapter(adaptador2);

lstOpciones.setOnItemClickListener(this::onItemClick);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        txtItemSelecter.setText("Item seleccionado: "+parent.getItemAtPosition(position).toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        txtItemSelecter.setText("");
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Toast.makeText(this.getApplicationContext(),parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
    }
}