package com.ix.ibrahim7.contact_app_assignment.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ix.ibrahim7.contact_app_assignment.BR
import com.ix.ibrahim7.contact_app_assignment.R
import com.ix.ibrahim7.contact_app_assignment.adapter.GenericAdapter
import com.ix.ibrahim7.contact_app_assignment.databinding.FragmentListUserBinding
import com.ix.ibrahim7.contact_app_assignment.model.User
import com.ix.ibrahim7.contact_app_assignment.ui.fragment.dialog.AddUserDialog


class ListUserFragment : Fragment(), AddUserDialog.onClickListener,GenericAdapter.OnListItemViewClickListener<User> {


    private lateinit var mBinding: FragmentListUserBinding

    private val userAdapter by lazy {
        GenericAdapter(R.layout.item_user, BR.user,this)
    }

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

        mBinding.rcUserList.adapter = userAdapter

        for (i in 0..6){
            userAdapter.data.add(User("user $i",about = "tewrthu ertuk wergtiolgwerit osdfljghksdfbhgjkbsdfkjggdsfggsfdg fsg dsg fsdgsd g"))
            userAdapter.notifyDataSetChanged()
        }
        mBinding.fabAdd.setOnClickListener {
            AddUserDialog(this).show(childFragmentManager,"")
        }


    }

    // dialog listener
    override fun onClick(type: Boolean) {

    }

    // recycler listener
    override fun onClickItem(itemViewModel: User, type: Int) {

    }

}