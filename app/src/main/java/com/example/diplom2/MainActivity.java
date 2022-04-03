package com.example.diplom2;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;

//class for working with the main menu of the program

public class MainActivity extends AppCompatActivity {

    public static ProgressBar progressBar;

    public static TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        progressBar = findViewById(R.id.progressBar);
        textView = findViewById(R.id.textprogress);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /* Handle action bar item clicks here. The action bar will
         automatically handle clicks on the Home/Up button, so long
         as specify a parent activity in AndroidManifest.xml. */

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void onBackPressed(View view){
        finish();
    }


    public void Click_layout(View view)
    {
        //calls a window depending on the clicked icon
        switch (view.getId())
        {
            case R.id.imageView:
                Intent intent = new Intent(MainActivity.this, TheoriActivity.class);
                startActivity(intent);
                break;

            case R.id.imageView2:
                Intent intent2 = new Intent(MainActivity.this, WorkoutActivity.class);
                startActivity(intent2);
                break;

            case R.id.imageView3:
                Intent intent3 = new Intent(MainActivity.this, ExamActivity.class);
                startActivity(intent3);
                break;

            case R.id.imageView4:
                Intent intent4 = new Intent(MainActivity.this, ErrrorActivity.class);
                startActivity(intent4);
                break;
        }



    }


}
