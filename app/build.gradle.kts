plugins {
    id (BuildPlugins.androidApplication)
    id (BuildPlugins.kotlinAndroid)
    id (BuildPlugins.kotlinKapt)
    id ("kotlin-android-extensions")
}

android {
    compileSdkVersion (30)
    buildToolsVersion (AndroidSdk.buildToolsVersion)

    defaultConfig {
        applicationId = Config.applicationId
        minSdkVersion (AndroidSdk.min)
        targetSdkVersion (AndroidSdk.target)
        versionCode = Config.versionCode
        versionName = Config.versionName
        vectorDrawables.useSupportLibrary = true
        testInstrumentationRunner = MobileUITestDependencies.AndroidJunitRunner
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures.dataBinding = true
    buildFeatures.viewBinding = true

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {

    implementation(MobileUIDependencies.kotlinStdLib)
    implementation(MobileUIDependencies.ktxCore)
    implementation(MobileUIDependencies.appCompat)
    implementation(MobileUIDependencies.constraintLayout)
    implementation(MobileUIDependencies.materialDesign)
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.extra["kotlin_version"]}")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
//     KODEIN
    implementation ("org.kodein.di:kodein-di-generic-jvm:6.5.5")
    implementation ("org.kodein.di:kodein-di-framework-android-x:6.5.5")
//
//     navigation
    implementation ("androidx.navigation:navigation-fragment-ktx:2.3.2")
    implementation ("androidx.navigation:navigation-ui-ktx:2.3.2")
//
//     NETWORK MONITORING
    implementation ("com.facebook.stetho:stetho:1.5.1")
    implementation ("com.facebook.stetho:stetho-okhttp3:1.5.1")
//
    implementation ("com.github.haroldadmin:NetworkResponseAdapter:4.0.1")

    //‌BottomNavigation
    implementation ("com.github.ibrahimsn98:SmoothBottomBar:1.7.6")

    implementation(MobileUIDependencies.retrofit)
    implementation(MobileUIDependencies.retrofitCoroutineAdapter)
    implementation(MobileUIDependencies.gsonAdapter)
    implementation(MobileUIDependencies.googleGson)
    implementation(MobileUIDependencies.androidXPaging)
    implementation(MobileUIDependencies.loginInterceptor)
    implementation(MobileUIDependencies.androidXLegacy)
    implementation(MobileUIDependencies.kodeinGeneric)
    implementation(MobileUIDependencies.kodeinFragmework)
    implementation(MobileUIDependencies.glide)
    implementation(MobileUIDependencies.androidXLifeCycleExt)
    implementation(MobileUIDependencies.androidXViewModelKtx)
    implementation(MobileUIDependencies.androidxLiveDataKtx)
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.2.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")
    kapt(MobileUIDependencies.glideCompilerKpt)
    kapt(MobileUIDependencies.androidXLifecycleCompilerKapt)
    implementation(MobileUIDependencies.afollestadMaterialDialog)
    implementation(MobileUIDependencies.androidXNavigation)
    implementation(MobileUIDependencies.androidxNavigationKtx)
    implementation(MobileUIDependencies.lottie)
    implementation(MobileUIDependencies.smarteistImageSlider)
    implementation(MobileUIDependencies.chrisbanesPhotoView)
    implementation(MobileUIDependencies.networkResponseAdapter)
    implementation(MobileUIDependencies.floatingSearchView)
    implementation(MobileUIDependencies.zarrinpal)
    implementation(MobileUIDependencies.androidXBrowser)
    implementation(MobileUIDependencies.stetho)
    implementation(MobileUIDependencies.stethoOkHttp)
    implementation(MobileUIDependencies.androidXFragmentKtx)
    implementation(MobileUIDependencies.jalaliTimePicker)


}