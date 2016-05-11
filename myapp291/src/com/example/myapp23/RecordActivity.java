package com.example.myapp23;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Administrator on 12.09.2015.
 */
public class RecordActivity extends Activity implements View.OnClickListener {
    String mas ;
    static int c = 0;
   TextView record;
    Button back;
    int s4;
    String s3;
  SharedPreferences sPref;
   final String SAVED_TEXT = "saved_text";
    GameActivity t;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tm4);
        record=(TextView)findViewById(R.id.record);
//
//
        record.setText(getIntent().getStringExtra("lo"));
        back=(Button)findViewById(R.id.back);
        back.setOnClickListener(this);




//loadText();

    }
   public void saveText(){

        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_TEXT, record.getText().toString());
        ed.commit();
        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();
    }
    public void loadText() {


        sPref =  getSharedPreferences("MyPref", MODE_PRIVATE);

        String savedText = sPref.getString(SAVED_TEXT, String.valueOf(t.save));
        record.setText(savedText);
        Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onClick(View v) {


        switch (v.getId()){
            case R.id.back:


                     //saveText();

                Intent intd=new Intent(this,GameActivity.class);


                startActivity(intd);
        }



    }



    /*@Override
    public void onBackPressed() {
        // This will be called either automatically for you on 2.0
        // or later, or by the code above on earlier versions of the
        // platform.
        return;
    }*/
}
