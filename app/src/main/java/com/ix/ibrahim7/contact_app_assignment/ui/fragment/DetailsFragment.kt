package com.ix.ibrahim7.contact_app_assignment.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ix.ibrahim7.contact_app_assignment.databinding.FragmentDetailsBinding
import com.ix.ibrahim7.contact_app_assignment.model.Product
import com.ix.ibrahim7.contact_app_assignment.other.PRODUCT
import com.ix.ibrahim7.contact_app_assignment.util.Constant.trackScreen


class DetailsFragment : Fragment() {

    private lateinit var mBinding: FragmentDetailsBinding

    private val productDetails by lazy {
        requireArguments().getParcelable<Product>(PRODUCT)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentDetailsBinding.inflate(layoutInflater).apply {
            executePendingBindings()
        }
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mBinding.product = productDetails
        requireActivity().trackScreen("DetailsFragment","Details",productDetails!!.name)


        super.onViewCreated(view, savedInstanceState)
    }



}