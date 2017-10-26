# Copyright (C) 2017 Fuzhou Rockchip Electronics Co., Ltd
# Released under the GNU GENERAL PUBLIC LICENSE Version 2
# (see COPYING.GPLv2 for the terms)

DEFAULT_PREFERENCE = "-1"

include gstreamer1.0-rockchip-extra.inc

SRCBRANCH ?= "master"
SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/rockchip-linux/gstreamer-rockchip-extra.git;branch=${SRCBRANCH}"

S = "${WORKDIR}/git"
