package com.example.database;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    sqlLite db =new sqlLite(this);
    public static final  String  insert_int_oemp1_values  = "insert_int_oemp1_values";

   
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.delete,R.id.insert,R.id.search,R.id.display,R.id.modify)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

    }


    public void search(View view) {

        TextView s = findViewById(R.id.searchOut);
        EditText i = findViewById(R.id.sId);
        String id = i.getText().toString();

if(!id.isEmpty()) {
    ArrayList a = db.search(Integer.parseInt(id));
    int index = 0;
    s.setText((CharSequence) a.get(index++));
}else{
    Toast.makeText(getApplicationContext(), "please enter id", Toast.LENGTH_SHORT).show();
}


    }
    public void insert(View view) {



        EditText n = findViewById(R.id.inName);
        String name = n.getText().toString();

        EditText s = findViewById(R.id.inSex);
        String sex = s.getText().toString();

        EditText r = findViewById(R.id.inRate);
        String ru=r.getText().toString();

        EditText b = findViewById(R.id.inBase_Salary);
        String bs =b.getText().toString();

        EditText t = findViewById(R.id.inTotal_Salary);
        String ts =t.getText().toString();


        Intent intent=new Intent(MainActivity.this, insertService.class);
         intent.putExtra("name",name);
        intent.putExtra("sex",sex);
        intent.putExtra("ru",ru);
        intent.putExtra("bs",bs);
        intent.putExtra("ts",ts);
       startService(intent);
    }


    public void modify(View view) {

        EditText n = findViewById(R.id.mdName);
        String name = n.getText().toString();


        EditText s = findViewById(R.id.mdSex);
        String sex = s.getText().toString();

        EditText r = findViewById(R.id.mdRate);
        String ru=r.getText().toString();


        EditText b = findViewById(R.id.mdBase_Salary);
        String bs =b.getText().toString();



        EditText t = findViewById(R.id.mdTotal_Salary);
        String ts =t.getText().toString();


        EditText i = findViewById(R.id.mdid);
        String id =i.getText().toString();


        Intent intent=new Intent(MainActivity.this, modifyService.class);
        intent.putExtra("name",name);
        intent.putExtra("sex",sex);
        intent.putExtra("ru",ru);
        intent.putExtra("bs",bs);
        intent.putExtra("ts",ts);
        intent.putExtra("id",id);
        startService(intent);
    }
    public void delete(View view) {
        EditText i = findViewById(R.id.dlid);
        String id =i.getText().toString();

        Intent intent=new Intent(MainActivity.this, deleteService.class);
        intent.putExtra("id",id);
        startService(intent);

    }

}