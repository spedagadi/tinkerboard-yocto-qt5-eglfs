# Copyright (C) 2014 NEO-Technologies
# Copyright (C) 2017 Fuzhou Rockchip Electronics Co., Ltd
# Released under the MIT license (see COPYING.MIT for the terms)

inherit image_types

# This image depends on the rootfs ext4 image
IMAGE_TYPEDEP_rockchip-update-img = "ext4"

# WORKROUND: miss recipeinfo
do_image_rockchip_update_img[depends] += " \
	rk-binary-loader:do_populate_lic"

do_image_rockchip_update_img[depends] += " \
	rk-binary-native:do_populate_sysroot \
	rk-binary-loader:do_deploy \
	virtual/kernel:do_deploy"

FIRMWARE_VER ?= "1.0"
MANUFACTURER ?= "Rockchip"
MACHINE_MODEL?= "${MACHINE}"

ATAG_rk3288 ?= "0x60000800"
CMDLINE_rk3288 ?= "console=ttyS2,115200n8 root=/dev/mmcblk2p6 rw rootfstype=ext4 init=/sbin/init"
MTDPARTS_rk3288 ?= "0x00002000@0x00002000(uboot),0x00002000@0x00004000(misc),0x00001000@0x00006000(resource),0x00007000@0x00007000(kernel),0x00010000@0x0000E000(boot),-@0x0001e000(linuxroot)"

ATAG_rk3399 ?= "0x00200800"
CMDLINE_rk3399 ?= "androidboot.baseband=N/A androidboot.selinux=permissive androidboot.hardware=rk30board androidboot.console=ttyFIQ0 root=/dev/mmcblk1p5 rw rootfstype=ext4"
MTDPARTS_rk3399 ?= "0x00002000@0x00002000(uboot),0x00002000@0x00004000(trust),0x00008000@0x00006000(resource),0x00009000@0x0000e000(kernel),-@0x00017000(boot)"

PARAMETER    = "parameter"
LOADER_BIN   = "loader.bin"
UBOOT_IMG   = "uboot.img"
TRUST_IMG   = "trust.img"
KERNEL_IMG   = "kernel.img"
RESOURCE_IMG   = "resource.img"

IMAGE_CMD_rockchip-update-img () {
	# Change to image directory
	cd ${DEPLOY_DIR_IMAGE}

	# Create parameter
	cat > ${PARAMETER} << EOF
FIRMWARE_VER:${FIRMWARE_VER}
MACHINE_MODEL:${MACHINE}
MACHINE_ID:007
MANUFACTURER:${MANUFACTURER}
MAGIC: 0x5041524B
ATAG: ${ATAG}
MACHINE: rk3x
CHECK_MASK: 0x80
PWR_HLD: 0,0,A,0,1
#RECOVER_KEY: 1,1,0,20,0
CMDLINE:${CMDLINE} initrd=0x62000000,0x00800000 mtdparts=rk29xxnand:${MTDPARTS}
EOF

	# Create kernel.img
	mkkrnlimg ${KERNEL_IMAGETYPE} ${KERNEL_IMG}

	# Create resource.img
	for DTS_FILE in ${KERNEL_DEVICETREE}; do
		DTS_FILE=${DTS_FILE##*/}
		resource_tool  ${KERNEL_IMAGETYPE}-${DTS_FILE}
	done
}
