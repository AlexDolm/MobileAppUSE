package com.example.diplom2;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

import static java.lang.Integer.toBinaryString;

//The class of output, generation and verification of tasks

public class WorkoutTaskActivity extends AppCompatActivity {
    String [] exercise = new String[10];
    String [] answer_true= new String[10];
    String [] textAnswer =new String[] {"","","","","","","","",""};
    Integer [] status= new Integer[] {0,0,0,0,0,0,0,0,0};
    String [] colorButtons = new String[] {"gray","gray","gray","gray","gray","gray","gray","gray","gray"};
    String solution[] = new String[] {"","","","","","","","",""};
    int taskNumber;
    LinearLayout linearLayout;

    Button checkButton;
    TextView textView1;
    TextView textView2;
    Button TaskGenerationButton;
    Integer practNumler;
    TextView header;
    Button [] buttonMass = new Button[9];
    String [] idButton = new String[9];
    Random random = new Random();
    EditText editText;
    TextView textExercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout_tasks);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar =getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        linearLayout = (LinearLayout) findViewById(R.id.otvet_lay);
        checkButton = (Button) findViewById(R.id.check);
        TaskGenerationButton = (Button) findViewById(R.id.decision);
        textView1 = (TextView) findViewById(R.id.otv1);
        textView2 = (TextView) findViewById(R.id.otv2);
        header = (TextView) findViewById(R.id.headpr);

        idButton = new String[] {"but1","but2","but3","but4","but5","but6"
                ,"but7","but8","but9"};

        int temp;
        //assigning a button array by id
        for(int i=0;i<idButton.length; i++){
            temp  = getResources().getIdentifier(idButton[i],"id",getPackageName());
            buttonMass[i] = (Button) findViewById(temp);
        }
        editText = (EditText) findViewById(R.id.answer);
        textExercise = (TextView) findViewById(R.id.exercise);

        int defaultvalue=0;
        Intent intent = getIntent();
        practNumler = intent.getIntExtra("myIntVariableName",defaultvalue);


        String strings [] = getResources().getStringArray(R.array.theme);
        header.setText(strings[practNumler-1]);
        AllTasks();
        buttonMass[0].getBackground().setColorFilter(Color.parseColor("#a6a6a6"), PorterDuff.Mode.SRC_ATOP);
        textExercise.setText(exercise[0]);
        taskNumber =1;

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

    //checking the correctness of the answer
    public void Check(View view)
    {

        checkButton.setEnabled(false);
        TaskGenerationButton.setEnabled(true);
        textView1.setVisibility(View.VISIBLE);
        textView2.setVisibility(View.VISIBLE);
        status [taskNumber-1] = 1;
        textView2.setText(solution[taskNumber-1]);
        String s1=answer_true[taskNumber-1];
        String s2 = editText.getText().toString();

        //coloring the answer depending on the correctness
        if (s1.equals(s2))
        {
            linearLayout.setBackgroundColor(getResources().getColor(R.color.green));
            colorButtons[taskNumber-1]="green";
            buttonMass[taskNumber-1].getBackground().setColorFilter(Color.parseColor("#42c291"), PorterDuff.Mode.SRC_ATOP);
        }
        else
        {
            linearLayout.setBackgroundColor(getResources().getColor(R.color.red));
            colorButtons[taskNumber-1]="red";
            buttonMass[taskNumber-1].getBackground().setColorFilter(Color.parseColor("#e46161"), PorterDuff.Mode.SRC_ATOP);
        }

    }

    //move to the next task
    public void Next(View view)
    {
        textAnswer[taskNumber-1]=editText.getText().toString();
        ColorChange(taskNumber);
        editText.setText(textAnswer[taskNumber-1]);
        textView2.setText(solution[taskNumber-1]);

    }

    public void ColorChange(int n){
        buttonMass[n].getBackground().setColorFilter(Color.parseColor("#a6a6a6"), PorterDuff.Mode.SRC_ATOP);
        textExercise.setText(exercise[n]);
        for(int i=0;i<buttonMass.length; i++){
            if (i!=n)buttonMass[i].getBackground().setColorFilter(Color.parseColor("#d8d8d8"), PorterDuff.Mode.SRC_ATOP);
        }
        taskNumber =n+1;
        status_true_false(n+1);
    }


    // setting the color of the Layout
    public void SetColor(int num)
    {
        switch (colorButtons[num-1]) {
            case "gray":
                linearLayout.setBackgroundColor(getResources().getColor(R.color.White_norm));
                break;
            case "red":
                linearLayout.setBackgroundColor(getResources().getColor(R.color.red));
                break;
            case "green":
                linearLayout.setBackgroundColor(getResources().getColor(R.color.green));
                break;
        }

    }

    // setting the color of the top menu buttons
    public void ColorButton(int n){
        for(int i=0;i<buttonMass.length; i++){
            if(i == n){
                if(colorButtons[i]=="gray")buttonMass[i].getBackground().setColorFilter(Color.parseColor("#a6a6a6"), PorterDuff.Mode.SRC_ATOP);
                else if (colorButtons[i]=="red")buttonMass[i].getBackground().setColorFilter(Color.parseColor("#e46161"), PorterDuff.Mode.SRC_ATOP);
                else buttonMass[i].getBackground().setColorFilter(Color.parseColor("#42c291"), PorterDuff.Mode.SRC_ATOP);
                textExercise.setText(exercise[i]);
            }
            else {
                if(colorButtons[i]=="gray")buttonMass[i].getBackground().setColorFilter(Color.parseColor("#d8d8d8"), PorterDuff.Mode.SRC_ATOP);
                else if (colorButtons[i]=="red")buttonMass[i].getBackground().setColorFilter(Color.parseColor("#e46161"), PorterDuff.Mode.SRC_ATOP);
                else buttonMass[i].getBackground().setColorFilter(Color.parseColor("#42c291"), PorterDuff.Mode.SRC_ATOP);
            }
        }
        taskNumber = n+1;
        status_true_false(n+1);
    }

    //hiding and coloring buttons depending on previous actions
    public void status_true_false(int num)
    {
        if (status[num-1]!=1) //not decided
        {
            checkButton.setEnabled(true);
            TaskGenerationButton.setEnabled(false);
            textView1.setVisibility(View.GONE);
            textView2.setVisibility(View.GONE);


        }
        else //decided
        {
            checkButton.setEnabled(false);
            TaskGenerationButton.setEnabled(true);
            textView1.setVisibility(View.VISIBLE);
            textView2.setVisibility(View.VISIBLE);
        }
    }


    //task generation module


    public void FirstTask()
    {
        /*
        generation of different variations on the task:
        How many ones are in the binary representation of the decimal
        number 406?
         */
        String zeroOrOne[] = { "нулей", "единиц" };
        int randomZeroOrOne = random.nextInt(zeroOrOne.length);
        int randomNumber = 100 + (int) (Math.random() * 900); //// MIN + Math.random()*MAX-MIN
        exercise[0] = "Сколько " + zeroOrOne[randomZeroOrOne] + " в двоичной записи десятичного числа "+String.valueOf(randomNumber)+" ?";

        //Solution
        int j=0;String str = toBinaryString(randomNumber);
        for (char element : str.toCharArray())
        {
            if (zeroOrOne[randomZeroOrOne] == "нулей")
            {
                if (element == '0') j++;
            }
            else
            {
                if (element == '1') j++;
            }


        }

        answer_true[0] = String.valueOf(j);
        solution[0] = "Для начала переведем "+String.valueOf(randomNumber)+ " в двоичную систему счисления. Целая часть числа находится делением на основание новой системы(в данном случае на 2). Получим: "+ toBinaryString(randomNumber)+".\n" +
                "Теперь посчитаем количество " + zeroOrOne[randomZeroOrOne] + " в полученном числе. Их "+answer_true[0]+". Таким образом, ответ равен "+answer_true[0]+".";
    }


    public void SecondTast()
    {
        /*
        generation of different variations on the task:
        Convert decimal number 259 to hexadecimal
         */

        String notation[] = { "двоичную", "восьмеричную", "шестнадцатиричную" };
        int randomNotation = random.nextInt(notation.length);
        int randomNumber = 20 + (int) (Math.random() * 280);
        exercise[1] = "Переведите десятичное число " + String.valueOf(randomNumber) + " в "+notation[randomNotation] + " систему счисления.";

        int divider;
        if (notation[randomNotation]=="двоичную") {divider=2; answer_true[1] = toBinaryString(randomNumber);}
        else if (notation[randomNotation]=="восьмеричную") {divider=8; answer_true[1] = Integer.toString(randomNumber, 8);}
        else {divider=16;answer_true[1] = Integer.toString(randomNumber, 16);}

        solution[1]="Для того, чтобы перевести " + String.valueOf(randomNumber) + " в "+notation[randomNotation] + " систему счисления, следует поделить заданное число на основание нужной системы счисления(в данном случае на "+divider+" ). Таким образом, в ответе будет "+answer_true[1]+".";
    }

    public void ThirdTask()
    {
        /*
        generation of different variations on the task:
        Calculate the sum of x and y binary numbers if y = 10111001, x = 1101011.
        Write your answer in binary
         */

        String sumOrDifference[] = { "сумму", "разность" };
        int randomSumOrDifference = random.nextInt(sumOrDifference.length);

        exercise[2] = "Вычислите " + sumOrDifference[randomSumOrDifference] + " X и Y двоичных чисел, если Y=" + toBinaryString(10 + (int) (Math.random() * 1000)) + " Х=" + toBinaryString(10 + (int) (Math.random() * 1000)) +". Ответ запишите в двоичной системе.";
        //TODO add solution
        solution[2]="";
    }

    public void FourthTask()
    {
        /*
        generation of different variations on the task:
        Calculate the value of the hexadecimal expression 265-372.
        In the answer, write down the calculated value in decimal notation.
         */

        String plusOrMinus [] = {"-","+"};
        int randomPlusOrMinus = random.nextInt(plusOrMinus.length);
        exercise[3] = "Вычислите значение шестнадцатиричного выражения " + Integer.toString(10 + (int) (Math.random() * 1000), 16) + " " + plusOrMinus[randomPlusOrMinus]+ " " + Integer.toString(10 + (int) (Math.random() * 1000), 16) +". В ответе запишите вычисленное значение в десятичной системе счисления.";
        //TODO add solution
        solution[3]="";
    }
    public void FifthTask()
    {
        /*
        generation of different variations on the task:
        How many true inequalities are there among the listed:
        1000101 < 100101;
        1011111111 > 1010101010;
        10000000<1010111
        */
        exercise[4] = "Сколько верных неравенств среди перечисленных: \n" + toBinaryString(10 + (int) (Math.random() * 1000))+" > "+ toBinaryString(10 + (int) (Math.random() * 1000))+";\n" + toBinaryString(10 + (int) (Math.random() * 1000))+" > "+ toBinaryString(10 + (int) (Math.random() * 1000))+";\n"  + toBinaryString(10 + (int) (Math.random() * 1000))+" > "+ toBinaryString(10 + (int) (Math.random() * 1000))+";\n" ;
        //TODO add solution
        solution[4]="";
    }
    public void SixthTask()
    {
        /*
        generation of different variations on the task:
        Given 4 integers written in binary: 10001011, 10111000, 10011011, 10110100.
        How many of them are numbers greater than A416+208?
        */

        String plusOrMinus [] = {"-","+"};
        String moreOrLess [] = {"больших","меньших"};
        int randomMoreOrLess = random.nextInt(moreOrLess.length);
        int randomPlusOrMinus = random.nextInt(plusOrMinus.length);
        exercise[5] = "Даны 4 целых числа, записанные в двоичной системе: " + toBinaryString(0 + (int) (Math.random() * 500)) + ", "+ toBinaryString(0 + (int) (Math.random() * 500)) + ", "+ toBinaryString(0 + (int) (Math.random() * 500)) + ", "+ toBinaryString(0 + (int) (Math.random() * 500)) + ". Сколько среди них чисел, " +moreOrLess[randomMoreOrLess] +", чем результат выражения, представленного в шестнадцатиричной системе " + Integer.toString(50 + (int) (Math.random() * 150), 16) +plusOrMinus[randomPlusOrMinus]+ Integer.toString(1 + (int) (Math.random() * 19), 16) +"?";
        //TODO add solution
        solution[5]="";
    }
    public void SeventhTask()
    {
        /*
        generation of different variations on the task:
        How many natural numbers x exist for which the inequality
        101101112 < x < 101111112 holds?
        In the answer, specify only the number of numbers,
        the numbers themselves do not need to be written.
        */

        exercise[6] = "Сколько существует натуральных чисел x, для которых выполняется неравенство \n" + toBinaryString(0 + (int) (Math.random() * 15)) + " < x < "+ toBinaryString(17 + (int) (Math.random() * 35)) +"? В ответе укажите только количество чисел, сами числа писать не нужно.";
        //TODO add solution
        solution[6]="";
    }
    public void EighthTask()
    {
        /*
        generation of different variations on the task:
        Specify an integer whose binary notation contains exactly 2 units
        */

        String zeroOrOne[] = { "нуля", "единицы" };
        int randomZeroOrOne = random.nextInt(zeroOrOne.length);
        exercise[7] = "Укажите целое число, двоичная запись которого содержит ровно "+ String.valueOf(1 + (int) (Math.random() * 6))+" " + zeroOrOne[randomZeroOrOne]+".";
        //TODO add solution
        solution[7]="";
    }
    public void NinthTask()
    {
        /*
        generation of different variations on the task:
        Specify the smallest two-digit octal number whose binary
        notation contains 4 units.
        In the answer, write down only the octal number itself,
        the base of the number system does not need to be specified.
        */

        String moreOrLess[] = { "наибольшее", "наименьшее" };
        int randomMoreOrLess = random.nextInt(moreOrLess.length);
        exercise[8] = "Укажите "+moreOrLess[randomMoreOrLess]+" двухзначное восьмеричное число, двоичная запись которого содержит "+ String.valueOf(1 + (int) (Math.random() * 6))+" единицы. В ответе запишите только само восьмеричное число, основание системы счисления указывать не нужно." ;
        //TODO add solution
        solution[8]="";
    }


    //toggle top menu
    public void But_menu(View view)
    {
        textAnswer[taskNumber-1]=editText.getText().toString();

        switch (view.getId())
        {

            case R.id.but1:
                ColorButton(0);

                break;

            case R.id.but2:
                ColorButton(1);
                break;


            case R.id.but3:
                ColorButton(2);
                break;


            case R.id.but4:
                ColorButton(3);
                break;

            case R.id.but5:
                ColorButton(4);
                break;

            case R.id.but6:
                ColorButton(5);
                break;


            case R.id.but7:
                ColorButton(6);
                break;

            case R.id.but8:

                ColorButton(7);
                break;

            case R.id.but9:

                ColorButton(8);
                break;
        }
        editText.setText(textAnswer[taskNumber-1]);
        textView2.setText(solution[taskNumber-1]);
        SetColor(taskNumber);
    }

    public void AllTasks()
    {
        FirstTask();
        SecondTast();
        ThirdTask();
        FourthTask();
        FifthTask();
        SixthTask();
        SeventhTask();
        EighthTask();
        NinthTask();
    }

    //calling the generation function depending on the selected task
    public void Rand(View view)
    {
        switch (taskNumber)
        {
            case 1:
                FirstTask();
                break;
            case 2:
                SecondTast();
                break;
            case 3:
                ThirdTask();
                break;
            case 4:
                FourthTask();
                break;
            case 5:
                FifthTask();
                break;
            case 6:
                SixthTask();
                break;
            case 7:
                SeventhTask();
                break;
            case 8:
                EighthTask();
                break;
            case 9:
                NinthTask();
                break;

        }
        status [taskNumber-1] = 0;
        status_true_false(taskNumber);
        textExercise.setText(exercise[taskNumber-1]);
        textAnswer[taskNumber-1]="";
        editText.setText(textAnswer[taskNumber-1]);
        colorButtons[taskNumber-1]="gray";
        buttonMass[0].getBackground().setColorFilter(Color.parseColor("#a6a6a6"), PorterDuff.Mode.SRC_ATOP);
        linearLayout.setBackgroundColor(getResources().getColor(R.color.White_norm));
    }


}
