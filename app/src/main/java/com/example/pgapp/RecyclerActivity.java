package com.example.pgapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@SuppressWarnings("FieldCanBeLocal")
public class RecyclerActivity extends AppCompatActivity implements JsonTask.JsonTaskListener{

    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=a22vioja";
    ArrayList<Bonsai> listOfBonsai;
    private RecyclerView.ViewHolder holder;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        listOfBonsai = new ArrayList<Bonsai>();

        //new JsonTask(this).execute(JSON_URL);

        adapter=new MyAdapter(this, listOfBonsai, new MyAdapter.OnClickListener() {
            @Override
            public void onClick(Bonsai item) {
                Toast.makeText(RecyclerActivity.this, item.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView view = findViewById(R.id.recycler_view);
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(adapter);

        new JsonTask(this).execute(JSON_URL);

    }
    @Override
    public void onPostExecute(String json) {
        Log.d("MainActivity", json);

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Bonsai>>() {}.getType();

        listOfBonsai = gson.fromJson(json, type);
        adapter.addData(listOfBonsai);


        ArrayList<Bonsai> listOfBonsai = gson.fromJson(json, type);
// Log.d("violeta", String.valueOf(listOfBonsai.size()));
 //for(Bonsai bonsai : listOfBonsai){
  //   Log.d("violeta-li", bonsai.toString());
 //}

        adapter.notifyDataSetChanged();
    }

}