package com.yijihun.navigationparcelableargumentexample.di

import com.yijihun.navigationparcelableargumentexample.data.LectureRepository
import com.yijihun.navigationparcelableargumentexample.data.LectureRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
internal abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindLectureRepository(lectureRepositoryImpl: LectureRepositoryImpl): LectureRepository
}
