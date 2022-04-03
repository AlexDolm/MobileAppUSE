package com.example.diplom2;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

//Menu for choosing practical work

public class WorkoutActivity extends AppCompatActivity {

    Integer practNumler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar =getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



    public void Click_layout(View view)
    {
        //assignment of a task number
        switch (view.getId())
        {
            case R.id.pract1: practNumler = 1;
                break;
            case R.id.pract2: practNumler = 2;
                break;
            case R.id.pract3: practNumler = 3;
                break;
            case R.id.pract4: practNumler = 4;
                break;
            case R.id.pract5: practNumler = 5;
                break;
            case R.id.pract6: practNumler = 6;
                break;
            case R.id.pract7: practNumler = 7;
                break;
            case R.id.pract8: practNumler = 8;
                break;
            case R.id.pract9: practNumler = 9;
                break;
            case R.id.pract10: practNumler = 10;
                break;
            case R.id.pract11: practNumler = 11;
                break;
            case R.id.pract12: practNumler = 12;
                break;
            case R.id.pract13: practNumler = 13;
                break;
            case R.id.pract14: practNumler = 14;
                break;
            case R.id.pract15: practNumler = 15;
                break;
            case R.id.pract16: practNumler = 16;
                break;
            case R.id.pract17: practNumler = 17;
                break;
            case R.id.pract18: practNumler = 18;
                break;
            case R.id.pract19: practNumler = 19;
                break;
            case R.id.pract20: practNumler = 20;
                break;
            case R.id.pract21: practNumler = 21;
                break;
            case R.id.pract22: practNumler = 22;
                break;
            case R.id.pract23: practNumler = 23;
                break;
            case R.id.pract24: practNumler = 24;
                break;
        }
        Intent intent = new Intent(WorkoutActivity.this, WorkoutTaskActivity.class);
        intent.putExtra("myIntVariableName", practNumler);
        startActivity(intent);
    }

}
