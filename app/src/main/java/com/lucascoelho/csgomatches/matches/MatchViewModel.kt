package com.lucascoelho.csgomatches.matches

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.lucascoelho.csgomatches.datasource.matches.entities.Opponent
import com.lucascoelho.csgomatches.datasource.matches.entities.Player
import com.lucascoelho.csgomatches.matches.usecases.IGetTeamDetailsUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MatchViewModel(
    val app: Application,
    private val getTeamUseCase: IGetTeamDetailsUseCase,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : AndroidViewModel(app) {

    private val _teamOne: MutableLiveData<List<Player>> = MutableLiveData()
    val teamOne: LiveData<List<Player>>
        get() = _teamOne

    private val _teamTwo: MutableLiveData<List<Player>> = MutableLiveData()
    val teamTwo: LiveData<List<Player>>
        get() = _teamTwo

    fun fetchTeamDetails(opponents: List<Opponent>) {
        viewModelScope.launch {
            withContext(ioDispatcher) {
                _teamOne.postValue(getTeamUseCase.invoke(opponents[0].opponent.id))
                if (opponents.size == 2) {
                    _teamTwo.postValue(getTeamUseCase.invoke(opponents[1].opponent.id))
                }
            }
        }
    }
}
