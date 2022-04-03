package com.example.diplom2;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

//class for theory selection

public class TheoriActivity extends AppCompatActivity {

    Integer lectNumler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theory);
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
        //assigning an identifier for accessing the database
        switch (view.getId())
        {
            case R.id.lect1: lectNumler = 1;
            break;
            case R.id.lect2: lectNumler = 2;
                break;
            case R.id.lect3: lectNumler = 3;
                break;
            case R.id.lect4: lectNumler = 4;
                break;
            case R.id.lect5: lectNumler = 5;
                break;
            case R.id.lect6: lectNumler = 6;
                break;
            case R.id.lect7: lectNumler = 7;
                break;
            case R.id.lect8: lectNumler = 8;
                break;
            case R.id.lect9: lectNumler = 9;
                break;
            case R.id.lect10: lectNumler = 10;
                break;
            case R.id.lect11: lectNumler = 11;
                break;
            case R.id.lect12: lectNumler = 12;
                break;
            case R.id.lect13: lectNumler = 13;
                break;
            case R.id.lect14: lectNumler = 14;
                break;
            case R.id.lect15: lectNumler = 15;
                break;
            case R.id.lect16: lectNumler = 16;
                break;
            case R.id.lect17: lectNumler = 17;
                break;
            case R.id.lect18: lectNumler = 18;
                break;
            case R.id.lect19: lectNumler = 19;
                break;
            case R.id.lect20: lectNumler = 20;
                break;
            case R.id.lect21: lectNumler = 21;
                break;
            case R.id.lect22: lectNumler = 22;
                break;
            case R.id.lect23: lectNumler = 23;
                break;
            case R.id.lect24: lectNumler = 24;
                break;
            case R.id.lect25: lectNumler = 25;
                break;
            case R.id.lect26: lectNumler = 26;
                break;
            case R.id.lect27: lectNumler = 27;
                break;
        }
        Intent intent = new Intent(TheoriActivity.this, TheoryTasksActivity.class);
        intent.putExtra("myIntVariableName", lectNumler);
        startActivity(intent);


    }
}
