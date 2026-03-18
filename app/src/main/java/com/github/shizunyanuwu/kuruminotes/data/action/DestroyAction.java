package com.github.shizunyanuwu.kuruminotes.data.action;

import com.github.shizunyanuwu.kuruminotes.R;
import com.github.shizunyanuwu.kuruminotes.common.I18N;
import com.github.shizunyanuwu.kuruminotes.data.Property;

public class DestroyAction extends ActionParameter {
    @Override
    protected void childInit() {
        super.childInit();
    }

    @Override
    public String localizedDetail(int level, Property property) {
        return I18N.getString(R.string.Kill_s_instantly, targetParameter.buildTargetClause());
    }
}
