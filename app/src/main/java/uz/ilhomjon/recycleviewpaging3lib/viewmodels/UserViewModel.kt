package uz.ilhomjon.recycleviewpaging3lib.viewmodels

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import uz.ilhomjon.recycleviewpaging3lib.retrofit.ApiClient

class UserViewModel : ViewModel() {

    val liveData = Pager(PagingConfig(pageSize = 2)) {
        UserDataSource(ApiClient.apiService)
    }.liveData
}