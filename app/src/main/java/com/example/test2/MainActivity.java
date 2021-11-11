package com.example.test2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.provider.Settings;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public void crash() {
        throw new RuntimeException("Sorry but the app has crashed");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crash();
            }
        });
    }
@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);
            return true;
        }
        if (id == R.id.open_permission) {
            startActivity(new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                    Uri.fromParts("package", getPackageName(), null)));
            return true;
        }
        if (id == R.id.do_not_click) {
            startActivity(new Intent(Settings.ACTION_BLUETOOTH_SETTINGS,
                    Uri.fromParts("package", getPackageName(), null)));
            crash();
        }else if (id == R.id.M) {
            Random rand = new Random();
            int n = rand.nextInt(6);
            switch(n) {
                case 1:
                    startActivity(new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.fromParts("package", getPackageName(), null)));
                case 2:
                    startActivity(new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.fromParts("package", getPackageName(), null)));
                case 3:
                    startActivity(new Intent(Settings.METADATA_USAGE_ACCESS_REASON, Uri.fromParts("package", getPackageName(), null)));
                case 4:
                    crash();
                case 5:
                    startActivity(new Intent(Settings.ACTION_AIRPLANE_MODE_SETTINGS, Uri.fromParts("package", getPackageName(), null)));

                case 0:
                    startActivity(new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS, Uri.fromParts("package", getPackageName(), null)));
            }


        }

        return super.onOptionsItemSelected(item);
    }
}