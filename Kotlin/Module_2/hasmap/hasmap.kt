class hasmap {


    fun hasmap() {
        //A simple example of HashMap class define
        // with empty "HashMap of <String, Int>"
        var hashMap : HashMap<String, Int>
                = HashMap<String, Int> ()

        //printing the Empty hashMap
        printHashMap(hashMap)

        //adding elements to the hashMap using
        // put() function
        hashMap.put("IronMan" , 3000)
        hashMap.put("Thor" , 100)
        hashMap.put("SpiderMan" , 1100)
        hashMap.put("NickFury" , 1200)
        hashMap.put("HawkEye" , 1300)

        //printing the non-Empty hashMap
        printHashMap(hashMap)
        //using the overloaded print function of
        //Kotlin language to get the same results
        println("hashMap : " + hashMap + "\n")

        //hashMap traversal using a for loop
        for(key in hashMap.keys){
            println("Element at key $key : ${hashMap[key]}")
        }

        //creating another hashMap object with
        // the previous version of hashMap object
        var secondHashMap : HashMap<String, Int>
                = HashMap<String, Int> (hashMap)

        println("\n" + "Second HashMap : ")
        for(key in secondHashMap.keys){
            //using hashMap.get() function to fetch the values
            println("Element at key $key : ${hashMap.get(key)}")
        }

        //this will clear the whole map and make it empty
        println("hashMap.clear()")
        hashMap.clear()

        println("After Clearing : " + hashMap)


    }

    //function to print the hashMap
    fun printHashMap(hashMap : HashMap<String, Int>){
        // isEmpty() function to check whether
        // the hashMap is empty or not
        if(hashMap.isEmpty()){
            println("hashMap is empty")
        }else{
            println("hashMap : " + hashMap)
        }
    }
}