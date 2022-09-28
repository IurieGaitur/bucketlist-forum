package com.gnosis.bucketlistgroup.app.build

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
object AppModules {
    @Provides
    fun userApi: UserApi() {
        return Retrofit.Builder()
            .baseUrl("https://example.com")
            .build()
            .create(UserApi::class.java)
    }
}

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    fun provideAuthInterceptorOkHttpClient(
        authInterceptor: AuthInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .build()
    }
}

object RxModule {

    @Singleton
    @Provides
    fun rxBus: RxBus {
        return RxBus()
    }
}

object DataModule {

}
