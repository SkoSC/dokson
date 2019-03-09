package com.skosc.dokson

import org.bson.Document

class DocumentListBuilder internal constructor() {
    private val documents: MutableList<Document> = mutableListOf()

    /**
     * Adds Document with passed [key]/[value] pair to builder
     */
    fun <T> doc(key: String, value: T) {
        documents.add(Document(key, value))
    }

    /**
     * AddsDocument with passed [key]/[value] pair to builder if [condition] is true
     */
    fun <T> ifDoc(condition: Boolean, key: String, value: T) {
        if (condition) {
            doc(key, value)
        }
    }

    internal fun build(): List<Document> = documents
}

/**
 * Creates list of documents using passed builder
 */
fun docs(builder: DocumentListBuilder.() -> Unit): List<Document> {
    val list = DocumentListBuilder()
    builder(list)
    return list.build()
}