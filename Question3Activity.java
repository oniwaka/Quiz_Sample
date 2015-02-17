package com.example.konitake.quiz_sample;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;


public class Question3Activity extends ActionBarActivity implements OnClickListener{

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    int ansCount;

    ImageView goodView;
    ImageView badView;

    private final Handler handler = new Handler();
    private final Runnable nextPage = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(Question3Activity.this, Question4Activity.class);
            intent.putExtra("countNumber", ansCount);
            finish();
            startActivity(intent);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);

        goodView = (ImageView)findViewById(R.id.Good_image);
        badView = (ImageView)findViewById(R.id.Bad_image);

        //○を非表示にする
        goodView.setVisibility(View.INVISIBLE);

        //×を非表示にする
        badView.setVisibility(View.INVISIBLE);

        button1 = (Button)findViewById(R.id.ques3Ans1);
        button2 = (Button)findViewById(R.id.ques3Ans2);
        button3 = (Button)findViewById(R.id.ques3Ans3);
        button4 = (Button)findViewById(R.id.ques3Ans4);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);

        Intent intent = getIntent();
        ansCount = intent.getIntExtra("countNumber",0);

//        TextView textView = (TextView) findViewById(R.id.textTest);
//        textView.setText(String.format("%d問正解", ansCount));

    }

    public void onClick(View view){

        goodView = (ImageView)findViewById(R.id.Good_image);
        badView = (ImageView)findViewById(R.id.Bad_image);

        switch (view.getId()){
            case R.id.ques3Ans2:
                goodView.setVisibility(View.VISIBLE);
                ansCount++;
                break;

            default:
                badView.setVisibility(View.VISIBLE);
                break;
        }
        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);
        button4.setEnabled(false);

        handler.postDelayed(nextPage, 1000);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_end, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_end) {
            Intent intent = new Intent(Question3Activity.this, MainActivity.class);
            startActivity(intent);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}