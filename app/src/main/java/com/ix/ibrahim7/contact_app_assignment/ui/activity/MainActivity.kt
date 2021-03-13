package com.ix.ibrahim7.contact_app_assignment.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ix.ibrahim7.contact_app_assignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        setSupportActionBar(mBinding.toolbar)



    }
}