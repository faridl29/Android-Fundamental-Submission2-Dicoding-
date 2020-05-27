package com.example.submission2.Adapter

import android.content.Context
import android.os.Bundle
import androidx.annotation.Nullable
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.submission2.R
import com.example.submission2.Views.fragment.followers.FollowersFragment
import com.example.submission2.Views.fragment.following.FollowingFragment


class SectionsPagerAdapter(private val mContext: Context, fm: FragmentManager, private val username:String) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    @StringRes
    private val TAB_TITLES = intArrayOf(R.string.tab_following, R.string.followers)
    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> {
                fragment =
                    FollowingFragment()
                val bundle = Bundle()
                bundle.putString(FollowingFragment.EXTRA_USERNAME, username)
                fragment?.arguments = bundle
            }
            1 -> {
                fragment =
                    FollowersFragment()
                val bundle = Bundle()
                bundle.putString(FollowersFragment.EXTRA_USERNAME, username)
                fragment?.arguments = bundle
            }
        }
        return fragment as Fragment
    }
    @Nullable
    override fun getPageTitle(position: Int): CharSequence? {
        return mContext.resources.getString(TAB_TITLES[position])
    }
    override fun getCount(): Int {
        return 2
    }
}