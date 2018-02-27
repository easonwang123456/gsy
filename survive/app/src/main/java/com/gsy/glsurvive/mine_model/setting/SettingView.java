package com.gsy.glsurvive.mine_model.setting;

import com.gsy.glsurvive.mine_model.setting.update.UpdateResult;

/**
 * Created by TR-AND2 on 2017/12/13.
 */

public interface SettingView {
    void showcache(String cache);
    void showUpdate(UpdateResult.ContentBean contentBean);
}
