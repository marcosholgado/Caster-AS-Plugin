package org.example.myplugin.actions.trello

data class Card(val id: String, val name: String, val desc: String) {
    override fun toString(): String {
        return name
    }
}

data class TrelloState(
    var apiKey: String = "My api key here",
    var token: String = "My token here",
    var fromListId: String = "My from list ID here",
    var toListId: String = "My to list ID here"
)