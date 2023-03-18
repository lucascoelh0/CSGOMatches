package com.lucascoelho.csgomatches.matches

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.lucascoelho.csgomatches.datasource.matches.entities.Match
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

    private val _matches: MutableLiveData<List<Match>> = MutableLiveData()
    val matches: LiveData<List<Match>>
        get() = _matches

    fun updateMatches() {
        viewModelScope.launch {
            withContext(ioDispatcher) {
                val matchesList = getMatchesUseCase.invoke()
                _matches.postValue(matchesList)
            }
        }
    }
}
