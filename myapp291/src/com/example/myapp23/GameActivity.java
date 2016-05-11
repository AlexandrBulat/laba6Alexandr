package com.example.myapp23;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.*;
import android.view.inputmethod.InputMethodManager;
import android.widget.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static java.lang.String.valueOf;

public class GameActivity extends Activity implements View.OnClickListener {
    private long mStartTime = 0L;
    Intent it1;
    static int sav = 0;
    static int sav1 = 0;
    int seconds = 0;
    int minutes = 0;
    // Handler to handle the message to the timer task
    private Handler mHandler = new Handler();

    static int UPDATE_INTERVAL = 0;

    String timerStop1;
    static int n = 0;
    static int jr = 0;
    static int save = 0;
    //   static  int save1=0;
    static int s3;
    Thread t;
    static int backButtonCount = 0;
    static int N = 0;
    String s1;
    int lineCount;
    static int n1 = 0;
    static int n2 = 0;
    TextView time;
    ListView lv;
    Button btn1;
    Button playbtn;
    EditText edt;
    TextView t57;
    TextView login1;
    Button rec;
    Button tim;
    TextView tvt;


    private ArrayList<String> data = new ArrayList<String>();

    int random5;

    SharedPreferences sPref;
    final String SAVED_TEXT = "saved_text";

    String mas[] = {"Yes", "No"};
    RecordActivity r = new RecordActivity();
    Activity myActivity;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


      time = (TextView) findViewById(R.id.time);
        rec = (Button) findViewById(R.id.Record);
        rec.setOnClickListener(this);
        btn1 = (Button) findViewById(R.id.b);
        playbtn = (Button) findViewById(R.id.playbt);
        edt = (EditText) findViewById(R.id.edt);

        t57 = (TextView) findViewById(R.id.t1);
        tvt = (TextView) findViewById(R.id.tvt);
        btn1.setOnClickListener(this);
        playbtn.setOnClickListener(this);
        login1 = (TextView) findViewById(R.id.name);
        login1.setText(getIntent().getStringExtra("login"));

        time.setText("00:00:00");

        new LockOrientation(this).lock();



        data.add("This number" + (n));
        Ir();


    }


    public void generateRandomLevel1(int i1) {
        Random r = new Random();
        random5 = r.nextInt(i1) + 1;
        Log.d("tag", "Random number = " + random5);

    }


    public void showChangeLangDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);


        dialogBuilder.setTitle("Custom dialog");
        dialogBuilder.setMessage("You win " + " if you want to play again click button playagain or enter 2 to 10 ");
        dialogBuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                playbtn.setEnabled(true);
                n = 0;
                t57.setText("Your Points" + (n2 - n));
                data.clear();
                Ir();


            }

        });


        AlertDialog b = dialogBuilder.create();
        b.show();
    }


    public void Ir() {

        lv = (ListView) findViewById(R.id.listView);

        lv.setAdapter(new Myadapter(this, R.layout.laour_item, data));


        lv.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));


    }


    public void launchIntent() {


        int uy = s3;


        Intent it = new Intent(this, RecordActivity.class);
        it.putExtra("lo", t57.getText().toString());


        startActivity(it);


    }

    public void saveText() {
        sPref = getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_TEXT, String.valueOf(save));
        ed.commit();
        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();
    }

    void loadText() {
        Intent it12 = new Intent(this, RecordActivity.class);
        sPref = getSharedPreferences("MyPref", MODE_PRIVATE);
        String savedText = sPref.getString(SAVED_TEXT, String.valueOf(save));
        it12.putExtra("lo", savedText);
        startActivity(it12);
        Toast.makeText(this, "Text l" +
                "oaded", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onClick(View v) {


switch (v.getId()) {
            case R.id.playbt:
                edt.setEnabled(true);
                btn1.setEnabled(true);
                data.clear();
                n = 0;


                t57.setText("Your Points" + (n2 - n));

                data.add("Io" + (n));
                Ir();
                break;


            case R.id.b:


                tvt.setText(edt.getText().toString());

                s1 = edt.getText().toString();

                try {
                    lineCount = Integer.parseInt(s1);
                    n1 = Integer.parseInt(s1);


                    generateRandomLevel1(lineCount);


                    if (lineCount >= 2 && lineCount <= 10) {


                        edt.setEnabled(false);
                        btn1.setEnabled(false);
                        edt.setText("");
                        data.clear();
                        n = 0;
                        data.add("This number" + (n));


                        Ir();


                    } else {
                        Toast.makeText(getApplicationContext(), " Enter 2 to 10", Toast.LENGTH_LONG).show();
                    }
                } catch (NumberFormatException ex) {
                    Toast.makeText(getApplicationContext(), " Enter 2 to 10", Toast.LENGTH_LONG).show();
                }


                if (mStartTime == 0L) {
                    mStartTime = SystemClock.uptimeMillis();
                    mHandler.removeCallbacks(mUpdateTimeTask);
                    mHandler.postDelayed(mUpdateTimeTask, 100);

                }


                break;
            case R.id.Record:

                sPref = getSharedPreferences("MyPref", MODE_PRIVATE);

               // String p = sPref.getString(SAVED_TEXT, String.valueOf(save));
              //  save = Integer.parseInt(p);
                save=sPref.getInt(SAVED_TEXT,save);
                it1 = new Intent(this, RecordActivity.class);
                if (s3 >= save) {
                    save = s3;
                    saveText();


                    it1.putExtra("lo", valueOf(save));

                } else {

                    loadText();
                    it1.putExtra("lo", valueOf(save));


                }


                startActivity(it1);

                break;


        }




    }


    public void Snow() {

        AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
        builder.setTitle("You lose")

                .setMessage("Do you want continue?\n" + t57.getText().toString())
                .setCancelable(false)

                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        edt.setEnabled(true);
                        btn1.setEnabled(true);
                        data.clear();
                        Ir();


                        //launchIntent();

                    }
                });


        builder.show();
    }


    class Myadapter extends ArrayAdapter<String> {
        private int layout;
        private Context ctx;


        final ViewBolder viewBolder = new ViewBolder();


        public Myadapter(Context context, int resourse, List<String> objects) {
            super(context, resourse, objects);
            layout = resourse;
            ctx = context;
        }


        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {


            if (convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(layout, parent, false);

                int j;

                if (position + 1 != lineCount) {


                    viewBolder.lnr1 = (LinearLayout) convertView.findViewById(R.id.lin);
                    //viewBolder.t1 = (TextView) convertView.findViewById(R.id.t1);



                    LinearLayout.LayoutParams rightGravityParams = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f);
                    rightGravityParams.gravity = Gravity.CENTER;


                    for (j = lineCount- position; j > 0; j--) {


                        View vLeft = new View(ctx);
                        View vRight = new View(ctx);

                        vLeft.setLayoutParams(rightGravityParams);
                        vRight.setLayoutParams(rightGravityParams);

                        viewBolder.btn = new Button(ctx);

                        viewBolder.t = new TextView(ctx);


                        viewBolder.btn.setText("X");

                        viewBolder.btn.setLayoutParams(rightGravityParams);

                        viewBolder.lnr1.addView(vLeft);
                        viewBolder.lnr1.addView(viewBolder.btn);
                        viewBolder.lnr1.addView(viewBolder.t);





                        //
                        if (j == 1)
                            viewBolder.lnr1.addView(vRight);

                        if (position == n) {
                            viewBolder.btn.setEnabled(true);
                        } else {
                            viewBolder.btn.setEnabled(false);
                        }

                        final int finalJ = j;
                        viewBolder.btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                if (finalJ == random5) {
                                    viewBolder.t.setText("No");
                                } else {
                                    if (lineCount - position - 1 > 1)

                                        generateRandomLevel1(lineCount - position - 1);
                                    viewBolder.t.setText("Yes");
                                }

                                if (position + 1 == lineCount && viewBolder.t.getText().toString().equals("Yes")) {

                                    playbtn.setEnabled(true);
                                    btn1.setEnabled(true);
                                    edt.setEnabled(true);
                                    showChangeLangDialog();
                                    btn1.setEnabled(true);
                                    edt.setEnabled(true);
                                    mHandler.removeCallbacks(mUpdateTimeTask);



                                    time.setText(timerStop1);
                                    mStartTime = 0L;


                                } else {
                               playbtn.setEnabled(false);
                                }


                                if (viewBolder.t.getText().toString().equals("Yes")) {



                                    n1++;
                                    /*if(seconds<3) {

                                        t57.setText("Your Points" + (100 / (lineCount - position) * n1 - 100)*5);

                                        s3 = (100 / (lineCount - position) * n1 - 100);
                                        jr=s3;
                                        N=jr;

                                    }
                                    if(seconds<5 && seconds>=3){
                                        t57.setText("Your Points" + ((100 / (lineCount - position) * n1 - 100)*8)+jr);

                                        s3 = (100 / (lineCount - position) * n1 - 100)+jr;



                                    }
                                    if(seconds>5 ){*/
                                t57.setText("Your Points" + (100 / (lineCount - position) * n1 - 100));


                                    s3 = ((100 / (lineCount - position) * n1 - 100));


                                    n++;

                                    data.add("This number" + (n));

                                    Ir();



                                }


                                if (viewBolder.t.getText().toString().equals("No")) {

                                    Snow();
                                    mHandler.removeCallbacks(mUpdateTimeTask);

                                    time.setText(timerStop1);
                                    mStartTime = 0L;


                                    n = 0;
                                   t57.setText("Your Points" + n);
                                    lineCount = n1;
                                }

                            }
                        });
                    }
                } else {
                    showChangeLangDialog();
                }
            }

            convertView.setTag(viewBolder);

            return convertView;

        }

        public class ViewBolder {

            LinearLayout lnr1;
            TextView t;
            TextView t1;

            TextView t57;
            Button btn;
            TextView time;
            Button rec;

            Button btn1;
            Button playbtn;
            EditText edt;


            TextView login1;


             TextView tvt;
        }
    }


    /* @Override
     public boolean onKeyDown(int keyCode, KeyEvent event) {
         if (keyCode == KeyEvent.KEYCODE_BACK) {
             Intent a = new Intent(this,MyActivity.class);
             a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
             startActivity(a);

             return true;
         }
         return super.onKeyDown(keyCode, event);
     }*/
    private Runnable mUpdateTimeTask = new Runnable() {

        public void run() {

            final long start = mStartTime;
            long millis = SystemClock.uptimeMillis() - start;

            seconds = (int) (millis / 1000);
            minutes = seconds / 60;
            seconds = seconds % 60;

            time.setText("" + minutes + ":"
                    + String.format("%02d", seconds));
            timerStop1 = minutes + ":"
                    + String.format("%02d", seconds);


            mHandler.postDelayed(this, 200);

        }
    };

    public class LockOrientation {
        Activity act;

        public LockOrientation(Activity act) {
            this.act = act;
        }

        public void lock() {
            switch (act.getResources().getConfiguration().orientation) {
                case Configuration.ORIENTATION_PORTRAIT:
                    if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.FROYO) {
                        act.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                    } else {
                        int rotation = act.getWindowManager().getDefaultDisplay().getRotation();
                        if (rotation == android.view.Surface.ROTATION_90 || rotation == android.view.Surface.ROTATION_180) {
                            act.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT);
                        } else {
                            act.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                        }
                    }
                    break;
                case Configuration.ORIENTATION_LANDSCAPE:
                    if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.FROYO) {
                        act.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                    } else {
                        int rotation = act.getWindowManager().getDefaultDisplay().getRotation();
                        if (rotation == android.view.Surface.ROTATION_0 || rotation == android.view.Surface.ROTATION_90) {
                            act.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                        } else {
                            act.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT);
                        }
                    }
                    break;
            }
        }
    }

}
