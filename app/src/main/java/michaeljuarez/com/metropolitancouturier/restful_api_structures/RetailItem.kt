package michaeljuarez.com.metropolitancouturier.restful_api_structures

import android.os.Parcel
import android.os.Parcelable

class RetailItem() : Parcelable {

    var id : String? = ""
    var price : Float? = 0f
    var item_brand : String? = ""
    var item_name : String? = ""
    var image_url : String? = ""
    var size_xsmall : Int? = 0
    var size_small : Int? = 0
    var size_medium : Int? = 0
    var size_large : Int? = 0
    var size_xlarge : Int? = 0

    constructor(parcel: Parcel) : this() {
        id = parcel.readString()
        price = parcel.readValue(Int::class.java.classLoader) as? Float
        item_brand = parcel.readString()
        item_name = parcel.readString()
        image_url = parcel.readString()
        size_xsmall = parcel.readValue(Int::class.java.classLoader) as? Int
        size_small = parcel.readValue(Int::class.java.classLoader) as? Int
        size_medium = parcel.readValue(Int::class.java.classLoader) as? Int
        size_large = parcel.readValue(Int::class.java.classLoader) as? Int
        size_xlarge = parcel.readValue(Int::class.java.classLoader) as? Int
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
        price?.let { parcel.writeFloat(it) }
        parcel.writeString(item_brand)
        parcel.writeString(item_name)
        parcel.writeString(image_url)
        size_xsmall?.let { parcel.writeInt(it)}
        size_small?.let { parcel.writeInt(it)}
        size_medium?.let { parcel.writeInt(it)}
        size_large?.let { parcel.writeInt(it)}
        size_xlarge?.let { parcel.writeInt(it)}
    }

    override fun describeContents(): Int {
        return 0
    }

}