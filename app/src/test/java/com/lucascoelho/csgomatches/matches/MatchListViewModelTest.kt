package com.lucascoelho.csgomatches.matches

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import com.lucascoelho.csgomatches.datasource.matches.entities.model.MatchModel
import com.lucascoelho.csgomatches.matches.usecases.IGetMatchesUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
@ExperimentalCoroutinesApi
class MatchListViewModelTest {

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()

    private lateinit var matchListViewModel: MatchListViewModel
    private lateinit var application: Application
    private val testCoroutineDispatcher = UnconfinedTestDispatcher()

    @MockK
    private lateinit var getMatchesUseCase: IGetMatchesUseCase

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(testCoroutineDispatcher)
        application = ApplicationProvider.getApplicationContext()
        matchListViewModel = MatchListViewModel(application, getMatchesUseCase)
    }

    @Test
    fun `fetchMatches should update matches livedata`() {
        val expectedList = listOf(mockk<MatchModel>())
        coEvery { getMatchesUseCase.invoke() } returns expectedList

        matchListViewModel.fetchMatches()

        assertEquals(expectedList, matchListViewModel.matches.value)
    }
}
