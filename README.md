## MVC
Reactive Programming paradigms and `android.arch.lifecycle.ViewModel` allow for the following changes to MVC on Android:

* UI elements listen to a ViewModel and ONLY update themselves when something changes.
* Controllers listen for UI interactions and update the ViewModel accordingly.
* Controllers hold a reference to a ViewModel rather than a View
* Controllers only ever respond to ui interactions, a UI can not ask the controller to do something.

```
                                Emit change
           ----------------------------------------------------
          |                                                    |
          |                                                    |
          |                                                    |
  --------v--------          ----------------          ----------------
 |                 |        |                |        |                |
 |                 |        |                |        |                |
 |                 |        |                |        |                |
 |                 |        |                |        |                |
 |     (Model)     | Listen |     (View)     |        |  (Controller)  |
 |    ViewModel    *--------|    Activity    |        |                |
 |                 |        |                |        |                |
 |                 |        |                |        |                |
 |                 |        |                |        |                |
 |                 |        |                |        |                |
  -----------------          -------*--------          ----------------
                                    |                          |
                                    |                          |
                                    |                          |
                                     --------------------------
                                     Listen for UI interactions

 ```

 ### Unit testing
 The behaviour of the ViewModel can be easily tested, please see `com.memtrip.mvmp.presenter.app.cake.CakeControllerTests.java`