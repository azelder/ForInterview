package com.azelder.model.data

/**
 * Model data class for our json response data. It's a bit overkill having a separate module here
 * just for the data but it does enforce best practices with the dependency hierarchy and is good to
 * have for extensibility
 */
data class ItemModel(
    val id: Int,
    val listId: String,
    val name: String?
)
