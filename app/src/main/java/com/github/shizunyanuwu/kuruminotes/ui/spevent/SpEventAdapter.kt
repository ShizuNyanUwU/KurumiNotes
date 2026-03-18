package com.github.shizunyanuwu.kuruminotes.ui.spevent

import android.view.View
import androidx.navigation.findNavController
import com.github.shizunyanuwu.kuruminotes.R
import com.github.shizunyanuwu.kuruminotes.data.SpEvent
import com.github.shizunyanuwu.kuruminotes.databinding.ItemSpEventBinding
import com.github.shizunyanuwu.kuruminotes.ui.base.BaseRecyclerAdapter
import com.github.shizunyanuwu.kuruminotes.ui.shared.SharedViewModelClanBattle

class SpEventAdapter(
    private val sharedClanBattle: SharedViewModelClanBattle
) : BaseRecyclerAdapter<SpEvent, ItemSpEventBinding>(R.layout.item_sp_event) {
    override fun onBindViewHolder(holder: VH<ItemSpEventBinding>, position: Int) {
        with(holder.binding){
            val thisSpEvent = itemList[position]
            spEvent = thisSpEvent
            spName.text = thisSpEvent.name
            clickListener = View.OnClickListener {
                sharedClanBattle.mSetSelectedBoss(thisSpEvent.spBoss)
                it.findNavController().navigate(
                    SpEventFragmentDirections.actionNavSpEventToNavEnemy()
                )
            }
            executePendingBindings()
        }
    }
}