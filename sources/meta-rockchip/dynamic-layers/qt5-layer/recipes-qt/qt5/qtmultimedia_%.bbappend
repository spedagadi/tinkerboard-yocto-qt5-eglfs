# Copyright (C) 2017 Fuzhou Rockchip Electronics Co., Ltd
# Released under the MIT license (see COPYING.MIT for the terms)

SRC_URI += "file://0001-qt5multimedia-qmlvideo-support-assigned-videosink.patch"

PACKAGECONFIG += " gstreamer"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"