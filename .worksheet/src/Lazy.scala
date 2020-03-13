object Lazy {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(125); val res$0 = 
  (0 until 100000).view.map(math.pow(_, 2)).filter(_.toLong % 2 == 0).map(_ / 4).filter(n => n.toLong == n).sum;System.out.println("""res0: Double = """ + $show(res$0));$skip(115); val res$1 = 
  (0 until 100000).toArray.map(math.pow(_, 2)).filter(_.toLong % 2 == 0).map(_ / 4).filter(n => n.toLong == n).sum;System.out.println("""res1: Double = """ + $show(res$1))}
}
