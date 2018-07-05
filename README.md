# MAD-Minder -- Android note taking application

Hub description: This repository is a FH JOANNEUM students project for MobileApplicationDeveloment.

# Environment used

* Android Studio
* Windows 10 64bit

# Build gradle information

**Dependencies**
* implementation fileTree(dir: 'libs', include: ['*.jar'])
* implementation 'com.android.support:appcompat-v7:27.1.1'
* implementation 'com.android.support.constraint:constraint-layout:1.1.2'
* implementation 'com.android.support:support-v4:27.1.1'
* testImplementation 'junit:junit:4.12'
* androidTestImplementation 'com.android.support.test:runner:1.0.2'
* androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.2'
* implementation 'com.android.support:design:27.1.1'

*Verify if versions are compatible inside gradle app file before starting*

# Application features

The application starts with a splash screen. Which is a small introduction logo to generate a better user experience while starting the application.

MainActivity class contains a toolbar including an add button to create new notes. In the rest of the window a listview was implemented to render the created notes.

Tapping on a existing note opens a second activity where the user is able to manage the selected activity by changing it or marking it as done.

# Easter eggs

By shaking the MainActivity the background color of the listview will change.

# Storage

All user notes are stored on the internal device storage inside a SQLite database.