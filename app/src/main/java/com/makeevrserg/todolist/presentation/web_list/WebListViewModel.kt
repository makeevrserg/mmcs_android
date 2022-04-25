package com.makeevrserg.todolist.presentation.web_list

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.makeevrserg.todolist.application.App
import com.makeevrserg.todolist.data.network.models.Characters
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WebListViewModel : AndroidViewModel(App.instance) {
    private val _characterList = MutableLiveData<Characters?>(null)
    val characterList: LiveData<Characters?>
        get() = _characterList
    val isLoading = MutableLiveData(true)

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _characterList.postValue(App.webRepository.fetchCharacters())
            isLoading.postValue(false)
        }
    }
}