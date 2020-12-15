package com.example.database;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.example.database.sqlLite;

public class insertService extends IntentService {

    public insertService() {
        super("dataServes");
    }

    @Override
    public void onCreate() {
        super.onCreate();



    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {








        String name = intent.getStringExtra("name");
        String sex = intent.getStringExtra("sex");
        String ru=intent.getStringExtra("ru");
        String bs =intent.getStringExtra("bs");
        String ts =intent.getStringExtra("ts");

        if(!name.isEmpty()&&!sex.isEmpty()&&!ru.isEmpty()&&!bs.isEmpty()&&!ts.isEmpty()) {
            float Base_Salary = Float.parseFloat(bs);
            float Total_Salary = Float.parseFloat(ts);
            float Rate = Float.parseFloat(ru);
            sqlLite db= new  sqlLite(this);
            Boolean res = db.insert(name, sex, Base_Salary, Total_Salary, Rate);
            if (res)
                Toast.makeText(getApplicationContext(), "ok", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(getApplicationContext(), "ERORe", Toast.LENGTH_SHORT).show();

        }
        else{
            Toast.makeText(getApplicationContext(), "please enter value of all row", Toast.LENGTH_SHORT).show();
        }




    }
}
