package org.example.myplugin.actions.trello

interface TrelloFormView {
    fun showCards(cards: List<Card>)
    fun success()
    fun error(error: Throwable)
}