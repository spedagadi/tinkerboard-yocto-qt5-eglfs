# Copyright (C) 2017 Fuzhou Rockchip Electronics Co., Ltd
# Released under the MIT license (see COPYING.MIT for the terms)

PACKAGECONFIG_append = " networkd resolved"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " file://eth.network"

FILES_${PN} += " \
	${base_sbindir}/init \
	${sysconfdir}/systemd/network/eth.network \
"

do_install_append () {
	install -d ${D}/${base_sbindir}
	ln -s ${D}${exec_prefix}/lib/systemd ${D}${base_sbindir}/init

	if ${@bb.utils.contains('PACKAGECONFIG','networkd','true','false',d)}; then
		install -d ${D}${sysconfdir}/systemd/network
		install -m 0755 ${WORKDIR}/eth.network ${D}${sysconfdir}/systemd/network
	fi
}
