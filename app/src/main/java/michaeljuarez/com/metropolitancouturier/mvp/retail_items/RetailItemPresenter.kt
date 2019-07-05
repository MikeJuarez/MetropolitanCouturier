package michaeljuarez.com.metropolitancouturier.mvp.retail_items

import michaeljuarez.com.metropolitancouturier.callbacks.RetrieveRetailItemCallback
import michaeljuarez.com.metropolitancouturier.restful_api_structures.RetailItem
import michaeljuarez.com.metropolitancouturier.views.RetailItemsActivity
import michaeljuarez.com.mvpmodulekotlin.MvpPresenter

class RetailItemPresenter(view : RetailItemsActivity) : MvpPresenter<RetailItemsActivity, RetailItemModel>(){

    init {
        attachView(view)
        attachModel(RetailItemModel(this))
    }

    fun retrieveRetailItemList() {
        var retrieveRetailItemCallback = object : RetrieveRetailItemCallback {
            override fun getRetailItemList(retailItemList: ArrayList<RetailItem>) {
                mvpView.itemListRetrieved(retailItemList)
            }
        }

        mvpModel.retrieveRetailItemList(retrieveRetailItemCallback)
    }





}