package com.ms.wc

import scala.collection.mutable

class WordCounter {
  private val wordMap: collection.mutable.Map[String, Int] = collection.mutable.Map.empty

  def addWords(words: String*): Unit = {
    words.foreach(addWord)
  }

  def addWord(word: String): Unit = {
    val count = wordMap.getOrElse(word, 0)
    wordMap.put(word, count + 1)
  }

  def getCount(word: String): Int = {
    wordMap.getOrElse(word, 0)
  }
}

