package com.htmlism.hangul

sealed trait Syllable {
  def initial: InitialConsonant
  def medial: Vowel
}

trait TwoCharacterSyllable extends Syllable

trait ThreeCharacterSyllable extends Syllable {
  def `final`: FinalConsonant
}

