package com.arentator.domain.executor

import io.reactivex.Scheduler

/**
 * Created by Nikolay on 18.02.2018.
 */
interface PostExecutionThread {
    val scheduler: Scheduler
}