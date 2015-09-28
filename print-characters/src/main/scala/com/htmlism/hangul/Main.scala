package com.htmlism.hangul

object Hangul {
  val initialOriginCodePoint = 0x1100
  val medialOriginCodePoint  = 0x1161
  val finalOriginCodePoint   = 0x11A8

  val initalConsonants = Seq(
    Kiyeok,
    SsangKiyeok,
    Nieun,
    Tikeut,
    SsangTikeut,
    Rieul,
    Mieum,
    Pieup,
    SsangPieup,
    Sios,
    SsangSios,
    Ieung,
    Cieuc,
    SsangCieuc,
    Chiuech,
    Khieukh,
    Thieuth,
    Phieuph,
    Hieuh)

  val vowels = Seq(
    VowelA,
    VowelAe,
    VowelYa,
    VowelYae,
    VowelEo,
    VowelE,
    VowelYeo,
    VowelYe,
    VowelO,
    VowelWa,
    VowelWae,
    VowelOe,
    VowelYo,
    VowelU,
    VowelWeo,
    VowelWe,
    VowelWi,
    VowelYu,
    VowelEu,
    VowelYi,
    VowelI)

  val initialConsonantsTotal = initalConsonants.length
  val vowelsTotal = vowels.length
  val finalConsonantsTotal = 27
  val finalConsonantsWithOptionTotal = 28

  assert(initialConsonantsTotal == 19)
  assert(vowelsTotal == 21)

  val syllableOrigin = 0xAC00
}

sealed trait UnicodeCharacter

sealed trait Jamo extends UnicodeCharacter

sealed trait InitialConsonant extends Jamo

sealed trait Vowel extends Jamo

sealed trait FinalConsonant extends Jamo

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

case object Kiyeok      extends InitialConsonant
case object SsangKiyeok extends InitialConsonant
case object Nieun       extends InitialConsonant
case object Tikeut      extends InitialConsonant
case object SsangTikeut extends InitialConsonant
case object Rieul       extends InitialConsonant
case object Mieum       extends InitialConsonant
case object Pieup       extends InitialConsonant
case object SsangPieup  extends InitialConsonant
case object Sios        extends InitialConsonant
case object SsangSios   extends InitialConsonant
case object Ieung       extends InitialConsonant
case object Cieuc       extends InitialConsonant
case object SsangCieuc  extends InitialConsonant
case object Chiuech     extends InitialConsonant
case object Khieukh     extends InitialConsonant
case object Thieuth     extends InitialConsonant
case object Phieuph     extends InitialConsonant
case object Hieuh       extends InitialConsonant

case object VowelA   extends Vowel
case object VowelAe  extends Vowel
case object VowelYa  extends Vowel
case object VowelYae extends Vowel
case object VowelEo  extends Vowel
case object VowelE   extends Vowel
case object VowelYeo extends Vowel
case object VowelYe  extends Vowel
case object VowelO   extends Vowel
case object VowelWa  extends Vowel
case object VowelWae extends Vowel
case object VowelOe  extends Vowel
case object VowelYo  extends Vowel
case object VowelU   extends Vowel
case object VowelWeo extends Vowel
case object VowelWe  extends Vowel
case object VowelWi  extends Vowel
case object VowelYu  extends Vowel
case object VowelEu  extends Vowel
case object VowelYi  extends Vowel
case object VowelI   extends Vowel
