package com.ix.ibrahim7.contact_app_assignment.ui.dialog


import android.os.Bundle
import android.text.TextUtils
import android.view.*
import android.widget.EditText
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.ix.ibrahim7.contact_app_assignment.databinding.AddUserDialogBinding
import com.ix.ibrahim7.contact_app_assignment.model.User

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
                when{
                    TextUtils.isEmpty(mBinding.etxtUsername.text) -> {
                        validationData(mBinding.etxtUsername)
                    }
                    TextUtils.isEmpty(mBinding.etxtPhone.text) -> {
                        validationData(mBinding.etxtPhone)
                    }
                    TextUtils.isEmpty(mBinding.etxtAbout.text) -> {
                        validationData(mBinding.etxtAbout)
                    }
                    else->{
                        onGo.onClick(true,User(mBinding.etxtUsername.text.toString(),mBinding.etxtPhone.text.toString()
                        ,mBinding.etxtAbout.text.toString()))
                        dismiss()
                    }
                }
            }

        }


    }

    private fun validationData(view: EditText) {
        view.error =
            "Required field"
        view.requestFocus()
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }

    interface onClickListener {
        fun onClick(type:Boolean,user:User)
    }


}