package org.example.myplugin.actions.trello

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

interface TrelloInjector {
    val trelloRepository: TrelloRepository
    val trelloServiceApi: TrelloServiceApi

    fun trelloActionPresenter(view: TrelloFormView): TrelloActionPresenter
}

class TrelloInjectorImp: TrelloInjector {

    override val trelloServiceApi: TrelloServiceApi by lazy {
        Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl("https://api.trello.com/")
            .build()
            .create(TrelloServiceApi::class.java)
    }

    override val trelloRepository: TrelloRepository by lazy {
        TrelloRepositoryImp(trelloServiceApi)
    }

    override fun trelloActionPresenter(view: TrelloFormView): TrelloActionPresenter {
        return TrelloActionPresenterImp(view, trelloRepository)
    }
}