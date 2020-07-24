package org.example.myplugin.actions.trello

interface TrelloActionPresenter {
    fun loadCards()
    fun moveCard(card: Card)
}

class TrelloActionPresenterImp(
    private val view: TrelloFormView,
    private val repository: TrelloRepository
): TrelloActionPresenter {
    override fun loadCards() {
        TODO("Not yet implemented")
    }

    override fun moveCard(card: Card) {
        TODO("Not yet implemented")
    }

}