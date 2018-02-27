package com.gsy.glsurvive.logo;

import java.util.ArrayList;

/**
 * Created by TR-AND2 on 2018/1/16.
 */

public interface LogoView {
    void showLead(ArrayList<LogoResult.ContentBean.StartBean> list);
    void update(ArrayList<LogoResult.ContentBean.UpdateBean> list);
}
