package jolchu.tolik.me

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import jolchu.tolik.me.remote.model.InfoModel
import jolchu.tolik.me.repository.Repository

class MainViewModel : ViewModel() {

    private val repository = Repository()
    fun getInfo(name: String): LiveData<InfoModel> {
        return repository.getInfo(name)
    }

}