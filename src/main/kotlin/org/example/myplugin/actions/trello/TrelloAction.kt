package org.example.myplugin.actions.trello

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import org.example.myplugin.services.TrelloService

class TrelloAction: AnAction() {
    override fun actionPerformed(p0: AnActionEvent) {
        val dialog = TrelloForm(p0.project!!, TrelloInjectorImp())
        dialog.show()
    }

    override fun update(e: AnActionEvent) {
        val state = TrelloService.getInstance(e.project!!).state
        e.presentation.isEnabled = state.apiKey.isNotBlank() && state.token.isNotBlank() && state.fromListId.isNotBlank() && state.toListId.isNotBlank()
    }
}