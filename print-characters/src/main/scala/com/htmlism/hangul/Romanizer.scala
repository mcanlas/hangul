package com.htmlism.hangul

object Romanizer {
  def applyWhen(str: String, filter: Char => Boolean, romanize: String => String): String = {
    val res = new StringBuilder
    var acc = new StringBuilder

    for (c <- str)
      if (filter(c))
        acc += c
      else {
        val hangul = acc.result()

        if (hangul.nonEmpty) {
          res ++= romanize(hangul)

          // reset the accumulator
          acc = new StringBuilder
        }

        res += c
      }

    res.result()
  }
}

trait Romanizer {
  def romanize(hangul: String): String
}
