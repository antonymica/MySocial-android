package com.tamimt.mysocial.models

class Post {
    var postUrl:String=""
    var caption:String=""
    var uid:String=""
    var time:String=""
    constructor()
    constructor(postUrl: String, caption: String) {
        this.postUrl = postUrl
        this.caption = caption
    }

    constructor(postUrl: String, caption: String, uid: String, time: String) {
        this.postUrl = postUrl
        this.caption = caption
        this.uid = uid
        this.time = time
    }


}