package com.cali.uao.camaraintent;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.sql.BatchUpdateException;


public class MainActivity extends Activity {

    Button btnCamara;
    ImageView imgview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCamara= (Button) findViewById(R.id.btnCamara);
        imgview=(ImageView) findViewById(R.id.imgvFoto);

        btnCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent camaraintent= new Intent();
                camaraintent.setAction(MediaStore.ACTION_IMAGE_CAPTURE );
                File carpeta =new File(Environment.getExternalStorageDirectory()+"/CamaraIntent");

                if (!carpeta.exists()){
                    carpeta.mkdirs();
                }

                File foto=new File(carpeta+"/"+"foto1.jpg");

                Uri location=Uri.fromFile(foto);

                camaraintent.putExtra(MediaStore.EXTRA_OUTPUT,location);

                startActivityForResult(camaraintent, 10);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==10){
            //Toast.makeText(this,"OK",Toast.LENGTH_SHORT ).show();
            Bitmap bmFoto= BitmapFactory.decodeFile(Environment.getExternalStorageDirectory()+"/CamaraIntent/foto1.jpg");
            imgview.setImageBitmap(bmFoto);

        }
    }
}
