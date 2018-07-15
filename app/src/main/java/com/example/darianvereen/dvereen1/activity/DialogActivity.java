package com.example.darianvereen.dvereen1.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.example.darianvereen.dvereen1.R;
import com.example.darianvereen.dvereen1.bean.Base;
import com.example.darianvereen.dvereen1.dialog.CustomDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DialogActivity extends BaseActivity{

    private int checkedID;

    @OnClick(R.id.dialog_submit)
    public void submit(View view){
        switch(checkedID){
            case R.id.dialog_custom:
                CustomDialog.CustomDialogEventListener listener
                        = new CustomDialog.CustomDialogEventListener() {
                    @Override
                    public void onClickListener(String msg) {
                        showToast(msg);
                    }
                };
                CustomDialog dialog =
                        new CustomDialog(DialogActivity.this, listener);
                dialog.show();
                break;
        }

    }
    @BindView(R.id.dialog_radio_group)
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        ButterKnife.bind(this);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                checkedID = checkedId;
            }
        });
    }
}
