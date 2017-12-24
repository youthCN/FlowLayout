package gcytest.flowlayout;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private static List<String> datas = new ArrayList<>();
    static {
        datas.add("微信");
        datas.add("手机QQ");
        datas.add("支付宝");
        datas.add("高德地图");
        datas.add("淘宝");
        datas.add("天猫");
        datas.add("京东");
        datas.add("唯品会");
        datas.add("手机助手");
        datas.add("携程旅行");
        datas.add("滴滴出行");
        datas.add("阿里星球(原天天动听)");
        datas.add("滴滴出行");
        datas.add("Uber");
        datas.add("58同城");
        datas.add("咸鱼");
        datas.add("英雄联盟");
        datas.add("绝地逃生");
        datas.add("膜拜单车");
        datas.add("ofo小黄车");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        ScrollView scrollView=new ScrollView(UiUtils.getContext());
        scrollView.setBackgroundResource(R.mipmap.grid_item_bg_normal);
        Flowlayout layout=new Flowlayout(UiUtils.getContext());
        int padding=UiUtils.dip2px(13);
        layout.setPadding(padding, padding, padding, padding);
        //layout.setOrientation(LinearLayout.VERTICAL);// 设置线性布局的方向
        int backColor = 0xffcecece;
        Drawable pressedDrawable=DrawableUtils.createShape(backColor);// 按下显示的图片
        for(int i=0;i<datas.size();i++){
            TextView textView=new TextView(UiUtils.getContext());


            Random random=new Random();   //创建随机
            int red = random.nextInt(200)+22;
            int green = random.nextInt(200)+22;
            int blue = random.nextInt(200)+22;
            int color= Color.rgb(red, green, blue);//范围 0-255

            GradientDrawable createShape = DrawableUtils.createShape(color); // 默认显示的图片
            StateListDrawable createSelectorDrawable = DrawableUtils.createSelectorDrawable(pressedDrawable, createShape);// 创建状态选择器
            textView.setBackgroundDrawable(createSelectorDrawable);

            textView.setTextColor(Color.WHITE);
            int textPaddingV = UiUtils.dip2px(4);
            int textPaddingH = UiUtils.dip2px(7);
            textView.setPadding(textPaddingH, textPaddingV, textPaddingH, textPaddingV); //设置padding
            textView.setClickable(true);//设置textView可以被点击
            final String str=datas.get(i);
            textView.setText(str);
            textView.setTextSize(UiUtils.dip2px(10));
            textView.setGravity(Gravity.CENTER);

            textView.setOnClickListener(new View.OnClickListener() {  // 设置点击事件

                @Override
                public void onClick(View v) {
                    Toast.makeText(UiUtils.getContext(), str, Toast.LENGTH_SHORT).show();
                }
            });
            layout.addView(textView,new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, -2));// -2 包裹内容
        }

        scrollView.addView(layout);
        setContentView(scrollView);
    }
}
