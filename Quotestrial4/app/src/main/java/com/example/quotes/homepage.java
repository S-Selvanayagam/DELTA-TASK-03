package com.example.quotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class homepage extends AppCompatActivity {
    private TextView fetchquote;
    private TextView fetchauthor;
    private RequestQueue mQueue;
    private RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        fetchquote = findViewById(R.id.quote);
        fetchauthor = findViewById(R.id.author);
        Button buttonParse = findViewById(R.id.button);


        mQueue = Volley.newRequestQueue(this);

        buttonParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                jsonParse();
            }
        });

    }

    private void jsonParse(){
        String URL="https://api.quotable.io/random";
        JsonObjectRequest objectRequest = new JsonObjectRequest(
                Request.Method.GET,
                URL,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            String quote = response.getString("content");
                            String author = response.getString("author");

                            fetchquote.setText(quote);
                            fetchauthor.setText(author);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

            }
        });
        mQueue.add(objectRequest);

    }



    public void Proceed(View view) {
        Intent i = new Intent(homepage.this, quotescollection.class);
        startActivity(i);
    }
}