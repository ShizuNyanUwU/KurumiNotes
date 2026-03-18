package com.github.shizunyanuwu.kuruminotes.data.action;

import com.github.shizunyanuwu.kuruminotes.R;
import com.github.shizunyanuwu.kuruminotes.common.I18N;
import com.github.shizunyanuwu.kuruminotes.data.Property;

public class UpperLimitAttackAction extends ActionParameter {
    @Override
    protected void childInit() {
        super.childInit();
    }

    @Override
    public String localizedDetail(int level, Property property) {
        return I18N.getString(R.string.s_Damage_is_reduced_on_low_level_players,
                super.localizedDetail(level, property));
    }
}
