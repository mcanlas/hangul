package com.htmlism.hangul

object Hangul {
  val initialOriginCodePoint = 0x1100
  val medialOriginCodePoint  = 0x1161
  val finalOriginCodePoint   = 0x11A8

  val initialConsonants = Seq(Kiyeok,
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
    VowelI
  )

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
    Hieuh
  )

  val initialConsonantsTotal         = 19
  val vowelsTotal                    = 21
  val finalConsonantsTotal           = 27
  val finalConsonantsWithOptionTotal = finalConsonants.length + 1

  assert(initialConsonantsTotal == initialConsonants.length)
  assert(vowelsTotal == vowels.length)
  assert(finalConsonantsTotal == finalConsonants.length)

  val totalCombinations = initialConsonantsTotal * vowelsTotal * finalConsonantsWithOptionTotal

  val syllableOrigin = 0xAC00
  val lastSyllable   = syllableOrigin + (initialConsonantsTotal * vowelsTotal * finalConsonantsWithOptionTotal) - 1

  def toSyllable(char: Char): Option[Syllable] =
    if (char < syllableOrigin || char >= syllableOrigin + totalCombinations)
      None
    else {
      val syllableIndex = char - syllableOrigin

      val initialIndex          = syllableIndex / (vowelsTotal * finalConsonantsWithOptionTotal)
      val remainingVowelBatchim = syllableIndex - (initialIndex * vowelsTotal * finalConsonantsWithOptionTotal)

      val medialIndex = remainingVowelBatchim / finalConsonantsWithOptionTotal
      val finalIndex  = remainingVowelBatchim - medialIndex * finalConsonantsWithOptionTotal

      val initial = initialConsonants(initialIndex)
      val medial  = vowels(medialIndex)

      if (finalIndex == 0)
        Some(TwoCharacterSyllable(initial, medial))
      else {
        val finalConsonant = finalConsonants(finalIndex - 1)

        Some(ThreeCharacterSyllable(initial, medial, finalConsonant))
      }
    }
}
