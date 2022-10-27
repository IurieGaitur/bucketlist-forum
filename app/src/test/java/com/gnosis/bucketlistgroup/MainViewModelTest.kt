package com.gnosis.bucketlistgroup

import androidx.lifecycle.SavedStateHandle
import com.gnosis.bucketlistgroup.data.api.WishesApi
import com.gnosis.bucketlistgroup.data.db.WishesRepository
import com.gnosis.bucketlistgroup.main.MainViewModel
import com.gnosis.bucketlistgroup.util.RxBus
import com.nhaarman.mockito_kotlin.any
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

class MainViewModelTest {

    val rxBus = RxBus()
    val savedState = mockk<SavedStateHandle>()
    val wishesRepository = mockk<WishesRepository>(relaxed = true)
    val wishesApi = mockk<WishesApi>(relaxed = true)

    val mainViewModel = MainViewModel(savedState, wishesRepository, rxBus, wishesApi, Dispatchers.Main )

    @Before
    fun setup() {
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @Test
    fun `test get all wishes return all`() = runTest {


        val expectedSize = 0
        coEvery { mainViewModel.getAvailableWishes() } returns emptyList()

        val wishes = mainViewModel.getAvailableWishes()
        assertEquals(wishes.size, expectedSize)
    }
}