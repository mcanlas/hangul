package com.htmlism.hangul

sealed trait Jamo

sealed trait InitialConsonant extends Jamo

sealed trait Vowel extends Jamo

sealed trait SimpleVowel extends Vowel

abstract class CompoundVowel(first: Vowel, second: Vowel) extends Vowel

abstract class IotizedVowel(from: Vowel) extends Vowel

sealed trait FinalConsonant extends Jamo

trait SimpleFinalConsonant extends FinalConsonant

trait ConsonantCluster extends FinalConsonant {
  def first: SimpleFinalConsonant
  def second: SimpleFinalConsonant
}

class ConsonantClusterValue(val first: SimpleFinalConsonant, val second: SimpleFinalConsonant) extends ConsonantCluster

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

case object VowelA   extends SimpleVowel
case object VowelAe  extends SimpleVowel
case object VowelYa  extends IotizedVowel(VowelA)
case object VowelYae extends IotizedVowel(VowelAe)
case object VowelEo  extends SimpleVowel
case object VowelE   extends SimpleVowel
case object VowelYeo extends IotizedVowel(VowelEo)
case object VowelYe  extends IotizedVowel(VowelE)
case object VowelO   extends SimpleVowel
case object VowelWa  extends CompoundVowel(VowelO, VowelA)
case object VowelWae extends CompoundVowel(VowelO, VowelAe)
case object VowelOe  extends CompoundVowel(VowelO, VowelI)
case object VowelYo  extends IotizedVowel(VowelO)
case object VowelU   extends SimpleVowel
case object VowelWeo extends CompoundVowel(VowelU, VowelEo)
case object VowelWe  extends CompoundVowel(VowelU, VowelE)
case object VowelWi  extends CompoundVowel(VowelU, VowelI)
case object VowelYu  extends IotizedVowel(VowelU)
case object VowelEu  extends SimpleVowel
case object VowelYi  extends CompoundVowel(VowelEu, VowelI)
case object VowelI   extends SimpleVowel

case object KiyeokSios  extends ConsonantClusterValue(Kiyeok, Sios)
case object NieunCieuc  extends ConsonantClusterValue(Nieun, Cieuc)
case object NieunHieuh  extends ConsonantClusterValue(Nieun, Hieuh)
case object RieulKiyeok extends ConsonantClusterValue(Rieul, Kiyeok)
case object RieulMieum  extends ConsonantClusterValue(Rieul, Mieum)
case object RieulPieup  extends ConsonantClusterValue(Rieul, Pieup)
case object RieulSios   extends ConsonantClusterValue(Rieul, Sios)
case object RieulThieth extends ConsonantClusterValue(Rieul, Thieuth)
case object RieulPhieph extends ConsonantClusterValue(Rieul, Phieuph)
case object RieulHieuh  extends ConsonantClusterValue(Rieul, Hieuh)
case object PiuepSios   extends ConsonantClusterValue(Pieup, Sios)
