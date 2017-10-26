DESCRIPTION = "Rockchip binary loader"

LICENSE = "BINARY"
LIC_FILES_CHKSUM = "file://LICENSE.TXT;md5=564e729dd65db6f65f911ce0cd340cf9"
NO_GENERIC_LICENSE[BINARY] = "LICENSE.TXT"

DEPENDS = "rk-binary-native"

SRC_URI = "git://github.com/rockchip-linux/rkbin.git"
SRCREV = "76ec4622c56a5d077b9cfa0548d3dd4f494e71f5"
S = "${WORKDIR}/git"

LOADER_rk3399 ?= "rk33/rk3399_loader_*.bin"

MINILOADER_rk3328 ?= "rk33/rk3328_miniloader_*.bin"
MINILOADER_rk3399 ?= "rk33/rk3399_miniloader_*.bin"

DDR_rk3328 ?= "rk33/rk3328_ddr_786MHz_*.bin"
DDR_rk3399 ?= "rk33/rk3399_ddr_800MHz_*.bin"

inherit deploy

DDR_BIN = "ddr.bin"
LOADER_BIN = "loader.bin"
MINILOADER_BIN = "miniloader.bin"
ATF_BIN = "atf.bin"
UBOOT_IMG = "uboot.img"
TRUST_IMG = "trust.img"

do_deploy () {
	install -d ${DEPLOYDIR}
	[ ${DDR} ] && cp ${S}/${DDR} ${DEPLOYDIR}/${DDR_BIN}
	[ ${MINILOADER} ] && cp ${S}/${MINILOADER} ${DEPLOYDIR}/${MINILOADER_BIN}
	[ ${LOADER} ] && cp ${S}/${LOADER} ${DEPLOYDIR}/${LOADER_BIN}
	[ ${ATF} ] && cp ${S}/${ATF} ${DEPLOYDIR}/${ATF_BIN}

	# Don't remove it!
	echo "done"
}

deploy_prebuilt_image () {
	install -d ${DEPLOYDIR}
	[ -e {S}/img/${SOC_FAMILY}/${UBOOT_IMG} ] && cp ${S}/img/${SOC_FAMILY}/${UBOOT_IMG} ${DEPLOYDIR}/${UBOOT_IMG}
	[ -e ${S}/img/${SOC_FAMILY}/${TRUST_IMG}  ] && cp ${S}/img/${SOC_FAMILY}/${TRUST_IMG} ${DEPLOYDIR}/${TRUST_IMG}
}

do_deploy_append_rk3328 () {
	deploy_prebuilt_image
	dd if=${DEPLOYDIR}/${DDR_BIN} of=${DEPLOYDIR}/TMP bs=4 skip=1
	mv ${DEPLOYDIR}/TMP ${DEPLOYDIR}/${DDR_BIN}
}

do_deploy_append_rk3399 () {
	deploy_prebuilt_image
}

addtask deploy before do_build after do_compile

do_package[noexec] = "1"
do_packagedata[noexec] = "1"
do_package_write[noexec] = "1"
do_package_write_ipk[noexec] = "1"
do_package_write_rpm[noexec] = "1"
do_package_write_deb[noexec] = "1"
do_package_write_tar[noexec] = "1"
