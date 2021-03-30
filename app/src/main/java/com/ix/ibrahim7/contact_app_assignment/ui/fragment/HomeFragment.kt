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
import com.ix.ibrahim7.contact_app_assignment.databinding.FragmentHomeBinding
import com.ix.ibrahim7.contact_app_assignment.databinding.FragmentListUserBinding
import com.ix.ibrahim7.contact_app_assignment.model.Category


class HomeFragment : Fragment(),GenericAdapter.OnListItemViewClickListener<Category> {

    private lateinit var mBinding: FragmentHomeBinding

    private val categoryAdapter by lazy {
        GenericAdapter(R.layout.item_category, BR.category,this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentHomeBinding.inflate(layoutInflater).apply {
            executePendingBindings()
        }
        return mBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        mBinding.apply {
            rcCategoryList.adapter = categoryAdapter
        }

        categoryAdapter.data.clear()
        categoryAdapter.data.add(Category(1,"Food",R.drawable.ic_food_category))
        categoryAdapter.data.add(Category(2,"Tool's",R.drawable.ic_tools_category))
        categoryAdapter.data.add(Category(3,"Technology",R.drawable.ic_game_category))
        categoryAdapter.notifyDataSetChanged()

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onClickItem(itemViewModel: Category, type: Int) {
     when(type){
         1->{
             val bundle = Bundle().apply {
                 putInt("id",itemViewModel.id)
             }
             findNavController().navigate(R.id.action_homeFragment_to_listProductFragment,bundle)
         }
     }
    }

}