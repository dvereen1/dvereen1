package com.example.darianvereen.dvereen1.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import com.example.darianvereen.dvereen1.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RadioGroupActivity extends BaseActivity {

    private int checkedId;

    @BindView(R.id.radio_radiogroup)
    RadioGroup radioGroup;

    @OnClick(R.id.radio_group_btn)
    public void submit(View view){
        switch (checkedId){
            case R.id.radio_rb1:
                showToast("You chose 1");
                break;
            case R.id.radio_rb2:
                showToast("You chose 2");
                break;
            case R.id.radio_rb3:
               showToast("You chose 3");
                break;

                default:
                    showToast("You've chosen nothing  ");

        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_group);
        ButterKnife.bind(this);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                  RadioGroupActivity.this.checkedId = checkedId;
            }
        });
    }
}
