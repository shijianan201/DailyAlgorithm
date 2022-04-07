package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_146 : IAlgorithmExecutor {

    override fun execute() {
        val cache = LRUCache(2)
        cache.put(1, 1)
        cache.put(2, 2)
        cache.get(1)
        cache.put(3, 3)
        cache.get(2)
        cache.put(4, 4)
        cache.get(1)
        cache.get(3)
        cache.get(4)
    }
}

class LRUCache(capacity: Int) {

    private val mCap = capacity
    private val map: HashMap<Int, Entry> = HashMap(capacity)
    private var head: Entry = Entry(-1, -1)
    private var tail: Entry = Entry(-1, -1)

    init {
        head.next = tail
        tail.prev = head
    }

    fun deleteRealHead(entry: Entry) {
        head.next = entry.next
        entry.next?.prev = head
        entry.prev = null
        entry.next = null
    }

    fun deleteEntry(entry: Entry){
        entry.prev?.next = entry.next
        entry.next?.prev = entry.prev
        entry.next = null
        entry.prev = null
    }

    fun add2tail(entry: Entry){
        entry.next = tail
        entry.prev = tail.prev
        tail.prev?.next = entry
        tail.prev = entry
    }

    fun get(key: Int): Int {
        val entry = map.get(key)
        if (entry == null) {
            return -1
        }
        deleteEntry(entry)
        add2tail(entry)
        return entry.value
    }

    fun put(key: Int, value: Int) {
        val entry = map.get(key)
        val size = getSize()
        if (entry == null) {
            val newEntry = Entry(key,value)
            map.put(key,newEntry)
            add2tail(newEntry)
            if(size >= mCap){
                //满了
                map.remove(head.next?.key!!)
                deleteRealHead(head.next!!)
            }
        }else{
            entry.value = value
            deleteEntry(entry)
            add2tail(entry)
        }
    }

    fun getSize(): Int {
        return map.size
    }

    inner class Entry(val key: Int, var value: Int, var prev: Entry? = null, var next: Entry? = null)
}