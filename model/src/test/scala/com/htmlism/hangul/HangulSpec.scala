package com.htmlism.hangul

import org.specs2.mutable.Specification

class HangulSpec extends Specification {
  "The Hangul decoder" should {
    "convert characters correctly" in {
      Hangul.toSyllable(0xABFF.toChar) === None

      Hangul.toSyllable(0xAC00.toChar) === Some(TwoCharacterSyllable(Kiyeok, VowelA))
      Hangul.toSyllable(0xAC01.toChar) === Some(TwoCharacterSyllable(SsangKiyeok, VowelA))

      Hangul.toSyllable((0xAC00 + 19).toChar) === Some(TwoCharacterSyllable(Kiyeok, VowelAe))

      Hangul.toSyllable((0xAC00 + 19 * 21 * 28 - 1).toChar) === Some(ThreeCharacterSyllable(Hieuh, VowelI, Hieuh))

      Hangul.toSyllable((0xAC00 + 19 * 21 * 28).toChar) === None
    }
  }
}
