const val kotlinVersion = "1.3.71"
const val coroutineVersion = "1.0.1"

object Config{
    const val applicationId = "com.videostreamshows"
    const val versionCode = 1
    const val versionName = "1.0"
}

object BuildPlugins {

    object Versions {
        const val buildToolsVersion = "3.6.2"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"

    // domain plugins
    const val kotlin = "kotlin"
    const val javaLibrary = "java-library"
    const val kotlinKapt = "kotlin-kapt"
    const val kotlinExt = "kotlin-android-extensions"
    const val kotlinSafeArgs = "androidx.navigation.safeargs.kotlin"
}


object AndroidSdk {
    const val min = 23
    const val compile = 30
    const val target = compile
    const val buildToolsVersion = "29.0.3"
}

object MobileUIDependencies{
    private object Versions {
        const val jetpack = "1.0.0-beta01"
        const val constraintLayout = "1.1.2"
        const val ktx = "1.1.0-alpha05"
        const val material = "1.2.1"

        const val kotlin_version = "1.3.72"
        const val coroutines_version = "1.0.1"
        const val app_compat_version = "1.1.0-beta01"
        const val constraint_layout_version = "2.0.0-rc1"
        const val koin_version = "1.0.2"
        const val glide_version = "4.9.0"
        const val android_material_version = "1.2.1"
        const val retrofit_version = "2.9.0"
        const val retrofit_coroutines_adapter_version = "0.9.2"
        const val retrofit_gson_adapter_version = "2.9.0"
        const val gson_version = "2.8.5"
        const val pagination_version = "2.1.0"
        const val okhttp_version = "3.12.1"
        const val material_dialog_version = "2.0.0-rc7"
        const val kodein_version = "5.2.0"
        const val lifecycle_version = "2.0.0"
        const val room_version = "2.2.5"
        const val browser = "1.0.0"
        const val zarrin_pal = "0.0.10"
        const val floatin_search_bar = "2.1.1"
        const val network_response_adapter = "4.0.1"
        const val multidex = "1.0.3"
        const val firebase_crashlytics = "17.2.2"
        const val firebase_analytics = "17.5.0"
        const val material_button = "1.2.5"
        const val photo_view = "2.3.0"
        const val auto_image_slider = "1.3.2"
        const val lottie_animation = "3.5.0"
        const val navigation =  "2.2.1"
        const val room = "2.2.5"
        const val legcy_support = "1.0.0"
        const val life_cycle = "2.2.0"
    }

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.jetpack}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val ktxCore = "androidx.core:core-ktx:${Versions.ktx}"
    const val materialDesign = "com.google.android.material:material:${Versions.material}"

    // NETWORK
    const val retrofit =  "com.squareup.retrofit2:retrofit:${Versions.retrofit_version}"
    const val retrofitCoroutineAdapter = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.retrofit_coroutines_adapter_version}"
    const val gsonAdapter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit_gson_adapter_version}"
    // GSON
    const val googleGson =  "com.google.code.gson:gson:${Versions.gson_version}"
    const val androidXPaging = "androidx.paging:paging-runtime:${Versions.pagination_version}"
    // OKHTTP
    const val loginInterceptor =  "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp_version}"
    const val androidXLegacy = "androidx.legacy:legacy-support-v4:1.0.0"

    // KODEIN
    const val kodeinGeneric = "org.kodein.di:kodein-di-generic-jvm:${Versions.kodein_version}"
    const val kodeinFragmework =  "org.kodein.di:kodein-di-framework-android-x:${Versions.kodein_version}"

    // Glide
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide_version}"

    const val androidXLifeCycleExt = "androidx.lifecycle:lifecycle-extensions:${Versions.life_cycle}"
    const val androidXViewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.life_cycle}"
    const val androidxLiveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.life_cycle}"
    const val glideCompilerKpt =  "com.github.bumptech.glide:compiler:${Versions.glide_version}"
    // ViewModel
    const val androidXLifecycleCompilerKapt = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle_version}"

    // MATERIAL DIALOG
    const val  afollestadMaterialDialog = "com.afollestad.material-dialogs:core:${Versions.material_dialog_version}"

    // navigation
    const val  androidXNavigation =  "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val  androidxNavigationKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    // lottie
    const val lottie =  "com.airbnb.android:lottie:${Versions.lottie_animation}"
    // Image Slider
    const val  smarteistImageSlider = "com.github.smarteist:autoimageslider:${Versions.auto_image_slider}"

    // zoom image
    const val  chrisbanesPhotoView = "com.github.chrisbanes:PhotoView:${Versions.photo_view}"


    // NetworkCallAdapter
    const val networkResponseAdapter =  "com.github.haroldadmin:NetworkResponseAdapter:${Versions.network_response_adapter}"

    // SEARCH
    const  val floatingSearchView =  "com.github.arimorty:floatingsearchview:${Versions.floatin_search_bar}"

    // ZARRIN PAL -- Payment
    const val zarrinpal =  "com.zarinpal:purchase:${Versions.zarrin_pal}"

    // BRIWSER
    const val androidXBrowser =  "androidx.browser:browser:${Versions.browser}"

    // NETWORK MONITORING
    const val  stetho =        "com.facebook.stetho:stetho:1.5.1"
    const val  stethoOkHttp = "com.facebook.stetho:stetho-okhttp3:1.5.1"

    // MEMORY LEAK
//    debugImplementation "com.squareup.leakcanary:leakcanary-android:2.5"

    // INPUT VALIDATION
    const val awesomeValidation =  "com.basgeekball:awesome-validation:4.2"

    // jalali date picker
    const val jalaliTimePicker =  "ir.scriptestan.jalalimaterialdatetimepicker:library:0.1.2"

    const val androidXFragmentKtx =  "androidx.fragment:fragment-ktx:1.3.0-beta01"

    // IMAGE COMPOSER
    const val composer =  "id.zelory:compressor:3.0.0"

    const val imageSlider = "com.github.smarteist:autoimageslider:1.3.2"
    const val exoPlayer = "com.google.android.exoplayer:exoplayer:2.13.1"


}
object MobileUITestDependencies{
    const val AndroidJunitRunner = "androidx.test.runner.AndroidJUnitRunner"
}
