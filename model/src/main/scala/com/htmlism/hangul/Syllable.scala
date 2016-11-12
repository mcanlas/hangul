package com.htmlism.hangul

sealed trait Syllable {
  def initial: InitialConsonant
  def medial: Vowel
}

case class TwoCharacterSyllable(initial: InitialConsonant, medial: Vowel) extends Syllable

case class ThreeCharacterSyllable(initial: InitialConsonant, medial: Vowel, finalConsonant: FinalConsonant) extends Syllable

