# Copyright (C) 2017 Fuzhou Rockchip Electronics Co., Ltd
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Rockchip CarMachine Demo."
DESCRIPTION = "It will search video files under /mnt."

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = " \
	git://github.com/rockchip-linux/carmachine.git;branch=master \
	file://0001-don-t-use-frameless-for-mainwindow.patch \
"

SRCREV = "a0d58f32136d7875d8e9cbcc6fbbbfe182305e3c"

S = "${WORKDIR}/git"

DEPENDS = "qtdeclarative qtgraphicaleffects qtmultimedia qtconnectivity"

require recipes-qt/qt5/qt5.inc

FILES_${PN}-dbg += "${datadir}/${P}/.debug"
FILES_${PN} += "${datadir}"
