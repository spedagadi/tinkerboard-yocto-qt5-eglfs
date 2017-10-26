# Copyright (C) 2017 Fuzhou Rockchip Electronics Co., Ltd
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Autotest client"
DESCRIPTION = "Fully automated testing under linux"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=46bdd99511e3434a768b5e0998fe295a"

SRC_URI = "git://github.com/autotest/autotest.git;name=autotest \
	gitsm://github.com/rockchip-linux/autotest-client-tests.git;destsuffix=git/client/tests;name=autotest-client-tests"
SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"

inherit allarch

do_install () {
	install -d ${D}/usr/local/autotest
	cp -rf ${S}/* ${D}/usr/local/autotest
}

PACKAGES = "${PN}"

PACKAGE_ARCH = "all"

FILES_${PN} = "/usr/local/autotest"

RDEPENDS_${PN} = "python python-modules"

QAPATHTEST[arch] = ""