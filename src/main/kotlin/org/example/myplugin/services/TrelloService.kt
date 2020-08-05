package org.example.myplugin.services

import com.intellij.openapi.components.*
import com.intellij.openapi.project.Project
import org.example.myplugin.actions.trello.TrelloState

@Service
@State(name = "TrelloConfiguration", storages = [
    Storage(value = "trelloConfiguration.xml")
])
class TrelloService: PersistentStateComponent<TrelloState> {

    private var trelloState: TrelloState = TrelloState()

    override fun getState(): TrelloState = trelloState

    override fun loadState(state: TrelloState) {
        trelloState = state
    }

    companion object {
        fun getInstance(project: Project): TrelloService = project.service()
    }
}