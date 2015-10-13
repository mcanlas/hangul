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
