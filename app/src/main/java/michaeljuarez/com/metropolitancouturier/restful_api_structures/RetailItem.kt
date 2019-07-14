package michaeljuarez.com.metropolitancouturier.restful_api_structures

import android.os.Parcel
import android.os.Parcelable

class RetailItem() : Parcelable {

    var id : String? = ""
    var price : Float = 0f
    var item_brand : String? = ""
    var item_name : String? = ""
    var image_url : List<String> = ArrayList<String>()
    var colors : List<String> = ArrayList<String>()
    var size_xsmall : Int = 0
    var size_small : Int = 0
    var size_medium : Int = 0
    var size_large : Int = 0
    var size_xlarge : Int = 0

    constructor(parcel: Parcel) : this() {
        id = parcel.readString()
        price = parcel.readFloat()
        item_brand = parcel.readString()
        item_name = parcel.readString()
        parcel.readStringList(image_url)
        parcel.readStringList(colors)
        size_xsmall = parcel.readInt()
        size_small = parcel.readInt()
        size_medium = parcel.readInt()
        size_large = parcel.readInt()
        size_xlarge = parcel.readInt()
    }

    companion object CREATOR : Parcelable.Creator<RetailItem> {
        override fun createFromParcel(parcel: Parcel): RetailItem {
            return RetailItem(parcel)
        }

        override fun newArray(size: Int): Array<RetailItem?> {
            return arrayOfNulls(size)
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeFloat(price)
        parcel.writeString(item_brand)
        parcel.writeString(item_name)
        parcel.writeStringList(image_url)
        parcel.writeStringList(colors)
        parcel.writeInt(size_xsmall)
        parcel.writeInt(size_small)
        parcel.writeInt(size_medium)
        parcel.writeInt(size_large)
        parcel.writeInt(size_xlarge)
    }

    override fun describeContents(): Int {
        return 0
    }

}