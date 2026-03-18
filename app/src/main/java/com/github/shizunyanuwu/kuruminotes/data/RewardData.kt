package com.github.shizunyanuwu.kuruminotes.data

import com.github.shizunyanuwu.kuruminotes.R
import com.github.shizunyanuwu.kuruminotes.common.I18N
import com.github.shizunyanuwu.kuruminotes.common.Statics

class RewardData(
    val rewardType: Int,
    val rewardId: Int,
    val rewardNum: Int,
    val odds: Int
) {
    val rewardIcon: String = Statics.EQUIPMENT_ICON_URL.format(rewardId)
    val oddsString: String = I18N.getString(R.string.percent_modifier).format(odds)

}