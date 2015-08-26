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

  printJamo("Initial consonants", initalConsonants, initialOriginCodePoint)
  printJamo("Vowels", vowels, medialOriginCodePoint)
  printJamo("Final consonants", finalConsonants, finalOriginCodePoint)

  private def printJamo(heading: String, number: Int, origin: Int) = {
    val jamo = (0 until number)
      .map(_ + origin)
      .map(_.toChar)
      .mkString(" ")

    println(heading)
    println(jamo)
  }
}
