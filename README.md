# Tinkerboard - QT5 Yocto (Console based)

This is a console based Yocto QT5 image for Tinkerboard using eglfs for rendering

Prebuilt toolchain/SDK https://drive.google.com/open?id=0B2aU6UdMlrQbRnpEMURhRW9Ebzg

Prebuilt OS image - https://drive.google.com/open?id=0B2aU6UdMlrQbQ0tTbE9VRHhDQjQ

## Building a fresh Yocto image

Browse to the cloned directory, then type

   $ . ./setup-environment
   
   $ bitbake core-image-base
   
The build/local.conf file in this repo adds a number of QT5 libraries and applications. All the example apps can be found under /usr/share/
To run each of the example apps pass **-platform eglfs** as additonal argument. 

EG:

   $ cd /usr/share/cinematicexperience-1.0
   
   $  ./Qt5_CinematicExperience -platform eglfs

For completeness, the instructions on building toolchain and preparing QTCreator are provided below ([source](http://rockchip.wikidot.com/yocto-user-guide-qt))

## Building tool chain 

   $ bitbake meta-toolchain-qt5
  
   $ apt-get install qtcreator
   
   $ sh <DISTRO>-glibc-x86_64-meta-toolchain-qt5-cortexa17hf-neon-vfpv4-toolchain-2.2.1.sh
   
   
## Configuring QTCreator

   $ cd /opt/<DISTRO>/2.2.1
   
   $ . ./environment-setup-cortexa17hf-neon-vfpv4-rk-linux-gnueabi
   
   $ qtcreator

In QtCreator go to Tools > Options > Devices and add "rockchip" as a generic linux device.
go to Tools > Options > Build & Run and:

* Add a new compiler. Select your compiler: /opt/<DISTRO>/2.2.1/sysroots/x86_64-rksdk-linux/usr/bin/arm-rk-linux-gnueabi/arm-rk-linux-gnueabi-g++
* Add your new cross compiled Qt version by selecting the qmake located in /opt/<DISTRO>/2.2.1/sysroots/x86_64-rksdk-linux/usr/bin/qt5
* Add a new kit selecting your new Qt5 version and compiler and setting the sysroot to /opt/<DISTRO>/2.2.1/sysroots/cortexa17hf-neon-vfpv4-rk-linux-gnueabi and set the Qt mkspec to "linux-oe-g++".
* Finally select your "rockchip" for the device. 
      
