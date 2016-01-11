package cn.jiajixin.nuwasample;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.jiajixin.nuwasample.Hello.Hello;

public class MainActivity extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //当xml中没有对应id时会崩溃
        setContentView(R.layout.activity_main);
        RelativeLayout main_rl = (RelativeLayout) findViewById(R.id.main_rl);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView textView = (TextView) findViewById(R.id.textview);
        textView.setText(new Hello().say());

        TextView textView2 = new TextView(this);
        textView2.setText("喵~");
        //!!!
        textView2.setId(View.generateViewId());
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.BELOW,R.id.textview);
        main_rl.addView(textView2, params);

        //不管是哪个版本（向前向后）都会被替换
        TextView textView3 = new TextView(this);
        textView3.setText("喵~喵~喵~");
        RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        Log.i("LHF","textView2.getId():"+textView2.getId());
        params2.addRule(RelativeLayout.BELOW,textView2.getId());
        main_rl.addView(textView3,params2);
    }

}
