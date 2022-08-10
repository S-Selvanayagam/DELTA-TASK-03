package com.example.quotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.WindowManager;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Locale;

public class quotescollection extends AppCompatActivity {
    datafragment obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EditText v;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        v=findViewById(R.id.search);
        obj=new datafragment();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportFragmentManager().beginTransaction().replace(R.id.maincontainer,obj).commit();

        //Log.d("Cools",obj.dataList.toString());
        v.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            filter(s.toString());
            }
        });
    }
    private void filter(String text)
    {

        ArrayList<DataModel> datas=new ArrayList<>();
        for(DataModel item: obj.dataList){
            if((item.getContent().toLowerCase().contains(text.toLowerCase()))||(item.getAuthor().toLowerCase().contains(text.toLowerCase())))
            {
                datas.add(item);
            }
        }
        obj.adaptery.filterlist(datas);
    }
}