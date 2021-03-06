package com.example.mvvmdemo.player

/**
 * 数据容器
 * 可以监听数据的变化
 */
class DataListenContainer<T> {

    private val blocks= arrayListOf<(T?)->Unit>()

    var value:T?=null

    //当数据变化的时候通知更新
    set(value:T?){
        blocks.forEach{it.invoke(value)}
    }

    fun addListener(block:(T?)->Unit){
        if (!blocks.contains(block)){
            blocks.add(block)
        }
    }
}