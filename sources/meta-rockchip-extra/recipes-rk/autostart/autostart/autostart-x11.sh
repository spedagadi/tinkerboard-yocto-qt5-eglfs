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
### END INIT INFOsync

export QT_GSTREAMER_WIDGET_VIDEOSINK=rkximagesink
export QT_GSTREAMER_WINDOW_VIDEOSINK=rkximagesink
export DISPLAY=:0.0

case $1 in
start)
	cd /usr/share/qt5/examples/multimedia/Carmachine
	nohup ./Carmachine &
	;;
stop)
	killall Carmachine
	;;
esac
