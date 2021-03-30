package com.ix.ibrahim7.contact_app_assignment.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ix.ibrahim7.contact_app_assignment.BR
import com.ix.ibrahim7.contact_app_assignment.R
import com.ix.ibrahim7.contact_app_assignment.adapter.GenericAdapter
import com.ix.ibrahim7.contact_app_assignment.databinding.FragmentListUserBinding
import com.ix.ibrahim7.contact_app_assignment.model.User
import com.ix.ibrahim7.contact_app_assignment.ui.dialog.AddUserDialog
import com.ix.ibrahim7.contact_app_assignment.ui.dialog.LoadingDialog
import com.ix.ibrahim7.contact_app_assignment.ui.viewmodel.ListUserViewModel
import com.ix.ibrahim7.contact_app_assignment.util.Resource


class ListUserFragment : Fragment(), AddUserDialog.onClickListener,GenericAdapter.OnListItemViewClickListener<User> {


    private lateinit var mBinding: FragmentListUserBinding
    private lateinit var dialog: LoadingDialog

    private val userAdapter by lazy {
        GenericAdapter(R.layout.item_user, BR.user,this)
    }

    private val viewModel by lazy {
        ViewModelProvider(this)[ListUserViewModel::class.java]
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
        dialog = LoadingDialog()

        mBinding.rcUserList.adapter = userAdapter


        viewModel.getUserLiveData().observe(viewLifecycleOwner, Observer {response ->
            when (response) {
                is Resource.Success -> {
                    if (dialog.isAdded)
                        dialog.dismiss()
                    when {
                        response.data!!.isNotEmpty() -> {
                            userAdapter.addItems(response.data)
                            userAdapter.notifyDataSetChanged()
                        }
                    }
                }
                is Resource.Error -> {
                    if (dialog.isAdded)
                        dialog.dismiss()
                }
                is Resource.Loading -> {
                    dialog.show(childFragmentManager, "")
                }
            }
        })

        viewModel.AddUserLiveData().observe(viewLifecycleOwner, Observer {response ->
            when (response) {
                is Resource.Success -> {
                    if (dialog.isAdded)
                        dialog.dismiss()
                    toastMessage("User added successfully")
                }
                is Resource.Error -> {
                    if (dialog.isAdded)
                        dialog.dismiss()
                    toastMessage(response.message.toString())
                }
                is Resource.Loading -> {
                    dialog.show(childFragmentManager, "")
                }
            }
        })


        mBinding.fabAdd.setOnClickListener {
            AddUserDialog(this)
                .show(childFragmentManager,"")
        }


    }

    private fun toastMessage(message:String){
        Toast.makeText(requireContext(),message,Toast.LENGTH_SHORT).show()
    }

    // dialog listener
    override fun onClick(type: Boolean,user: User) {
        if (type)  dialog.show(childFragmentManager, ""); viewModel.addUser(user)
    }

    // recycler listener
    override fun onClickItem(itemViewModel: User, type: Int) {

    }

}