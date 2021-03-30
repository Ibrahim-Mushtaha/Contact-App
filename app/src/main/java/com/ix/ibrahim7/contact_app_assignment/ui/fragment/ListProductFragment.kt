package com.ix.ibrahim7.contact_app_assignment.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ix.ibrahim7.contact_app_assignment.BR
import com.ix.ibrahim7.contact_app_assignment.R
import com.ix.ibrahim7.contact_app_assignment.adapter.GenericAdapter
import com.ix.ibrahim7.contact_app_assignment.databinding.FragmentListProductBinding
import com.ix.ibrahim7.contact_app_assignment.model.Product


class ListProductFragment : Fragment(),GenericAdapter.OnListItemViewClickListener<Product> {


    private lateinit var mBinding: FragmentListProductBinding

    private val productAdapter by lazy {
        GenericAdapter(
            R.layout.item_category,
            BR.category,this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentListProductBinding.inflate(layoutInflater).apply {
            executePendingBindings()
        }
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        super.onViewCreated(view, savedInstanceState)
    }

    override fun onClickItem(itemViewModel: Product, type: Int) {

    }

}