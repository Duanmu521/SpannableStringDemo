package com.strivestay.spannablestringdemo;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.widget.TextView;

import static android.text.Spanned.SPAN_EXCLUSIVE_EXCLUSIVE;
import static android.text.Spanned.SPAN_EXCLUSIVE_INCLUSIVE;
import static android.text.Spanned.SPAN_INCLUSIVE_EXCLUSIVE;
import static android.text.Spanned.SPAN_INCLUSIVE_INCLUSIVE;
/**
 * SpannableString 示例代码
 * @author StriveStay
 * @date 2018/2/6
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // SPAN_INCLUSIVE_INCLUSIVE
        // SPAN_EXCLUSIVE_EXCLUSIVE
        // SPAN_EXCLUSIVE_INCLUSIVE
        // SPAN_INCLUSIVE_EXCLUSIVE

        // ForegroundColorSpan
        TextView tvForegroundColorSpan = (TextView) findViewById(R.id.tv_foregroundColorSpan);
        SpannableString sb1 = new SpannableString(tvForegroundColorSpan.getText());
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.parseColor("#3187D2"));
        sb1.setSpan(foregroundColorSpan,0,10, SPAN_INCLUSIVE_EXCLUSIVE); // 始终包前，不包后
        tvForegroundColorSpan.setText(sb1);

        // BackgroundColorSpan
        TextView tvBackgroundColorSpan = (TextView) findViewById(R.id.tv_backgroundColorSpan);
        SpannableString sb2 = new SpannableString(tvBackgroundColorSpan.getText());
        BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(Color.parseColor("#F5A721"));
        // 结束位置下标可以设置为字符串的长度，因为不管flag如何设置都不会包含最后一个字符，不会下标越界；开始位置下标不能小于0
        sb2.setSpan(backgroundColorSpan,0,sb2.length(), SPAN_EXCLUSIVE_EXCLUSIVE);
        tvBackgroundColorSpan.setText(sb2);

        // RelativeSizeSpan
        TextView tvRelativeSizeSpan = (TextView) findViewById(R.id.tv_relativeSizeSpan);
        SpannableString sb3 = new SpannableString(tvRelativeSizeSpan.getText());
        RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan(1.5f);
        sb3.setSpan(relativeSizeSpan,0,12, SPAN_EXCLUSIVE_EXCLUSIVE);
        tvRelativeSizeSpan.setText(sb3);


        // AbsoluteSizeSpan
        TextView tvAbsoluteSizeSpan = (TextView) findViewById(R.id.tv_absoluteSizeSpan);
        SpannableString sb4 = new SpannableString(tvAbsoluteSizeSpan.getText());
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(22,true);
        sb4.setSpan(absoluteSizeSpan,0,12, SPAN_INCLUSIVE_INCLUSIVE);
        tvAbsoluteSizeSpan.setText(sb4);


        // StrikethroughSpan
        TextView tvStrikethroughSpan = (TextView) findViewById(R.id.tv_strikethroughSpan);
        SpannableString sb5 = new SpannableString(tvStrikethroughSpan.getText());
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
        sb5.setSpan(strikethroughSpan,0,sb5.length(), SPAN_INCLUSIVE_EXCLUSIVE);
        tvStrikethroughSpan.setText(sb5);

        // UnderlineSpan
        TextView tvUnderlineSpan = (TextView) findViewById(R.id.tv_underlineSpan);
        SpannableString sb6 = new SpannableString(tvUnderlineSpan.getText());
        UnderlineSpan underlineSpan = new UnderlineSpan();
        sb6.setSpan(underlineSpan,0,sb6.length(), SPAN_INCLUSIVE_INCLUSIVE);
        tvUnderlineSpan.setText(sb6);

        // SuperscriptSpan
        TextView tvSuperscriptSpan = (TextView) findViewById(R.id.tv_superscriptSpan);
        SpannableString sb7 = new SpannableString(tvSuperscriptSpan.getText());
        SuperscriptSpan superscriptSpan = new SuperscriptSpan();
        sb7.setSpan(superscriptSpan,11,sb7.length(), SPAN_EXCLUSIVE_INCLUSIVE);
        tvSuperscriptSpan.setText(sb7);

        // SubscriptSpan
        TextView tvSubscriptSpan = (TextView) findViewById(R.id.tv_subscriptSpan);
        SpannableString sb8 = new SpannableString(tvSubscriptSpan.getText());
        SubscriptSpan subscriptSpan = new SubscriptSpan();
        sb8.setSpan(subscriptSpan,9,sb8.length(), SPAN_INCLUSIVE_INCLUSIVE);
        tvSubscriptSpan.setText(sb8);

        // StyleSpan
        TextView tvStyleSpan = (TextView) findViewById(R.id.tv_styleSpan);
        SpannableString sb9 = new SpannableString(tvStyleSpan.getText());
        StyleSpan styleSpan1 = new StyleSpan(Typeface.BOLD);
        StyleSpan styleSpan2 = new StyleSpan(Typeface.ITALIC);
        sb9.setSpan(styleSpan1,0,5, SPAN_EXCLUSIVE_EXCLUSIVE);
        sb9.setSpan(styleSpan2,5,sb9.length(), SPAN_INCLUSIVE_INCLUSIVE);
        tvStyleSpan.setText(sb9);

        // ImageSpan
        TextView tvImageSpan = (TextView) findViewById(R.id.tv_imageSpan);
        Drawable drawable = ContextCompat.getDrawable(this,R.drawable.smile);
        drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
        SpannableString sb10 = new SpannableString(tvImageSpan.getText());
        ImageSpan imageSpan = new ImageSpan(drawable);
        sb10.setSpan(imageSpan,5,6, SPAN_EXCLUSIVE_EXCLUSIVE);
        tvImageSpan.setText(sb10);


        // UrlSpan
        TextView tvUrlSpan = (TextView) findViewById(R.id.tv_urlSpan);
        SpannableString sb11 = new SpannableString(tvUrlSpan.getText());
        URLSpan urlSpan = new URLSpan("https://www.jianshu.com/u/3154fc47383d");
        sb11.setSpan(urlSpan,0,sb11.length(), SPAN_INCLUSIVE_INCLUSIVE);
        tvUrlSpan.setMovementMethod(LinkMovementMethod.getInstance());
        tvUrlSpan.setText(sb11);

        // SpannableStringBuilder
        TextView tvSsb = (TextView) findViewById(R.id.tv_ssb);
        SpannableStringBuilder ssb = new SpannableStringBuilder();
        ssb.append(sb1 );
        ssb.append(sb2 );
        ssb.append(sb3 );
        tvSsb.setText(ssb);
    }
}
