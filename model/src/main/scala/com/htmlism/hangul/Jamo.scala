package com.htmlism.hangul

sealed trait Jamo
sealed trait InitialConsonant extends Jamo
sealed trait Vowel extends Jamo
sealed trait FinalConsonant extends Jamo

sealed trait BasicVowel extends Vowel

sealed abstract class CompoundVowel(val first: BasicVowel, val second: BasicVowel) extends Vowel

sealed abstract class IotizedVowel(val from: BasicVowel) extends Vowel

sealed trait BasicFinalConsonant extends FinalConsonant

sealed trait ConsonantCluster extends FinalConsonant {
  def left: BasicFinalConsonant
  def right: BasicFinalConsonant
}

// these two classes cannot be case classes since they are to be extended by case objects
// and scala cannot support case to case inheritance

sealed class LeftBiasCluster(val left: BasicFinalConsonant, val right: BasicFinalConsonant) extends ConsonantCluster
sealed class RightBiasCluster(val left: BasicFinalConsonant, val right: BasicFinalConsonant) extends ConsonantCluster

// =====================================

case object Kiyeok extends InitialConsonant with BasicFinalConsonant
case object SsangKiyeok extends InitialConsonant with BasicFinalConsonant
case object Nieun extends InitialConsonant with BasicFinalConsonant
case object Tikeut extends InitialConsonant with BasicFinalConsonant
case object SsangTikeut extends InitialConsonant
case object Rieul extends InitialConsonant with BasicFinalConsonant
case object Mieum extends InitialConsonant with BasicFinalConsonant
case object Pieup extends InitialConsonant with BasicFinalConsonant
case object SsangPieup extends InitialConsonant
case object Sios extends InitialConsonant with BasicFinalConsonant
case object SsangSios extends InitialConsonant with BasicFinalConsonant
case object Ieung extends InitialConsonant with BasicFinalConsonant
case object Cieuc extends InitialConsonant with BasicFinalConsonant
case object SsangCieuc extends InitialConsonant
case object Chiuech extends InitialConsonant with BasicFinalConsonant
case object Khieukh extends InitialConsonant with BasicFinalConsonant
case object Thieuth extends InitialConsonant with BasicFinalConsonant
case object Phieuph extends InitialConsonant with BasicFinalConsonant
case object Hieuh extends InitialConsonant with BasicFinalConsonant

case object VowelA extends BasicVowel
case object VowelAe extends BasicVowel
case object VowelYa extends IotizedVowel(VowelA)
case object VowelYae extends IotizedVowel(VowelAe)
case object VowelEo extends BasicVowel
case object VowelE extends BasicVowel
case object VowelYeo extends IotizedVowel(VowelEo)
case object VowelYe extends IotizedVowel(VowelE)
case object VowelO extends BasicVowel
case object VowelWa extends CompoundVowel(VowelO, VowelA)
case object VowelWae extends CompoundVowel(VowelO, VowelAe)
case object VowelOe extends CompoundVowel(VowelO, VowelI)
case object VowelYo extends IotizedVowel(VowelO)
case object VowelU extends BasicVowel
case object VowelWeo extends CompoundVowel(VowelU, VowelEo)
case object VowelWe extends CompoundVowel(VowelU, VowelE)
case object VowelWi extends CompoundVowel(VowelU, VowelI)
case object VowelYu extends IotizedVowel(VowelU)
case object VowelEu extends BasicVowel
case object VowelYi extends CompoundVowel(VowelEu, VowelI)
case object VowelI extends BasicVowel

case object KiyeokSios extends LeftBiasCluster(Kiyeok, Sios)
case object NieunCieuc extends LeftBiasCluster(Nieun, Cieuc)
case object NieunHieuh extends LeftBiasCluster(Nieun, Hieuh)
case object RieulKiyeok extends RightBiasCluster(Rieul, Kiyeok)
case object RieulMieum extends RightBiasCluster(Rieul, Mieum)
case object RieulPieup extends LeftBiasCluster(Rieul, Pieup)
case object RieulSios extends LeftBiasCluster(Rieul, Sios)
case object RieulThieth extends LeftBiasCluster(Rieul, Thieuth)
case object RieulPhieph extends LeftBiasCluster(Rieul, Phieuph)
case object RieulHieuh extends LeftBiasCluster(Rieul, Hieuh)
case object PiuepSios extends LeftBiasCluster(Pieup, Sios)
