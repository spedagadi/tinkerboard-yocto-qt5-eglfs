# Copyright (C) 2016 - 2017 Jacob Chen <jacob2.chen@rock-chips.com>
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Memory accesses tool"
DESCRIPTION = "Simple app to do memory accesses via /dev/mem."

LICENSE = "CLOSED"

SRCBRANCH = "master"
SRCREV = "56e9d7661f2e7ae9818e6fc22f38a222867f2076"
SRC_URI = "git://github.com/rockchip-linux/io.git;branch=${SRCBRANCH}"
S = "${WORKDIR}/git"

do_compile() {
	cd ${S}
	${CC} io.c -o io
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${S}/io ${D}${bindir}
}

INSANE_SKIP_${PN} = "ldflags"