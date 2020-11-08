package com.example.contact.Adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.contact.Fragment.ProfileFragment
import com.example.contact.Fragment.UserFragment

class PageAdapter(ctx: Context, fm:FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> {return UserFragment() }
            else -> {return ProfileFragment()}
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            0 -> return "User"
            else -> return "Profile"
        }
    }

    override fun getCount(): Int {
        return 2;
    }

}