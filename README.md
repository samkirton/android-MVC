## MVMP
The MVMP (Model View Model Presenter) pattern is derived from the MVP pattern, it continues to separate interface logic from how data is represented on the screen. However, Reactive Programming paradigms and `android.arch.lifecycle.ViewModel` allow for the following changes:

* UI elements listen to a ViewModel and ONLY update themselves when something changes.
* Presenters listen for UI interactions and update the ViewModel accordingly.
* Presenters hold a reference to a ViewModel rather than a View
* Presenters only ever respond to ui interactions, a UI can not ask the presenter to do something.

```
 ----------------                -------------                 -------------
|                |              |             |               |             |
|                |              |             |               |             |
|                |              |             |               |             |
|                |     Listen   |             |    Emit change|             |
|    Activity    +------------* |  ViewModel  | <-------------+  Presenter  |
|                |              |             |               |             |
|                |              |             |               |             |
|                |              |             |               |             |
 ------+---------                -------------                 ------+------
       *                                                             |
       |                  Listen for ui interactions                 |
       +-------------------------------------------------------------+

 ```