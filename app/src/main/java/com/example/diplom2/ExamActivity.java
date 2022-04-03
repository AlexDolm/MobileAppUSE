package com.example.diplom2;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.CountDownTimer;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

//Class for working with the "Exam" section

public class ExamActivity extends AppCompatActivity {


    Button [] topMenu = new Button[27];
    TextView textView;
    TextView textView2;
    LinearLayout linearLayout;
    EditText editText;
    Button button;
    Button button2;
    private TextView mTimer;
    private String [] id;
    int sec=60;
    int min=55;
    int taskNumber;
    boolean end = false;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam);

        Toolbar toolbar = findViewById(R.id.toolbar);
        mTimer = (TextView) findViewById(R.id.tik);
        button = (Button) findViewById(R.id.next);
        button2 = (Button) findViewById(R.id.end);
        textView = (TextView) findViewById(R.id.n);
        textView2 = (TextView) findViewById(R.id.zadanie);
        linearLayout = (LinearLayout) findViewById(R.id.linear);
        editText = (EditText) findViewById(R.id.text);

        id = new String[] {"but1","but2","but3","but4","but5","but6"
                ,"but7","but8","but9","but10","but11","but12","but13",
                "but14","but15","but16","but17","but18","but19","but20",
                "but21","but22","but23","but24","but25","but26","but27"};

        int temp;

        //definition and output of the topic
        for(int i=0;i<id.length-1; i++){
          temp  = getResources().getIdentifier(id[i],"id",getPackageName());
            topMenu[i] = (Button) findViewById(temp);
        }

        setSupportActionBar(toolbar);
        ActionBar actionBar =getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        /* Creating a countdown timer for 20 seconds with a countdown step
        in 1 second (setting values in milliseconds): */
        new CountDownTimer(330000, 1000) {

            //update the text of the countdown counter with every second
            public void onTick(long millisUntilFinished) {
               sec--;
                if (sec==0)
               {
                   sec=60;
                   min--;
                }
                mTimer.setText("3:"
                        + min+":"+sec);
            }
            // set the actions after the countdown is completed (we highlight the inscription "Время вышло!"):
            public void onFinish() {
                mTimer.setText("Время вышло!");
            }
        }
                .start();

        taskNumber=1;
        topMenu[0].getBackground().setColorFilter(Color.parseColor("#a6a6a6"), PorterDuff.Mode.SRC_ATOP);
        FragmentManager manager = getSupportFragmentManager();
                MyDialogFragment2 myDialogFragment2 = new MyDialogFragment2();
        //myDialogFragment2.show(manager, "myDialog");

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



    public void onClick(View view) {
        FragmentManager manager = getSupportFragmentManager();
        MyDialogFragment myDialogFragment = new MyDialogFragment();
        myDialogFragment.show(manager, "myDialog");

        for(int i=0;i<topMenu.length; i++){
            topMenu[i].getBackground().setColorFilter(Color.parseColor("#42c291"), PorterDuff.Mode.SRC_ATOP);
        }
        button.setVisibility(View.GONE);
        button2.setVisibility(View.GONE);
        mTimer.setVisibility(View.GONE);
        end = true;
        linearLayout.setBackgroundColor(getResources().getColor(R.color.red));
        MainActivity.progressBar.setProgress(14);
        MainActivity.textView.setText("14/100");
    }


}
