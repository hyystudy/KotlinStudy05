import `class`.*
import java.io.File

fun main(args: Array<String>) {
    val client = Client("hyy", 10)
    val client1 = Client("hyy", 10)
    println(client)
    println(client == client1)

    val processed = hashSetOf(client)
    println(processed.contains(client1))

    val countingSet = CountingSet<Int>()
    countingSet.addAll(listOf(1, 2, 2))

    println("${countingSet.objectAdded} objects were added, ${countingSet.size} remain")

    Payroll.allEmployees.add(Person(1200))
    Payroll.allEmployees.add(Person(3000))
    Payroll.allEmployees.add(Person(7000))
    println(Payroll.calculateSalary())


    println(CaseInsensitiveFileComparator.compare(File("/User"), File("/Zser")))

    val files = listOf(File("/Z"), File("/a"), File("/c"))

    println(files.sortedWith(CaseInsensitiveFileComparator))

    val works = listOf(Worker("hyy"), Worker("zal"))
    println(works.sortedWith(Worker.NameComparator))

    A.bar()

    val faceBookUser = User.newFaceBookUser(123)
    val sunscribingUser = User.newSunscribingUser("hyy@gmail.com")
    println(faceBookUser.nickname)
    println(sunscribingUser.nickname)


}
