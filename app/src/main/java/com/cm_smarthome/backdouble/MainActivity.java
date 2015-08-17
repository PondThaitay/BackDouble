package com.cm_smarthome.backdouble;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private Context context = this;
    private boolean Count = false;
    private Button btnTel;
    private TextView tvNumber;
    private static final int TIME_INTERVAL = 2000;
    private long mBackPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTel = (Button) findViewById(R.id.button);
        tvNumber = (TextView) findViewById(R.id.textView2);

        btnTel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String number = tvNumber.getText().toString();
                Intent newActivity = new Intent(Intent.ACTION_CALL);
                newActivity.setData(Uri.parse("tel:"+number));
                startActivity(newActivity);
            }
        });
    }

   @Override
    public void onBackPressed() {
        if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis()) {
            super.onBackPressed();
            return;
        } else {
            Toast.makeText(getBaseContext(), "Press Back again to Exit", Toast.LENGTH_SHORT).show();
        }
        mBackPressed = System.currentTimeMillis();
    }
}
