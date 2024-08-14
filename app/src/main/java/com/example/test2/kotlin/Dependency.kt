package com.example.test2.kotlin

class Dependency {
    val libraries = ArrayList<String>()
    fun implementation(lib:String){
        libraries.add(lib)
    }


}
fun dependencies(block:Dependency.() -> Unit):List<String>{
    val dependency = Dependency()
    dependency.block()
    return dependency.libraries
}

class Td{ //DSL
    var content = ""
    fun html() = "\n\t\t<td>$content</td>"
}

class Tr{
    private val children = ArrayList<Td>()
    fun td(block:Td.() -> String){
        val td = Td()
        td.content = td.block()
        children.add(td)
    }

    fun html():String{
        val builder = StringBuilder()
        builder.append("\n\t<tr>")
        for(childTag in children){
            builder.append(childTag.html())
        }
        builder.append("\n\t</tr>")
        return builder.toString()
    }
}

fun main(args: Array<String>) {
    val libraries = dependencies {
        implementation("com.sqasjdlfajsdljalsj:1")
        implementation("com.sqasjdlfajsdljalsj:3")
    }
    for (lib in libraries){
        println(lib)
    }

    val tr = Tr()
    tr.td { "111" }
    tr.td { "222" }
    tr.td { "333" }
}