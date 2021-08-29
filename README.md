# PomeloPickup

## Summary
- Overall architecture is MVVM + Clean Architecture (only separate layers into packages since it would take time to separate them into modules) 
- Use many of the [Android Jetpack](https://developer.android.com/jetpack)
  - [Data Binding](https://developer.android.com/topic/libraries/data-binding): Declaratively bind observable data to UI elements
  - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata): Notify views when underlying datasource changes
  - [Navigation](https://developer.android.com/guide/navigation/): Handle everything needed for in-app navigation
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel): Manage UI-related data in a lifecycle-conscious way
- Use [Koin](https://github.com/InsertKoinIO/koin) for dependency injection
- Use [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) for managing background threads with simplified code and reducing needs for callbacks
- Unit tests cover business logics in all layers including `presentation`, `domain` and `data`

## Activity
A simple app with the following features:
- The app should contain one screen
- Display a list of locations with name, city and address (use the following fields
from API `pickup.alias`, `pickup.address1`, `pickup.city`)
- Get the list of pickup locations from the API endpoint
  - Filter location by `active=true` 4. Add a button to the toolbar
  - Clicking the button should request for location permission and get the current user location.
- Sort locations by distance to the user location, closest location first, when the current location is available
