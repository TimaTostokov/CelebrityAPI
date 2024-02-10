package jolchu.tolik.me.remote.model

import com.google.gson.annotations.SerializedName

data class InfoModelItem(
    val name: String?,
    val gender: String?,
    val nationality: String?,
    val occupation: List<String?>?,
    val height: Double?,
    val birthday: String?,
    val age: Int?,
    @SerializedName("is_alive")
    val isAlive: Boolean?
)