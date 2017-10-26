# Copyright (C) 2017 Fuzhou Rockchip Electronics Co., Ltd
# Released under the MIT license (see COPYING.MIT for the terms)

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
FILESPATH_prepend := "${THISDIR}/${PN}:"

SRC_URI_append += " \
	file://weston.ini \
	file://1003-compositor-set-DEFAULT_REPAINT_WINDOW-15.patch \
"

do_install_append() {
	WESTON_INI_CONFIG=${sysconfdir}/xdg/weston
	install -d ${D}${WESTON_INI_CONFIG}
	install -m 0644 ${WORKDIR}/weston.ini ${D}${WESTON_INI_CONFIG}/weston.ini
}

PACKAGES += "${PN}-ini"

FILES_${PN}-ini = "${sysconfdir}/xdg"
