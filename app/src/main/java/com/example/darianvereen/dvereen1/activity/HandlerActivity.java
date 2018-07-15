package com.example.darianvereen.dvereen1.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.darianvereen.dvereen1.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HandlerActivity extends BaseActivity {

    @BindView(R.id.handler_et)
    EditText editText;

    @OnClick(R.id.handler_countdown)
            public void countDown(View view){
        runHangler.postDelayed(runnable, 1000);
    }

    Handler downloadHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch(msg.what){
                case 1:
                    editText.setText("Started");
                    showToast(String.valueOf(msg.arg1));
                    break;
                case 2:
                    editText.setText("Downloading");
                    break;
                case 3:
                    editText.setText("Finished");
                    break;
            }
        }
    };


    Handler runHangler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            String s = editText.getText().toString();
            int number =Integer.valueOf(s);
            if(number > 0){
                number-=1;
            }
            editText.setText(String.valueOf(number));
            runHangler.postDelayed(runnable, 1000);
        }
    };


    /*@Override
    public void handleMessage(Message msg){
        super handleMessage(msg);
    }*/



    @OnClick(R.id.handler_download)
    public void download(View view){
        new Thread(new Runnable() {
            @Override
            public void run() {

                //editText.setText("Start");
                Message msg = new Message();
                msg.what = 1;
                msg.arg1= 123;
                downloadHandler.sendMessage(msg);

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Message msg1 = new Message();
                msg1.what = 2;
                downloadHandler.sendMessage(msg1);

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Message msg2 = new Message();
                msg2.what = 3;
                downloadHandler.sendMessage(msg2);
            }
        }).start();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        ButterKnife.bind(this);
    }


    /*class DownloadThread extends Thread{
        @Override
        public void run() {
            super.run();
           // editText.setText("Start");
            try {
                editText.setText("Start");
                Thread.sleep(2000);
                editText.setText("Download");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }*/
}
