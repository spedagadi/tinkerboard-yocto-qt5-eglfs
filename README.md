# Tinkerboard - QT5 Yocto (Console based)

This is a console based Yocto QT5 image for Tinkerboard using eglfs for rendering

## Building a fresh Yocto image

Browse to the cloned directory, then type

   $ . ./setup-environment
   
   $ bitbake core-image-console
   
The build/local.conf file in this repo adds a number of QT5 libraries and applications. All the example apps can be found under /usr/share/
To run each of the example apps pass **-platform eglfs** as additonal argument. 

EG:

   $ cd /usr/share/cinematicexperience-1.0
   
   $  ./Qt5_CinematicExperience -platform eglfs
