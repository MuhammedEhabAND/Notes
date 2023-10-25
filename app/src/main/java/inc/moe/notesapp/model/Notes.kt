package inc.moe.notesapp.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Notes")
data class Notes(
    @PrimaryKey(autoGenerate = true)
    var id:Int?= null ,
    @ColumnInfo(name = "title")
    var title: String?= null,
    @ColumnInfo(name = "sub_title")
    var subTitle: String?= null,
    @ColumnInfo(name = "date_time")
    var dateTime: String?= null,
    @ColumnInfo(name = "note_text")
    var noteText: String?= null,
    @ColumnInfo(name = "img_path")
    var imagePath: String?= null,
    @ColumnInfo(name = "web_link")
    var webLink: String?= null,
    @ColumnInfo(name = "color")
    var color: String?= null,
        ): Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        id?.let { parcel.writeInt(it) }
        parcel.writeString(title)
        parcel.writeString(subTitle)
        parcel.writeString(dateTime)
        parcel.writeString(noteText)
        parcel.writeString(imagePath)
        parcel.writeString(webLink)
        parcel.writeString(color)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Notes> {
        override fun createFromParcel(parcel: Parcel): Notes {
            return Notes(parcel)
        }

        override fun newArray(size: Int): Array<Notes?> {
            return arrayOfNulls(size)
        }
    }

}