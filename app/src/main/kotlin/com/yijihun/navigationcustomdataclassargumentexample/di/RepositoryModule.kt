package com.yijihun.navigationcustomdataclassargumentexample.di

import com.yijihun.navigationcustomdataclassargumentexample.data.LectureRepository
import com.yijihun.navigationcustomdataclassargumentexample.data.LectureRepositoryImpl
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
