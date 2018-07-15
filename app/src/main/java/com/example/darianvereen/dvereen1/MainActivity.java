package com.example.darianvereen.dvereen1;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.darianvereen.dvereen1.Fragment.DemoFragment;
import com.example.darianvereen.dvereen1.Fragment.WorkFragment;
import com.example.darianvereen.dvereen1.activity.BaseActivity;
import com.example.darianvereen.dvereen1.activity.NinePatchActivity;
import com.example.darianvereen.dvereen1.util.LogUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity{
    //@BindView(R.id.main_title_btn_orange) Button picButton;
    @OnClick(R.id.main_title_btn_orange)
    public void submit(View view){
        //Toast.makeText(this, "ORANGE", Toast.LENGTH_SHORT).show();
        showToast("Orange");
    }


    private Button orgButton /*picButton*/, demoButton, workButton;
    private LinearLayout fragmentLayout;
    private WorkFragment workFragment;
    private DemoFragment demoFragment;
    //Here is a method that defines the what we want to happen when we click the orange button
    //Essentially instead of defining the onclick method we make a xml onClick tag in our main_activity.xml
    //file and set it equal to a method name... then in that java file we define the method of the same name
    //to trigger the action when the button is clicked.

    public void onBack(View v){
        Toast.makeText(MainActivity.this,"BACK!", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //here we define java objects that represents the elements that appear on the screen.
        orgButton = findViewById(R.id.main_title_btn_orange);
       // picButton = findViewById(R.id.main_title_btn_pic);
        demoButton = findViewById(R.id.demo_btn);
        workButton = findViewById(R.id.work_btn);


        //Below we define the different fragments
          workFragment = new WorkFragment();
          demoFragment = new DemoFragment();
          getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_layout, demoFragment).commit();



        //Below will be the listeners for all the elements we have on our screen.
        //So the listeners for button
       /* picButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast enables a notification to pop up on the screen// The parameters
               // are the current context or the activtiy or fragment in which the message appears.
               // Make sure to chain the show method our else this text willnot show up on the screen

                Toast.makeText(MainActivity.this, "Picture Button!", Toast.LENGTH_SHORT).show();
               // startActivity(NinePatchActivity.class, "Test", "test");
                startActivity(NinePatchActivity.class, "TEST", "test");
                LogUtil.LogD("TEST", "test");
            }
        });*/

      demoButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              demoButton.setTextColor(Color.BLACK);
              workButton.setTextColor(Color.RED);
              getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_layout, demoFragment).commit();

          }
      });
      workButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workButton.setTextColor(Color.BLACK);
                demoButton.setTextColor(Color.RED);
               // setContentView(R.layout.fragment_work);
                getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_layout,workFragment).commit();
            }
        });






    }



}