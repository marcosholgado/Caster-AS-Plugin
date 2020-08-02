package org.example.myplugin.actions.trello

import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface TrelloServiceApi {

    @GET("1/lists/{listId}/cards")
    fun getCards(
        @Path("listId") listId: String,
        @Query("key") key: String,
        @Query("token") token: String
    ): Single<List<Card>>

    @PUT("1/cards/{cardId}")
    fun moveCardToList(
        @Path("cardId") cardId: String,
        @Query("idList") idList: String,
        @Query("key") key: String,
        @Query("token") token: String
    ): Completable
}