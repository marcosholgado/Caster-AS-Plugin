package org.example.myplugin.actions.trello

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent

class TrelloAction: AnAction() {
    override fun actionPerformed(p0: AnActionEvent) {
        val dialog = TrelloForm(p0.project!!, TrelloInjectorImp())
        dialog.show()
    }
}