package com.example.contenedores_is_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.contenedores_is_2023.adaptador.AdaptadorUsuario;
import com.example.contenedores_is_2023.modelos.Usuario;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import webservice.Asynchtask;
import webservice.WebService;

public class listadesdeapi extends AppCompatActivity implements Asynchtask {
    ListView lstOpciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listadesdeapi);
        lstOpciones = (ListView)findViewById(R.id.listx);
        View header = getLayoutInflater().inflate(R.layout.ly_itemusuario, null);
        lstOpciones.addHeaderView(header);
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://reqres.in/api/users",
                datos, listadesdeapi.this, listadesdeapi.this);
        ws.execute("GET");

    }

    @Override
    public void processFinish(String result) throws JSONException {
        JSONObject JSONlista = new JSONObject(result);
        JSONArray JSONlistaUsuarios= JSONlista.getJSONArray("data");
        ArrayList<Usuario>  lstUsuarios = Usuario.JsonObjectsBuild(JSONlistaUsuarios);
        AdaptadorUsuario adapatorUsuario = new AdaptadorUsuario(this, lstUsuarios);
         lstOpciones.setAdapter(adapatorUsuario);
    }
}