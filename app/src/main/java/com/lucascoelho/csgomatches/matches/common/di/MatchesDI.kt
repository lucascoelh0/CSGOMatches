package com.lucascoelho.csgomatches.matches.common.di

import com.lucascoelho.csgomatches.datasource.matches.repository.IMatchesRepository
import com.lucascoelho.csgomatches.matches.MatchListViewModel
import com.lucascoelho.csgomatches.matches.usecases.GetMatchesUseCaseImpl
import com.lucascoelho.csgomatches.matches.usecases.IGetMatchesUseCase
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object MatchesDI {
    val module = module {
        single<IGetMatchesUseCase> {
            GetMatchesUseCaseImpl(get() as IMatchesRepository)
        }

        viewModel {
            MatchListViewModel(
                app = androidApplication(),
                getMatchesUseCase = get()
            )
        }
    }
}
