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

  val finalConsonants = Seq(
    Kiyeok,
    SsangKiyeok,
    KiyeokSios,
    Nieun,
    NieunCieuc,
    NieunHieuh,
    Tikeut,
    Rieul,
    RieulKiyeok,
    RieulMieum,
    RieulPieup,
    RieulSios,
    RieulThieth,
    RieulPhieph,
    RieulHieuh,
    Mieum,
    Pieup,
    PiuepSios,
    Sios,
    SsangSios,
    Ieung,
    Cieuc,
    Chiuech,
    Khieukh,
    Thieuth,
    Phieuph,
    Hieuh)

  val initialConsonantsTotal = initalConsonants.length
  val vowelsTotal = vowels.length
  val finalConsonantsTotal = finalConsonants.length
  val finalConsonantsWithOptionTotal = finalConsonants.length + 1

  assert(initialConsonantsTotal == 19)
  assert(vowelsTotal == 21)
  assert(finalConsonantsTotal == 27)

  val syllableOrigin = 0xAC00
}

sealed trait UnicodeCharacter

sealed trait Jamo extends UnicodeCharacter
sealed trait InitialConsonant extends Jamo
sealed trait Vowel extends Jamo

sealed trait FinalConsonant extends Jamo
trait SimpleFinalConsonant extends FinalConsonant

trait CompoundFinalConsonant extends FinalConsonant {
  def first: SimpleFinalConsonant
  def second: SimpleFinalConsonant
}

sealed trait Syllable extends {
  def inital: InitialConsonant
  def medial: Vowel
}

trait TwoCharacterSyllable extends Syllable

trait ThreeCharacterSyllable extends Syllable {
  def `final`: FinalConsonant
}

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

case object Kiyeok      extends InitialConsonant with SimpleFinalConsonant
case object SsangKiyeok extends InitialConsonant with SimpleFinalConsonant
case object Nieun       extends InitialConsonant with SimpleFinalConsonant
case object Tikeut      extends InitialConsonant with SimpleFinalConsonant
case object SsangTikeut extends InitialConsonant
case object Rieul       extends InitialConsonant with SimpleFinalConsonant
case object Mieum       extends InitialConsonant with SimpleFinalConsonant
case object Pieup       extends InitialConsonant with SimpleFinalConsonant
case object SsangPieup  extends InitialConsonant
case object Sios        extends InitialConsonant with SimpleFinalConsonant
case object SsangSios   extends InitialConsonant with SimpleFinalConsonant
case object Ieung       extends InitialConsonant with SimpleFinalConsonant
case object Cieuc       extends InitialConsonant with SimpleFinalConsonant
case object SsangCieuc  extends InitialConsonant
case object Chiuech     extends InitialConsonant with SimpleFinalConsonant
case object Khieukh     extends InitialConsonant with SimpleFinalConsonant
case object Thieuth     extends InitialConsonant with SimpleFinalConsonant
case object Phieuph     extends InitialConsonant with SimpleFinalConsonant
case object Hieuh       extends InitialConsonant with SimpleFinalConsonant

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

class CompoundFinalConsonantValue(val first: SimpleFinalConsonant, val second: SimpleFinalConsonant) extends CompoundFinalConsonant

case object KiyeokSios  extends CompoundFinalConsonantValue(Kiyeok, Sios)
case object NieunCieuc  extends CompoundFinalConsonantValue(Nieun,  Cieuc)
case object NieunHieuh  extends CompoundFinalConsonantValue(Nieun,  Hieuh)
case object RieulKiyeok extends CompoundFinalConsonantValue(Rieul,  Kiyeok)
case object RieulMieum  extends CompoundFinalConsonantValue(Rieul,  Mieum)
case object RieulPieup  extends CompoundFinalConsonantValue(Rieul,  Pieup)
case object RieulSios   extends CompoundFinalConsonantValue(Rieul,  Sios)
case object RieulThieth extends CompoundFinalConsonantValue(Rieul,  Thieuth)
case object RieulPhieph extends CompoundFinalConsonantValue(Rieul,  Phieuph)
case object RieulHieuh  extends CompoundFinalConsonantValue(Rieul,  Hieuh)
case object PiuepSios   extends CompoundFinalConsonantValue(Pieup,  Sios)
