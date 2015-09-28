package com.htmlism.hangul

sealed trait Jamo

sealed trait InitialConsonant extends Jamo

sealed trait Vowel extends Jamo

sealed trait FinalConsonant extends Jamo

trait SimpleFinalConsonant extends FinalConsonant

trait CompoundConsonant extends FinalConsonant {
  def first: SimpleFinalConsonant
  def second: SimpleFinalConsonant
}

class CompoundConsonantValue(val first: SimpleFinalConsonant, val second: SimpleFinalConsonant) extends CompoundConsonant

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

case object KiyeokSios  extends CompoundConsonantValue(Kiyeok, Sios)
case object NieunCieuc  extends CompoundConsonantValue(Nieun, Cieuc)
case object NieunHieuh  extends CompoundConsonantValue(Nieun, Hieuh)
case object RieulKiyeok extends CompoundConsonantValue(Rieul, Kiyeok)
case object RieulMieum  extends CompoundConsonantValue(Rieul, Mieum)
case object RieulPieup  extends CompoundConsonantValue(Rieul, Pieup)
case object RieulSios   extends CompoundConsonantValue(Rieul, Sios)
case object RieulThieth extends CompoundConsonantValue(Rieul, Thieuth)
case object RieulPhieph extends CompoundConsonantValue(Rieul, Phieuph)
case object RieulHieuh  extends CompoundConsonantValue(Rieul, Hieuh)
case object PiuepSios   extends CompoundConsonantValue(Pieup, Sios)
