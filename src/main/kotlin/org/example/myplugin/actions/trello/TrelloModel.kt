package org.example.myplugin.actions.trello

data class Card(val id: String, val name: String, val desc: String) {
    override fun toString(): String {
        return name
    }
}

data class TrelloState(
    var apiKey: String = "",
    var token: String = "",
    var fromListId: String = "",
    var toListId: String = ""
)