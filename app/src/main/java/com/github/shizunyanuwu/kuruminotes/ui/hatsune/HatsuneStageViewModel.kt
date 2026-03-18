package com.github.shizunyanuwu.kuruminotes.ui.hatsune

import androidx.lifecycle.ViewModel
import com.github.shizunyanuwu.kuruminotes.ui.base.HatsuneStageVT
import com.github.shizunyanuwu.kuruminotes.ui.base.OnItemActionListener
import com.github.shizunyanuwu.kuruminotes.ui.base.ViewType
import com.github.shizunyanuwu.kuruminotes.ui.shared.SharedViewModelHatsune

class HatsuneStageViewModel(
    private val sharedHatsune: SharedViewModelHatsune
) : ViewModel() {

    val viewList = mutableListOf<ViewType<*>>()
        get() {
            field.clear()
            sharedHatsune.hatsuneStageList.value?.forEach {
                field.add(HatsuneStageVT(it))
            }
            return field
        }
}

interface OnHatsuneClickListener<T>: OnItemActionListener {
    fun onStageClicked(item: T)
}