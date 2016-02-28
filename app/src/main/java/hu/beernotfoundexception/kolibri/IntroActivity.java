package hu.beernotfoundexception.kolibri;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class IntroActivity extends AppCompatActivity {

    @Bind(R.id.imgLogoBegin)
    protected ImageView imgLogoBegin;

    @Bind(R.id.imgLogoEnd)
    protected ImageView imgLogoEnd;

    @Bind(R.id.imgIntroBgOverlay)
    protected ImageView imgBgOverlay;

    @Bind(R.id.linIntroControl)
    protected LinearLayout linIntroControl;

    @OnClick(R.id.btnLogin)
    protected void onLoginClick() {
        logIn();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_intro);

        ButterKnife.bind(this);

        setAnimation();
    }

    /**
     * Animation depends on category.
     */
    private void setAnimation() {
        animation1();
        animation2();
        animation3();
        animation4();
    }

    private void animation1() {
//        ObjectAnimator alphaAnimation = ObjectAnimator.ofFloat(imgBgOverlay, "alpha", 0.0F, 1.0F);
//        alphaAnimation.setDuration(500);
//        alphaAnimation.start();
    }

    private void animation2() {
        imgLogoBegin.setAlpha(1.0F);
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.translate_top_to_center);
        imgLogoBegin.startAnimation(anim);
        imgLogoEnd.setAlpha(1.0F);
        Animation anim2 = AnimationUtils.loadAnimation(this, R.anim.translate_top_to_center);
        imgLogoEnd.startAnimation(anim2);
    }

    private void animation3() {
//        ObjectAnimator alphaAnimation = ObjectAnimator.ofFloat(txtIntroAppTitle, "alpha", 0.0F, 1.0F);
//        alphaAnimation.setStartDelay(1700);
//        alphaAnimation.setDuration(500);
//        alphaAnimation.start();
    }

    private void animation4() {
        linIntroControl.setAlpha(1.0F);
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.translate_bottom_to_center);
        linIntroControl.setAnimation(anim);
        anim.start();
    }

    private void logIn() {
        SharedPreferences settings = this.getSharedPreferences("appInfo", MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("logged_in", true);
        editor.apply();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(IntroActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}
