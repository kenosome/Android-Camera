package com.cali.uao.camaraintent;

import android.app.Activity;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.sql.BatchUpdateException;


public class MainActivity extends Activity {

    Button btnCamara;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCamara= (Button) findViewById(R.id.btnCamara);

        btnCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent camaraintent= new Intent();
                camaraintent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(camaraintent);
            }
        });

    }


}
