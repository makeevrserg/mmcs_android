package com.makeevrserg.todolist.presentation.web_list

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.makeevrserg.todolist.application.App
import com.makeevrserg.todolist.data.network.models.Character
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WebListViewModel : AndroidViewModel(App.instance) {
    private val _characterList = MutableLiveData<List<Character>?>(null)
    val characterList: LiveData<List<Character>?>
        get() = _characterList
    val isLoading = MutableLiveData(true)

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val list = App.repository.fetchCharacters()
            list?.let {
                _characterList.postValue(it)
            }
            isLoading.postValue(false)
        }
    }
}