package michaeljuarez.com.metropolitancouturier.callbacks

import michaeljuarez.com.metropolitancouturier.restful_api_structures.RetailItem

interface RetrieveRetailItemCallback {
    fun getRetailItemList(retailItemList: ArrayList<RetailItem>)
}