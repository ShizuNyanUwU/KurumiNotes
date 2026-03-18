package com.github.shizunyanuwu.kuruminotes.ui.analyze

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.github.shizunyanuwu.kuruminotes.R
import com.github.shizunyanuwu.kuruminotes.data.Property
import com.github.shizunyanuwu.kuruminotes.databinding.FragmentAnalyzeBinding
import com.github.shizunyanuwu.kuruminotes.ui.base.MaterialSpinnerAdapter
import com.github.shizunyanuwu.kuruminotes.ui.shared.SharedViewModelChara
import com.github.shizunyanuwu.kuruminotes.ui.shared.SharedViewModelCharaFactory

class AnalyzeFragment : Fragment() {

    private lateinit var binding: FragmentAnalyzeBinding
    private lateinit var sharedChara: SharedViewModelChara
    private lateinit var analyzeVM: AnalyzeViewModel
    private lateinit var starViewList: List<ImageView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedChara = ViewModelProvider(requireActivity())[SharedViewModelChara::class.java]
        analyzeVM = ViewModelProvider(this, SharedViewModelCharaFactory(sharedChara))[AnalyzeViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnalyzeBinding.inflate(inflater, container, false)
        binding.viewModel = analyzeVM
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedChara.backFlag = true
        with (binding) {

            // 星星的6个ImageView
            starViewList = listOf(
                charaStar1,
                charaStar2,
                charaStar3,
                charaStar4,
                charaStar5,
                charaStar6
            )

            // 标题条
            analyzeToolbar.apply {
                sharedChara.selectedChara?.let {
                    title = it.unitName
                }
                setNavigationOnClickListener {
                    it.findNavController().navigateUp()
                }
            }

            // Rank下拉框
            rankDropdown.apply {
                setAdapter(
                    MaterialSpinnerAdapter(
                        context,
                        R.layout.dropdown_item_chara_list,
                        analyzeVM.rankList.toTypedArray()
                    )
                )
                setText(analyzeVM.rank.toString())
                onItemClickListener = analyzeVM
            }

            // 角色星级点击监听
            for (i in 1..6) {
                starViewList[i - 1].setOnClickListener {
                    changeStarImage(i)
                    analyzeVM.rarity = i
                    analyzeVM.updateProperty()
                }
            }

            // 如果没有6星则隐藏
            if (analyzeVM.chara?.maxRarity == 5) {
                charaStar6.visibility = View.GONE
            }

            // 敌人等级slider
            enemyLevelSlider.valueTo = sharedChara.maxEnemyLevel.toFloat()
            enemyLevelSlider.addOnChangeListener { _, value, _ ->
                analyzeVM.enemyLevel = value.toInt()
                updateViewModel()
            }

            // 敌人命中slider
            enemyAccuracySlider.addOnChangeListener { _, value, _ ->
                analyzeVM.enemyAccuracy = value.toInt()
                updateViewModel()
            }

            // 敌人回避slider
            enemyDodgeSlider.addOnChangeListener { _, value, _ ->
                analyzeVM.enemyDodge = value.toInt()
                updateViewModel()
            }
        }
        analyzeVM.property4Analyze.observe(viewLifecycleOwner, propertyObserver)
    }

    // 改变星星的填充
    private fun changeStarImage(rarity: Int) {
        for (i in 1..6) {
            if (i <= rarity) {
                starViewList[i - 1].setImageResource(R.drawable.mic_star_filled)
            } else {
                starViewList[i - 1].setImageResource(R.drawable.mic_star_blank)
            }
        }
    }

    // property变化观察器
    private val propertyObserver = Observer<Property> {
        binding.analyzePropertyGroup.itemModel = it
        updateViewModel()
    }

    private fun updateViewModel() {
        binding.viewModel = analyzeVM
    }
}