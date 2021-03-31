package com.ix.ibrahim7.contact_app_assignment.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ix.ibrahim7.contact_app_assignment.BR
import com.ix.ibrahim7.contact_app_assignment.R
import com.ix.ibrahim7.contact_app_assignment.adapter.GenericAdapter
import com.ix.ibrahim7.contact_app_assignment.databinding.FragmentListProductBinding
import com.ix.ibrahim7.contact_app_assignment.model.Product
import com.ix.ibrahim7.contact_app_assignment.other.ID
import com.ix.ibrahim7.contact_app_assignment.other.PRODUCT
import com.ix.ibrahim7.contact_app_assignment.util.Constant.trackScreen


class ListProductFragment : Fragment(),GenericAdapter.OnListItemViewClickListener<Product> {


    private lateinit var mBinding: FragmentListProductBinding

    private val argID by lazy {
        requireArguments().getInt(ID)
    }

    private val productAdapter by lazy {
        GenericAdapter(R.layout.item_product, BR.product,this)
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

        productAdapter.data.clear()
        when(argID){
            1->{
                productAdapter.data.add(Product(1,1,"Food 1",getString(R.string.long_text),4F,R.drawable.ic_test_img1))
                productAdapter.data.add(Product(1,1,"Food 2",getString(R.string.long_text),5F,R.drawable.ic_test_img2))
            }
            2->{
                productAdapter.data.add(Product(2,2,"Tool 1",getString(R.string.long_text),3F,R.drawable.ic_test_img1))
                productAdapter.data.add(Product(2,2,"Tool 2",getString(R.string.long_text),5F,R.drawable.ic_test_img2))
            }
            3->{
                productAdapter.data.add(Product(2,2,"Game 1",getString(R.string.long_text),4F,R.drawable.ic_test_img1))
                productAdapter.data.add(Product(2,2,"Game 2",getString(R.string.long_text),2F,R.drawable.ic_test_img2))
            }
        }

        productAdapter.notifyDataSetChanged()


        mBinding.apply {
            rcProductList.adapter = productAdapter
        }

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onClickItem(itemViewModel: Product, type: Int) {
        when(type){
            1->{
                requireActivity().trackScreen("ListProductFragment","Product",itemViewModel.name)
                val bundle = Bundle().apply {
                    putParcelable(PRODUCT,itemViewModel)
                }
                findNavController().navigate(R.id.action_listProductFragment_to_detailsFragment,bundle)
            }
        }
    }

}