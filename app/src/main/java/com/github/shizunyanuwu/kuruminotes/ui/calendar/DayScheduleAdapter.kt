package com.github.shizunyanuwu.kuruminotes.ui.calendar

import com.github.shizunyanuwu.kuruminotes.R
import com.github.shizunyanuwu.kuruminotes.data.CampaignSchedule
import com.github.shizunyanuwu.kuruminotes.data.EventSchedule
import com.github.shizunyanuwu.kuruminotes.databinding.ItemScheduleBinding
import com.github.shizunyanuwu.kuruminotes.ui.base.BaseRecyclerAdapter

class DayScheduleAdapter : BaseRecyclerAdapter<EventSchedule, ItemScheduleBinding>(R.layout.item_schedule) {
    override fun onBindViewHolder(holder: VH<ItemScheduleBinding>, position: Int) {
        with(holder.binding) {
            val item = itemList[position]
            schedule = item
            if (item is CampaignSchedule) {
                typeDot.setColorFilter(item.campaignType.shortColor())
            } else {
                typeDot.setColorFilter(item.type.color)
            }
            executePendingBindings()
        }
    }
}