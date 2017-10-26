# Copyright (C) 2016 - 2017 Jacob Chen <jacob2.chen@rock-chips.com>
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Rockchip firmware"
DESCRIPTION = "Rockchip firmware such as for the WIFI, BT"

LICENSE = "proprietary-binary"
LIC_FILES_CHKSUM = "file://LICENSE.TXT;md5=564e729dd65db6f65f911ce0cd340cf9"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/rockchip-linux/rkbin.git"
S = "${WORKDIR}/git"

inherit allarch

do_install () {
	install -d ${D}/system/etc/firmware/
	cp -rf ${S}/firmware/wifi/* ${D}/system/etc/firmware/

	install -d ${D}/etc/firmware/
	cp -rf ${S}/firmware/bluetooth/*.hcd ${D}/etc/firmware/
}

PACKAGES =+ "${PN}-wifi \
	${PN}-bt \
"

FILES_${PN}-wifi = "/system/etc/*"
FILES_${PN}-bt = "/etc/firmware/*"