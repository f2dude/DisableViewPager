package org.rbt.disableviewpager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Switch;

import org.rbt.utils.CustomViewPager;
import org.rbt.utils.MyPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "DISABLE_VIEW_PAGER";
    private static final float NORMAL_OVERLAY = 1f; //full transparent
    private static final float GREY_OUT_OVERLAY = 0.4f; //slightly gereyed out
    private CustomViewPager customViewPager;
    private Switch customSwitch;
    private MyPagerAdapter myPagerAdapter;

    public static void showLog(String msg) {
        Log.d(TAG, msg);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //custom view pager
        customViewPager = (CustomViewPager) findViewById(R.id.customViewPager);
        //pager adapter extending fragmentstatepageradapter
        myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        myPagerAdapter.setAlphaValue(NORMAL_OVERLAY);
        customViewPager.setAdapter(myPagerAdapter);

        customSwitch = (Switch) findViewById(R.id.switch1);
        customSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    enable();
                } else {
                    disable();
                }
            }
        });
    }

    private void enable() {
        customViewPager.setPagingEnabled(true);
        myPagerAdapter.setAlphaValue(NORMAL_OVERLAY);
        myPagerAdapter.notifyDataSetChanged();
    }

    private void disable() {
        customViewPager.setPagingEnabled(false);
        myPagerAdapter.setAlphaValue(GREY_OUT_OVERLAY);
        myPagerAdapter.notifyDataSetChanged();
    }
}
