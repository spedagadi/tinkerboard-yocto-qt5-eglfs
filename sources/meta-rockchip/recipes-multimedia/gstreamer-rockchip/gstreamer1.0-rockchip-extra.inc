# Copyright (C) 2017 Fuzhou Rockchip Electronics Co., Ltd
# Released under the GNU GENERAL PUBLIC LICENSE Version 2
# (see COPYING.GPLv2 for the terms)

require recipes-multimedia/gstreamer/gstreamer1.0-plugins.inc

DESCRIPTION = "GStreamer 1.0 extra plugins for Rockchip platforms"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=6d1e4aa87f6192354d3de840cf774d93"
DEPENDS += "gstreamer1.0-plugins-bad"

inherit gettext autotools pkgconfig

PACKAGECONFIG ??= " \
	kms             \
	rkv4l2			\
	${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'rkximage', '', d)} \
"
PACKAGECONFIG[rkximage]	= "--enable-rkximage,--disable-rkximage,libdrm"
PACKAGECONFIG[kms]		= "--enable-kms,--disable-kms,libdrm"
PACKAGECONFIG[rkv4l2]	= "--enable-rkv4l2,--disable-rkv4l2,libv4l"

EXTRA_OECONF_remove = "--disable-gtk-doc"

do_configure[prefuncs] = " delete_pkg_m4_file"

do_configure() {
	NOCONFIGURE=true ${S}/autogen.sh
	oe_runconf
}
