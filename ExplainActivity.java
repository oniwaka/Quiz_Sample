package com.example.konitake.quiz_sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

public class ExplainActivity extends ActionBarActivity {

    Frag_question1 fragment1;
    Frag_question2 fragment2;
    Frag_question3 fragment3;
    Frag_question4 fragment4;
    Frag_question5 fragment5;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explain);

        //Fragmentを管理するFragmentManagerを取得
        manager = getSupportFragmentManager();
        //追加や削除などを1つの処理としてまとめるためのトランザクションクラスを取得
        FragmentTransaction ft = manager.beginTransaction();

        //1つ目のfragmentを生成
        fragment1 = new Frag_question1();
        Bundle bundle1 = new Bundle();

        // フラグメントに渡す値をセット
        fragment1.setArguments(bundle1);

        //2つ目のfragmentを生成
        fragment2 = new Frag_question2();
        Bundle bundle2 = new Bundle();

        fragment2.setArguments(bundle2);

        //3つ目のfragmentを生成
        fragment3 = new Frag_question3();
        Bundle bundle3 = new Bundle();

        fragment3.setArguments(bundle3);

        //4つ目のfragmentを生成
        fragment4 = new Frag_question4();
        Bundle bundle4 = new Bundle();

        fragment4.setArguments(bundle4);

        //5つ目のfragmentを生成
        fragment5 = new Frag_question5();
        Bundle bundle5 = new Bundle();

        fragment5.setArguments(bundle5);

        //Fragment をスタックに追加する
        //メインレイアウトに対して追加先のビューのID、Fragment、Fragmentのタグ。
        ft.add(R.id.explain_layout, fragment1, "layout_fragment_1");

        ft.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_explain, menu);

        return true;
    }


    //オプションメニューで選択されたフラグメントに応じてreplace
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.ques1:
                manager.beginTransaction()
                        .replace(R.id.explain_layout, fragment1, "layout_fragment_1")
                        .commit();
                return true;
            case R.id.ques2:
                manager.beginTransaction()
                        .replace(R.id.explain_layout, fragment2, "layout_fragment_2")
                        .commit();
                return true;
            case R.id.ques3:
                manager.beginTransaction()
                        .replace(R.id.explain_layout, fragment3, "layout_fragment_3")
                        .commit();
                return true;
            case R.id.ques4:
                manager.beginTransaction()
                        .replace(R.id.explain_layout, fragment4, "layout_fragment_4")
                        .commit();
                return true;
            case R.id.ques5:
                manager.beginTransaction()
                        .replace(R.id.explain_layout, fragment5, "layout_fragment_5")
                        .commit();
                return true;
            default:
                Intent intent = new Intent(ExplainActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
