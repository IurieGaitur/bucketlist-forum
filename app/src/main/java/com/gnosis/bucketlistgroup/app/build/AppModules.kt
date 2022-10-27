package com.gnosis.bucketlistgroup.app.build

import android.content.Context
import com.gnosis.bucketlistgroup.data.api.WishesApi
import com.gnosis.bucketlistgroup.data.db.AppDatabase
import com.gnosis.bucketlistgroup.data.db.RoomDB
import com.gnosis.bucketlistgroup.data.db.WishesRepository
import com.gnosis.bucketlistgroup.util.AppRxSchedulers
import com.gnosis.bucketlistgroup.util.RxBus
import com.gnosis.bucketlistgroup.util.RxSchedulers
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModules {


    @Singleton
    @Provides
    fun gson(): Gson {
        val builder = GsonBuilder()
        return builder.create()
    }
}

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class IoDispatcher

@Module
@InstallIn(SingletonComponent::class)
object DispatcherModule {
    @IoDispatcher
    @Provides
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO
}

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun okHttpClient(cache: Cache): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .cache(cache)
            .build()
    }

    @Provides
    fun cache(@ApplicationContext appContext: Context, @Named("OkHttpCacheDir") cacheDir: String, @Named(
        "OkHttpCacheSize") cacheSize: Int): Cache {
        return Cache(File(appContext.filesDir, cacheDir), cacheSize.toLong())
    }

    @Provides
    @Named("OkHttpCacheDir")
    fun cacheDir(): String {
        return "OkHttpCache"
    }

    @Provides
    @Named("OkHttpCacheSize")
    fun cacheSize(): Int {
        return 10 * 1024 * 1024 //10MB cache
    }
}

@Module
@InstallIn(SingletonComponent::class)
object RestModule {

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient,
                        rxSchedulers: RxSchedulers): Retrofit {

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("https://ad1bc7ca-72f1-4d8d-9cf4-3d440bd08436.mock.pstmn.io/")
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun wishesApi(retrofit: Retrofit): WishesApi {
        return retrofit.create(WishesApi::class.java)
    }
}

@Module
@InstallIn(SingletonComponent::class)
object RxModule {

    @Singleton
    @Provides
    fun rxBus(): RxBus {
        return RxBus()
    }

    @Singleton
    @Provides
    fun rxSchedulers(): RxSchedulers {
        return AppRxSchedulers()
    }
}

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun appDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return RoomDB(appContext).appDatabase
    }

    @Singleton
    @Provides
    fun wishesRepository(appDatabase: AppDatabase, rxSchedulers: RxSchedulers): WishesRepository {
        return WishesRepository(appDatabase, rxSchedulers)
    }
}
