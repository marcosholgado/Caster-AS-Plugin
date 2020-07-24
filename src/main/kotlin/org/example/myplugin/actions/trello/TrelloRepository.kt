package org.example.myplugin.actions.trello

interface TrelloRepository {
    fun getCards(): List<Card>
    fun moveCard()
}

class TrelloRepositoryImp(): TrelloRepository {
    override fun getCards(): List<Card> {
        TODO("Not yet implemented")
    }

    override fun moveCard() {
        TODO("Not yet implemented")
    }

}