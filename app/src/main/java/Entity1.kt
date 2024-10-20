import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Entity1(
    val property1: String,
    val property2: String,
    val description: String
) : Parcelable
