package com.example.myapp23.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapp23.MyActivity;
import com.example.myapp23.R;

import java.util.List;

/**
 * Created by Саша on 24.11.2015.
 */
class MyAdapter  {
//    private int layout;
//    private Context ctx;
//
//    final ViewBolder viewBolder = new ViewBolder();
//    public void Snow(){
//
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(MyActivity.this);
//        builder.setTitle("You lose")
//
//                .setMessage("Do you want continue?\n"+viewBolder.t1.getText().toString() )
//                .setCancelable(false)
//
//                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        viewBolder.edt.setEnabled(true);
//                        viewBolder.btn1.setEnabled(true);
//                        data.clear();
//                        Ir();
//
//
//
//                        //launchIntent();
//
//                    }
//                });
//
//        builder.show();
//    }
//
//    public Myadapter(Context context, int resourse, List<String> objects) {
//        super(context, resourse, objects);
//        layout = resourse;
//        ctx = context;
//    }
//
//
//
//    @Override
//    public View getView(final int position, View convertView, ViewGroup parent) {
//        if (convertView == null) {
//            LayoutInflater inflater = LayoutInflater.from(getContext());
//            convertView= inflater.inflate(layout, parent, false);
//
//
//
//
//
//
//            int j ;
//
//            viewBolder.lnr1=(LinearLayout)convertView.findViewById(R.id.lin);
//            viewBolder.t1=(TextView)findViewById(R.id.t1);
//            viewBolder.btn1=(Button)findViewById(R.id.b);
//            viewBolder.t57=(TextView)findViewById(R.id.tvt);
//            viewBolder.edt = (EditText)findViewById(R.id.edt);
//
//
//            viewBolder.btn1.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    viewBolder.t57.setText(viewBolder.edt.getText().toString());
//                    s1=viewBolder.edt.getText().toString();
//                    i=Integer.parseInt(s1);
//
//                    generateRandomLevel(i);
//
//                    if(i >=2 && i<=10) {
//
//
//                        viewBolder.edt.setEnabled(false);
//                        viewBolder.btn1.setEnabled(false);
//                        viewBolder.edt.setText("");
//                        data.clear();
//                        n=0;
//                        data.add("This number" + n);
//
//                        Ir();
//                    }
//                    else {
//                        Toast.makeText(getApplicationContext(), " Enter 2 to 10", Toast.LENGTH_LONG).show();
//                    }
//
//                }
//            });
//
//
//
//
//
//            LinearLayout.LayoutParams rightGravityParams = new LinearLayout.LayoutParams(
//                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f);
//            rightGravityParams.gravity = Gravity.CENTER;
//
//
//
//            for (j = i - position; j > 0; j--) {
//
//                View vLeft = new View(ctx);
//                View vRight = new View(ctx);
//
//                vLeft.setLayoutParams(rightGravityParams);
//                vRight.setLayoutParams(rightGravityParams);
//
//                viewBolder.btn = new Button(ctx);
//
//                viewBolder.t = new TextView(ctx);
//
//
//
//                viewBolder.btn.setText("X");
//                viewBolder.btn.setLayoutParams(rightGravityParams);
//
//                viewBolder.lnr1.addView(vLeft);
//                viewBolder.lnr1.addView(viewBolder.btn);
//                viewBolder.lnr1.addView(viewBolder.t);
//
//
//
//                //
//                if(j == 1)
//                    viewBolder.lnr1.addView(vRight);
//
//                if (position == n) {
//                    viewBolder.btn.setEnabled(true);
//                } else {
//                    viewBolder.btn.setEnabled(false);
//                }
//
//
//
//                final int finalJ = j;
//                viewBolder.btn.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//
//                        if(finalJ ==random5){
//                            viewBolder.t.setText("No");
//                        }
//                        else {
//                            viewBolder.t.setText("Yes");
//                        }
//                        if (viewBolder.t.getText().toString().equals("Yes")) {
//                            viewBolder.t1.setText("Your Points" + (getCount()));
//                            generateRandomLevel(finalJ-1);
//
//
//                            n++;
//                            data.add("This number" + n);
//
//                            Ir();
//
//
//                        }
//                        if (viewBolder.t.getText().toString().equals("No")) {
//                            Snow();
//
//                            n = 0;
//                            viewBolder.t1.setText("Your Points" + n);
//                        }
//                    }
//                });
//
//
//            }
//
//
//
//            convertView.setTag(viewBolder);
//        }
//        return convertView;
//
//    }
//
//    public class ViewBolder  {
//        LinearLayout lnr1;
//        TextView t;
//        TextView t1;
//        Button btn1;
//        TextView t57;
//        Button btn;
//        EditText edt;
//
//
//
//
//
//
//
//    }
}