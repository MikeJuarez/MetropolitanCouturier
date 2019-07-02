package michaeljuarez.com.metropolitancouturier.restful_api_structures

import android.os.Parcel
import android.os.Parcelable

class CategoryItem() : Parcelable{

    var category : String? = ""

    constructor(parcel: Parcel) : this() {
        category = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(category)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CategoryItem> {
        override fun createFromParcel(parcel: Parcel): CategoryItem {
            return CategoryItem(parcel)
        }

        override fun newArray(size: Int): Array<CategoryItem?> {
            return arrayOfNulls(size)
        }
    }

}