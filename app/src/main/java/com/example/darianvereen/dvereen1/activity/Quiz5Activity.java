package com.example.darianvereen.dvereen1.activity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.example.darianvereen.dvereen1.R;
import com.example.darianvereen.dvereen1.util.LogUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Quiz5Activity extends BaseActivity implements View.OnTouchListener{
    private ValueAnimator repeatAnimator;

    @BindView(R.id.activity_quiz5_tv)
    TextView tv;

    @BindView(R.id.animator_quiz5_tv)
    TextView tv1;

    private GestureDetector gestureDetector;
    private int sumX =0;
    private int sumY =0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz5);
        ButterKnife.bind(this);
        gestureDetector = new GestureDetector(this,new Quiz5Activity.simpleGestureListener());
        tv.setOnTouchListener(this);
        tv.setFocusable(true);
        tv.setClickable(true);
        tv.setLongClickable(true);


    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }


    private class simpleGestureListener extends
            GestureDetector.SimpleOnGestureListener{

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            LogUtil.LogD("Gesture","oSingleTapUp");
            return super.onSingleTapUp(e);
        }

        @Override
        public void onLongPress(MotionEvent e) {
            LogUtil.LogD("Gesture","onLongPress");
            super.onLongPress(e);
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            LogUtil.LogD("Gesture","ononScroll");
            LogUtil.LogD("Gesture","distanceX: "+distanceX);
            LogUtil.LogD("Gesture","distanceY: "+distanceY);
            sumX+=distanceX;
            sumY+=distanceY;
            return super.onScroll(e1, e2, distanceX, distanceY);
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            LogUtil.LogD("Gesture","onFling");
            if(sumX<0){
                if(Math.abs(sumX)>600) {

                    showToast("You scroll from left to right");
                    sumX = 0;
                    sumY = 0;
                    ObjectAnimator animator = ObjectAnimator.ofFloat(tv1, "translationX",  -1050, 0, 0, 0 ,  0); //translationY
                    animator.setDuration(5000);
                   // repeatAnimator = doAnimatorListener();
                    //repeatAnimator.start();
                   animator.start();

                }


            }
            if(sumX>0){

                if(Math.abs(sumX)>600) {
                    showToast("You scroll from  right to left");
                    sumY=0;
                    sumX = 0;
                    ObjectAnimator animator = ObjectAnimator.ofFloat(tv1, "translationX",  0, 0, 0, 0 ,  -1050); //translationY
                    animator.setDuration(5000);
                    animator.start();
                }
            }

            if(sumY<0){
                if(Math.abs(sumY)>100) {
                    showToast("You scroll from top to bottom");
                    sumX = 0;
                    sumY = 0;
                }
            }
            if(sumY>0){
                if(Math.abs(sumY)>100) {
                    showToast("You scroll from  bottom to top");
                    sumX = 0;
                    sumY = 0;
                }
            }
            return super.onFling(e1, e2, velocityX, velocityY);
        }

        @Override
        public void onShowPress(MotionEvent e) {
            LogUtil.LogD("Gesture","onShowPress");
            super.onShowPress(e);
        }

        @Override
        public boolean onDown(MotionEvent e) {
            LogUtil.LogD("Gesture","onDown");
            return super.onDown(e);
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            LogUtil.LogD("Gesture","onDoubleTap");
            return super.onDoubleTap(e);
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            LogUtil.LogD("Gesture","onDoubleTapEvent");
            return super.onDoubleTapEvent(e);
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            LogUtil.LogD("Gesture","onSingleTapConfirmed");
            return super.onSingleTapConfirmed(e);
        }

    }

    private ValueAnimator doAnimatorListener(){
        ValueAnimator animator = ValueAnimator.ofInt(0,400);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue = (int)animation.getAnimatedValue();
                tv1.layout(0,curValue,tv1.getRight(),curValue+tv1.getHeight());

            }
        });
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                //showToast("THis is initial left" + tv1.getLeft());
                tv1.setVisibility(View.INVISIBLE);
                showToast("Started");
                LogUtil.LogD("Yan","animation start");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                tv1.setVisibility(View.VISIBLE);
                showToast("Ended");
                LogUtil.LogD("Yan","animation end");
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                showToast("Canceled");
                LogUtil.LogD("Yan","animation cancel");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                showToast("Repeat");
                LogUtil.LogD("Yan","animation repeat");
            }
        });
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setRepeatCount(2);
//        animator.setInterpolator(new BounceInterpolator());
        animator.setDuration(2000);
        return animator;
    }
}
