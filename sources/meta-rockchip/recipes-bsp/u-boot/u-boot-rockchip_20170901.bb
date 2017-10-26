# Copyright (C) 2017 Fuzhou Rockchip Electronics Co., Ltd
# Released under the MIT license (see COPYING.MIT for the terms)

include u-boot-rockchip.inc

TAG = "release-${PV}"
SRC_URI = " \
	git://github.com/rockchip-linux/u-boot.git;tag=${TAG};nobranch=1; \
	file://binutils-2.28-ld-fix.patch \
"
S = "${WORKDIR}/git"
