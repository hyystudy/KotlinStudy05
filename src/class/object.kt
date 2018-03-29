package `class`

import java.io.File

class Person(val salary: Int)

object Payroll{
    val allEmployees = arrayListOf<Person>()
    fun calculateSalary() : Int  {

        return allEmployees.sumBy { it.salary }
    }
}

//单例静态的 comparator
object CaseInsensitiveFileComparator : Comparator<File>{
    override fun compare(file1: File, file2: File): Int {
        return file1.path.compareTo(file2.path, ignoreCase = true)
    }

}

//类中放置静态单例对象
data class Worker(val name: String){
    object NameComparator : Comparator<Worker>{
        override fun compare(o1: Worker, o2: Worker): Int = o1.name.compareTo(o2.name)

    }
}

class A{
    companion object {
        fun bar(){
            println("Companion object called")
        }
    }
}

class User private constructor(val nickname: String){
    companion object {
        fun newSunscribingUser(email: String) = User(email.substringBefore("@"))

        fun newFaceBookUser(facebookId: Int) = User(getFaceBookName(facebookId))

        private fun getFaceBookName(facebookId: Int): String = Integer.toString(facebookId)
    }
}

class PersonTwo(val name: String){
    companion object Loader{
        fun fromJson(jsonText: String) : PersonTwo = PersonTwo(jsonText)
    }
}