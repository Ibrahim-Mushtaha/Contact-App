package com.ix.ibrahim7.contact_app_assignment.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ix.ibrahim7.contact_app_assignment.R
import com.ix.ibrahim7.contact_app_assignment.databinding.FragmentListUserBinding
import com.ix.ibrahim7.contact_app_assignment.ui.fragment.dialog.AddUserDialog


class ListUserFragment : Fragment(), AddUserDialog.onClickListener {


    private lateinit var mBinding: FragmentListUserBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentListUserBinding.inflate(layoutInflater).apply {
            executePendingBindings()
        }
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.e("eee","home")
        mBinding.fabAdd.setOnClickListener {
            AddUserDialog(this).show(childFragmentManager,"")
        }


    }

    override fun onClick(type: Boolean) {

    }

}