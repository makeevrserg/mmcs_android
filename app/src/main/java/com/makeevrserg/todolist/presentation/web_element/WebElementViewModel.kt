package com.makeevrserg.todolist.presentation.web_element

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.makeevrserg.todolist.application.App
import com.makeevrserg.todolist.data.network.models.Character
import kotlinx.coroutines.launch

class WebElementViewModel(id: Long) : AndroidViewModel(App.instance) {
    private val _character = MutableLiveData<Character?>(null)
    val character: LiveData<Character?>
        get() = _character
    val isLoading = MutableLiveData(true)

    init {
        viewModelScope.launch {
            _character.postValue(App.webRepository.fetchCharacter(id))
            isLoading.postValue(false)
        }
    }

}