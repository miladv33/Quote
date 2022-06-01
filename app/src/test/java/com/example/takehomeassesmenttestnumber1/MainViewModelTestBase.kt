package com.example.takehomeassesmenttestnumber1

import com.example.takehomeassesmenttestnumber1.di.AppModule
import com.example.takehomeassesmenttestnumber1.data.model.RandomQuote
import com.example.takehomeassesmenttestnumber1.data.repository.RandomQuoteRepository
import com.example.takehomeassesmenttestnumber1.remote.service.RandomQuoteApi
import com.example.takehomeassesmenttestnumber1.domain.usecase.MainUseCase
import com.example.takehomeassesmenttestnumber1.presentation.viewmodel.MainViewModel
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.robolectric.RobolectricTestRunner
import retrofit2.Retrofit

@HiltAndroidTest
@RunWith(RobolectricTestRunner::class)
open class MainViewModelTestBase : TestBase() {
    var retrofit: Retrofit = Mockito.spy(AppModule.provideQuotableServerRetrofit())
    var randomQuoteApi: RandomQuoteApi = Mockito.spy(retrofit.create(RandomQuoteApi::class.java))
    var randomQuoteRepository: RandomQuoteRepository = Mockito.spy(RandomQuoteRepository(randomQuoteApi))
    var mainShowCase: MainUseCase = Mockito.spy(MainUseCase(randomQuoteRepository))
    var mainViewModel: MainViewModel = Mockito.spy(MainViewModel(mainShowCase))
    var testDataRandomQuote = RandomQuote("", "", "", "", "", "", 10, listOf())

}


