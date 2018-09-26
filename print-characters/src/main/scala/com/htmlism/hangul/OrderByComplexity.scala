package com.htmlism.hangul

import com.htmlism.hangul.Hangul._

object OrderByComplexity {
  val complexity = Map[Jamo, Double](
    Kiyeok      -> 2,
    SsangKiyeok -> 4,
    Nieun       -> 2,
    Tikeut      -> 3,
    SsangTikeut -> 6,
    Rieul       -> 3,
    Mieum       -> 3,
    Pieup       -> 4,
    SsangPieup  -> 8,
    Sios        -> 2,
    SsangSios   -> 4,
    Ieung       -> 1,
    Cieuc       -> 3,
    SsangCieuc  -> 6,
    Chiuech     -> 4,
    Khieukh     -> 3,
    Thieuth     -> 4,
    Phieuph     -> 4,
    Hieuh       -> 3,
    // vowels
    VowelA   -> 1.5,
    VowelAe  -> 2.5,
    VowelYa  -> 2,
    VowelYae -> 3,
    VowelEo  -> 1.5,
    VowelE   -> 2.5,
    VowelYeo -> 2,
    VowelYe  -> 3,
    VowelO   -> 1.5,
    VowelWa  -> 3,
    VowelWae -> 4,
    VowelOe  -> 2.5,
    VowelYo  -> 2,
    VowelU   -> 1.5,
    VowelWeo -> 3,
    VowelWe  -> 4,
    VowelWi  -> 2.5,
    VowelYu  -> 2,
    VowelEu  -> 1,
    VowelYi  -> 2,
    VowelI   -> 1
  )

  def main(args: Array[String]): Unit = {
    val syllables = (syllableOrigin to lastSyllable)
      .map(_.toChar)
      .map { c =>
        val s       = toSyllable(c).get
        val complex = calculateComplexity(s)

        c -> complex
      }
      .toArray
      .sortBy(_._2)

    syllables
      .foreach(println)
  }

  def calculateComplexity(s: Syllable) = s match {
    case TwoCharacterSyllable(i, m) =>
      complexity(i) + complexity(m)

    case ThreeCharacterSyllable(i, m, f) =>
      f match {
        case a: BasicFinalConsonant =>
          complexity(i) + complexity(m) + complexity(a)

        case a: ConsonantCluster =>
          complexity(i) + complexity(m) + complexity(a.left) + complexity(
            a.right)
      }
  }
}
