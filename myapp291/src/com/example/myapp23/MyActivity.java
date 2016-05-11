package com.example.myapp23;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MyActivity extends Activity implements View.OnClickListener {
    TextView lognin1;
    EditText editText;
    Button bt;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.tm5);
        editText=(EditText)findViewById(R.id.edvod);
        lognin1=(TextView)findViewById(R.id.login);
        bt=(Button)findViewById(R.id.game);
        bt.setOnClickListener(this);




}

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.game:
                Intent in=new Intent(this,GameActivity.class);
               // in.putExtra("login",editText.getText().toString());
                startActivity(in);

        }

    }
    public void Ony(){
        Intent in = new Intent(this, GameActivity.class);
        startActivity(in);
    }
    public void exit(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MyActivity.this);
        AlertDialog.Builder yes = builder.setTitle("You lose")

                .setMessage("Do you want finish?\n" )
                .setCancelable(false)

                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        finish();

                    }
                });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


                Ony();


            }
        });


        builder.show();


    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
