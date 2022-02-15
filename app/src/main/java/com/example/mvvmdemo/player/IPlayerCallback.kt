package com.example.mvvmdemo.player

/**
 *on 2022/2/15
 *com.example.mvvmdemo.player
 */
interface IPlayerCallback {
    //标题改变
    fun onTitleChange(title:String)
    //进度改变
    fun onProgressChange(current:Int)
    //播放状态
    fun onPlaying()
    fun onPlayerPause()
    fun onCoverChange(cover:String)
}