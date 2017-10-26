# Copyright (C) 2017 Fuzhou Rockchip Electronics Co., Ltd
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Rockchip base Image."

IMAGE_FEATURES += "\
	package-management \
	${@bb.utils.contains("DISTRO_FEATURES", "x11 wayland", "", \
	   bb.utils.contains("DISTRO_FEATURES", "x11", "x11-base", "", d), d)} \
"

LICENSE = "MIT"

inherit core-image

TASK_INSTALL = " \
	96boards-tools \
	dvfs-rules \
"

RF_INSTALL = " \
	brcm-patchram-plus \
	firmware-rk-wifi \
	firmware-rk-bt \
"

CORE_IMAGE_EXTRA_INSTALL += " \
	io \
	${TASK_INSTALL} \
	${RF_INSTALL} \
	${@bb.utils.contains("DISTRO_FEATURES", "x11 wayland", "xserver-xorg-xwayland weston-xwayland", "", d)} \
	${@bb.utils.contains("DISTRO_FEATURES", "wayland", "weston weston-init weston-examples weston-ini", "", d)} \
"
