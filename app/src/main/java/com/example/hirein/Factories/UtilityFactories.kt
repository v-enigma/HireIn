package com.example.hirein.Factories

import com.example.hirein.data.db.entity.Follower

fun  followerFactory(userId:Long, followerId:Long): Follower{
    return Follower(userId,followerId)
}