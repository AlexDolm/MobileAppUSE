package com.example.diplom2;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.security.cert.Extension;

//class for filling the "theory" section with data from the database

public class TheoryTasksActivity extends AppCompatActivity {

    TextView header;
    TextView [] textView = new TextView[6];
    String [] idText =  new String[6];

    ImageView imageView;
    Button button;
    Integer lectNumler;
    private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theory_tasks);
        mDBHelper = new DatabaseHelper(this);
        try {
            mDBHelper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }
        try {
            mDb = mDBHelper.getWritableDatabase();
        } catch (SQLException mSQLException) {
            throw mSQLException;
        }
        int defaultvalue=0;
        Intent intent = getIntent();
        lectNumler = intent.getIntExtra("myIntVariableName",defaultvalue);
        header = (TextView) findViewById(R.id.head);
        idText = new String[] {"text0","text","text2","text3","text4","text5"};

        int temp;

        for(int i=0;i<idText.length; i++){
            temp  = getResources().getIdentifier(idText[i],"id",getPackageName());
            textView[i] = (TextView) findViewById(temp);
        }

        imageView = (ImageView) findViewById(R.id.imageViewTheory);
        button = (Button) findViewById(R.id.nxt);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar =getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        textOutput();

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

    public void Click_layout2(View view)
    {
        if (lectNumler>24)lectNumler=24;
        Intent intent = new Intent(TheoryTasksActivity.this, WorkoutTaskActivity.class);
        intent.putExtra("myIntVariableName", lectNumler);
        startActivity(intent);

    }


    public void  textOutput()
    {
        String LectureName [] = getResources().getStringArray(R.array.theme);
        if (lectNumler==27)
        {
            header.setText(LectureName[lectNumler-1]);
            button.setEnabled(false);
        }
        else {
            BD(lectNumler);
            header.setText(LectureName[lectNumler-1]);
        }

    }
    public void next(View view)
    {
        lectNumler++;
        textOutput();

    }

    //get data from database
   public void BD(int lectNumler) {
      String [] productNum = new String[6];
       Cursor cursor = mDb.rawQuery("SELECT * FROM theory_tb WHERE _id="+ lectNumler, null);
       cursor.moveToFirst();
       for(int i=0;i<productNum.length; i++){
           productNum[i] += cursor.getString(i+1);
       }
       cursor.close();

       for(int i=0;i<textView.length; i++){
           textView[i].setText(productNum[i]);
       }

   }


}
