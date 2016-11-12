package com.htmlism.hangul

sealed trait Jamo

sealed trait InitialConsonant extends Jamo

sealed trait Vowel extends Jamo

sealed trait BasicVowel extends Vowel

abstract class CompoundVowel(first: BasicVowel, second: BasicVowel) extends Vowel

abstract class IotizedVowel(from: BasicVowel) extends Vowel

sealed trait FinalConsonant extends Jamo

sealed trait BasicFinalConsonant extends FinalConsonant

trait ConsonantCluster extends FinalConsonant {
  def first: BasicFinalConsonant
  def second: BasicFinalConsonant
}

abstract class ConsonantClusterValue(val first: BasicFinalConsonant, val second: BasicFinalConsonant) extends ConsonantCluster

class LeftCluster(first: BasicFinalConsonant, second: BasicFinalConsonant) extends ConsonantClusterValue(first, second)
class RightCluster(first: BasicFinalConsonant, second: BasicFinalConsonant) extends ConsonantClusterValue(first, second)

case object Kiyeok      extends InitialConsonant with BasicFinalConsonant
case object SsangKiyeok extends InitialConsonant with BasicFinalConsonant
case object Nieun       extends InitialConsonant with BasicFinalConsonant
case object Tikeut      extends InitialConsonant with BasicFinalConsonant
case object SsangTikeut extends InitialConsonant
case object Rieul       extends InitialConsonant with BasicFinalConsonant
case object Mieum       extends InitialConsonant with BasicFinalConsonant
case object Pieup       extends InitialConsonant with BasicFinalConsonant
case object SsangPieup  extends InitialConsonant
case object Sios        extends InitialConsonant with BasicFinalConsonant
case object SsangSios   extends InitialConsonant with BasicFinalConsonant
case object Ieung       extends InitialConsonant with BasicFinalConsonant
case object Cieuc       extends InitialConsonant with BasicFinalConsonant
case object SsangCieuc  extends InitialConsonant
case object Chiuech     extends InitialConsonant with BasicFinalConsonant
case object Khieukh     extends InitialConsonant with BasicFinalConsonant
case object Thieuth     extends InitialConsonant with BasicFinalConsonant
case object Phieuph     extends InitialConsonant with BasicFinalConsonant
case object Hieuh       extends InitialConsonant with BasicFinalConsonant

case object VowelA   extends BasicVowel
case object VowelAe  extends BasicVowel
case object VowelYa  extends IotizedVowel(VowelA)
case object VowelYae extends IotizedVowel(VowelAe)
case object VowelEo  extends BasicVowel
case object VowelE   extends BasicVowel
case object VowelYeo extends IotizedVowel(VowelEo)
case object VowelYe  extends IotizedVowel(VowelE)
case object VowelO   extends BasicVowel
case object VowelWa  extends CompoundVowel(VowelO, VowelA)
case object VowelWae extends CompoundVowel(VowelO, VowelAe)
case object VowelOe  extends CompoundVowel(VowelO, VowelI)
case object VowelYo  extends IotizedVowel(VowelO)
case object VowelU   extends BasicVowel
case object VowelWeo extends CompoundVowel(VowelU, VowelEo)
case object VowelWe  extends CompoundVowel(VowelU, VowelE)
case object VowelWi  extends CompoundVowel(VowelU, VowelI)
case object VowelYu  extends IotizedVowel(VowelU)
case object VowelEu  extends BasicVowel
case object VowelYi  extends CompoundVowel(VowelEu, VowelI)
case object VowelI   extends BasicVowel

case object KiyeokSios  extends LeftCluster(Kiyeok, Sios)
case object NieunCieuc  extends LeftCluster(Nieun, Cieuc)
case object NieunHieuh  extends LeftCluster(Nieun, Hieuh)
case object RieulKiyeok extends RightCluster(Rieul, Kiyeok)
case object RieulMieum  extends RightCluster(Rieul, Mieum)
case object RieulPieup  extends LeftCluster(Rieul, Pieup)
case object RieulSios   extends LeftCluster(Rieul, Sios)
case object RieulThieth extends LeftCluster(Rieul, Thieuth)
case object RieulPhieph extends LeftCluster(Rieul, Phieuph)
case object RieulHieuh  extends LeftCluster(Rieul, Hieuh)
case object PiuepSios   extends LeftCluster(Pieup, Sios)
