package com.github.shizunyanuwu.kuruminotes.ui.dungeon

import android.view.View
import androidx.navigation.findNavController
import com.github.shizunyanuwu.kuruminotes.R
import com.github.shizunyanuwu.kuruminotes.data.Dungeon
import com.github.shizunyanuwu.kuruminotes.databinding.ListItemDungeonBinding
import com.github.shizunyanuwu.kuruminotes.ui.shared.SharedViewModelClanBattle
import com.github.shizunyanuwu.kuruminotes.ui.base.BaseRecyclerAdapter

class DungeonAdapter(
    private val sharedClanBattle: SharedViewModelClanBattle
) : BaseRecyclerAdapter<Dungeon, ListItemDungeonBinding>(R.layout.list_item_dungeon) {

    override fun onBindViewHolder(holder: VH<ListItemDungeonBinding>, position: Int) {
        with(holder.binding){
            val thisDungeon = itemList[position]
            dungeon = thisDungeon
            textDungeonDescription.text = thisDungeon.description
            mode.text = thisDungeon.modeText
            clickListener = View.OnClickListener {
                sharedClanBattle.mSetSelectedBoss(thisDungeon.dungeonBoss)
                it.findNavController().navigate(
                    DungeonFragmentDirections.actionNavDungeonToNavEnemy()
                )
            }
            executePendingBindings()
        }
    }
}