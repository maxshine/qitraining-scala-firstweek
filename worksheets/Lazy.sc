object Lazy {
  (0 until 100000).view.map(math.pow(_, 2)).filter(_.toLong % 2 == 0).map(_ / 4).filter(n => n.toLong == n).sum
                                                  //> res0: Double = 4.1665416675E13
  (0 until 100000).toArray.map(math.pow(_, 2)).filter(_.toLong % 2 == 0).map(_ / 4).filter(n => n.toLong == n).sum
                                                  //> res1: Double = 4.1665416675E13
}