package com.yhklsdf.demo_kotlin.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.yhklsdf.demo_kotlin.R
import com.yhklsdf.demo_kotlin.fragment.EmptyFragment
import com.yhklsdf.demo_kotlin.fragment.LearnFragment
import com.yhklsdf.demo_kotlin.mediamvp.ShowPicturesFragment
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        rg_main_bottom_navigation.setOnCheckedChangeListener { group, checkedId ->
            var fragment: Fragment? = null
            when (checkedId) {
                R.id.rbtn_main_bottom_learn -> fragment = LearnFragment()
                R.id.rbtn_main_bottom_picture -> fragment = ShowPicturesFragment()
                R.id.rbtn_main_bottom_tools -> {
                    toast("工具")
                    fragment = EmptyFragment()
                }
            }
            if (fragment != null) {
                supportFragmentManager.beginTransaction().replace(R.id.fl_main_home_container, fragment).commit()
            }
        }
        rbtn_main_bottom_picture.isChecked = true
    }
}