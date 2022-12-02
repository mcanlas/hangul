package com.htmlism.hangul

import com.htmlism.hangul.Hangul._

object OrderByComplexity {
  val complexity = Map[Jamo, Int](
    Kiyeok      -> 4,
    SsangKiyeok -> 8,
    Nieun       -> 4,
    Tikeut      -> 6,
    SsangTikeut -> 12,
    Rieul       -> 6,
    Mieum       -> 6,
    Pieup       -> 8,
    SsangPieup  -> 16,
    Sios        -> 4,
    SsangSios   -> 8,
    Ieung       -> 2,
    Cieuc       -> 6,
    SsangCieuc  -> 12,
    Chiuech     -> 8,
    Khieukh     -> 6,
    Thieuth     -> 8,
    Phieuph     -> 8,
    Hieuh       -> 6,
    // vowels
    VowelA      -> 3,
    VowelAe     -> 5,
    VowelYa     -> 4,
    VowelYae    -> 6,
    VowelEo     -> 3,
    VowelE      -> 5,
    VowelYeo    -> 4,
    VowelYe     -> 6,
    VowelO      -> 3,
    VowelWa     -> 6,
    VowelWae    -> 8,
    VowelOe     -> 5,
    VowelYo     -> 4,
    VowelU      -> 3,
    VowelWeo    -> 6,
    VowelWe     -> 8,
    VowelWi     -> 5,
    VowelYu     -> 4,
    VowelEu     -> 2,
    VowelYi     -> 4,
    VowelI      -> 2
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

  def calculateComplexity(s: Syllable) =
    s match {
      case TwoCharacterSyllable(i, m) =>
        complexity(i) + complexity(m)

      case ThreeCharacterSyllable(i, m, f) =>
        f match {
          case a: BasicFinalConsonant =>
            complexity(i) + complexity(m) + complexity(a)

          case a: ConsonantCluster =>
            complexity(i) + complexity(m) + complexity(a.left) + complexity(a.right)
        }
    }
}
