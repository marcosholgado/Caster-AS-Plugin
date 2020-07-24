package org.example.myplugin.actions.trello

interface TrelloInjector {
    val trelloRepository: TrelloRepository

    fun trelloActionPresenter(view: TrelloFormView): TrelloActionPresenter
}

class TrelloInjectorImp: TrelloInjector {
    override val trelloRepository: TrelloRepository by lazy {
        TrelloRepositoryImp()
    }

    override fun trelloActionPresenter(view: TrelloFormView): TrelloActionPresenter {
        return TrelloActionPresenterImp(view, trelloRepository)
    }
}