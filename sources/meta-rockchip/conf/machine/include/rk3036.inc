# Copyright (C) 2017 Jacob Chen
# Released under the MIT license (see COPYING.MIT for the terms)

SOC_FAMILY = "rk3036"

require conf/machine/include/tune-cortexa7.inc
require conf/machine/include/soc-family.inc

PREFERRED_PROVIDER_virtual/kernel = "linux-rockchip"
PREFERRED_VERSION_linux-rockchip = "4.4"

SERIAL_CONSOLES = "115200;ttyS2"
KERNEL_IMAGETYPE = "zImage"
KBUILD_DEFCONFIG = "rockchip_linux_defconfig"

PREFERRED_PROVIDER_virtual/bootloader ?= "u-boot-rockchip"
SPL_BINARY ?= "u-boot-spl-nodtb.bin"

IMAGE_FSTYPES += "ext4 rockchip-gpt-img"
IMAGE_CLASSES += "rockchip-gpt-img"
