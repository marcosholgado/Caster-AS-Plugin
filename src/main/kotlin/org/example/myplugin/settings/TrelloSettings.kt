package org.example.myplugin.settings

import com.intellij.openapi.options.Configurable
import com.intellij.openapi.project.Project
import com.intellij.ui.layout.panel
import org.example.myplugin.actions.trello.TrelloState
import org.example.myplugin.services.TrelloService
import javax.swing.JComponent
import javax.swing.JPanel
import javax.swing.JPasswordField
import javax.swing.JTextField
import javax.swing.event.DocumentEvent
import javax.swing.event.DocumentListener

class TrelloSettings(private val project: Project): Configurable, DocumentListener {

    private val state: TrelloState by lazy { TrelloService.getInstance(project).state }
    private var modified = false

    private val apiKeyField: JPasswordField = JPasswordField()
    private val tokenField: JPasswordField = JPasswordField()
    private val fromListIdField: JTextField = JTextField()
    private val toListIdField: JTextField = JTextField()
    private val panel: JPanel = panel{
        row("API key") { apiKeyField() }
        row("Token") { tokenField() }
        row("From List Id") { fromListIdField() }
        row("To List Id") { toListIdField() }
    }

    override fun isModified(): Boolean = modified

    override fun getDisplayName(): String = "Trello Settings"

    override fun apply() {
        state.apiKey = String(apiKeyField.password)
        state.token = String(tokenField.password)
        state.fromListId = fromListIdField.text
        state.toListId = toListIdField.text

        TrelloService.getInstance(project).loadState(state)
        modified = false
    }

    override fun createComponent(): JComponent? {
        apiKeyField.apply {
            text = state.apiKey
            document.addDocumentListener(this@TrelloSettings)
        }
        tokenField.apply {
            text = state.token
            document.addDocumentListener(this@TrelloSettings)
        }
        fromListIdField.apply {
            text = state.fromListId
            document.addDocumentListener(this@TrelloSettings)
        }
        toListIdField.apply {
            text = state.toListId
            document.addDocumentListener(this@TrelloSettings)
        }
        return panel
    }

    override fun changedUpdate(e: DocumentEvent?) {
        modified = true
    }

    override fun insertUpdate(e: DocumentEvent?) {
        modified = true
    }

    override fun removeUpdate(e: DocumentEvent?) {
        modified = true
    }
}