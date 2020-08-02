package org.example.myplugin.actions.trello

import hu.akarnokd.rxjava2.swing.SwingSchedulers
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

interface TrelloRepository {
    fun getCards(fromListId: String, key: String, token: String): Single<List<Card>>
    fun moveCard(cardId: String, toListId: String, key: String, token: String): Completable
}

class TrelloRepositoryImp(
    private val trelloServiceApi: TrelloServiceApi
): TrelloRepository {

    override fun getCards(fromListId: String, key: String, token: String): Single<List<Card>> {
        return trelloServiceApi.getCards(fromListId, key, token)
            .subscribeOn(Schedulers.io())
            .observeOn(SwingSchedulers.edt())
    }

    override fun moveCard(cardId: String, toListId: String, key: String, token: String): Completable {
        return trelloServiceApi.moveCardToList(cardId, toListId, key, token)
            .subscribeOn(Schedulers.io())
            .observeOn(SwingSchedulers.edt())
    }

}