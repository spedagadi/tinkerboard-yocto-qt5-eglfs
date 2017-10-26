# Copyright (C) 2017 Fuzhou Rockchip Electronics Co., Ltd
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Set the application that will run automatically"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

USE_X11 = "${@bb.utils.contains("DISTRO_FEATURES", "x11", "yes", "no", d)}"
USE_WL = "${@bb.utils.contains("DISTRO_FEATURES", "wayland", "yes", "no", d)}"

SRC_URI = " \
	file://autostart-x11.sh \
	file://autostart-wayland.sh \
	file://autostart.sh \
	file://autostart.service \
"
S = "${WORKDIR}"

inherit systemd allarch update-rc.d

do_install() {
	install -d ${D}/${sysconfdir}/init.d

	if [ "${USE_WL}" = "yes" ]; then
		install -m 0755 ${S}/autostart-wayland.sh ${D}/${sysconfdir}/init.d/autostart.sh
	elif [ "${USE_X11}" = "yes" ]; then
		install -m 0755 ${S}/autostart-x11.sh ${D}/${sysconfdir}/init.d/autostart.sh
	else
		install -m 0755 ${S}/autostart.sh ${D}/${sysconfdir}/init.d/autostart.sh
	fi

    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${S}/autostart.service ${D}${systemd_unitdir}/system
}

RDEPENDS_${PN} = "bash"

INITSCRIPT_NAME = "autostart.sh"
INITSCRIPT_PARAMS = "start 100 5 3 ."

SYSTEMD_SERVICE_${PN} = "autostart.service"
