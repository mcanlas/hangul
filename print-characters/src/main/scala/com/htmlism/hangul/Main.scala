package com.htmlism.hangul

import com.htmlism.hangul.Hangul.*

object Main extends App {
  // optional final constant makes 28
  // 19 * 21 * 28 = 11,172

  printJamo("Initial consonants", initialConsonantsTotal, initialOriginCodePoint)
  printJamo("Vowels", vowelsTotal, medialOriginCodePoint)
  printJamo("Final consonants", finalConsonantsTotal, finalOriginCodePoint)

  private[this] def printJamo(heading: String, total: Int, origin: Int) = {
    val jamo = (0 until total)
      .map(_ + origin)
      .map(_.toChar)
      .mkString("  ")

    println(heading)
    println(jamo)
  }
}

object TwoCharacterSyllables extends App {
  for (c <- 0 until initialConsonantsTotal) {
    val syllables = (0 until vowelsTotal)
      .map { v =>
        syllableOrigin +
          (c * vowelsTotal * finalConsonantsWithOptionTotal) +
          (v * finalConsonantsWithOptionTotal)
      }
      .map(_.toChar)
      .mkString(" ")

    println(syllables)
  }
}

object ThreeCharacterSyllables extends App {
  for (c <- 0 until initialConsonantsTotal) {
    for (v <- 0 until vowelsTotal) {
      val syllables = (0 until finalConsonantsWithOptionTotal)
        .map { cf =>
          syllableOrigin +
            (c * vowelsTotal * finalConsonantsWithOptionTotal) +
            (v * finalConsonantsWithOptionTotal) +
            cf
        }
        .map(_.toChar)
        .mkString(" ")

      println(syllables)
    }
  }
}
