package com.htmlism.hangul

object Hangul {
  val initialOriginCodePoint = 0x1100
  val medialOriginCodePoint  = 0x1161
  val finalOriginCodePoint   = 0x11A8

  val initialConsonants = 19
  val vowels = 21
  val finalConsonants = 27
}

object Main extends App {
  import com.htmlism.hangul.Hangul._

  // optional final constant makes 28
  // 19 * 21 * 28 = 11,172

  printJamo("Initial consonants", initialConsonants, initialOriginCodePoint)
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
