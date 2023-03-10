package com.graphicless.cricketapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.google.android.material.transition.Hold
import com.google.android.material.transition.MaterialElevationScale
import com.graphicless.cricketapp.adapter.ViewPagerAdapter
import com.graphicless.cricketapp.databinding.FragmentFixtureBinding
import com.graphicless.cricketapp.utils.MyConstants

class MatchSummaryContainerOuterFragment : Fragment(){

    private lateinit var _binding: FragmentFixtureBinding
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        exitTransition = Hold()
        exitTransition = MaterialElevationScale(/* growing = */ false)
        reenterTransition = MaterialElevationScale(/* growing = */ true)

        (activity as AppCompatActivity).supportActionBar?.title = MyConstants.MATCHES
        (activity as AppCompatActivity).supportActionBar?.elevation = 0f
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFixtureBinding.inflate(inflater, container, false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val fragmentList: List<Fragment> = listOf(MatchSummaryContainerFragment(), MatchSummaryContainerFragment(), MatchSummaryContainerFragment())
        val tabNameList: List<String> = listOf("Upcoming", "Recent", "Previous")

        val viewPagerAdapter = ViewPagerAdapter(this, fragmentList, null, null)

        binding.viewPager.adapter = viewPagerAdapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabNameList[position]
        }.attach()
    }
}

