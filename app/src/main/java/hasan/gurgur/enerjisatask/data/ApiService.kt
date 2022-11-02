package hasan.gurgur.enerjisatask.data

import hasan.gurgur.enerjisatask.model.ItemModel
import io.reactivex.Single
import retrofit2.http.GET


interface ApiService {
    @GET("main/menu.json")
    fun getItems(): Single<ItemModel>
}