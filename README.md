# Random User

* A Random User Application uses [RandomUser API](https://randomuser.me/documentation) based on Kotlin MVVM Clean architecture and simple design.
* A single-activity pattern, using the Navigation component to manage fragment operations.
* Reactive UIs using LiveData + Flow observables and Data Binding.
* Use different implementations of REST API libraries - Retrofit or Ktor.
* Use automated data classes mapping - DataStruct 
* In branch [master](https://github.com/antonykiev/Random-User/tree/master) is no DI
* In branch [di_koin](https://github.com/antonykiev/Random-User/tree/di_koin) used DI Koin
* In branch [di_dagger](https://github.com/antonykiev/Random-User/tree/di_dagger) used DI Dagger 2
* It consists of 3 fragments.


## Libraries
- 100% Kotlin + [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) + [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/)
- MVVM Clean Architecture
- Architecture Components (Lifecycle, LiveData, ViewModel, DataBinding, Navigation)
- [RandomUser API](https://randomuser.me/documentation)
- [MapStruct](https://mapstruct.org/) automated mapping of data classes 
- [Dagger2](https://github.com/google/dagger) for dependency injection
- [Ktor](https://ktor.io/) native kotlin HTTP client
- [Kotlin Serialization](https://kotlinlang.org/docs/serialization.html) native kotlin JSON serialization
- [Retrofit2 & Gson](https://github.com/square/retrofit) for REST API
- [Glide](https://github.com/bumptech/glide) for loading images
- [Timber](https://github.com/JakeWharton/timber) for logging

### Stable samples - Kotlin
|     Sample     | Description |
| ------------- | ------------- |
| [master](https://github.com/antonykiev/Random-User/tree/master) | In app used no DI |
| [di_koin](https://github.com/antonykiev/Random-User/tree/di_koin)| Dependency resolved by DI Koin |
| [di_dagger](https://github.com/antonykiev/Random-User/tree/di_dagger)| Dependency resolved by DI Dagger 2 |


## License
```xml
Copyright 2022 The Android Open Source Project, Inc.
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```