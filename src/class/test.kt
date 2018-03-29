package `class`

data class Client(val name: String, val postal: Int){
   /* override fun toString(): String {
        return "name: $name, postal: $postal"
    }

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Client) return false
        return name == other.name && postal == other.postal
    }

    override fun hashCode(): Int {
        return name.hashCode() * 31 + postal
    }*/

}

class DelegatingCollectionTwo<T> : Collection<T>{
    private val innerList = arrayListOf<T>()

    override fun contains(element: T): Boolean {
        return innerList.contains(element)
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        return innerList.containsAll(elements)
    }

    override fun isEmpty(): Boolean {
        return innerList.isEmpty()
    }

    override fun iterator(): Iterator<T> {
        return innerList.iterator()
    }

    override val size: Int = innerList.size

}

class DelegatingCollection<T>(
        innerList: Collection<T> = ArrayList()
) : Collection<T> by innerList{}


class CountingSet<T>(
        val innerSet: MutableCollection<T> = HashSet<T>()
) : MutableCollection<T> by innerSet{
    var objectAdded = 0

    override fun add(element: T): Boolean {
        objectAdded ++
        return innerSet.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        objectAdded += elements.size
        return innerSet.addAll(elements)
    }
}