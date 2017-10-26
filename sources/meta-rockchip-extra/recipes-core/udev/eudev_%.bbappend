FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
	file://11-udisk-auto-mount.rules \
	file://12-sdcard-auto-mount.rules \
"

do_install_append () {
	install -m 0755 ${WORKDIR}/11-udisk-auto-mount.rules ${D}${sysconfdir}/udev/rules.d/11-udisk-auto-mount.rules
	install -m 0755 ${WORKDIR}/12-sdcard-auto-mount.rules ${D}${sysconfdir}/udev/rules.d/12-sdcard-auto-mount.rules
}
