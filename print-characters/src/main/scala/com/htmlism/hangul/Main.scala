package com.htmlism.hangul

object Main extends App {
  val initialOriginCodePoint = 0x1100
  val medialOriginCodePoint  = 0x1161
  val finalOriginCodePoint   = 0x11A8

  val initalConsonants = 19
  val vowels = 21
  val finalConsonants = 27

  // optional final constant makes 28
  // 19 * 21 * 28 = 11,172

  println("Initial consonants")

  for (i <- 0 until initalConsonants) {
    val codePoint = initialOriginCodePoint + i

    println(codePoint + ": " + codePoint.toChar)
  }

  println("Vowels")

  for (i <- 0 until vowels) {
    val codePoint = medialOriginCodePoint + i

    println(codePoint + ": " + codePoint.toChar)
  }

  println("Final consonants")

  for (i <- 0 until finalConsonants) {
    val codePoint = finalOriginCodePoint + i

    println(codePoint + ": " + codePoint.toChar)
  }
}
