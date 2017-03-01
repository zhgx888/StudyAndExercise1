package feicui.edu.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class AnimationActivity extends AppCompatActivity {
    ImageView mImgAlpha1, mImgAlpha2, mImgRotate1, mImgRotate2, mImgScale1, mImgScale2, mImgTrans1,mImgTrans2,
            mImgSet1, mImgSet2, mImgFrame,mImgObjAlpha1,mImgObjRotate2,mImgObjScale3,mImgObjTrans4,mImgObjAnimSet1,mImgObjAnimSet2,mImgHybrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImgAlpha1 = (ImageView) findViewById(R.id.img_alpha1);
        mImgAlpha2 = (ImageView) findViewById(R.id.img_alpha2);
        mImgRotate1 = (ImageView) findViewById(R.id.img_rotate1);
        mImgRotate2 = (ImageView) findViewById(R.id.img_rotate2);
        mImgScale1 = (ImageView) findViewById(R.id.img_scale1);
        mImgScale2 = (ImageView) findViewById(R.id.img_scale2);
        mImgTrans1 = (ImageView) findViewById(R.id.img_trans1);
        mImgTrans2 = (ImageView) findViewById(R.id.img_trans2);
        mImgSet1 = (ImageView) findViewById(R.id.img_animationSet1);
        mImgSet2 = (ImageView) findViewById(R.id.img_animationSet2);
        mImgFrame = (ImageView) findViewById(R.id.img_frame);
        mImgObjAlpha1= (ImageView) findViewById(R.id.img_objObjAlpha1);
        mImgObjRotate2= (ImageView) findViewById(R.id.img_objObjRotate2);
        mImgObjScale3= (ImageView) findViewById(R.id.img_objObjScale3);
        mImgObjTrans4= (ImageView) findViewById(R.id.img_objObjTrans4);
        mImgObjAnimSet1= (ImageView) findViewById(R.id.img_animatorSet1);
        mImgObjAnimSet2= (ImageView) findViewById(R.id.img_animatorSet2);
        mImgHybrid= (ImageView) findViewById(R.id.img_animatorHybrid);
        Animation animAlpha1 = AnimationUtils.loadAnimation(AnimationActivity.this, R.anim.alpha);//补间动画淡入淡出效果
        mImgAlpha1.startAnimation(animAlpha1);
        Animation animRotate1 = AnimationUtils.loadAnimation(AnimationActivity.this, R.anim.rotate);//补间动画旋转效果
        mImgRotate1.startAnimation(animRotate1);
        Animation animScale1 = AnimationUtils.loadAnimation(AnimationActivity.this, R.anim.scale);//补间动画缩放效果
        mImgScale1.startAnimation(animScale1);
        Animation animTrans1 = AnimationUtils.loadAnimation(AnimationActivity.this, R.anim.translate);//补间动画移动效果
        mImgTrans1.startAnimation(animTrans1);
        AnimationSet animSet1 = (AnimationSet) AnimationUtils.loadAnimation(AnimationActivity.this, R.anim.set);//补间动画多重动画效果
        mImgSet1.startAnimation(animSet1);
        mImgFrame.setImageResource(R.drawable.frame_huocairen);//帧动画1
        AnimationDrawable animDraw1 = (AnimationDrawable) mImgFrame.getDrawable();
        animDraw1.start();
        mImgFrame.setBackgroundResource(R.drawable.frame_dengguang);//帧动画2
        AnimationDrawable animDraw2 = (AnimationDrawable) mImgFrame.getBackground();
        animDraw2.start();
        AlphaAnimation animAlpha2 = new AlphaAnimation(0, 1);//补间动画淡入淡出效果
        animAlpha2.setDuration(2000);
        animAlpha2.setFillAfter(true);
        animAlpha2.setRepeatCount(Animation.INFINITE);
        animAlpha2.setRepeatMode(Animation.REVERSE);
        mImgAlpha2.startAnimation(animAlpha2);
        RotateAnimation animRotate2 = new RotateAnimation(0, 360,Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);//补间动画旋转效果
        animRotate2.setDuration(3000);
        animRotate2.setFillAfter(true);
        animRotate2.setRepeatCount(Animation.INFINITE);
        animRotate2.setRepeatMode(Animation.RESTART);
        mImgRotate2.startAnimation(animRotate2);
        ScaleAnimation animScale2 = new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);//补间动画缩放效果
        animScale2.setDuration(3000);
        animScale2.setFillAfter(true);
        animScale2.setRepeatCount(Animation.INFINITE);
        animScale2.setRepeatMode(Animation.REVERSE);
        mImgScale2.startAnimation(animScale2);
        TranslateAnimation animTrans2 = new TranslateAnimation(-10, 10, -10, 10);//补间动画移动效果
        animTrans2.setDuration(2000);
        animTrans2.setFillAfter(true);
        animTrans2.setRepeatCount(Animation.INFINITE);
        animTrans2.setRepeatMode(Animation.REVERSE);
        mImgTrans2.startAnimation(animTrans2);
        AnimationSet nimSet2 = new AnimationSet(true);//补间动画多重动画效果
        nimSet2.addAnimation(animAlpha2);
        nimSet2.addAnimation(animTrans2);
        mImgSet2.startAnimation(nimSet2);
        ObjectAnimator objAlpha=ObjectAnimator.ofFloat(mImgObjAlpha1,"alpha",0, 0.5f, 0, 1,0,1);//属性动画淡入淡出效果
        objAlpha.setRepeatCount(Animation.INFINITE);
        objAlpha.setDuration(3000);
        objAlpha.start();
        ObjectAnimator objRotate = ObjectAnimator.ofFloat(mImgObjRotate2, "rotation", 0, 360);//属性动画旋转效果
//        ObjectAnimator objRotate=ObjectAnimator.ofFloat(mImgObjRotate2,"rotationX",0, 180, 90, 360);
        objRotate.setRepeatCount(Animation.INFINITE);
        objRotate.setDuration(3000);
        objRotate.start();
        ObjectAnimator objScale = ObjectAnimator.ofFloat(mImgObjScale3,"scaleY", 0.1f, 2, 1, 2);//属性动画缩放效果
//        ObjectAnimator objScale3 = ObjectAnimator.ofFloat(mImgObjScale3,"scaleY", 0.1f, 2, 1, 2);
        objScale.setRepeatCount(Animation.INFINITE);
        objScale.setDuration(3000);
        objScale.start();
        ObjectAnimator objTrans = ObjectAnimator.ofFloat(mImgObjTrans4, "translationX", -10,10,-10,10);//属性动画移动效果
//        ObjectAnimator objTrans = ObjectAnimator.ofFloat(mImgObjTrans4, "translationX", -10,10,-10,10);
        objTrans.setRepeatCount(Animation.INFINITE);
        objTrans.setDuration(3000);
        objTrans.start();
        AnimatorSet as = new AnimatorSet();//属性动画混合使用
        ObjectAnimator objAlpha1=ObjectAnimator.ofFloat(mImgObjAnimSet1,"alpha",0, 0.5f, 0, 1,0,1);//属性动画淡入淡出效果
        objAlpha1.setRepeatCount(Animation.INFINITE);
        ObjectAnimator objRotate1 = ObjectAnimator.ofFloat(mImgObjAnimSet1, "rotation", 0, 360);//属性动画旋转效果
        objRotate1.setRepeatCount(Animation.INFINITE);
        ObjectAnimator objScale1 = ObjectAnimator.ofFloat(mImgObjAnimSet1,"scaleY", 0.1f, 2, 1, 2);//属性动画缩放效果
        objScale1.setRepeatCount(Animation.INFINITE);
        ObjectAnimator objTrans1 = ObjectAnimator.ofFloat(mImgObjAnimSet1, "translationX", -10,10,-10,10);//属性动画移动效果
        objTrans1.setRepeatCount(Animation.INFINITE);
        as.setDuration(3000);
        as.playSequentially(objAlpha1, objRotate1, objScale1, objTrans1);//挨个飞
        as.start();
        AnimatorSet ass = new AnimatorSet();//属性动画混合使用
        ObjectAnimator objAlpha2=ObjectAnimator.ofFloat(mImgObjAnimSet2,"alpha",0, 0.5f, 0, 1,0,1);//属性动画淡入淡出效果
        objAlpha2.setRepeatCount(Animation.INFINITE);
        ObjectAnimator objRotate2 = ObjectAnimator.ofFloat(mImgObjAnimSet2, "rotation", 0, 360);//属性动画旋转效果
        objRotate2.setRepeatCount(Animation.INFINITE);
        ObjectAnimator objScale2 = ObjectAnimator.ofFloat(mImgObjAnimSet2,"scaleY", 0.1f, 2, 1, 2);//属性动画缩放效果
        objScale2.setRepeatCount(Animation.INFINITE);
        ObjectAnimator objTrans2 = ObjectAnimator.ofFloat(mImgObjAnimSet2, "translationX", -10,10,-10,10);//属性动画移动效果
        objTrans2.setRepeatCount(Animation.INFINITE);
        ass.playTogether(objAlpha2, objRotate2, objScale2, objTrans2);//一起飞
        ass.setDuration(3000);
        ass.start();
        mImgHybrid.setImageResource(R.drawable.frame_huocairen);//帧动画及补间动画效果
        AnimationDrawable animDrawa = (AnimationDrawable) mImgHybrid.getDrawable();
        animDrawa.start();
        Animation animAlpha = AnimationUtils.loadAnimation(AnimationActivity.this, R.anim.alpha);//补间动画淡入淡出效果
        mImgHybrid.startAnimation(animAlpha);
    }
}
