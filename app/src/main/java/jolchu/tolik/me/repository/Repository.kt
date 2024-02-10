package jolchu.tolik.me.repository

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import jolchu.tolik.me.remote.RetrofitClient
import jolchu.tolik.me.remote.model.InfoModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    private lateinit var context: Context

    fun getInfo(name: String): MutableLiveData<InfoModel> {
        val liveData = MutableLiveData<InfoModel>()
        RetrofitClient().create().getInfo(name).enqueue(object : Callback<InfoModel> {
            override fun onResponse(call: Call<InfoModel>, response: Response<InfoModel>) {
                if (response.isSuccessful) {
                    liveData.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<InfoModel>, t: Throwable) {
                Toast.makeText(context, "Error getting info", Toast.LENGTH_SHORT).show()
            }
        })
        return liveData
    }

}