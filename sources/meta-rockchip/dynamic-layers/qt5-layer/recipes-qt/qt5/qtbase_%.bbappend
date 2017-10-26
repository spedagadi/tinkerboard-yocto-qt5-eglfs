# Copyright (C) 2017 Fuzhou Rockchip Electronics Co., Ltd
# Released under the MIT license (see COPYING.MIT for the terms)

SRC_URI += "file://0008-qt5base-eglfs_kms-set-framebuffer-support-transparen.patch"

PACKAGECONFIG_GL   = "gles2"
PACKAGECONFIG_FONTS	= "fontconfig"

PACKAGECONFIG_APPEND = " \
	${@bb.utils.contains("DISTRO_FEATURES", "wayland", "xkbcommon-evdev", \
	   bb.utils.contains("DISTRO_FEATURES", "x11", " ", "libinput eglfs gbm", d), d)} \
"
PACKAGECONFIG_append = " ${PACKAGECONFIG_APPEND} kms accessibility sm"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
