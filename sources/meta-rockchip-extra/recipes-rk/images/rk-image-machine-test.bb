# Copyright (C) 2017 Fuzhou Rockchip Electronics Co., Ltd
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "A image used for test and benchmark."

# dbg-pkgs
IMAGE_FEATURES += " \
	debug-tweaks \
	tools-testapps \
	tools-profile \
	tools-debug \
"

require recipes-rk/images/rk-image-multimedia.bb

AUTO_TEST_INSTALL = "\
	v4l-utils \
	glmark2 \
	cpufrequtils \
	usbutils \
	memtester \
	stress \
	libdrm-tests \
"

OTHERS_TEST_INSTALL = "\
    ${@bb.utils.contains("DISTRO_FEATURES", "x11 wayland", "", \
       bb.utils.contains("DISTRO_FEATURES",     "wayland", "", \
       bb.utils.contains("DISTRO_FEATURES",         "x11", "gtkperf", \
                                                           "", d), d), d)} \
"

# autotest
CORE_IMAGE_EXTRA_INSTALL += " \
	openssh \
	sshfs-fuse \
	dhcp-client \
	${AUTO_TEST_INSTALL} \
"
