package com.github.shizunyanuwu.kuruminotes.data.action;

import com.github.shizunyanuwu.kuruminotes.R;
import com.github.shizunyanuwu.kuruminotes.common.I18N;
import com.github.shizunyanuwu.kuruminotes.data.Property;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class ToadAction extends ActionParameter {

    protected List<ActionValue> durationValues = new ArrayList<>();

    @Override
    protected void childInit() {
        super.childInit();
        durationValues.add(new ActionValue(actionValue1, actionValue2, null));
    }

    @Override
    public String localizedDetail(int level, Property property) {
        return I18N.getString(R.string.Polymorph_s1_for_s2_sec,
                targetParameter.buildTargetClause(),
                buildExpression(level, durationValues, RoundingMode.UNNECESSARY, property));
    }
}
