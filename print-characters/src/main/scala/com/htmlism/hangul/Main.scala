package com.htmlism.hangul

object Hangul {
  val initialOriginCodePoint = 0x1100
  val medialOriginCodePoint  = 0x1161
  val finalOriginCodePoint   = 0x11A8

  val initalConsonants = Seq(
    InitialConsonant("g"),
    InitialConsonant("kk"),
    InitialConsonant("n"),
    InitialConsonant("d"),
    InitialConsonant("tt"),
    InitialConsonant("r"),
    InitialConsonant("m"),
    InitialConsonant("b"),
    InitialConsonant("pp"),
    InitialConsonant("s"),
    InitialConsonant("ss"),
    InitialConsonant(""),
    InitialConsonant("j"),
    InitialConsonant("jj"),
    InitialConsonant("ch"),
    InitialConsonant("k"),
    InitialConsonant("t"),
    InitialConsonant("p"),
    InitialConsonant("h"))

  val initialConsonantsTotal = initalConsonants.length // 19
  val vowelsTotal = 21
  val finalConsonantsTotal = 27
  val finalConsonantsWithOptionTotal = 28

  val syllableOrigin = 0xAC00
}

sealed trait UnicodeCharacter

sealed trait Jamo extends UnicodeCharacter {
  def romanization: String
}

case class InitialConsonant(romanization: String) extends Jamo

case class Vowel(romanization: String) extends Jamo

case class FinalConsonant(romanization: String) extends Jamo

sealed trait Syllable extends UnicodeCharacter {
  def pronunciation: String
}

trait TwoCharacterSyllable extends Syllable

trait ThreeCharacterSyllable extends Syllable

object Main extends App {
  import com.htmlism.hangul.Hangul._

  // optional final constant makes 28
  // 19 * 21 * 28 = 11,172

  printJamo("Initial consonants", initialConsonantsTotal, initialOriginCodePoint)
  printJamo("Vowels", vowelsTotal, medialOriginCodePoint)
  printJamo("Final consonants", finalConsonantsTotal, finalOriginCodePoint)

  private def printJamo(heading: String, total: Int, origin: Int) = {
    val jamo = (0 until total)
      .map(_ + origin)
      .map(_.toChar)
      .mkString("  ")

    println(heading)
    println(jamo)
  }
}

object TwoCharacterSyllables extends App {
  import com.htmlism.hangul.Hangul._

  for (c <- 0 until initialConsonantsTotal) {
    val syllables = (0 until vowelsTotal)
      .map { v => syllableOrigin +
        (c * vowelsTotal * finalConsonantsWithOptionTotal) +
        (v * finalConsonantsWithOptionTotal)
      }
      .map(_.toChar)
      .mkString(" ")

    println(syllables)
  }
}

object ThreeCharacterSyllables extends App {
  import com.htmlism.hangul.Hangul._

  for (c <- 0 until initialConsonantsTotal) {
    for (v <- 0 until vowelsTotal) {
      val syllables = (0 until finalConsonantsWithOptionTotal)
        .map { cf => syllableOrigin +
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
