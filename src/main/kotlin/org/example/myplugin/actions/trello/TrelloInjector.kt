package org.example.myplugin.actions.trello

import com.intellij.openapi.project.Project
import org.example.myplugin.services.TrelloService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

interface TrelloInjector {
    val trelloRepository: TrelloRepository
    val trelloServiceApi: TrelloServiceApi

    fun trelloState(project: Project): TrelloState
    fun trelloActionPresenter(view: TrelloFormView, project: Project): TrelloActionPresenter
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

    override fun trelloState(project: Project): TrelloState {
        return TrelloService.getInstance(project).state
    }

    override fun trelloActionPresenter(view: TrelloFormView, project: Project): TrelloActionPresenter {
        return TrelloActionPresenterImp(view, trelloRepository, trelloState(project))
    }
}