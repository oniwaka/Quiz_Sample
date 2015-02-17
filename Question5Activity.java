package com.example.konitake.quiz_sample;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;


public class Question5Activity extends ActionBarActivity implements OnClickListener{

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    int ansCount;

    ImageView goodView;
    ImageView badView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);

        goodView = (ImageView)findViewById(R.id.Good_image);
        badView = (ImageView)findViewById(R.id.Bad_image);

        //○を非表示にする
        goodView.setVisibility(View.INVISIBLE);

        //×を非表示にする
        badView.setVisibility(View.INVISIBLE);

        button1 = (Button)findViewById(R.id.ques5Ans1);
        button2 = (Button)findViewById(R.id.ques5Ans2);
        button3 = (Button)findViewById(R.id.ques5Ans3);
        button4 = (Button)findViewById(R.id.ques5Ans4);

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
            case R.id.ques5Ans2:
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

        double questionNo = 5.0;
        double aq = (ansCount/questionNo)*100;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("結果")
                .setMessage(String.format("問題数：5問\n" +
                        "正解数：%s問\n" +
                        "正答率："+aq+"%%",
                        ansCount))
                .setPositiveButton("TOPへ戻る",
                        new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int which){
                                Intent intent = new Intent(Question5Activity.this, MainActivity.class);
                                startActivity(intent);
                                finish();

                        }
                    }
                )
                .setNegativeButton("解説",
                        new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int which){
                                Intent intent = new Intent(Question5Activity.this, ExplainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        }
                )
                .show();
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
            Intent intent = new Intent(Question5Activity.this, MainActivity.class);
            startActivity(intent);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}