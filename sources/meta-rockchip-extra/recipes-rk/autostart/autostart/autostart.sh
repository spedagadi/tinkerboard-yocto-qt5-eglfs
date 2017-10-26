#!/bin/sh
### BEGIN INIT INFO
# Provides:          autostart
# Required-Start:    $remote_fs $all
# Required-Stop:     $remote_fs $all
# Default-Start:     5
# Default-Stop:
# Short-Description: Start application at boot time
# Description:       This script will run the application as the
#					 last tep in the boot process.
### END INIT INFO

export QT_EGLFSPLATFORM_USE_GST_VIDEOSINK=1
export QT_GSTREAMER_WINDOW_VIDEOSINK=kmssink
export QT_QPA_PLATFORM=eglfs
export QT_QPA_EGLFS_KMS_CONFIG=/tmp/qt.json

case $1 in
start)
	cat >/tmp/qt.json <<EOF
{
  "device": "/dev/dri/card0",
  "hwcursor": true,
  "pbuffers": true
}
EOF

	cd /usr/share/qt5/examples/multimedia/Carmachine
	nohup ./Carmachine &
	;;
stop)
	killall Carmachine
	;;
esac
