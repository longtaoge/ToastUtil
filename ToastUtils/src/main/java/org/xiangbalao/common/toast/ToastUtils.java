package org.xiangbalao.common.toast;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 自定义吐丝
 */
public class ToastUtils extends Toast {

    /**
     * 自定义吐丝布局
     */
    private static View mToastView;
    /**
     * 默认显示时间
     */
    private static int mDuration = Toast.LENGTH_LONG;
    // 吐丝
    private static Toast mToast;


    private static Context context;

    public ToastUtils(Context context) {
        super(context);
    }

    /**
     * 初始化
     *
     * @param context
     */
    public static void init(Context context) {

        ToastUtils.context = context;

    }

    public static void init(Context context, int duration) {
        init(context);
        ToastUtils.mDuration = duration;
    }


    /**
     * 默认显示时间的吐丝
     *
     * @param text
     * @return
     */
    public static Toast makeText(CharSequence text) {

        checkContext();
        return ToastUtils.makeText(context, text, Toast.LENGTH_SHORT);
    }


    /**
     * @param text
     * @param duration
     * @param drawable
     * @return 自定义背景 资源
     */
    public static Toast makeText(CharSequence text,
                                 int duration, Drawable drawable) {

        checkContext();


        if (mToast == null) {
            mToast = new Toast(ToastUtils.context.getApplicationContext());
            mToast.setGravity(Gravity.CENTER, 0, 0);

        }
        LayoutInflater inflate = (LayoutInflater) ToastUtils.context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View mView = inflate.inflate(R.layout.widget_toastutils, null);
        mToastView = mView.findViewById(R.id.toast_layout);


        if (mToastView != null) {
            mToastView.setPadding(10, 0, 10, 0);
            mToastView.setBackgroundDrawable(drawable);
        } else {
            mToast.getView().setBackgroundDrawable(drawable);
        }


        TextView tv = (TextView) mView.findViewById(R.id.message);
        tv.setText(text);

        if (Toast.LENGTH_LONG == duration || Toast.LENGTH_SHORT == duration) {
            mToast.setDuration(duration);
        }

        mToast.setView(mView);


        return mToast;
    }




    private static void checkContext() {
        if (context == null) {
            throw new RuntimeException(" ToastUtils is  no init,context can not is null  ");
        }
    }


    /**
     * 自定义背景颜色
     *
     * @param text
     * @param duration
     * @param Color
     * @return
     */
    public static Toast makeText(CharSequence text,
                                 int duration, int Color) {
        checkContext();
        mToast = ToastUtils.makeText(context, text, duration);

        if (mToastView != null) {
            mToastView.setBackgroundColor(Color);
        } else {
            mToast.getView().setBackgroundColor(Color);
        }

        return mToast;
    }


    /**
     * @param text
     * @param duration
     * @param view
     * @return 自定义布局
     */
    public static Toast makeText(CharSequence text,
                                 int duration, View view) {
        checkContext();
        mToast = ToastUtils.makeText(context, text, duration);
        mToast.setView(view);
        return mToast;
    }

    /**
     * @param text
     * @param duration
     * @param view
     * @param onClickListener
     * @return 自定义带点击事件的布局
     */
    public static Toast makeText(CharSequence text,
                                 int duration, View view, OnClickListener onClickListener) {
        checkContext();
        mToast = ToastUtils.makeText(context, text, duration);
        view.setOnClickListener(onClickListener);
        mToast.setView(view);
        return mToast;
    }

    /**
     * @param text
     * @param duration
     * @return 绿色背景 的吐丝 用于显示正确信息
     */
    public static Toast i(CharSequence text, int duration) {
        checkContext();
        return ToastUtils.makeText(
                text,
                duration,
                context.getResources().getDrawable(
                        R.drawable.background_standard_green)); //   R.drawable.background_standard_green));
    }

    /**
     * @param text
     * @return 绿色背景 的吐丝 用于显示正确信息 默认时长
     */
    public static Toast i(CharSequence text) {
        return ToastUtils.i(String.valueOf(text), mDuration);
    }

    /**
     * @param text
     * @param duration
     * @return 红色背景，用于错误提示
     */
    public static Toast e(CharSequence text, int duration) {
        checkContext();
        return ToastUtils
                .makeText(String.valueOf(text), duration, context.getResources()
                        .getDrawable(R.drawable.background_standard_red));
    }

    /**
     * @param text
     * @return 红色背景 默认时长
     */
    public static Toast e(CharSequence text) {
        return ToastUtils.e(String.valueOf(text), mDuration);
    }

    /**
     * @param text
     * @param duration
     * @return 蓝色背景 显示调试信息时用
     */
    public static Toast d(CharSequence text, int duration) {
        checkContext();
        return ToastUtils.makeText(text, duration, context
                .getResources()
                .getDrawable(R.drawable.background_standard_blue));
    }

    /**
     * @param text
     * @return 蓝色背景 默认时长
     */
    public static Toast d(CharSequence text) {

        return ToastUtils.d(text, mDuration);
    }

    /**
     * @param text
     * @param duration
     * @return 警告背景 用于提示警告信息
     */
    public static Toast w(CharSequence text, int duration) {
        checkContext();
        return ToastUtils.makeText(
                text,
                duration,
                context.getResources().getDrawable(
                        R.drawable.background_standard_orange));
    }

    /**
     * @param text
     * @return 警告背景 默认时长
     */
    public static Toast w(CharSequence text) {

        return ToastUtils.w(text, mDuration);
    }

}
