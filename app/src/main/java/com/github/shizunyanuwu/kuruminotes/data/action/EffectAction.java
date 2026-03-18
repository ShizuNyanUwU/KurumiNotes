package com.github.shizunyanuwu.kuruminotes.data.action;

import com.github.shizunyanuwu.kuruminotes.R;
import com.github.shizunyanuwu.kuruminotes.common.I18N;
import com.github.shizunyanuwu.kuruminotes.data.Property;

public class EffectAction extends ActionParameter{

    @Override
    protected void childInit() {
        super.childInit();
    }

    @Override
    public String localizedDetail(int level, Property property) {
        return I18N.getString(R.string.Implement_some_visual_effects_to_s1, targetParameter.buildTargetClause());
    }
}
