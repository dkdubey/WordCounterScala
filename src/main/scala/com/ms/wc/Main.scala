package com.ms.wc

object Main {

  def main(args: Array[String]): Unit = {
    val counter = new WordCounter()
    counter.addWords("apple", "banana", "apple", "orange")
    println(counter.getCount("apple"))   // Output: 2
    println(counter.getCount("banana"))  // Output: 1
    println(counter.getCount("orange"))  // Output: 1
    println(counter.getCount("grape"))   // Output: 0

  }

}
