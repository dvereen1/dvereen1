package com.example.darianvereen.dvereen1.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

import com.example.darianvereen.dvereen1.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class CustomDialog extends Dialog {

    //Define the variable of the listener
    private CustomDialogEventListener listener;

    //Defined Interface: Listener
    public interface CustomDialogEventListener{
        public void onClickListener(String msg);
    }

    @OnClick(R.id.dialog_ok)
    public void ok(View view){
        listener.onClickListener("Okay");
        dismiss();
    }
    public CustomDialog(@NonNull Context context, CustomDialogEventListener listener) {
        super(context, R.style.dialog);
        //we recieve the listener from the outside
        this.listener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_custom);
        ButterKnife.bind(this);


    }
}
