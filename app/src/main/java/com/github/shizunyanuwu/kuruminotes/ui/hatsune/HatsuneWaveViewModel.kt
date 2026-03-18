package com.github.shizunyanuwu.kuruminotes.ui.hatsune

import androidx.lifecycle.ViewModel
import com.github.shizunyanuwu.kuruminotes.data.WaveGroup
import com.github.shizunyanuwu.kuruminotes.ui.base.HatsuneWaveVT
import com.github.shizunyanuwu.kuruminotes.ui.base.OnItemActionListener
import com.github.shizunyanuwu.kuruminotes.ui.base.ViewType
import com.github.shizunyanuwu.kuruminotes.ui.shared.SharedViewModelHatsune

class HatsuneWaveViewModel(
    private val sharedHatsune: SharedViewModelHatsune
) : ViewModel() {

    val viewList = mutableListOf<ViewType<*>>()
        get() {
            field.clear()
            sharedHatsune.selectedHatsune?.let { stage ->
                stage.battleWaveGroupMap.forEach {
                    field.add(HatsuneWaveVT(it))
                }
            }
            return field
        }
}

interface OnWaveClickListener : OnItemActionListener {
    fun onWaveClick(waveGroup: WaveGroup)
}