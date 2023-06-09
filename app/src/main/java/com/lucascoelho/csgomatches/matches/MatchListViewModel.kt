package com.lucascoelho.csgomatches.matches

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.lucascoelho.csgomatches.datasource.matches.entities.model.MatchModel
import com.lucascoelho.csgomatches.matches.usecases.IGetMatchesUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MatchListViewModel(
    val app: Application,
    private val getMatchesUseCase: IGetMatchesUseCase,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : AndroidViewModel(app) {

    private val _matches: MutableLiveData<List<MatchModel>> = MutableLiveData()
    val matches: LiveData<List<MatchModel>>
        get() = _matches

    fun fetchMatches() {
        viewModelScope.launch {
            withContext(ioDispatcher) {
                _matches.postValue(getMatchesUseCase.invoke())
            }
        }
    }
}
