fun main(args: Array<String>) {
    val jeongbin = Student("정빈", 30, "철학")
    val wasingun = Student("와신군", 35, "무역")
    val wooseob = Student("이우섭", 30, "무역")

}


open class Person(private val name: String, private val age: Int){
    var IQ = 100
    fun greeting(){
        println("안녕하세요. $name 입니다. 나이는 $age 입니다.")
    }
}
class Student(private val name: String, private val age: Int, private val major: String): Person(name, age){
    fun introduceMajor(){
        println("제 전공은 $major 이며, IQ는 $IQ 입니다 ")
    }

}