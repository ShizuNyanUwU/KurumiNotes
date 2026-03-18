package com.github.shizunyanuwu.kuruminotes.ui.shared

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.shizunyanuwu.kuruminotes.data.HatsuneStage
import com.github.shizunyanuwu.kuruminotes.db.MasterHatsune
import kotlin.concurrent.thread

class SharedViewModelHatsune : ViewModel() {

    val hatsuneStageList = MutableLiveData<List<HatsuneStage>>()
    var selectedHatsune: HatsuneStage? = null

    fun loadData() {
        if (hatsuneStageList.value.isNullOrEmpty()) {
            thread(start = true) {
                hatsuneStageList.postValue(MasterHatsune().getHatsune())
            }
        }
    }
}