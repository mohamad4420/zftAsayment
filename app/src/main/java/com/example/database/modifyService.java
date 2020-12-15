package com.example.database;

import android.app.IntentService;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class modifyService  extends IntentService {

    public modifyService() {
        super("modify");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {


        sqlLite db= new  sqlLite(this);
        String name = intent.getStringExtra("name");
        String sex = intent.getStringExtra("sex");
        String ru=intent.getStringExtra("ru");
        String bs =intent.getStringExtra("bs");
        String ts =intent.getStringExtra("ts");
        String id =intent.getStringExtra("id");

        if(!id.isEmpty()&&!name.isEmpty()&&!sex.isEmpty()&&!ru.isEmpty()&&!bs.isEmpty()&&!ts.isEmpty()) {
            float Base_Salary = Float.parseFloat(bs);
            float Total_Salary = Float.parseFloat(ts);
            float Rate = Float.parseFloat(ru);

            Boolean res = db.modify(id,name, sex, Base_Salary, Total_Salary, Rate);
            if(res)
                Toast.makeText(getApplicationContext(), "update", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(getApplicationContext(), "not fount id", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(), "please enter value of all row", Toast.LENGTH_SHORT).show();
        }

    }
}
