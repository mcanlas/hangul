package com.htmlism.hangul

import weaver.*

object HangulSpec extends FunSuite {
  test("The Hangul decoder should convert characters correctly") {
    expect.same(None, Hangul.toSyllable(0xabff.toChar)) and
      whenSuccess(Hangul.toSyllable(0xac00.toChar)) {
        expect.same(TwoCharacterSyllable(Kiyeok, VowelA), _)
      } and
      whenSuccess(Hangul.toSyllable(0xac01.toChar)) {
        expect.same(ThreeCharacterSyllable(Kiyeok, VowelA, Kiyeok), _)
      } and
      whenSuccess(Hangul.toSyllable((0xac00 + 28).toChar)) {
        expect.same(TwoCharacterSyllable(Kiyeok, VowelAe), _)
      } and
      whenSuccess(Hangul.toSyllable((0xac00 + 19 * 21 * 28 - 1).toChar)) {
        expect.same(ThreeCharacterSyllable(Hieuh, VowelI, Hieuh), _)
      } and
      expect.same(None, Hangul.toSyllable((0xac00 + 19 * 21 * 28).toChar))
  }
}
