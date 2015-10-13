package com.htmlism.hangul

sealed trait Syllable {
  def inital: InitialConsonant
  def medial: Vowel
}

trait TwoCharacterSyllable extends Syllable

trait ThreeCharacterSyllable extends Syllable {
  def `final`: FinalConsonant
}

