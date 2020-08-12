package org.example.myplugin.actions.trello

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class TrelloActionPresenterImpTest {

    private lateinit var testee: TrelloActionPresenterImp
    private val mockView: TrelloFormView = mock()
    private val mockRepository: TrelloRepository = mock()

    @Before
    fun before() {
        val state = TrelloState("apiKey", "token", "fromListId", "toListId")

        testee = TrelloActionPresenterImp(
            view = mockView,
            state = state,
            repository = mockRepository
        )
    }

    @Test
    fun whenLoadCardsExecutedWithErrorThenErrorIsCalled() {
        whenever(mockRepository.getCards(any(), any(), any())).thenReturn(Single.error(Exception()))

        testee.loadCards()

        verify(mockView).error(any())
    }

    @Test
    fun whenLoadCardsExecutedThenShowCardsIsCalled() {
        val cards = listOf(Card("id", "name", "description"))
        whenever(mockRepository.getCards(any(), any(), any())).thenReturn(Single.just(cards))

        testee.loadCards()

        verify(mockView).showCards(cards)
    }
}