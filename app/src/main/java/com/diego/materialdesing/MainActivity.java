package com.diego.materialdesing;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CalligraphyConfig.initDefault("Fonts/fontawesome.ttf");
        setContentView(R.layout.activity_main2);

        // Check if we're running on Android 5.0 or higher
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // Call some material design APIs here
        } else {
            // Implement this feature without material design
        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(new CalligraphyContextWrapper(newBase));
    }

    public void onclickButonElevation(View view) {
        switch (view.getId()) {
            case R.id.imageButton2:

                break;
            case R.id.imageButton:

                break;

        }
        Toast.makeText(this, "is  click", Toast.LENGTH_LONG).show();
    }


    public void hideScreen(View v) {
        final View miEncabezado = findViewById(R.id.headline);
        if (miEncabezado.getVisibility() == View.VISIBLE) {

            int cx = (miEncabezado.getLeft() + miEncabezado.getRight()) / 2;
            int cy = (miEncabezado.getTop() + miEncabezado.getBottom()) / 2;
            int radioInicial = miEncabezado.getWidth();
            Animator animator = null;
            Animation animation = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                animator = ViewAnimationUtils.createCircularReveal(miEncabezado, cx, cy, radioInicial, 0);
                animator.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        miEncabezado.setVisibility(View.INVISIBLE);
                    }
                });
                animator.start();
            }
            else{
                animation= AnimationUtils.loadAnimation(this,R.anim.multiple_animations);
                animation.setFillAfter(true);
                miEncabezado.startAnimation(animation);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        miEncabezado.setVisibility(View.INVISIBLE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }

        }
    }


    public void screenDisplay(View v) {
        final View miEncabezado = findViewById(R.id.headline);
        if (miEncabezado.getVisibility() != View.VISIBLE) {

            int cx = (miEncabezado.getLeft() + miEncabezado.getRight()) / 2;
            int cy = (miEncabezado.getTop() + miEncabezado.getBottom()) / 2;
            int radioFinal= Math.max(miEncabezado.getWidth(), miEncabezado.getHeight());
            Animator animator = null;
            Animation animation = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                animator = ViewAnimationUtils.createCircularReveal(miEncabezado, cx, cy, 0, radioFinal);
                miEncabezado.setVisibility(View.VISIBLE);
                animator.start();
            }else{
                animation= AnimationUtils.loadAnimation(this,R.anim.fade_in);
                animation.setRepeatMode(Animation.RESTART);
                miEncabezado.startAnimation(animation);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        miEncabezado.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }




        }
    }
}
