package org.xiangbalao;

import android.app.Application;
import android.widget.Toast;

import org.xiangbalao.common.toast.ToastUtils;

/**
 * Created by longtaoge on 17/1/21.
 */

public class MApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        ToastUtils.init(getApplicationContext());

    }
}
