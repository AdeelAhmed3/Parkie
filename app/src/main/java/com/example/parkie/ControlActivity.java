package com.example.parkie;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class ControlActivity extends AppCompatActivity {

    GridView controlGrid;
    List<ControlBean> data = new ArrayList<>();
    SharedPreferences preferences;
    SharedPreferences.Editor prefEditor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);



        controlGrid = findViewById(R.id.controls_container);
        preferences = getSharedPreferences("session", Context.MODE_PRIVATE);
        prefEditor = preferences.edit();
        ControlBean item1 = new ControlBean();
        ControlBean item2 = new ControlBean();
        ControlBean item3 = new ControlBean();
        ControlBean item4 = new ControlBean();
        ControlBean item5 = new ControlBean();
        ControlBean item6 = new ControlBean();

        item1.setText("Scan");
        item1.setImage(R.drawable.ic_barcode_scanner);

        item2.setText("My Profile");
        item2.setImage(R.drawable.ic_person);

        item3.setText("History");
        item3.setImage(R.drawable.ic_clock);

        item4.setText("Inbox");
        item4.setImage(R.drawable.ic_email);

        item5.setText("Create");
        item5.setImage(R.drawable.ic_create);

        item6.setText("Settings");
        item6.setImage(R.drawable.ic_setting);


        data.add(item1);
        data.add(item2);
        data.add(item3);
        data.add(item4);
        data.add(item5);
        data.add(item6);

        ControlAdapter adapter = new ControlAdapter(data);
        controlGrid.setAdapter(adapter);

    }

    @Override
    public boolean onCreatePanelMenu(int featureId,  Menu menu) {
         getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreatePanelMenu(featureId, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.logout:
                prefEditor.putBoolean("signin",false);
                prefEditor.commit();
                Intent i = new Intent(ControlActivity.this,MainActivity.class);
                startActivity(i);
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}