package com.ix.ibrahim7.contact_app_assignment.ui.fragment.dialog


import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.*
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.ix.ibrahim7.contact_app_assignment.databinding.AddUserDialogBinding

class AddUserDialog(val onGo: onClickListener) : BottomSheetDialogFragment(){

    private lateinit var mBinding: AddUserDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = AddUserDialogBinding.inflate(inflater, container, false).apply {
            executePendingBindings()
        }
        dialog!!.requestWindowFeature(STYLE_NO_TITLE)
        isCancelable = true
        return mBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding.apply {

            btnCreate.setOnClickListener {
                onGo.onClick(true)
            }

        }


    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }

    interface onClickListener {
        fun onClick(type:Boolean)
    }


}