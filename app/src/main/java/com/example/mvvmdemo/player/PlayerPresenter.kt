package com.example.mvvmdemo.player

import com.example.mvvmdemo.player.domain.Music

/**
 *on 2022/2/15
 *com.example.mvvmdemo.player
 *播放音乐
 *暂停音乐
 * 上一首
 * 下一首
 *
 * 播放的状态：
 * -通知UI改变成播放状态
 * -通知UI进度的变化
 * 上一首，下一首
 * -通知UI歌曲标题变化
 * -通知UI歌曲封面变化
 * 暂停音乐
 * -更新UI状态为暂停
 *
 *
 * 相关数据：
 * 当前播放的歌曲
 * 当前播放的状态
 */
class PlayerPresenter private constructor(){

    private val playerModel by lazy{
        PlayerModel()
    }

    private val player by lazy {
        MusicPlayer()
    }

//    private var currentMusic: Music?=null
    var currentMusic=DataListenContainer<Music>()

    //当前状态
//    private var currentPlayState=PlayState.NONE
    var currentPlayState=DataListenContainer<PlayState>()

    companion object{
        val instance by lazy {
           PlayerPresenter()
        }
    }

    enum class PlayState{
        NONE,PLAYING,PAUSE,LOADING
    }

//    private val callbacksList= arrayListOf<IPlayerCallback>()

//    fun registerCallback(callback: IPlayerCallback){
//        if(!callbacksList.contains(callback)){
//            callbacksList.add(callback)
//        }
//    }
//    //解除绑定
//    fun unregisterCallbck(callback: IPlayerCallback){
//        callbacksList.remove(callback)
//    }

    /**
     * 根据状态控制音乐播放还是暂停
     */

    fun doPlayOrPause(){
        if(currentMusic.value==null){
            //去获取一首歌曲
            currentMusic.value=playerModel.getMusicById("卡农")
        }
        player.play(currentMusic.value)
//        dispatchTitleChange("当前播放的歌曲标题...")
//        dispatchCoverChange("当前播放的歌曲封面...")
        if (currentPlayState.value!=PlayState.PLAYING){
            //开始播放音乐
            //TODO:
//            dispatchPlayingState()
            currentPlayState.value=PlayState.PLAYING
        }else{
            //暂停播放
            currentPlayState.value=PlayState.PAUSE
//            dispatchPlayerPauseState()
        }
    }

//    private fun dispatchPlayerPauseState(){
//        callbacksList.forEach{
//            it.onPlayerPause()
//        }
//    }
//
//    private fun dispatchPlayingState(){
//        callbacksList.forEach{
//            it.onPlaying()
//        }
//    }

    /**
     * 下一首
     */
    fun playNext() {
        currentMusic.value=playerModel.getMusicById("下一首:梦中的婚礼")
        //TODO:播放下一首内容
        //1.拿到下一首歌曲-->变更UI，包括标题和封面
//        dispatchTitleChange("切换到下一首，标题变化了...")
//        dispatchCoverChange("切换到下一首，封面变化了...")
        //2.设置给播放器
        //3.等待播放的时间回调通知
        currentPlayState.value=PlayState.PLAYING
    }

//    private fun dispatchTitleChange(title:String){
//        callbacksList.forEach{
//            it.onTitleChange(title)
//        }
//    }
//
//    private fun dispatchCoverChange(cover:String){
//        callbacksList.forEach{
//            it.onCoverChange(cover)
//        }
//    }

    /**
     * 上一首
     */
    fun playPre() {
        currentMusic.value=playerModel.getMusicById("上一首:圣母颂")
        //1.拿到上一首歌曲-->变更UI，包括标题和封面
//        dispatchTitleChange("切换到上一首，标题变化了...")
//        dispatchCoverChange("切换到上一首，封面变化了...")
        //2.设置给播放器
        //3.等待播放的时间回调通知
        currentPlayState.value=PlayState.PLAYING
    }
}