package com.example.database;

import android.app.IntentService;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class deleteService extends IntentService {

    public deleteService() {
        super("delete");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        sqlLite db= new  sqlLite(this);
        String id = intent.getStringExtra("id");


        if(!id.isEmpty()) {

            int res = db.delete(id);
            if(res==1){
                Toast.makeText(getApplicationContext(), "delete", Toast.LENGTH_SHORT).show();

            }else {
                Toast.makeText(getApplicationContext(), "error ", Toast.LENGTH_SHORT).show();

            }

        }else {

            Toast.makeText(getApplicationContext(), "please enter id to delete", Toast.LENGTH_SHORT).show();
        }

    }
}
