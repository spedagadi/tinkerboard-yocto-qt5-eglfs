require conf/distro/poky.conf

DISTRO = "rk-base"
DISTRO_NAME = "Rockchip Distro Base"
SDK_VENDOR = "-rksdk"

MAINTAINER = "Jacob Chen <jacob2.chen@rock-chips.com>"

TARGET_VENDOR = "-rk"

DISTROOVERRIDES = "rockchip"

# Rockchip BSP default settings

VIRTUAL-RUNTIME_init_manager = "systemd"

PREFERRED_VERSION_libdrm = "rk"
PREFERRED_VERSION_xserver-xorg = "rk"
PREFERRED_VERSION_xserver-nodm-init = "2.0"
XSERVER ?= "xserver-xorg \
		   xf86-input-libinput \
		   xf86-video-modesetting"

PREFERRED_PROVIDER_virtual/egl = "rockchip-mali"
PREFERRED_PROVIDER_virtual/libgles1 = "rockchip-mali"
PREFERRED_PROVIDER_virtual/libgles2 = "rockchip-mali"
PREFERRED_PROVIDER_virtual/libopencl = "rockchip-mali"

DEFAULTTUNE_rk3036="cortexa7hf-neon-vfpv4"
DEFAULTTUNE_rk3288="cortexa17hf-neon-vfpv4"
DEFAULTTUNE_rk3328="aarch64"
DEFAULTTUNE_rk3399="aarch64"

LICENSE_FLAGS_WHITELIST="commercial"