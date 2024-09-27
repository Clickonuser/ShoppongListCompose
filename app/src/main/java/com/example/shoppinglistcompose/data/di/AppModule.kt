package com.example.shoppinglistcompose.data.di

import android.app.Application
import androidx.room.Room
import com.example.shoppinglistcompose.data.repository.MainListRepository
import com.example.shoppinglistcompose.data.repository.MainListRepositoryImpl
import com.example.shoppinglistcompose.data.repository.NoteRepository
import com.example.shoppinglistcompose.data.repository.NoteRepositoryImpl
import com.example.shoppinglistcompose.data.repository.ProductRepository
import com.example.shoppinglistcompose.data.repository.ProductRepositoryImpl
import com.example.shoppinglistcompose.data.room.MainDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideMainDataBase(app: Application): MainDataBase = Room.databaseBuilder(
        app,
        MainDataBase::class.java,
        "shopping_list_db"
    ).build()

    @Singleton
    @Provides
    fun provideMainListRepo(db: MainDataBase): MainListRepository {
        return MainListRepositoryImpl(db.mainListDao)
    }

    @Singleton
    @Provides
    fun provideProductRepo(db: MainDataBase): ProductRepository {
        return ProductRepositoryImpl(db.productDao)
    }

    @Singleton
    @Provides
    fun provideNoteRepo(db: MainDataBase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }
}