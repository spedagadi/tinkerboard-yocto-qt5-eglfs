# Copyright (C) 2017 Fuzhou Rockchip Electronics Co., Ltd
# Released under the MIT license (see COPYING.MIT for the terms)

do_configure_prepend () {
	# enable transparent UI
	sed -i '/DEVICE_EVB/s/^/#&/' ${S}/Carmachine.pro
}