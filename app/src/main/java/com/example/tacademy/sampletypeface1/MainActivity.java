package com.example.tacademy.sampletypeface1;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        TextView textView = (TextView)findViewById(R.id.text_namun);
//        Typeface typeface = Typeface.createFromAsset(getAssets(), "nanumgothic.ttf");  // 각각 typeface해서 폰트 바꾸는 법
        textView.setTypeface(FontManager.getInstance().getTypeface(this, FontManager.FONT_NAME_NANUM));

        textView = (TextView)findViewById(R.id.text_noto);
        textView.setTypeface(FontManager.getInstance().getTypeface(this, FontManager.FONT_NAME_NOTO));

        textView = (TextView)findViewById(R.id.text_roboto);
        textView.setTypeface(FontManager.getInstance().getTypeface(this, FontManager.FONT_NAME_ROBOTO));
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
