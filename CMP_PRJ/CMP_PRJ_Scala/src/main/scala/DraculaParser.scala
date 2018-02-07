
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.util.parsing.combinator.JavaTokenParsers

object DraculaParser extends JavaTokenParsers {
  def program: Parser[Any] = rep(assign | definition | function)

  def function: Parser[Any] = funccall | custom_funccall

  def int_s: Parser[Any] = INT

  def name: Parser[Any] = NAME

  def double_s: Parser[Any] = DOUBLE

  def deffunc: Parser[Any] =
    "(" ~> func_domain ~ deffunc_tail |
      "TimeFunc" ~ "(" ~ "Date" ~ ")" ~ "->" ~> TYPE ^^ (x => List("TIME", x))

  def func_domain: Parser[Any] = TYPE ~ rep("," ~> TYPE)

  def deffunc_tail: Parser[Any] = ")" ~ "->" ~> TYPE

  def defvar: Parser[Any] = TYPE

  def definition: Parser[Any] = NAME ~ defvar_body ^^ (x => List("[", "DEFVAR", x, "]")) |
    NAME ~ deffunc_body ^^ (x => List("[", "DEFFUNC", x, "]"))

  def defvar_body: Parser[Any] = "::" ~> defvar

  def deffunc_body: Parser[Any] = "::" ~> deffunc

  def NAME: Parser[String] = """[a-z]+[a-z0-9]*""".r ^^ (x => s"$name_prefix$x")

  def TYPE: Parser[Any] = "Int" | "Double" | "Date" | "Contract"

  def assign: Parser[Any] = NAME ~ assignment ^^ (x => List("[", "ASSIGNMENT", x, "]"))

  def assignment: Parser[Any] = "=" ~> expr

  def expr: Parser[Any] = expr_prior2 ~ rep((PLUS | MINUS) ~ expr)

  def expr_prior2: Parser[Any] = expr_prior1 ~ rep((MULTIPLY | DIVIDE) ~ expr_prior2)

  def expr_prior1: Parser[Any] = number ||| name ||| "(" ~ expr ~ ")" ||| function

  def number: Parser[Any] =
    int_s ^^ (x => List("[", "NUMBER", x, "]")) |
      double_s ^^ (x => List("[", "NUMBER", x, "]"))

  def funccall: Parser[Any] =
    ONE ^^ (x => List("[", "FUNCCALL", x, "]")) |
      GIVE ~ single_arg ^^ (x => List("[", "FUNCCALL", x, "]")) |
      MKDATE ~ double_arg ^^ (x => List("[", "FUNCCALL", x, "]")) |
      FUNCOP ~ double_arg ^^ (x => List("[", "FUNCCALL", x, "]"))

  def single_arg: Parser[Any] = "(" ~> arg <~ ")"

  def double_arg: Parser[Any] = "(" ~> arg ~ comma_arg <~ ")"

  def comma_arg: Parser[Any] = "," ~> arg

  def multi_arg: Parser[Any] = "(" ~> args <~ ")"

  def custom_funccall: Parser[Any] = NAME ~ multi_arg ^^ (x => List("[", "CFUNCCALL", x, "]"))

  def arg: Parser[Any] = expr

  def args: Parser[Any] = arg ~ rep("," ~> arg)

  def INT: Parser[Any] = """[0-9]+""".r ^^ (x => s"$x.0")

  def DOUBLE: Parser[Any] = floatingPointNumber

  def MINUS: Parser[Any] = "-"

  def PLUS: Parser[Any] = "+"

  def MULTIPLY: Parser[Any] = "*"

  def DIVIDE: Parser[Any] = "/"

  def WHITESPACE: Parser[Any] = """[ \n\t\r]+""".r

  def ONE: Parser[Any] =
    "one" ~ "(" ~ ")" ^^ (_ => "ONE")

  def GIVE: Parser[Any] =
    "give" ^^ (_ => "GIVE")

  def MKDATE: Parser[Any] =
    "mkdate" ^^ (_ => "MKDATE")

  def FUNCOP: Parser[Any] =
    "and" ^^ (_ => "AND") |
      "or" ^^ (_ => "OR") |
      "then" ^^ (_ => "THEN") |
      "scaleX" ^^ (_ => "SCALEX") |
      "scale" ^^ (_ => "SCALE") |
      "truncate" ^^ (_ => "TRUNCATE")


  var cppcodepart1: String =
    """
      |#include <iostream>
      |#include <cstdio>
      |#include <iomanip>
      |
      |using namespace std;
      |
      |typedef int time_type;
      |
      |const int Inf = -1u/2;
      |int t;
      |const int Maxt = 365*24;
      |
      |double scaledValue;
      |
      |struct Date {
      |    int day = 500;
      |    int hour = 100;
      |
      |    int val(){
      |        return ((day - 1)*24+hour);
      |    }
      |
      |    void val2D(int x){
      |        day = x/24;
      |        hour = x%24;
      |    }
      |
      |    bool operator < (Date &d){
      |        int x = val();
      |        int y = d.val();
      |        return (x<y);
      |    }
      |
      |    bool operator > (Date &d){
      |        int x = val();
      |        int y = d.val();
      |        return (x>y);
      |    }
      |
      |    bool operator <= (Date &d){
      |        int x = val();
      |        int y = d.val();
      |        return (x <= y);
      |    }
      |
      |    bool operator >= (Date &d){
      |        int x = val();
      |        int y = d.val();
      |        return (x >= y);
      |    }
      |};
      |
      |Date infDate;
      |
      |struct Contract {
      |    Date date;
      |    double value = 1.0;
      |
      |    double eval(){
      |        if(value>0.0 && date.val()>=t)
      |            return value;
      |        else
      |            return 0.0;
      |    }
      |};
      |
      |Date makeDate(int day = 500, int hour = 25){
      |    Date x;
      |    x.day = day;
      |    x.hour = hour;
      |    return x;
      |}
      |
      |Date MKDATE(int day = 500, int hour = 25){
      |    Date x;
      |    x.day = day;
      |    x.hour = hour;
      |    return x;
      |}
      |
      |Contract makeContract(Date date, int val=1){
      |    Contract x;
      |    x.date = date;
      |    x.value = val;
      |    return x;
      |}
      |
      |Contract ONE(){
      |    Contract x = makeContract(infDate,1);
      |    return x;
      |}
      |
      |Contract GIVE(Contract x){
      |    Contract y = makeContract(x.date,-1*x.value);
      |    return y;
      |}
      |
      |Contract SCALE(double d,Contract x){
      |    Contract y = makeContract(x.date,d*x.value);
      |    return y;
      |}
      |
      |Contract SCALEX(double(*f)(time_type t),Contract x){
      |    Contract y = makeContract(x.date,x.value * (*f)(t));
      |    return y;
      |}
      |
      |Contract TRUNCATE(Date d, Contract c){
      |    Date nd = (c.date > d)?d:c.date;
      |    Contract y = makeContract(nd,c.value);
      |    return y;
      |}
      |
      |Contract AND(Contract c1,Contract c2){
      |    Date d = ((c1.date>c2.date)?c1.date:c2.date);
      |
      |    double val = 0.0;
      |    if (c1.date.val()>=t) val += c1.value;
      |    if (c2.date.val()>=t) val += c2.value;
      |
      |    Contract y = makeContract(d,val); //TODO check and of contract with itself
      |    return y;
      |}
      |
      |Contract THEN(Contract c1, Contract c2){
      |    Contract x;
      |    if(t <= c1.date.val())
      |        x = c1;
      |    else
      |        x = c2;
      |
      |    return x;
      |}
      |
      |Contract tmp;
    """.stripMargin

  var cppcodepart2:String =
    """
      |int main(){
    """.stripMargin

  var cppcodepart3:String =
    """
      |double sum = 0.0;
    """.stripMargin

  var cppcodepart4:String =
    """
      |    cout << fixed << setprecision(0) <<sum<<endl;
      |    return 0;
      |}
    """.stripMargin


  var functionsString: String = ""
  var defString: String = ""
  var tString: String = ""
  var queryString: String = ""
  var func_declarations: String = ""
  var func_definitions: String = ""

  var map_name_declaration: Map[String, String] = Map()

  val name_prefix: String = "__name_prefix_"
  var func_names: ArrayBuffer[String] = new ArrayBuffer[String]()
  var cntrct_names: ArrayBuffer[String] = new ArrayBuffer[String]()

  var cntrctFuncMap: Map[String,(String,String)]= Map()

  var ccnt: Int = 0
  var dcnt: Int = 0

  def one(): String = {
    "One();\n"
  }

  def give(c: String): String = {
    s"Give($c);\n"
  }

  def mkdate(d: Int, h: Int): String = {
    s"makeDate($d,$h);\n"
  }

  def mkContract(d: String, v: Double): String = {
    s"makeContract($d, $v);\n"
  }

  def scale(d: Double, c: String): String = {
    s"SCALE($d,$c);\n"
  }

  def scale(d: String, c: String, lhs: String): String = {
    s"$lhs = SCALE($d,$c);\n"
  }

  def truncate(d: String, c: String): String = {
    s"Truncate($d,$c);\n"
  }

  def And(c1: String, c2: String): String = {
    s"And($c1,$c2);\n"
  }

  def scaleX(tfn: NamedList, cn: NamedList, c2n: NamedList): Any = {
    var tf = tfn.name
    var c = cn.name
    var c2 = c2n.name

    var sclx:String =
      s"""scaledValue = $tf(t);
         |for(int i=t+1;i<Maxt;i++)
         |  scaledValue = (scaledValue>$tf(i))?scaledValue:$tf(i);
         |$c2 = makeContract($c.date(),scaledValue);
       """.stripMargin
    defString = defString + sclx

    var tfexpr = find_last_definition_of_func(tf)

    var funcdec:String =
      s"""
         |double __valueFunc_$c2 (time_type arg2, Contract $c2);
       """.stripMargin

    var funcdef:String =
      s"""
         |double __valueFunc_$c2 (time_type arg2, Contract $c2){
         |  double arg1 = __valueFunc_$c(arg2);
         |  double res = $tfexpr;
         |  return res;
         |}
       """.stripMargin

    var func:(String , String) = (funcdec,funcdef)

    cntrctFuncMap += (c2 -> func)
  }

  def Then(c1: String, c2: String): String = {
    s"Then($c1,$c2);"
  }

  def defVar(l: ArrayBuffer[NamedList]): Unit = {
    var name: String = l(0).name
    var tp: String = l(1).name
    if (tp == "Int")
      tp = "int"
    else if (tp == "Double")
      tp = "double"

    if(tp == "Contract"){
      var funcdec:String =
        s"""
           |double __valueFunc_$name (time_type arg2, Contract $name);
       """.stripMargin

      var funcdef:String =
        s"""
           |double __valueFunc_$name (time_type arg2, Contract $name){
           |  return $name.value;
           |}
       """.stripMargin

      var func:(String , String) = (funcdec,funcdef)

      cntrctFuncMap += (name -> func)
    }

    defString =
      s"""$defString
      $tp $name;
      """
  }

  def casg(node: NamedList): (String, String) = {
    var right_hand_side: String = ""
    val left_hand_side = node.list(0).name

    for (i <- 1 until node.list.size) {
      if (node.list(i).name == "NUMBER") {
        right_hand_side += node.list(i).list(0).name
      } else if (Array("*", "/", "+", "-", "(", ")").contains(node.list(i).name)) {
        right_hand_side += node.list(i).name
      } else if (node.list(i).name == "FUNCCALL" || node.list(i).name == "CFUNCCALL") {
        right_hand_side += compile_funccall(node.list(i))
      } else {
        right_hand_side += node.list(i).name
      }
    }

    (left_hand_side, right_hand_side)
  }

  def expr(node: NamedList): String = {

//    println("expr node name*****************************")
//    println(node.name)
//    println(node.list.size)

    var right_hand_side: String = ""

    for (i <- 0 until node.list.size) {
      if (node.list(i).name == "NUMBER") {
        right_hand_side += node.list(i).list(0).name
      } else if (Array("*", "/", "+", "-", "(", ")").contains(node.list(i).name)) {
        right_hand_side += node.list(i).name
      } else if (node.list(i).name == "FUNCCALL" || node.list(i).name == "CFUNCCALL") {
        right_hand_side += compile_funccall(node.list(i))
      } else {
        right_hand_side += node.list(i).name
      }
    }

    right_hand_side
  }

  var cnt:Int = 0
  def doAssignment(node: NamedList): Any = {
    var name: String = casg(node)._1

    var exp: String = casg(node)._2

//    if(node.list(1).name == "FUNCCALL" && node.list(1).list(0).name=="SCALEX"){
//
//
//      if(node.list(1).list(2).name != "FUNCCALL") {
//        defString += scale(node.list(1).list(1).name + "(t)", node.list(1).list(2).name, node.list(0).name)
//
////        scaleX(node.list(1).list(1), node.list(1).list(2), node.list(0))
//      } else {
//        defString += scale(node.list(1).list(1).name + "(t)", compile_funccall(node.list(1).list(2)), node.list(0).name)
////        def tmpcntrct:String  = compile_funccall(node.list(1).list(2))
////        def nname:String = s"tmp$cnt"
////        cnt = cnt+1
////
////        defString = defString +
////          s"""
////             |Contract $nname = $tmpcntrct;
////                  """.stripMargin
////
////
////        var funcdec:String =
////          s"""
////             |double __valueFunc_$nname (time_type arg2, Contract $nname);
////       """.stripMargin
////
////        var funcdef:String =
////          s"""
////             |double __valueFunc_$nname (time_type arg2, Contract $nname){
////             |  return $nname.value;
////             |}
////       """.stripMargin
////
////        var func:(String , String) = (funcdec,funcdef)
////
////        cntrctFuncMap += (name -> func)
//
//      }
////      println("For check:::::::::::::::::::::::::")
////      println(node.list(1).list(1).name)
////      println(node.list(1).list(2).name)
////      println(node.list(0).name)
//      return
//    }

    var asg: String = s"$name = $exp;"
    defString =
      s"""$defString
      $asg
      """
  }

  var isvar: Boolean =false
  def lineHandler(node: NamedList): Unit = {
    if (node.name == "DEFVAR") {
      defVar(node.list)
      isvar = true
    }
    else if (node.name == "ASSIGNMENT" && isvar) {
      doAssignment(node)
    }
    else{
      isvar = false
    }
  }

  def walkParsedOutput(input: Any): Unit = input match {
    case input: String =>
      list += input
    //      println(input)
    case ~(a, b) =>
      walkParsedOutput(a)
      walkParsedOutput(b)
    case lst: List[Any] => lst foreach walkParsedOutput
  }

  var list: ArrayBuffer[String] = new ArrayBuffer[String]()
  var line: String = ""
  val namedList = new NamedList("PROGRAM_ROOT")

  def main(args: Array[String]): Unit = {
    line = scala.io.StdIn.readLine()
    while (line.toUpperCase() != "END") {
      walkParsedOutput(parseAll(program, line).get)
      line = scala.io.StdIn.readLine()
    }
    //    print(list)



    var head: Int = 0

    while (head < list.size) {
      val temp = extract_rec(list, head)
      head = temp._2
      namedList.list += temp._1

      /////////For test
      lineHandler(temp._1)
    }

    //    println(namedList)

    line = scala.io.StdIn.readLine()
    val contract_count = line.split(" ")(0).toInt
    val time = line.split(" ")(1).toInt

    var contract_name: String = ""
    tString = s"t = $time;"

    var counter_declaration: String = ""
    var counter_updates: String = ""
    var finding_sum: String = ""

    for (i <- 0 until contract_count) {
      contract_name = scala.io.StdIn.readLine()
      counter_declaration += s"double __contract_max_$i = 0.0;\n"
      counter_updates += s"__contract_max_$i = (__contract_max_$i < $name_prefix$contract_name.eval())?($name_prefix$contract_name.eval()):(__contract_max_$i);\n"
      finding_sum += s"sum += __contract_max_$i;\n"
    }

    val for_header: String = "for (t ; t < Maxt ; t++) {\n"
    val for_footer: String = "}\n"

    queryString += counter_declaration
    queryString += for_header
    queryString += counter_updates
    queryString += for_footer
    queryString += finding_sum

//    println(tString)
//    println(queryString)
//
//    println(defString)

    for (elem <- namedList.list) {
      if (elem.name == "DEFFUNC") {

        val name: String = elem.list(0).name
        func_names += elem.list(0).name
        val ret_type = elem.list(elem.list.size - 1).name.toLowerCase()
        var func_declaration: String = s"$ret_type $name ("

        for (i <- 1 to elem.list.size - 2) {
          var arg_type = elem.list(i).name.toLowerCase()
          if (arg_type == "time") arg_type = "time_type"
          func_declaration += s"$arg_type $name_prefix" + s"arg$i"

          if (i != elem.list.size - 2) func_declaration += ", "
        }

        func_declaration += ")"
        map_name_declaration += (name -> func_declaration)
        func_declarations += s"$func_declaration;\n"
      } else if (elem.name == "ASSIGNMENT" && func_names.contains(elem.list(0).name)) {

        val name: String = elem.list(0).name
        var func_definition: String = ""
        func_definition += map_name_declaration(name)
        func_definition += " {\n return "

        for (i <- 1 until elem.list.size) {
          if (elem.list(i).name == "NUMBER") {
            func_definition += elem.list(i).list(0).name
          } else if (Array("*", "/", "+", "-", "(", ")").contains(elem.list(i).name)) {
            func_definition += elem.list(i).name
          } else if (elem.list(i).name == "FUNCCALL" || elem.list(i).name == "CFUNCCALL") {
            func_definition += compile_funccall(elem.list(i))
          } else {
            func_definition += elem.list(i).name
          }
        }

        func_definition += ";\n}\n"
        func_definitions += func_definition
      }
    }

    //println(func_declarations)
    //println(func_definitions)

    for(elem <- cntrctFuncMap.values) {
      func_declarations += elem._1
      func_definitions += elem._2
    }

    var code:String = cppcodepart1 + func_declarations + cppcodepart2 + counter_declaration + tString + cppcodepart3 + for_header + defString + counter_updates + for_footer + finding_sum + cppcodepart4 + func_definitions

    println(code)
  }

  def compile_funccall(node: NamedList): String = {
    var result: String = ""
    var place_comma: Boolean = true
    val func_name = node.list(0).name
    result += s"$func_name("
    for (i <- 1 until node.list.size) {

      if (i < node.list.size - 1 && (
        Array("*", "/", "+", "-", ")").contains(node.list(i + 1).name) ||
          Array("*", "/", "+", "-", "(").contains(node.list(i).name))) {
        place_comma = false
      }

      if (node.list(i).name == "NUMBER") {
        result += node.list(i).list(0).name
      } else if (Array("*", "/", "+", "-", "(", ")").contains(node.list(i).name)) {
        result += node.list(i).name
      } else if (node.list(i).name == "FUNCCALL" || node.list(i).name == "CFUNCCALL") {
        result += compile_funccall(node.list(i))
      } else {
        result += node.list(i).name
      }

      if (i != node.list.size - 1 && place_comma) {
        result += ", "
      } else {
        place_comma = true
      }
    }

    result += ")"
    result
  }

  def find_last_definition_of_func(func_name: String): String = {
    var result: String = ""
    for (elem <- namedList.list) {
      if (elem.name == "ASSIGNMENT" && elem.list(0).name == func_name) {
        result = casg(elem)._2
      }
    }

    result
  }

  def extract_scalex_second_op(node: NamedList): NamedList = {
    node.list(1).list(2)
  }


  def extract_rec(list: ArrayBuffer[String], head: Int): (NamedList, Int) = {
    var i: Int = head
    if (list(i) == "[") i += 1
    val namedList = new NamedList(list(i))
    i += 1
    while (list(i) != "]") {
      if (list(i) == "[") {
        i += 1
        val temp = extract_rec(list, i)
        namedList.list += temp._1
        i = temp._2
      } else {
        namedList.list += new NamedList(list(i))
        i += 1
      }
    }
    i += 1 // moving head out of "]" character

    (namedList, i)
  }
}

class NamedList(var name: String, var list: ArrayBuffer[NamedList]) {
  def this(name: String) {
    this(name, new ArrayBuffer[NamedList]())
  }

  def this() {
    this("__NULL", new ArrayBuffer[NamedList]())
  }
}