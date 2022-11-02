package hasan.gurgur.enerjisatask.data


import hasan.gurgur.enerjisatask.model.ItemModel
import io.reactivex.Single
import javax.inject.Inject

class ApiRepository @Inject constructor(val apiService: ApiService) {

    fun getItems(): Single<ItemModel> {
        return apiService.getItems()
    }
}