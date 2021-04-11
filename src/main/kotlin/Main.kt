import java.io.File

fun main() {
//    val desiredString = "בבא"
//    findWordInOneSefer(desiredString)
//    findWordInAllSeforim(desiredString)
}
fun findWordInOneSefer(desiredString:String){
    val tanachWordList = File("C:\\Users\\shmue\\OneDrive\\Desktop\\Sefaria Texts (Excluding Talmud and Tanaitic texts)\\Tanach\\Torah\\Genesis\\Hebrew\\just words.txt").readText().split(" ","-","\n")
    var accumulatedString = ""
    var i = 0
    while(i<tanachWordList.size){
        accumulatedString+=tanachWordList[i].first()
        i++
    }
    println(accumulatedString)
    if(accumulatedString.contains(desiredString)) println("$desiredString found, starting at index ${accumulatedString.indexOf(desiredString)}!")
}
fun findWordInAllSeforim(desiredString: String){
    val listOfChumashFiles = File("C:\\Users\\shmue\\OneDrive\\Desktop\\Sefaria Texts (Excluding Talmud and Tanaitic texts)\\Tanach\\Torah").walk().toList().filter{it.name=="Tanach with Text Only.txt"}
    val accumulatedString = StringBuilder()
    val listOfWords = mutableListOf<String>()
    listOfChumashFiles.forEach{listOfWords.addAll(it.readText().split("\n"," ","-"))}
    var i = 0
    while(i<listOfWords.size){
        accumulatedString.append(listOfWords[i].first())
        i+=10
    }
    if(accumulatedString.contains(desiredString)) println("$desiredString found, starting at index ${accumulatedString.indexOf(desiredString)}!")
}