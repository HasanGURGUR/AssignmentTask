package hasan.gurgur.enerjisatask.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import hasan.gurgur.enerjisatask.data.ApiRepository
import hasan.gurgur.enerjisatask.model.ItemModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(private val repository: ApiRepository) : ViewModel() {

    val upcomingItemModel = MutableLiveData<ItemModel>()
    private val disposable: CompositeDisposable = CompositeDisposable()

    fun fetchDataFromRemoteApi() {
        disposable.add(
            repository.getItems()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object :
                    DisposableSingleObserver<ItemModel>() {
                    override fun onSuccess(response: ItemModel) {
                        upcomingItemModel.value = response
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }
                })
        )
    }

}