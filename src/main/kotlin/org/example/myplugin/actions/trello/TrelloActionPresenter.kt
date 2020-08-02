package org.example.myplugin.actions.trello

interface TrelloActionPresenter {
    fun loadCards()
    fun moveCard(card: Card)
}

class TrelloActionPresenterImp(
    private val view: TrelloFormView,
    private val repository: TrelloRepository
): TrelloActionPresenter {

    val fromListId = "Add your todo list ID"
    val toListId = "Add the list you want to move your card to"
    val apiKey = "Your api key here"
    val token = "Your token here"

    override fun loadCards() {
        repository.getCards(fromListId, apiKey, token)
            .subscribe(
                { cards -> view.showCards(cards) },
                { error -> view.error(error) }
            )
    }

    override fun moveCard(card: Card) {
        repository.moveCard(card.id, toListId, apiKey, token)
            .subscribe(
                { view.success() },
                { error -> view.error(error) }
            )
    }

}