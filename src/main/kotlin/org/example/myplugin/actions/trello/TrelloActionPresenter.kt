package org.example.myplugin.actions.trello

interface TrelloActionPresenter {
    fun loadCards()
    fun moveCard(card: Card)
}

class TrelloActionPresenterImp(
    private val view: TrelloFormView,
    private val repository: TrelloRepository,
    private val state: TrelloState
): TrelloActionPresenter {

    override fun loadCards() {
        repository.getCards(state.fromListId, state.apiKey, state.token)
            .subscribe(
                { cards -> view.showCards(cards) },
                { error -> view.error(error) }
            )
    }

    override fun moveCard(card: Card) {
        repository.moveCard(card.id, state.toListId, state.apiKey, state.token)
            .subscribe(
                { view.success() },
                { error -> view.error(error) }
            )
    }

}