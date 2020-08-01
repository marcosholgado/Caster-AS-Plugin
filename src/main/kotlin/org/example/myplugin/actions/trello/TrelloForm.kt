package org.example.myplugin.actions.trello

import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.ComboBox
import com.intellij.openapi.ui.DialogWrapper
import com.intellij.ui.layout.panel
import java.awt.Dimension
import javax.swing.*

class TrelloForm(
        val project: Project,
        trelloInjector: TrelloInjector
): DialogWrapper(project), TrelloFormView {

    private var nameCombo: ComboBox<Card> = ComboBox<Card>().apply {
        name = "nameCombo"
    }
    private val descriptionPane: JTextPane = JTextPane().apply {
        name = "descriptionPane"
        isEditable = false
    }

    init {
        init()
    }

    override fun createCenterPanel(): JComponent? = panel {
        row("Name: ") {
            nameCombo(grow)
        }
        row("Description:") {
            descriptionPane()
        }
    }.apply {
        minimumSize = Dimension(500, 340)
        preferredSize = Dimension(500, 340)
    }

    override fun showCards(cards: List<Card>) {
        TODO("Not yet implemented")
    }

    override fun success() {
        TODO("Not yet implemented")
    }

    override fun error(error: Throwable) {
        TODO("Not yet implemented")
    }
}