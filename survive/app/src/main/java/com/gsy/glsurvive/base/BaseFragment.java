package com.gsy.glsurvive.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Created by TR-AND2 on 2017/11/30.
 */

public abstract class BaseFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        httpRequest();
        logic();
    }
    public abstract void logic();
    public abstract void httpRequest();

}
