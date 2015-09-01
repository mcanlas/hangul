package com.htmlism.hangul

object Hangul {
  val initialOriginCodePoint = 0x1100
  val medialOriginCodePoint  = 0x1161
  val finalOriginCodePoint   = 0x11A8

  val initialConsonants = 19
  val vowels = 21
  val finalConsonants = 27
  val finalConsonantsWithOption = 28

  val syllableOrigin = 0xAC00
}

sealed trait UnicodeCharacter

trait Jamo extends UnicodeCharacter {
  def name: String
}

sealed trait Syllable extends UnicodeCharacter {
  def pronunciation: String
}

trait TwoCharacterSyllable extends Syllable

trait ThreeCharacterSyllable extends Syllable

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

object TwoCharacterSyllables extends App {
  import com.htmlism.hangul.Hangul._

  for (c <- 0 until initialConsonants) {
    val syllables = (0 until vowels)
      .map { v => syllableOrigin +
        (c * vowels * finalConsonantsWithOption) +
        (v * finalConsonantsWithOption)
      }
      .map(_.toChar)
      .mkString(" ")

    println(syllables)
  }
}

object ThreeCharacterSyllables extends App {
  import com.htmlism.hangul.Hangul._

  for (c <- 0 until initialConsonants) {
    for (v <- 0 until vowels) {
      val syllables = (0 until finalConsonantsWithOption)
        .map { cf => syllableOrigin +
          (c * vowels * finalConsonantsWithOption) +
          (v * finalConsonantsWithOption) +
          cf
        }
        .map(_.toChar)
        .mkString(" ")

      println(syllables)
    }
  }
}
