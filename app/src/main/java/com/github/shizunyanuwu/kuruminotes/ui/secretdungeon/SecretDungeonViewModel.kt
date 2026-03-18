package com.github.shizunyanuwu.kuruminotes.ui.secretdungeon

import androidx.lifecycle.ViewModel
import com.github.shizunyanuwu.kuruminotes.ui.base.OnItemActionListener
import com.github.shizunyanuwu.kuruminotes.ui.base.SecretDungeonScheduleVT
import com.github.shizunyanuwu.kuruminotes.ui.base.ViewType
import com.github.shizunyanuwu.kuruminotes.ui.shared.SharedViewModelSecretDungeon

class SecretDungeonViewModel(
    private val sharedSecretDungeon: SharedViewModelSecretDungeon
) : ViewModel() {
        val viewList = mutableListOf<ViewType<*>>()
        get() {
            field.clear()
            sharedSecretDungeon.secretDungeonScheduleList.value?.forEach {
                field.add(SecretDungeonScheduleVT(it))
            }
            return field
        }
}

interface OnSecretDungeonScheduleClickListener<T>: OnItemActionListener {
    fun onSecretDungeonScheduleClicked(item: T)
}