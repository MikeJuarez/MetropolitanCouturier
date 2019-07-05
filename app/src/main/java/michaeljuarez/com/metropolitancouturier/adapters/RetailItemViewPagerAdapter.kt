package michaeljuarez.com.metropolitancouturier.adapters

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import michaeljuarez.com.metropolitancouturier.restful_api_structures.RetailItem
import michaeljuarez.com.metropolitancouturier.utility.Constants
import michaeljuarez.com.metropolitancouturier.views.RetailItemFragment

class RetailItemViewPagerAdapter(fragmentManager: FragmentManager, private val mRetailItemList : ArrayList<RetailItem>) : FragmentStatePagerAdapter(fragmentManager){

    override fun getCount(): Int {
        return 1
    }

    override fun getItem(position: Int): Fragment? {

        var fragment : Fragment? = null

        when (position) {
            0 -> {
                fragment = RetailItemFragment()

                var args = Bundle()
                args.putParcelableArrayList(Constants.RETAIL_ITEM_LIST_KEY, mRetailItemList)
                fragment.arguments = args
            }
        }

        return fragment
    }


}